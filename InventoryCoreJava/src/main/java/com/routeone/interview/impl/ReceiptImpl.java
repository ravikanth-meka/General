package com.routeone.interview.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.routeone.domain.Inventory;
import com.routeone.interview.Receipt;

public class ReceiptImpl implements Receipt{

	
	private ArrayList<Inventory> inventoryItems = null;
	
	public ArrayList<Inventory> getInventoryItems() {
		if (inventoryItems == null)
			inventoryItems = new ArrayList<Inventory>();
		return inventoryItems;
	}

	@Override
	public String getFormattedTotal() {
		double total =0.0;
		List<Inventory> inventoryList = getInventoryItems();
		for (Inventory inv : inventoryList) {
			total += inv.getPrice();
		}
		Double currencyAmount = new Double(total);
		Locale enUSLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(enUSLocale);

		return currencyFormatter.format(currencyAmount);
	}

	@Override
	public List<String> getOrderedItems() {
		//in order of most expensive item to least. If items have an identical price, sort in alphabetical (A-Z) order
		List<Inventory> inventoryList = getInventoryItems();
		Collections.sort(inventoryList, (s1, s2) -> {
			 double i = s2.getPrice()-s1.getPrice() ;
			 if (i==0)  i= s1.getComponent().compareTo(s2.getComponent());
			 return (int)i;
		 });
		List<String> orderedList = new ArrayList<String>();
		inventoryList.forEach(e->orderedList.add(e.getComponent()));
		return orderedList;
	}

}
