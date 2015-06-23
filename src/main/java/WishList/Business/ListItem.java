/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Business;

import java.net.URL;

/**
 *
 * @author Schuyler
 */
public class ListItem {
    private URL imageUrl;
    private URL url;
    private String descrition;
    private String title;
    private float price;
    private int id;
    private int listId;
    
    public ListItem() {
    }

    /**
     * Used when user is creating a new item. The itemId can be left out until 
     * added into the database
     * @param imageUrl
     * @param url
     * @param descrition
     * @param title
     * @param price
     * @param listId ID for the list that it belongs to
     */
    public ListItem(URL imageUrl, URL url, String descrition, String title, 
            float price, int listId) {
        this.imageUrl = imageUrl;
        this.url = url;
        this.descrition = descrition;
        this.title = title;
        this.price = price;
        this.listId = listId;
    }

    /**
     * Used when creating a ListItem based on data retrieved from a database
     * @param imageUrl
     * @param url
     * @param descrition
     * @param title
     * @param price
     * @param id
     * @param listId
     */
    public ListItem(URL imageUrl, URL url, String descrition, String title, 
            float price, int id, int listId) {
        this.imageUrl = imageUrl;
        this.url = url;
        this.descrition = descrition;
        this.title = title;
        this.price = price;
        this.id = id;
        this.listId = listId;
    }
    
    /**
     * Used so that a ListItem can simply be output and it will generate the 
     * HTML for the item in the list
     * @return 
     */
    @Override
    public String toString() {
        return "<a href=\"" + url + "\">" + title + "</a>";
    }
   
    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
