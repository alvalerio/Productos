
/**
 * Write a description of class Comments here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Comments
{
    private String text; 
    private String nameClient; 
    private Integer points;

    /**
     * Constructor for objects of class Comments
     */
    public Comments()
    {
        this.text = ""; 
        this.nameClient = ""; 
        this.points = 0; 
       
    }
/**
     * Parametricsize Constructor for objects of class Comments
     */
    public Comments(String text, String nameClient, Integer points)
    {
        this.text = text; 
        this.nameClient = nameClient; 
        this.points = points; 
       
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
       
    }
    /**
     * Get Text 
     *
     * @param  
     * @return    text
     */
    public String getText()
    {
        return this.text; 
       
    }
    
    /**
     * Get Name Client 
     *
     * @param  
     * @return    nameClient 
     */
    public String getNameClient()
    {
        return this.nameClient; 
       
    }
    /**
     * Get Points 
     *
     * @param  
     * @return    points
     */
    public Integer getPoints()
    {
        return this.points; 
       
    }
}
