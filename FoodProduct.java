
/**
 * Write a description of class FoodProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FoodProduct extends Product
{
    String fechaCaducidad;
    /**
     * Constructor for objects of class FoodProduct
     */
    public FoodProduct()
    {
        this.price=this.price-(this.price*0.10f);
        this.fechaCaducidad="";
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return  y;
    }
}
