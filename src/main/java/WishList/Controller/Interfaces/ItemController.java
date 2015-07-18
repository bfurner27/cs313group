/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Interfaces;

import WishList.Storage.Item;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public interface ItemController {
    public boolean addItem(Item item);    
    public boolean removeItem(int itemId);
    public List<Item> getItems(int listId);
    public Item getItem(int itemId);
    public boolean updateItem(Item updated);
}
