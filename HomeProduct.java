
/**
 * Write a description of class HomeProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HomeProduct extends Product implements Likeable
{
    private String homePart;
    private Integer likes;
    private Integer unlikes; 
    /**
     * Constructor for objects of class HomeProduct
     */
    public HomeProduct()
    {
        super(); 
        this.likes = 0; 
        this.unlikes = 0; 
    }
/**
     * Parametrized constructor for objects of class HomeProduct
     */
    public HomeProduct(Integer id, String name, Integer quantity, Integer stockMin, Integer price, String homePart)
    {
        super(id,name,quantity,stockMin, price);        
        this.homePart = homePart; 
        this.discount=-0.05f;
        this.likes = 0; 
        this.unlikes = 0; 
    }
    /**
     * Get the home part
     * @return The home part that is applied the product.
     *
    public String getHomePart(){
        return this.homePart;
    }
     /**
     * Increase in 1 the likes
     */
    @Override
    public void Like(){
        this.likes++;
    }
    /**
     * Decrease in 1 the likes
     */
    @Override
    public void Unlike(){
        this.unlikes++;
    }
    /**
     * Get the likes
     * @return The likes of the product.
     */
    @Override
    public Integer getLikes(){
        return this.likes;
    }
    /**
     * Get the unlikes
     * @return The unlikes of the product.
     */
    @Override
    public Integer getUnlikes(){
        return this.unlikes;
    }
}
