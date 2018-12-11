import java.util.Collection;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Iterator; 
import java.util.ArrayList;
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
        ArrayList favouriteOrder = new ArrayList<Product>(); 
        
        return favouriteOrder; 
    }
}
