package com.routeone.interview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.routeone.exception.ItemsNotFoundException;

public class StoreRegisterTest {
	
    @BeforeClass public static void initialize() {
 	    	StoreRegister r = new StoreRegister();
 	    	//URL url = getClass().getClassLoader().getResource("./sample-inventory.csv");
	    	r.loadInventory(new File(StoreRegisterTest.class.getClassLoader().getResource("./sample-inventory.csv").getPath()));
	    }
	 
    
    @Test
    public final void verifyBasic() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	
    	
    	purchaseList.add("PC1033V1");  
    	purchaseList.add("GenericMotherboardV1"); 
    	purchaseList.add("MouseV1");
    	purchaseList.add("LCDV1"); 
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    	//System.out.println("price is " + receipt.getFormattedTotal());
    	//receipt.getOrderedItems().forEach(e->System.out.println(e));
    	
    	Assert.assertEquals("$738.98",  receipt.getFormattedTotal());
        
    	List<String> ordList = new ArrayList<String>();
    	ordList.add("GenericMotherboardV1");
    	ordList.add("LCDV1");
    	ordList.add("MouseV1");
    	ordList.add("PC1033V1");
    	
    	Assert.assertTrue(receipt.getOrderedItems().equals(ordList));
    }
    
    @Test
    public final void verifySimple() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("GenericProcessor"); //110
    	purchaseList.add("LCD"); //75
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    /*	System.out.println("price is " + receipt.getFormattedTotal());
    	receipt.getOrderedItems().forEach(e->System.out.println(e));*/
    	
    	Assert.assertEquals("$205.00",  receipt.getFormattedTotal());
        
    	List<String> ordList = new ArrayList<String>();
    	ordList.add("GenericProcessor");
    	ordList.add("LCD");
    	ordList.add("PC1033");
    	Assert.assertTrue(receipt.getOrderedItems().equals(ordList));
    }
    
    
    @Test
    public final void verifySamePriceData() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	purchaseList.add("PC900");  //9.99
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("PC800");  //9.99
    	purchaseList.add("GenericProcessor");  //110
    	purchaseList.add("LCD"); //75
    	purchaseList.add("GenericMotherboardV2");  //100
    	purchaseList.add("LED");  //75
    	purchaseList.add("GenericMotherboardV3");  //100
    	
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    	//System.out.println("price is " + receipt.getFormattedTotal());
    	//receipt.getOrderedItems().forEach(e->System.out.println(e));
    	Assert.assertEquals("$499.98",  receipt.getFormattedTotal());
    
    	List<String> ordList = new ArrayList<String>();
    	ordList.add("GenericProcessor");
    	ordList.add("GenericMotherboardV2");
    	ordList.add("GenericMotherboardV3");
    	ordList.add("LCD");
    	ordList.add("LED");
    	ordList.add("PC1033");
    	ordList.add("PC800");
    	ordList.add("PC900");
   		Assert.assertTrue(receipt.getOrderedItems().equals(ordList));
    }
    
    
    @Test
    public final void verifyHighBillReceipt() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	purchaseList.add("COMPLETEPC");  //700.99
		purchaseList.add("COMPLETEPC");  //700.99
    	purchaseList.add("COMPLETEPC");  //700.99
    	purchaseList.add("PC900");  //9.99
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("PC800");  //9.99
    	purchaseList.add("GenericProcessor");  //110
    	purchaseList.add("LCD"); //75
    	purchaseList.add("GenericMotherboardV2");  //100
    	purchaseList.add("LED");  //75
    	purchaseList.add("GenericMotherboardV3");  //100
     	purchaseList.add("PC900");  //9.99
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("PC800");  //9.99
    	purchaseList.add("GenericProcessor");  //110
    	purchaseList.add("LCD"); //75
    	purchaseList.add("GenericMotherboardV2");  //100
    	purchaseList.add("LED");  //75
    	purchaseList.add("GenericMotherboardV3");  //100
    	purchaseList.add("PC900");  //9.99
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("PC800");  //9.99
    	purchaseList.add("GenericProcessor");  //110
    	purchaseList.add("LCD"); //75
    	purchaseList.add("GenericMotherboardV2");  //100
    	purchaseList.add("LED");  //75
    	purchaseList.add("GenericMotherboardV3");  //100
    	purchaseList.add("COMPLETEPC");  //700.99
    	purchaseList.add("COMPLETEPC");  //700.99
    	purchaseList.add("COMPLETEPC");  //700.99
    	
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    	//System.out.println("price is " + receipt.getFormattedTotal());
    	//receipt.getOrderedItems().forEach(e->System.out.println(e));
    	Assert.assertEquals("$5,705.88",  receipt.getFormattedTotal());
    
    
    
    }
    
    
    
    @Test
    public final void verifyDuplicateItems() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	purchaseList.add("COMPLETEPC");  //700.99
		purchaseList.add("PC900");  //9.99
    	purchaseList.add("PC1033");  //20
    	purchaseList.add("COMPLETEPC");  //700.99
    	purchaseList.add("PC800");  //9.99
    	
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    	//System.out.println("price is " + receipt.getFormattedTotal());
    	//receipt.getOrderedItems().forEach(e->System.out.println(e));
    	//Assert.assertEquals("$1,441.96",  receipt.getFormattedTotal());
      	List<String> ordList = new ArrayList<String>();
    	ordList.add("COMPLETEPC");
    	ordList.add("COMPLETEPC");
    	ordList.add("PC1033");
    	ordList.add("PC800");
    	ordList.add("PC900");
    	
   		Assert.assertTrue(receipt.getOrderedItems().equals(ordList));
    
    
    
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public final void verifyWrongData() throws ItemsNotFoundException{
    	StoreRegister r = new StoreRegister();
    	
    	List<String> purchaseList = new ArrayList<String>();
    	purchaseList.add("PC11100");
    	purchaseList.add("PC1033");
    	purchaseList.add("PC800");
    	purchaseList.add("GenericProcessor");
    	purchaseList.add("CECD");
    	purchaseList.add("GenericMotherboardV2");
    	purchaseList.add("LED");
    	purchaseList.add("GenericMotherboardV3");

    	thrown.expect(ItemsNotFoundException.class);
    	thrown.expectMessage("Items not found in Inventory : PC11100,CECD");
    	Receipt receipt = r.checkoutOrder(purchaseList);
    	
    	//System.out.println("price is " + receipt.getFormattedTotal());
        // receipt.getOrderedItems().forEach(e->System.out.println(e));
    }
   
    
}
