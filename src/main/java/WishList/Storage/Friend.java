/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishList.Storage;

/**
 *
 * @author Benjamin
 */
public class Friend {
    private String id;
    private String name;
    private String pictureURL;

    public Friend(String id, String name, String pictureURL) {
        this.id = id;
        this.name = name;
        this.pictureURL = pictureURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
    
    
}
