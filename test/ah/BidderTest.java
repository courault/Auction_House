package ah;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BidderTest
{

	private Bidder bidder;
	private Seller seller;
	private ArrayList<Item> items;

	public BidderTest()
	{
	}

	@BeforeClass
	public static void setUpClass()
	{
	}

	@AfterClass
	public static void tearDownClass()
	{
	}

	@Before
	public void setUp()
	{
		items = new ArrayList<>();
		items.add(new Item("Stuff 1", 100));
		try
		{
			bidder = new Bidder(1000, 0);
			this.seller = new Seller(items);
			seller.subscribe(bidder);
		}
		catch(EmptyItemListException ex)
		{
			Logger.getLogger(SellerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@After
	public void tearDown()
	{
	}

	/**
	 * Test of bidMonney method, of class Bidder.
	 */
	@Test
	public void testBidMonney()
	{
		System.out.println("bidMonney");
		Bidder instance = bidder;
		assertTrue("The bidder should have enough money.",
				instance.bidMonney(instance.getWallet()));
		assertFalse("The bidder sould not enough money.",
				instance.bidMonney(instance.getWallet() + 1));
	}

	/**
	 * Test of bidRefund method, of class Bidder.
	 */
	@Test
	public void testBidRefund()
	{
		System.out.println("bidRefund");
		int bid = 1234;
		int before = bidder.getWallet();
		bidder.bidRefund(bid);
		assertTrue("The bidder should have been credited of " + bid,
				bidder.getWallet() - bid == before);
	}

//    /**
//     * Test of refresh method, of class Bidder.
//     */
//    @Test
//    public void testRefresh() {
//        System.out.println("refresh");
//        bidder.refresh(seller);
//
//        try {
//            Field f = seller.getClass().getDeclaredField("offers");
//            f.setAccessible(true);
//            ArrayList<Offer> offers = (ArrayList) f.get(seller);
//            assertEquals("The only offer should come from the bidder of the function",
//                    offers.get(0).getBidder(),bidder);
//        } catch (NoSuchFieldException | SecurityException |
//                IllegalArgumentException | IllegalAccessException ex) {
//            Logger.getLogger(BidderTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
	/**
	 * Test of getID method, of class Bidder.
	 */
	@Test
	public void testGetID()
	{
		System.out.println("getID");
		int expResult = 0;                                                      //Defined at 0 in constructor
		int result = bidder.getID();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getWallet method, of class Bidder.
	 */
	@Test
	public void testGetWallet()
	{
		System.out.println("getWallet");
		int expResult = 1000;                                                   //Defined at 1000 in constructor
		int result = bidder.getWallet();
		assertEquals(expResult, result);
	}

}
