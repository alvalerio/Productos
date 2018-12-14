

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StandardClientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StandardClientTest
{
    /**
     * Default constructor for test class StandardClientTest
     */
    public StandardClientTest()
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
    public void testStandardClient()
    {
        StandardClient standard1 = new StandardClient(1, "Pedro", 25, "Caceres");
        assertEquals(25, standard1.getAge());
        assertEquals("Caceres", standard1.getActualLocation());
        assertEquals(1, standard1.getId());
        assertEquals("Pedro", standard1.getName());
    }
}

