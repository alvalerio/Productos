
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
     * @param String text The body text of the comment. 
     * @param nameClient The name of the Client who want to comment.
     * @param Integer points The number of points to give to the product. 
     */
    public Comments(String text, String nameClient, Integer points)
    {
        this.text = text; 
        this.nameClient = nameClient; 
        CheckCommentsPoints(points);

    }
    /**
     * Show the details of a Comment. This include the name of the CLient who has commented, the body text of the Comment and the value of points the Client has
     * give to the Product. 
     *  
     */
    public void ShowComment(){
     
        System.out.println("Client: " + this.nameClient); 
        System.out.println("Comment: " + this.text); 
        System.out.println("Points: " + this.points.toString()); 
    }

    /**
     * Get Text 
     *
     * @return    text
     */
    public String getText()
    {
        return this.text; 

    }

    /**
     * Get Name Client 
     *
     * @return    nameClient 
     */
    public String getNameClient()
    {
        return this.nameClient; 

    }

    /**
     * Get Points 
     *
     * @return    points
     */
    public Integer getPoints()
    {
        return this.points; 

    }
    
    public void CheckCommentsPoints(Integer points){
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
}
