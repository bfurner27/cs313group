/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Storage;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Date dateAdded;
    private float price; 
    private int listId;
    private int priority;
    private boolean claimed;
  
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
        if (imageUrl != null)
            this.picture_url = imageUrl;
        else
            this .picture_url = "http://hivewallpaper.com/wallpaper/2014/11/christmas-present-3-wide-wallpaper.jpg";
        this.url = url;
        this.description = descrition;
        this.name = title;
        this.price = price;
        this.listId = listId;
        this.dateAdded = new Date();
        this.priority = 1;
        this.claimed = false;
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
     * @param dateAdded
     * @param priority
     * @param isClaimed
     */
    public Item(String imageUrl, String url, String descrition, String title, 
            float price, int id, int listId, Date dateAdded, int priority, boolean isClaimed) {
        if (imageUrl != null)
            this.picture_url = imageUrl;
        else
            this .picture_url = "http://hivewallpaper.com/wallpaper/2014/11/christmas-present-3-wide-wallpaper.jpg";
        this.url = url;
        this.description = descrition;
        this.name = title;
        this.price = price;
        this.id = id;
        this.listId = listId;
        this.dateAdded = dateAdded;
        this.priority = priority;
        this.claimed = isClaimed;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
    
    public String getDateString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return dateFormat.format(this.dateAdded);
    }
    
    public String getDateSQL() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        return dateFormat.format(this.dateAdded);
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
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
        return this.picture_url;
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
    
    public Float getFloatPrice() {
        return price;
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
    
    public String getPicture_url() {
        return this.picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean isClaimed) {
        this.claimed = isClaimed;
    }
}
