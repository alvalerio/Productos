
/**
 * Write a description of class LeisureProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EntertainmentProduct extends Product
{
    

    /**
     * Constructor for objects of class LeisureProduct
     */
    public EntertainmentProduct()
    {
        super();
    }
   /**
     * Parametrized constructor for objects of class LeisureProduct
     */
    public EntertainmentProduct(Integer id, String name, Integer quantity, Integer stockMin, Integer price)
    {
        super(id,name,quantity,stockMin, price);
        //this.discount=0.2f;

    }
}
