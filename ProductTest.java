

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProductTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductTest
{
    private Product product1;

    /**
     * Default constructor for test class ProductTest
     */
    public ProductTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        product1 = new Product(1, "product", 5, 2, 10);
        
    }
    @Test
    public void testProduct()
    {
        Product product1 = new Product(1, "Milk", 10, 2, 100);
        assertEquals(1, (int)new Integer(product1.getID()));
        assertEquals("Milk", product1.getName());
        assertEquals(100, (int)new Integer(product1.getPrice()));
        assertEquals(10, (int)new Integer(product1.getQuantity()));
        assertEquals(2, (int)new Integer(product1.getStock()));
        assertEquals(0, (int)new Integer(product1.getSoldCount()));
        assertEquals(0, (int)new Integer(product1.getNumberOfComments()));
        
    }
        @Test
    public void testAddSold()
    {
        assertEquals(0,(int)product1.getSoldCount());
        
        product1.AddSold(1);

        assertEquals(1,(int)product1.getSoldCount());
    }
    
         @Test
    public void testIncreaseQuantity()
    {
        assertEquals(5,(int)product1.getQuantity());
        
        product1.increaseQuantity(2);

        assertEquals(7,(int)product1.getQuantity());
    }
    
        @Test
    public void testSellOne()
    {
        assertEquals(5,(int)product1.getQuantity());
        
        product1.sellOne();

        assertEquals(4,(int)product1.getQuantity());
    }
    
    @Test
    public void testSellOrder()
    {
        assertEquals(5,(int)product1.getQuantity());
        
        product1.sellOrder(2);

        assertEquals(3,(int)product1.getQuantity());
    }
    
    @Test
    public void testPostComment()
    {
        assertEquals(0,(int)product1.getNumberOfComments());
        
        product1.PostComment("good", "Pedro", 5);

        assertEquals(1,(int)product1.getNumberOfComments());
    }
    
        @Test
    public void testHasCommented()
    {
        assertEquals(false,(boolean)product1.HasCommented("Pedro"));
        
        product1.PostComment("good", "Pedro", 5);

        assertEquals(true,(boolean)product1.HasCommented("Pedro"));
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    
}

