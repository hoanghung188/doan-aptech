/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.ProductsDao;

import entity.Product;
import entity.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hoanghung
 */
public class ProductDaoImpl implements ProductsDao{

   private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Product> getSanPhamBanChay() {
         Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
            List list = session.createQuery("from Product").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null;
    }

    @Override
    public List<Product> getSanPhamTheoDanhMuc(int idCategory) {
         Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
             Query query = session.createQuery("from Product where idCategory.idCategory = :idCategory");
                   query.setParameter("idCategory", idCategory);
              List list = query.list();
             session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null;
    }

    @Override
    public List<Product> getSanPhamTheoDanhMucLimit4(int idCategory) {
        Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
             Query query = session.createQuery("from Product where idCategory.idCategory = :idCategory");
                   query.setParameter("idCategory", idCategory);
                   //lay 4 san pham
                   query.setMaxResults(4);
              List list = query.list();
             session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null;
    }

    @Override
    public List<Product> getTop5SanPhamMoi() {
      Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
            List list = session.createQuery("select top 10  Product.IdProduct,TenSanPham,Gia,AnhDaiDien from Product where TrangThai=1 order by  Product.IdProduct desc").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null;
    }

    @Override
    public List<Product> getByProductName(String tenSanPham) {
      Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
            if(tenSanPham == null)
                tenSanPham = "5";
            else
                tenSanPham = "%"+tenSanPham+"%";
            List list = session.createQuery("from Product where tenSanPham like :tenSanPham")
                    .setParameter("tenSanPham", tenSanPham)
                    .list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null;
    
    }

    @Override
    public Product getByIdProduct(Integer idProduct) {
       Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
            Product p =(Product) session.createQuery("from Product where idProduct= :idProduct")
                    .setParameter("idProduct", idProduct)
                    .uniqueResult();    
            session.getTransaction().commit();
            session.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
         return null; 
    }


    
 
}
