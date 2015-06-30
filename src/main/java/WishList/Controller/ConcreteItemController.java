/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller;

import WishList.Controller.Interfaces.ItemController;
import WishList.Storage.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class ConcreteItemController implements ItemController {
    @Override
    public boolean addItem(Item item){
        return true;
    }
    
    @Override
    public boolean removeItem(int itemId){
        return true;
    }
    
    @Override
    public List<Item> getItems(int listId){
        return new ArrayList<Item>();
    }
    
    @Override
    public boolean updateItem(Item updated)
    {
        return true;
    }
}
