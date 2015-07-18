/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Implementations;

import WishList.Controller.Interfaces.ItemController;
import WishList.Model.DatabaseAccessor;
import WishList.Storage.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class ConcreteItemController implements ItemController {
    private DatabaseAccessor dba;

    public ConcreteItemController() {
        this.dba = new DatabaseAccessor();
    }
    
    @Override
    public boolean addItem(Item item){
        return dba.addItem(item);
    }
    
    @Override
    public boolean removeItem(int itemId){
        return dba.removeItem(itemId);
    }
    
    @Override
    public List<Item> getItems(int listId){
        return dba.getItems(listId);
    }
    
    @Override
    public boolean updateItem(Item updated){
        return dba.updateItem(updated);
    }
}
