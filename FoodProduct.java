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
        this.price=this.price-(this.price*0.10f);
    }
    

    /**
     * Parametrized constructor for objects of class FoodProduct
     */
    public FoodProduct(Integer id, String name, Integer quantity, Integer stockMin, Float price, String ExpirationMonth)
    {
        super(id,name,quantity,stockMin, price);
        this.ExpirationMonth = ExpirationMonth; 

    }
    
    
}
