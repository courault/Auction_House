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
            this.seller = new Seller("Jack", items);
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
            if (seller.getCurrentBuyer() != bidder.getID()) {                   //Correct bid, should be accepted
                fail("Bidder is not the current buyer");
            }
            Field f = seller.getClass().getDeclaredField("offers");
            f.setAccessible(true);
            ArrayList<Bidder> offers = (ArrayList) f.get(seller);
            if (!offers.isEmpty()) //check if offers array not cleaned as it should be
            {
                fail("Offer array should be empty");
            }
            instance.bid(new Offer(bidder, seller.getCurrentPrice()));
            setUp();
            m = seller.getClass().getDeclaredMethod("getBestOffer", null);
            m.setAccessible(true);
            m.invoke(seller, null);
            if (seller.getCurrentBuyer() == bidder.getID()) {                   //Bid to low, should be rejected
                fail("Bidder should not be the current buyer");
            }
        } catch (EmptyItemListException ex) {
            fail("DAFUQ is going on ?");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException | NoSuchFieldException ex) {
            fail("Exception found");

            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of subscribe method, of class Seller.
     */
    @Test
    public void testSubscribe() {
        try {
            seller.unsubscribe(bidder);
            Field f = seller.getClass().getDeclaredField("bidders");
            f.setAccessible(true);
            ArrayList<Bidder> g = (ArrayList) f.get(seller);
            if (!g.isEmpty()) {
                fail("Subscribe list not empty");
            }
            System.out.println("subscribe");
            Observer bidder = this.bidder;
            Seller instance = seller;
            instance.subscribe(bidder);
            if (!g.contains(bidder)) {
                fail("Bidder did not subscribe.");
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            fail("Exception found");
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of notifyObserver method, of class Seller.
     */
    @Test
    public void testNotifyObserver() {
        System.out.println("notifyObserver");
            Seller instance = seller;
            instance.notifyObserver();
            if(!items.isEmpty())
                fail("All items are not sold, should not have ended");
            // TODO review the generated test code and remove the default call to fail.
            
    }

    /**
     * Test of unsubscribe method, of class Seller.
     */
    @Test
    public void testUnsubscribe() {
        try {
            System.out.println("unsubscribe");
            Field f = seller.getClass().getDeclaredField("bidders");
            f.setAccessible(true);
            ArrayList<Item> g = (ArrayList) f.get(seller);
            if(g.isEmpty())
                fail("No subscriber registered");
            Observer o = bidder;
            Seller instance = seller;
            instance.unsubscribe(o);
            // TODO review the generated test code and remove the default call to fail.
            if(!g.isEmpty()){
                System.out.println(g.size() + '\n' + g.get(0).getName());
                fail("The only bidder did not unsubscribe");
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
