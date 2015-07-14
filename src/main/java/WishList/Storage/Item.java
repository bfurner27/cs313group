/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Storage;

import java.io.Serializable;

/**
 *
 * @author Schuyler
 */
public class Item implements Displayable, Serializable {
    private int id;
    private String picture_url;
    private String url;
    private String description;
    private String name;
    private float price; 
    private int listId;

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
    
    /**
     *
     */
    public Item() {
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
    public Item(String imageUrl, String url, String descrition, String title, 
            float price, int listId) {
        this.picture_url = imageUrl;
        this.url = url;
        this.description = descrition;
        this.name = title;
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
    public Item(String imageUrl, String url, String descrition, String title, 
            float price, int id, int listId) {
        this.picture_url = imageUrl;
        this.url = url;
        this.description = descrition;
        this.name = title;
        this.price = price;
        this.id = id;
        this.listId = listId;
    }
    
    /**
     * Used so that a Item can simply be output and it will generate the 
 HTML for the item in the list
     * @return 
     */
    @Override
    public String toString() {
        return "<a href=\"" + url + "\">" + name + "</a>";
    }
   
    /**
     *
     * @return
     */
    @Override
    public String getImageUrl() {
        return picture_url.toString();
    }

    /**
     *
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.picture_url = imageUrl;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getDescrition() {
        return description;
    }

    /**
     *
     * @param descrition
     */
    public void setDescrition(String descrition) {
        this.description = descrition;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return name;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.name = title;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPrice() {
        return "$" + String.format("%.2f", price);
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDisplayName() {
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        return description;
    }
}
