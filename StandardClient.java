import java.util.Collection;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Iterator; 
import java.util.ArrayList;
import java.util.*; 
/**
 * Write a description of class ClientStandar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StandardClient extends Client
{

    /**
     * Constructor for objects of class StandardClient
     */
    public StandardClient()
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
    public StandardClient(Integer id, String name, Integer age,String actualLocation){
        super(id, name, age, actualLocation);  

    }

    @Override
    public void MakeOrderFavourites(StockManager SM){
        SM.getInstance();
        HashMap favouriteOrder = new HashMap<Product, Integer>(); 
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){            
            favouriteOrder.put(entry.getValue(), 50);             
        }
        SM.FavouriteOrder(favouriteOrder);

    }

    @Override
    public ArrayList PrepareOrder(){
        ArrayList aux = new ArrayList<Product>(); 
        ArrayList favouriteOrder = new ArrayList<Product>(); 
        for(Product product : favouriteProducts.values()){
            aux.add(product); 
        }

        Collections.sort(aux, Collections.reverseOrder(new PriceComparator())); 
        favouriteOrder.add(aux.get(0)); 
        try{
            
        
        favouriteOrder.add(aux.get(1)); 
        
        }catch (IndexOutOfBoundsException e){
            
        //favouriteOrder.add(aux.get(0)); 
            
        }
        return favouriteOrder; 
    }

    public Float GetPriceOrder(ArrayList<Product> favouriteOrder){
        Float totalPrice = 0.0f;
        for(Product product : favouriteOrder){
            totalPrice += 50*( product.getPrice() + (product.getPrice()*(product.getDiscount())));
        }
        return totalPrice;
    }

    @Override
    public void MakeOrder(ArrayList<Product> favouriteOrder){
        StockManager SM=StockManager.getInstance();
        for(Product product : favouriteOrder){
                SM.MakeStandardOrder(product);
                IncreaseOrderNumber(); 
                PostComment(product);
            }   
        
        this.moneySpent += GetPriceOrder(favouriteOrder); 
    }

    /**
     * Post a comment in determined products 
     *
     * @param   namebyClient A name given by the client to the product
     * @param   comment Comment to be posted
     * @param   points Points to rive [Range 1-5]
     *       
     */
    public void PostComment(Product product){

        if(favouriteProducts.containsValue(product)){
            if(product instanceof FoodProduct){
                System.out.println("Error. The product is a FoodProduct so you can't comment it");
            }else{                               
                CheckPoint(product); 
            }
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }

    private void CheckPoint(Product product){

        Integer point = (product.name.length()%5)+1;
        String comment = StockManager.getInstance().getDefaultComments(point-1);

        if(product instanceof HomeProduct){
            HomeProduct hp = (HomeProduct)product;
            if(point >= 4){            
                hp.Like();
            }else if(point <= 2){
                hp.Unlike(); 
            }
        }
        product.PostComment(comment, this.name, point);

    }

}
