package ah;

import java.lang.reflect.Field;
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

public class SellerTest {

    private Bidder bidder;
    private Seller seller;
    private ArrayList<Item> items;

    public SellerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        items = new ArrayList<>();
        items.add(new Item("Stuff 1", 100));
        try {
            bidder = new Bidder(1000, 0);
            this.seller = new Seller(items);
            seller.subscribe(bidder);
        } catch (EmptyItemListException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        seller.unsubscribe(bidder);
    }

    /**
     * Test of bid method, of class Seller.
     */
    @Test
    public void testBid() {
        try {
            System.out.println("bid");
            Seller instance = seller;
            instance.bid(new Offer(bidder, instance.getCurrentPrice() + instance.getCurrentItem().getMinBid()));
            Method m = instance.getClass().getDeclaredMethod("getBestOffer", null);
            m.setAccessible(true);
            m.invoke(instance, null);
            assertEquals("Bidder is not the current buyer",
                    seller.getCurrentBuyer(), bidder.getID());                   //Correct bid, should be accepted
            Field f = seller.getClass().getDeclaredField("offers");
            f.setAccessible(true);
            ArrayList<Offer> offers = (ArrayList) f.get(seller);
            assertTrue("Offer array should be empty",
                    offers.isEmpty());                                          //check if offers array not cleaned as it should be
            instance.bid(new Offer(bidder, seller.getCurrentPrice()));
            setUp();
            m = seller.getClass().getDeclaredMethod("getBestOffer", null);
            m.setAccessible(true);
            m.invoke(seller, null);
            assertFalse("Bidder should not be the current buyer", seller.getCurrentBuyer() == bidder.getID());               //Bid to low, should be rejected
        } catch (EmptyItemListException ex) {
            fail("DAFUQ is going on ? You should test your test function !");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException | NoSuchFieldException ex) {
            fail("Exception found in introspection");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of subscribe method, of class Seller.
     */
    @Test
    public void testSubscribe() {
        try {
            seller.unsubscribe(bidder);                                         //In the setup function, bidder has already subscribed.
            Field f = seller.getClass().getDeclaredField("bidders");            //Then it is necessary to remove it from the list before starting.
            f.setAccessible(true);
            ArrayList<Bidder> g = (ArrayList) f.get(seller);
            assertTrue("Subscribe list not empty", g.isEmpty());                 //If the remove didn't work
            System.out.println("subscribe");
            Observer bidder = this.bidder;
            Seller instance = seller;
            instance.subscribe(bidder);
            assertTrue("Bidder did not subscribe.", g.contains(bidder));         //If the subscribe didn't work
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            fail("Exception found");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of notifyObserver method, of class Seller.
     *
     * Stay cautious with this one because it is one of the main function of the
     * code. In other words, bugs could come up from other functions called by
     * this one.
     *
     * Should be considered as a whole program test function.
     */
    @Test
    public void testNotifyObserver() {
        System.out.println("notifyObserver");
        Seller instance = seller;
        instance.notifyObserver();
        try {
            seller.getCurrentPrice();
            fail("All items are not sold, should not have append");             //Should have catch an error at this point
        } catch (EmptyItemListException ex) {
            
        }
    }

    /**
     * Test of unsubscribe method, of class Seller.
     */
    @Test
    public void testUnsubscribe() {
        try {
            // In the setup function, bidder has already subscribed, 
            //not need to do it again
            System.out.println("unsubscribe");
            Field f = seller.getClass().getDeclaredField("bidders");
            f.setAccessible(true);
            ArrayList<Item> g = (ArrayList) f.get(seller);
            assertFalse("No subscriber registered", g.isEmpty());
            Observer o = bidder;
            Seller instance = seller;
            instance.unsubscribe(o);
            assertTrue("The only bidder did not unsubscribe", g.isEmpty());
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getCurrentItem method, of class Seller.
     */
    @Test
    public void testGetCurrentItem() {
        try {
            System.out.println("getCurrentItem");
            Seller instance = seller;
            Item expResult = items.get(0);
            Item result = instance.getCurrentItem();
            assertEquals(expResult, result);
        } catch (EmptyItemListException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getCurrentPrice method, of class Seller.
     */
    @Test
    public void testGetCurrentPrice() {
        System.out.println("getCurrentPrice");
        Seller instance = seller;
        int expResult = items.get(0).getPrice();
        int result;
        try {
            result = instance.getCurrentPrice();
            assertEquals(expResult, result);
        } catch (EmptyItemListException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of getCurrentBuyer method, of class Seller.
     */
    @Test
    public void testGetCurrentBuyer() {
        System.out.println("getCurrentBuyer");
        Seller instance = seller;
        int result = instance.getCurrentBuyer();
        assertEquals(-1, result);

        try {
            instance.bid(new Offer(bidder, instance.getCurrentPrice() + instance.getCurrentItem().getMinBid()));
            Method m = instance.getClass().getDeclaredMethod("getBestOffer", null);
            m.setAccessible(true);
            m.invoke(instance, null);
            result = instance.getCurrentBuyer();
            assertEquals(bidder.getID(), result);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("Exception found in introspection");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyItemListException ex) {
            fail("Exception found with ItemList empty.\n"
                    + "Are you sure you initialized your code ?");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
