import java.util.ArrayList;
/**
 * Write a description of class FoodProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FoodProduct extends Product
{
    public String ExpirationMonth; 
    /**
     * Constructor for objects of class FoodProduct
     */
    public FoodProduct()
    {
        super();
        this.ExpirationMonth = ""; 
        this.discount=-0.1f;
        
    }
    

    /**
     * Parametrized constructor for objects of class FoodProduct
     */
    public FoodProduct(Integer id, String name, Integer quantity, Integer stockMin, Float price, String ExpirationMonth)
    {
        super(id,name,quantity,stockMin, price);
        this.ExpirationMonth = ExpirationMonth; 
        this.discount=0.1f;

    }
    
    
}
