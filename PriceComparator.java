import java.util.*; 
import java.util.Comparator; 
/**
 * Write a description of class PriceComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public class PriceComparator implements Comparator<Product>
{
    /**
     * Constructor for objects of class PriceComparator
     */
    public int compare(Product p1, Product p2)
    {
        if(p1.getPrice() == p2.getPrice()){
            return 0; 
        }else if(p1.getPrice() > p2.getPrice()){
            
            return 1; 
        }
        else{
            return -1; 
        }
    }

}
