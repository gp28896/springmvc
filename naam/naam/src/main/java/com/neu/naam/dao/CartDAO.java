package com.neu.naam.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.naam.exception.CartException;
import com.neu.naam.exception.CategoryException;
import com.neu.naam.pojo.Advert;
import com.neu.naam.pojo.Cart;
import com.neu.naam.pojo.Category;
import com.neu.naam.pojo.User;

public class CartDAO extends DAO {
	
	public CartDAO(){
	
	}

	public Cart insert(Cart cart) throws CartException {
		try{
			begin();            
			getSession().save(cart);     
            commit();
            return cart;
		} catch (HibernateException ex){
			rollback();
            throw new CartException("Unable to save the cart\n Exception: ", ex);
		}
	}
	
	public void update(Cart cart) throws CategoryException {
        try {
            begin();
            getSession().update(cart);
            commit();
        } catch (HibernateException ex) {
            rollback();
            throw new CategoryException("Unable to save the cart\nHibernate Exception: ", ex);
        }
    }
	
	public User update(User user) throws CategoryException {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the user", e);
        }
        return user;
    }
	
	public List<Cart> list(){
		begin();
		Query q = getSession().createQuery("from Cart");
		List<Cart> cart1 = q.list();
		commit();
		return cart1;
	}
	
	public Cart updateCart(Cart cart) throws CategoryException {
        try {
            begin();
            getSession().update(cart);
            commit();
            return cart;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the cart", e);
        }
    }
	

}
