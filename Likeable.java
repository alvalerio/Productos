
/**
 * Write a description of interface Likeable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Likeable
{
     /**
     * Increase in 1 the likes
     */
    public void Like();
    /**
     * Decrease in 1 the likes
     */
    public void Unlike();
    /**
     * Get the likes
     * @return The likes of the product.
     */
    public Integer getLikes();
    /**
     * Get the unlikes
     * @return The unlikes of the product.
     */
    public Integer getUnlikes();
    
}
