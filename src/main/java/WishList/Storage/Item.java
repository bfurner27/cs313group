/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Storage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Schuyler
 */
public class Item implements Displayable {
    private URL imageUrl;
    private URL url;
    private String descrition;
    private String title;
    private float price;
    private int id;
    private int listId;
    
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
    public Item(URL imageUrl, URL url, String descrition, String title, 
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
    public Item(URL imageUrl, URL url, String descrition, String title, 
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
     * Used so that a Item can simply be output and it will generate the 
 HTML for the item in the list
     * @return 
     */
    @Override
    public String toString() {
        return "<a href=\"" + url + "\">" + title + "</a>";
    }
   
    /**
     *
     * @return
     */
    @Override
    public String getImageUrl() {
        return imageUrl.toString();
    }

    /**
     *
     * @param imageUrl
     */
    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    /**
     *
     * @param imageUrl
     * @throws MalformedURLException
     */
    public void setImageUrl(String imageUrl) throws MalformedURLException {
            this.imageUrl = new URL(imageUrl);
    }

    /**
     *
     * @return
     */
    public URL getUrl() {
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
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     *
     * @param descrition
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
        return title;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        return descrition;
    }
}
