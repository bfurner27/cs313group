/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.MockControllers;

import WishList.Controller.Interfaces.ItemController;
import WishList.Storage.Item;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class MockItemController implements ItemController {
    @Override
    public boolean addItem(Item item){
        return true;
    }
    
    @Override
    public boolean removeItem(int itemId){
        return true;
    }
    
    /**
     * Gets a mocked up list of items
     * There are two lists one for if the listId == 1 and another for otherwise
     * @param listId
     * @return
     */
    @Override
    public List<Item> getItems(int listId){
        List<Item> items = new ArrayList<Item>();
        if (listId == 1) {
            items.add(new Item("http://ecx.images-amazon.com/images/I/41h64p3BYtL._AA160_.jpg", "http://www.amazon.com/20030578-ASDF/dp/B004OBY8IG/ref=sr_1_1?ie=UTF8&qid=1435700253&sr=8-1&keywords=asdf", "Its a car!", "ASDF", (float) 59.99, 1, listId, new Date(), 1, false));
            items.add(new Item("http://ecx.images-amazon.com/images/I/51XwRGpkEXL._AA160_.jpg", "http://www.amazon.com/Greatest-Hits-Amazon-Exclusive-Fighters/dp/B002UHSDUK/ref=sr_1_2?ie=UTF8&qid=1435700261&sr=8-2&keywords=foo", "Foo Fighters CD", "Sonic Highways", (float) 10.30, 2, listId, new Date(), 1, false));
            items.add(new Item("http://ecx.images-amazon.com/images/I/51kTR4SvmSL._PI_PJStripe-HD-Only-500px,TopLeft,0,0_AA160_.jpg",  "http://www.amazon.com/This-40-Unrated-Paul-Rudd/dp/B00BGIBVP8/ref=sr_1_1?ie=UTF8&qid=1435701187&sr=8-1&keywords=this", "I don't know what there is 40 of", "This is 40", (float) 2.99, 3, listId, new Date(), 1, false));
            items.add(new Item("http://ecx.images-amazon.com/images/I/41YzinELUDL._AA160_.jpg", "http://www.amazon.com/Winsome-Newport-Expandable-Wine-Bar/dp/B001B2PA6A/ref=sr_1_1?ie=UTF8&qid=1435701337&sr=8-1&keywords=bar", "Searching for bar", "A table thing...", (float) 192.90, 4, listId, new Date(), 1, false));
        }
        else {
            Date today = new Date();
            items.add(new Item("http://ecx.images-amazon.com/images/I/41xmPQeiLZL._AA160_.jpg", "http://www.amazon.com/listlessness-granny-FooBar-Dragon-Comics/dp/4091406270/ref=sr_1_1?ie=UTF8&qid=1435701444&sr=8-1&keywords=foobar", "I searched for foobar and this was too good to pass up", "Ho and listlessness listlessness granny gag gag tales of old Japan one of FooBar old man", (float) 5.16, 5, listId, today, 1, false));
            items.add(new Item("http://ecx.images-amazon.com/images/I/51mWx8w7goL._PI_PJStripe-HD-Only-500px,TopLeft,0,0_AA160_.jpg", "http://www.amazon.com/Harry-Potter-Sorcerers-Daniel-Radcliffe/dp/B002DQLGHU/ref=sr_1_1?ie=UTF8&qid=1435701579&sr=8-1&keywords=harry", "Harry Potter", "Harry Potter", (float) 2.30, 6, listId, today, 1, false));
            items.add(new Item("http://ecx.images-amazon.com/images/I/313HPN793PL._AA160_.jpg", "http://www.amazon.com/Stanley-Proto-J1200GASD-Combination-Wrench/dp/B000LVI5OG/ref=sr_1_1?ie=UTF8&qid=1435701643&sr=8-1&keywords=gasd", "A bunch of tools", "Stanley Proto J1200GASD 10 Piece 12 Point Combination", (float) 172.99, 7, listId, today, 1, false));
        }
        return items;
    }
    
    @Override
    public boolean updateItem(Item updated)
    {
        return true;
    }
}
