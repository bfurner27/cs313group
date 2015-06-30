/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Storage;

/**
 *
 * @author Schuyler
 */
public class WishList implements Displayable {
    private int id;
    private String name;
    private String description;
    private String imageUrl;

    public WishList(int id, String name, String description) {
        this(id, name, description, "http://www.icons101.com/icon_png/size_256/id_69455/List.png");
    }

    public WishList(int id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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
