package com.routeone.interview;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InventoryLoadTest.class, StoreRegisterTest.class })
public class CompleteTestSuite {

    @BeforeClass 
    public static void setUpClass() {      
        System.out.println("Master setup");

    }

    @AfterClass 
    public static void tearDownClass() { 
        System.out.println("Master tearDown");
    }
    @Before  
    public void setUp()
    {

    }

    @After
    public void tearDown()
    {

    }
}