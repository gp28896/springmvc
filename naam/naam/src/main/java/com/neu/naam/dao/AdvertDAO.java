package com.neu.naam.dao;

//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.naam.exception.AdvertException;
import com.neu.naam.pojo.Advert;
//import com.neu.naam.pojo.Category;

public class AdvertDAO extends DAO {

    public Advert create(Advert advert)
            throws AdvertException {
        try {
            begin();            
            getSession().save(advert);     
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdvertException("Exception while creating advert: " + e.getMessage());
        }
    }

    public void delete(Advert advert)
            throws AdvertException {
        try {
            begin();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdvertException("Could not delete advert", e);
        }
    }
    
    public List<Advert> list() throws AdvertException{
    	
    	try {
            begin();
            Query query = getSession().createQuery("from Advert");
            List<Advert> listOfAdverts = query.list();
            commit();
            return listOfAdverts;
        } catch (HibernateException ex) {
            rollback();
            throw new AdvertException("Could not delete advert", ex);
        }
    	
    }
}