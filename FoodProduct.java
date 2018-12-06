import java.util.ArrayList;
/**
 * Write a description of class FoodProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FoodProduct extends Product
{
    private String ExpirationMonth; 
    private Integer likes;
    private Integer unlikes; 
    /**
     * Constructor for objects of class FoodProduct
     */
    public FoodProduct()
    {
        super();
        this.ExpirationMonth = ""; 
        this.likes = 0; 
        this.unlikes = 0; 
        
    }
    

    /**
     * Parametrized constructor for objects of class FoodProduct
     */
    public FoodProduct(Integer id, String name, Integer quantity, Integer stockMin, Float price, String ExpirationMonth)
    {
        super(id,name,quantity,stockMin, price);
        this.ExpirationMonth = ExpirationMonth; 
        this.discount=0.1f;
        this.likes = 0; 
        this.unlikes = 0; 

    }
    
        public void Like(){
        this.likes++;
    }
    
    public void Unlike(){
        this.unlikes++;
    }
}
