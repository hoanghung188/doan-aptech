/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.CategoryDao;
import entity.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hoanghung
 */
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getAllCategory() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery(" from Category").list();
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
    public Category Search(String nameCategory) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Category c = (Category) session.createQuery(" from Category where nameCategory like N':Category'")
                    .setParameter("nameCategory", nameCategory)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }


}
