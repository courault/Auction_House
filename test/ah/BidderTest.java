package ah;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BidderTest {
    
    public BidderTest() {
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
     * Test of bidMonney method, of class Bidder.
     */
    @Test
    public void testBidMonney() {
        System.out.println("bidMonney");
        int bid = 0;
        Bidder instance = null;
        boolean expResult = false;
        boolean result = instance.bidMonney(bid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bidRefund method, of class Bidder.
     */
    @Test
    public void testBidRefund() {
        System.out.println("bidRefund");
        int bid = 0;
        Bidder instance = null;
        instance.bidRefund(bid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class Bidder.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh");
        Seller seller = null;
        Bidder instance = null;
        instance.refresh(seller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bidder.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bidder instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Bidder.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Bidder instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWallet method, of class Bidder.
     */
    @Test
    public void testGetWallet() {
        System.out.println("getWallet");
        Bidder instance = null;
        int expResult = 0;
        int result = instance.getWallet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
