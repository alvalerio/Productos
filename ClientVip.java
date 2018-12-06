
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
            if(product instanceof FoodProduct){
                System.out.println("Error. The product is a FoodProduct so you musn't comment it");
            }else{
                product.PostComment("I really like this product", this.name, 4);
            }
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }}
