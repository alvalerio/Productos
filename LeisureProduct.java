
/**
 * Write a description of class LeisureProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LeisureProduct extends Product
{
    

    /**
     * Constructor for objects of class LeisureProduct
     */
    public LeisureProduct()
    {
        super();
        this.discount=0f;
    }
   /**
     * Parametrized constructor for objects of class LeisureProduct
     */
    public LeisureProduct(Integer id, String name, Integer quantity, Integer stockMin, Float price)
    {
        super(id,name,quantity,stockMin, price);
        this.discount=0.2f;

    }
}
