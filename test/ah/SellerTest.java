/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ah;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mad
 */
public class SellerTest {
    
    Bidder bidder;
    Seller seller;
    
    public SellerTest() {
        try{
            this.bidder= new Bidder(10000,1);
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item("Stuff 1", 100));
            this.seller= new Seller("Jack",items);
        } catch (EmptyItemListException ex) {
            fail("WTF ?");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
            AuctionHouse.main(null);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of bid method, of class Seller.
     */
    @Test
    public void testBid() {
        try {
            System.out.println("bid");
            Seller instance = seller;
            instance.bid(new Offer(bidder,seller.getCurrentPrice()+seller.getCurrentItem().getMinBid()));
            
            Method f = seller.getClass().getDeclaredMethod("getBestOffer", null);
            f.setAccessible(true);
            f.invoke(seller, null);
            if(seller.getCurrentBuyer()!=bidder.getID())          
                fail("The test case is a prototype.");
        } catch (EmptyItemListException ex) {
            fail("DAFUQ is going on ?");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of subscribe method, of class Seller.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        Observer bidder = null;
        Seller instance = null;
        instance.subscribe(bidder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObserver method, of class Seller.
     */
    @Test
    public void testNotifyObserver() {
        System.out.println("notifyObserver");
        Seller instance = null;
        instance.notifyObserver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unsubscribe method, of class Seller.
     */
    @Test
    public void testUnsubscribe() {
        System.out.println("unsubscribe");
        Observer o = null;
        Seller instance = null;
        instance.unsubscribe(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentItem method, of class Seller.
     */
    @Test
    public void testGetCurrentItem() throws Exception {
        System.out.println("getCurrentItem");
        Seller instance = null;
        Item expResult = null;
        Item result = instance.getCurrentItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPrice method, of class Seller.
     */
    @Test
    public void testGetCurrentPrice() {
        System.out.println("getCurrentPrice");
        Seller instance = null;
        int expResult = 0;
        int result = instance.getCurrentPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentBuyer method, of class Seller.
     */
    @Test
    public void testGetCurrentBuyer() {
        System.out.println("getCurrentBuyer");
        Seller instance = null;
        int expResult = 0;
        int result = instance.getCurrentBuyer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
