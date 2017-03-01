package com.routeone.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.routeone.exception.InventoryNotFoundException;

public class InventoryData {

	private static volatile InventoryData inventoryData;
	Map<String, Inventory> inventoryDataMap = null;
	

	private InventoryData()
	{
		
	}
	
	public static InventoryData getInstance()
	{
		if (inventoryData == null)
		{
			synchronized(InventoryData.class)
			{
				if (inventoryData == null)
				{
					inventoryData = new InventoryData();
				}
			}
		}
		return inventoryData;
	}
	
	public Map<String, Inventory> getInventoryDataMap() throws InventoryNotFoundException {
		if (inventoryDataMap == null )
		{
			throw new InventoryNotFoundException("Inventory Data not loaded properly.. Please check..");
		}
		return inventoryDataMap;
	}
	
	public void loadInventory(File csvFile) 
	{
		inventoryDataMap = new HashMap<String, Inventory>();
        String line = "";
        Scanner scanner;
		try {
			scanner = new Scanner(csvFile);
			//scanner.useDelimiter(",");
			
			   while(scanner.hasNextLine()){
	        	line = scanner.nextLine();
	        	String[] invLineItem = line.split(",");
	        	Inventory inv = new Inventory(invLineItem[0],Double.valueOf(invLineItem[1]),invLineItem[2]);
	        	//System.out.println(invLineItem[0]);
	        	inventoryDataMap.put(invLineItem[0], inv);
	        }
	        scanner.close();
        
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
