package ah;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SellerTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of bid method, of class Seller.
     */
    @Test
    public void testBid() {
        System.out.println("bid");
        Bidder bidder = null;
        int price = 0;
        Seller instance = null;
        boolean expResult = false;
        boolean result = instance.bid(bidder, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
