/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.TypeProductDao;
import entity.TypeProduct;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hoanghung
 */
public class TypeProductDaoImpl implements TypeProductDao{
    
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<TypeProduct> getListTypeProduct() {
      Session session = sessionFactory.openSession();
         try {
            session.beginTransaction();
            List list = session.createQuery("from TypeProduct").list();
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
    
}
