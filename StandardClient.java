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
    
    
    public ArrayList PrepareOrder(){
        ArrayList aux = new ArrayList<Product>(); 
        ArrayList favouriteOrder = new ArrayList<Product>(); 
        for(Product product : this.favouriteProducts.values()){
            aux.add(product); 
        }
        Collections.sort(aux, Collections.reverseOrder(new PriceComparator())); 
        favouriteOrder.add(aux.get(0)); 
        favouriteOrder.add(aux.get(1)); 
        return favouriteOrder; 
    }
    public Float GetPriceOrder(ArrayList<Product> favouriteOrder){
        Float totalPrice = 0.0f;
        for(Product product : favouriteOrder){
            totalPrice += product.getPrice() + (product.getPrice()*product.getDiscount());
        }
        return totalPrice;
    }
    
    public void MakeStandardOrder(ArrayList<Product> favouriteOrder){
        StockManager SM=StockManager.getInstance();
        
        Integer aux=0;
        for(Product product : favouriteOrder){
            if(aux<2){
            SM.MakeStandardOrder(product);
            aux++;
            }   
        }
        
    }
}
