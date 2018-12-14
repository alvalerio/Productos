

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VipClientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VipClientTest
{
    /**
     * Default constructor for test class VipClientTest
     */
    public VipClientTest()
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

    @Test
    public void testVipClient()
    {
        VipClient vipClien1 = new VipClient(1, "Pedro", 25, "Caceres");
        assertEquals(25, vipClien1.getAge());
        assertEquals(1, vipClien1.getId());
        assertEquals("Pedro", vipClien1.getName());
        assertEquals("Caceres", vipClien1.getActualLocation());
    }
}

