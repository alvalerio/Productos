

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentsTest
{
    /**
     * Default constructor for test class CommentsTest
     */
    public CommentsTest()
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

    @Test
    public void testComments()
    {
        Comments comments1 = new Comments("Good", "Pedro", 5);
        assertEquals("Pedro", comments1.getNameClient());
        assertEquals(5, (int)comments1.getPoints());
        assertEquals("Good", comments1.getText());
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
    public void testCheckPoints()
    {
        Comments comments1 = new Comments("Good", "Pedro", 6);
        assertEquals(5, (int)comments1.getPoints());
        
       Comments comments2 = new Comments("Good", "Pedro1", -3);
        assertEquals(1, (int)comments2.getPoints());
    }
}

