package com.routeone.interview;
import java.io.File;
import java.util.List;
import java.util.Map;

import com.routeone.domain.Inventory;
import com.routeone.domain.InventoryData;
import com.routeone.exception.InventoryNotFoundException;
import com.routeone.exception.ItemsNotFoundException;
import com.routeone.interview.impl.ReceiptImpl;
public class StoreRegister {
 
	private InventoryData id ;
    public void loadInventory(File inventoryFile){
    	
    	id.loadInventory(inventoryFile);
    }
    String itemsNotinOrder = "";
    
    public Map<String, Inventory> getInventoryDataValues() throws InventoryNotFoundException {
    
		Map<String, Inventory> invMap = id.getInventoryDataMap();
		return invMap;
	}

	
	public void setInventoryData(InventoryData id){
		this.id = InventoryData.getInstance() ;
	}
    
 	public Receipt checkoutOrder(List<String> items) throws ItemsNotFoundException {
    	
    	Receipt r = new ReceiptImpl();
    	
		try {
			Map<String, Inventory> invMap = getInventoryDataValues();

			//items.forEach(e-> ((ReceiptImpl)r).getInventoryItems().add(new Inventory(e,invMap.get(e).getPrice(), invMap.get(e).getCategory())));
			items.forEach(e->
			{
				if(invMap.get(e) !=null)
			     {
					((ReceiptImpl)r).getInventoryItems().add(new Inventory(e,invMap.get(e).getPrice(), invMap.get(e).getCategory()));
			    } 
				else
			    {
					if (itemsNotinOrder.length() > 0)
						itemsNotinOrder = itemsNotinOrder +"," + e;
					else
						itemsNotinOrder = e;
			    }
			});
			if (itemsNotinOrder.length() > 0)
				throw new ItemsNotFoundException("Items not found in Inventory : " + itemsNotinOrder);
			
		} catch (InventoryNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (ItemsNotFoundException e) {
	        throw new ItemsNotFoundException(e.getMessage());
	    }
		
		return r;
        
    }

	
    
}