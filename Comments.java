
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
        if(points<=0){
            points=1;
            this.points = points; 
        }else if(points>5){
            points=5;
            this.points = points; 
        }else{
            this.points = points; 
        }

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
