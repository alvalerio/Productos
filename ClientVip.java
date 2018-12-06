
/**
 * Write a description of class ClientVip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClientVip extends Client
{

    /**
     * Constructor for objects of class ClientVip
     */
    public ClientVip()
    {

    }
    
    
    @Override
    public void PostComment(String namebyClient, String comment, Integer points){
        
        if(favouriteProducts.containsKey(namebyClient)){
            Product product = new Product(); 
            product = FindProductbyName(namebyClient);
            product.PostComment(comment, this.name, points);
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }
}
