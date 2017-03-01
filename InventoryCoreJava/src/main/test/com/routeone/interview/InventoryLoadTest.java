package com.routeone.interview;

import java.io.File;
import java.net.URL;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.routeone.domain.Inventory;
import com.routeone.domain.InventoryData;
import com.routeone.exception.InventoryNotFoundException;

import org.junit.Assert;


public class InventoryLoadTest {
	
	 @Rule
	    public ExpectedException thrown = ExpectedException.none();
	 
	 
	 	@Test
	    public final void accessInventoryWithoutLoading() throws InventoryNotFoundException {
	    	StoreRegister r = new StoreRegister();
	    	
	    	thrown.expect(InventoryNotFoundException.class);
	    	Map<String, Inventory> invMap = InventoryData.getInstance().getInventoryDataMap();
	    	
	    	URL url = getClass().getClassLoader().getResource("./sample-inventory.csv");
	    	r.loadInventory(new File(url.getPath()));
	    }
	 
	    @Test
	    public final void loadInventoryData() throws InventoryNotFoundException {
	    	StoreRegister r = new StoreRegister();
	    	URL url = getClass().getClassLoader().getResource("./sample-inventory.csv");
	    	r.loadInventory(new File(url.getPath()));
	    	
	      	Map<String, Inventory> invMap = InventoryData.getInstance().getInventoryDataMap();
	    	
	    	Assert.assertTrue(invMap.size() > 0);
	    	
	    }
	   
	
}
