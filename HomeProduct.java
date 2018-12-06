
/**
 * Write a description of class HomeProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HomeProduct extends Product
{
    private String homePart;
    private Integer likes;
    private Integer dislikes; 
    /**
     * Constructor for objects of class HomeProduct
     */
    public HomeProduct()
    {
        super(); 
    }
/**
     * Parametrized constructor for objects of class HomeProduct
     */
    public HomeProduct(Integer id, String name, Integer quantity, Integer stockMin, Float price, String homePart)
    {
        super(id,name,quantity,stockMin, price);
        this.homePart = homePart; 
        this.discount=-0.05f;

    }
}
