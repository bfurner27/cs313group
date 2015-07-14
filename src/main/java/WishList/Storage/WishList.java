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
public class WishList implements Displayable, Serializable {
    private int id;
    private String owner;
    private String name;
    private String description;
    private String imageUrl;
    private Boolean is_public;
    
    public WishList() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(Boolean is_public) {
        this.is_public = is_public;
    }

    public WishList(int id, String name, String description, String owner, Boolean is_public) {
        this(id, name, description, owner, is_public, "http://www.icons101.com/icon_png/size_256/id_69455/List.png");
    }

    public WishList(int id, String name, String description, String owner, Boolean is_public, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.owner = owner;
        
    }
    
    public WishList(String name, String description, String owner, Boolean is_public, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.owner = owner;
        
    }
    
    @Override
    public String getImageUrl() {
            return imageUrl;    
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPrice() {
        return "";
    }

    @Override
    public int getId() {
        return id;
    }
    
    
}
