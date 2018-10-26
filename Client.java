import java.util.Collection;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Iterator; 
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 *//**/
public class Client
{
    // instance variables - replace the example below with your own

    private String name;
    private Integer id;
    private Integer age;
    private String actualLocation;
    private Map<String, Product> favouriteProducts; 

    /**
     * Constructor for objects of class Client
     */
    public Client()
    {
        this.name="";
        this.id=0;
        this.age=0;
        this.actualLocation="";
        this.favouriteProducts = new HashMap<>(); 

    }

    /**
     * Constructor Parametrized for objects of class Client
     */
    public Client(String name, int id, int age, String actualLocation){
        this.name=name;
        this.id=id;
        this.age=age;
        this.actualLocation=actualLocation;
        this.favouriteProducts = new HashMap<>(); 

    }

    /**
     * Add a favourite product to the map 
     *
     * @param  product The product who will be added
     * @return    0
     */
    public void AddProductFavourite(Product product, String namebyClient)
    {

        if(favouriteProducts.containsKey(namebyClient)){
            favouriteProducts.put(namebyClient, product);   
        }else{
            System.out.println("The product is alredy a favourite product");
        }

    }

    /**
     * Delete a favourite product to the map 
     *
     * @param  product The product who will be added
     * @return    0
     */
    public void DeleteProductFavourite(String namebyClient)
    {
        if(!favouriteProducts.containsKey(namebyClient)){
            favouriteProducts.remove(namebyClient);   
        }else{
            System.out.println("The product is not a favourite product");
        }

    }

   
    /**
     * Hace un pedido de un producto favorito 
     *
     * @param  
     * @return    0
     */
    public boolean findProductFavourite(Product product){
        boolean aux=false;
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){
            if(favouriteProducts.containsKey(product.getName())){
                aux=true;
            }
        }
        return aux;
    }

    /**
     * Get name
     *
     * @param  
     * @return    name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get Id
     *
     * @param  
     * @return    id
     */ 
    public int getId(){
        return this.id;
    }

    /**
     * Get Age
     *
     * @param  
     * @return    age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Get ActualLocation
     *
     * @param  
     * @return    actualLocation
     */
    public String getActualLocation(){
        return this.actualLocation;
    }

    /**
     * Set Name
     *
     * @param  name
     * @return    
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Set Id
     *
     * @param  id
     * @return    
     */ 
    public void setId(int id){
        this.id=id;
    }

    /**
     * Set Age
     *
     * @param  age
     * @return    
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * Set ActualLocation
     *
     * @param   actualLocation
     * @return    
     */
    public void setActualLocation(String actualLocation){
        this.actualLocation=actualLocation;
    }

    public void ShowProducts(){
        System.out.println("The list of favourite products: ");
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){

            System.out.println(entry.toString()); 
        }

    }

    
    /**
     * Post a comment in determined products 
     *
     * @param   product Product to be commented 
     * @return    
     */
    public void PostComment(String namebyClient, String comment, Integer points){
        
        if(!favouriteProducts.containsKey(namebyClient)){
            Product product = new Product(); 
            product = FindProductbyName(namebyClient);
            product.PostComment(comment, this.name, points);
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }

    public Product FindProductbyName(String namebyClient){
        Product product = new Product(); 
        for (Map.Entry<String, Product> entry : favouriteProducts.entrySet()){
            if(entry.getKey()==namebyClient){
                product = entry.getValue();
            }
        }
        return product; 
    }

    public void MakeOrder(String namebyClient, Integer OrderQuantity, StockManager SM){
       
        if(!favouriteProducts.containsKey(namebyClient)){
            Product product = new Product(); 
            product = FindProductbyName(namebyClient);
            SM.AddToOrder(OrderQuantity, product);
        }else{
            System.out.println("You only can order product whose is in your Favourite List");    
        }

    }

    public void MakeOrderFavourites(StockManager SM){

        HashMap favouriteOrder = new HashMap<Product, Integer>(); 
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){            
            favouriteOrder.put(entry.getValue(), 1);             
        }
        SM.FavouriteOrder(favouriteOrder);

    }
}
