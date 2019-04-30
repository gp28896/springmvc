package com.neu.naam.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.naam.exception.CategoryException;
import com.neu.naam.pojo.Category;

public class CategoryDAO extends DAO {

    public Category get(String title) throws CategoryException {
        try {
            begin();
            Query query=getSession().createQuery("from Category where title= :title");
            query.setString("title",title);
            Category category=(Category)query.uniqueResult();
            commit();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Unable to obtain the category " + title + " " + e.getMessage());
        }
    }

    public List<Category> list() throws CategoryException {
        try {
            begin();
            Query query = getSession().createQuery("from Category");
            List<Category> categoryList = query.list();
            commit();
            return categoryList;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Unable to list the categories", e);
        }
    }

    public Category create(String title) throws CategoryException {
        try {
            begin();
            Category category = new Category(title);
            getSession().save(category);
            commit();
            return category;
        } catch (HibernateException e) {
            rollback();
            
            throw new CategoryException("Unable to create a category: " + e.getMessage());
        }
    }

    public void update(Category category) throws CategoryException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the category", e);
        }
    }

    public void delete(Category category) throws CategoryException {
        try {
            begin();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not delete the category", e);
        }
    }
}