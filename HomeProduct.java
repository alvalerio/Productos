
/**
 * Write a description of class HomeProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HomeProduct extends Product
{
    

    /**
     * Constructor for objects of class HomeProduct
     */
    public HomeProduct()
    {
       this.price=this.price-(this.price*0.05f);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        return y;
    }
}
