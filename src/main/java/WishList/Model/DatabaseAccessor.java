/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Model;

import WishList.Storage.Item;
import WishList.Storage.WishList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.ReadAllQuery;

/**
 *
 * @author Schuyler
 */
public class DatabaseAccessor {
    public List<Item> getItems(int wishListId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();
        List<Item> result = null;
        
        try {                                
            ExpressionBuilder builder = new ExpressionBuilder();
            ReadAllQuery databaseQuery = new ReadAllQuery(WishList.class, builder);
            databaseQuery.setSelectionCriteria(builder.get("list_id").equal(wishListId));

            Query query = ((JpaEntityManager)em.getDelegate()).createQuery(databaseQuery);
            result = query.getResultList(); 
        } finally {
            emf.close();
            em.close();
        }
        
        return result;
    }
    
    public boolean addItem(Item item){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        
        return success;
    }
    
    public boolean removeItem(int itemId){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            Item list = em.find(Item.class, itemId);
            em.remove(list);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        
        return success;
    }
    
    public boolean removeItem(Item item){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(item);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        
        return success;
    }
    
    public List<WishList> getWishLists(String owner){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        List<WishList> result = null;
        try {            
            EntityManager em = emf.createEntityManager();
                    
            ExpressionBuilder builder = new ExpressionBuilder();
            ReadAllQuery databaseQuery = new ReadAllQuery(WishList.class, builder);
            databaseQuery.setSelectionCriteria(builder.get("owner").equal(owner));

            Query query = ((JpaEntityManager)em.getDelegate()).createQuery(databaseQuery);
            result = query.getResultList(); 
        } finally {
            emf.close();
        }
        
        return result;
    }
           
    public boolean addWishList(WishList wishList){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(wishList);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        return success;
    }
    
    public boolean removeWishList(int wishListId){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            WishList list = em.find(WishList.class, wishListId);
            em.remove(list);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        
        return success;
    }
    
    public boolean removeWishList(WishList wishList){
        boolean success = true;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlistNew");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(wishList);
            em.getTransaction().commit();
        } catch (Exception ex) {
            success = false;
        }finally{
            em.close();
            emf.close();
        }
        
        return success;
    }
}
