import java.util.ArrayList; 
/**
 * Write a description of class VipClient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VipClient extends Client
{
    /**
     * Constructor for objects of class ClientVip
     */
    public VipClient()
    {
        super();
    }
 /**
     * Constructor Parametrized for objects of class Client
     * @param name The client's name
     * @param id The client's identifying number
     * @param age The client's age 
     * @param actualLocation The actual location of the client
     */
    
    public VipClient(Integer id, String name, Integer age, String actualLocation){
        super(id, name, age, actualLocation); 

    }
    
    public void PostComment(String namebyClient){

        if(favouriteProducts.containsKey(namebyClient)){
            Product product = new Product(); 
            product = FindProductbyName(namebyClient);
            if(product instanceof FoodProduct){
                System.out.println("Error. The product is a FoodProduct so you can't comment it");
            }else{
                product.PostComment("I really like this product", this.name, 4);
                if(product instanceof HomeProduct){
                    HomeProduct hp = (HomeProduct)product;
                    hp.Like();
                }              
            }
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }
    
    @Override
    public ArrayList PrepareOrder(){
        
        ArrayList favouriteOrder = new ArrayList<Product>(); 
        for(Product product : favouriteProducts.values()){
            favouriteOrder.add(product);            
        }
    
        return favouriteOrder; 
    }
    
    public Float GetPriceOrder(ArrayList<Product> favouriteOrder){
        Float totalPrice = 0.0f; 
        for(Product product : favouriteOrder){
            totalPrice += product.getPrice() + (product.getPrice()*product.getDiscount());            
        }  
        return totalPrice; 
    }
    
    @Override
    public void MakeOrder(ArrayList<Product> favouriteOrder){
        StockManager SM = StockManager.getInstance();
        this.moneySpent += this.GetPriceOrder(favouriteOrder); 
        SM.MakeVipOrder(favouriteOrder);
    }
    
    
    
}