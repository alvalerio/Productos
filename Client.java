import java.util.Collection;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Iterator; 
import java.util.Objects; 
import java.util.ArrayList; 
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 *//**/
public class Client
{
    // instance variables - replace the example below with your own

    protected String name;
    protected Integer id;
    protected Integer age;
    protected String actualLocation;
    protected Map<String, Product> favouriteProducts; 
    protected Float moneySpent; 
    protected Integer orderNumber; 

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
        this.moneySpent= 0.0f; 
        this.orderNumber = 0; 

    }

    /**
     * Constructor Parametrized for objects of class Client
     * @param name The client's name
     * @param id The client's identifying number
     * @param age The client's age 
     * @param actualLocation The actual location of the client
     */
    public Client(Integer id, String name, Integer age, String actualLocation){
        this.name=name;
        this.id=id;
        this.age=age;
        this.actualLocation=actualLocation;
        this.favouriteProducts = new HashMap<>(); 
        this.moneySpent= 0.0f; 
        this.orderNumber = 0; 

    }

    /**
     * Add a favourite product to the map 
     *
     * @param  product The product who will be added
     * @param namebyClient The name that the client put to the product
     */
    public void AddProductFavourite(Product product, String namebyClient)
    {

        if(!favouriteProducts.containsKey(namebyClient)){
            favouriteProducts.put(namebyClient, product);   
        }else{
            System.out.println("The product is alredy a favourite product");
        }

    }

    /**
     * Delete a favourite product to the map 
     *
     * @param  namebyClient The name of the product that you will remove
     */
    public void DeleteProductFavourite(String namebyClient)
    {
        if(favouriteProducts.containsKey(namebyClient)){
            favouriteProducts.remove(namebyClient);   
        }else{
            System.out.println("The product is not a favourite product");
        }

    }

   
    /**
     * Find a product in the map of favourite products
     *
     * @param  product The product that you want to find
     */
    public boolean findProductFavourite(Product product){
        boolean aux=false;
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){
            if(favouriteProducts.containsValue(product)){
                aux=true;
            }
        }
        if(!aux){
             System.out.println("The product does not exist in the Favourite List");   
        }
        return aux;
    }

    /**
     * Get name
     *
     * @return    name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get Id
     * 
     * @return    id
     */ 
    public int getId(){
        return this.id;
    }

    /**
     * Get Age
     *
     * @return    age
     */
    public int getAge(){
        return this.age;
    }
 /**
     * Get moneySpent
     *
     * @return   moneySpent
     */
    public Float getMoneySpent(){
        return this.moneySpent;
    }
    /**
     * Get ActualLocation
     * 
     * @return    actualLocation
     */
    public String getActualLocation(){
        return this.actualLocation;
    }

    /**
     * Set Name
     *
     * @param  name
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Set Id
     *
     * @param  id
     */ 
    public void setId(int id){
        this.id=id;
    }

    /**
     * Set Age
     *
     * @param  age
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * Set ActualLocation
     *
     * @param   actualLocation
     */
    public void setActualLocation(String actualLocation){
        this.actualLocation=actualLocation;
    }
    
        /**
     * Get orderNumber
     *
     * @return    orderNumber
     */
    public Integer getOrderNumber(){
        return this.orderNumber;
    }
    /**
     * Show every product in the favourite list of the client
     * 
     */
    public void ShowProducts(){
        System.out.println("The list of favourite products: ");
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){

            System.out.println(entry.toString()); 
        }

    }

    
    /**
     * Post a comment in determined products 
     *
     * @param   namebyClient A name given by the client to the product
     * @param   comment Comment to be posted
     * @param   points Points to rive [Range 1-5]
     *       
     */
    public void PostComment(String namebyClient, String comment, Integer points){
        
        if(favouriteProducts.containsKey(namebyClient)){
            Product product = new Product(); 
            product = FindProductbyName(namebyClient);
            
            product.PostComment(comment, this.name, points);
            
        }else {
            System.out.println("Error. You must add the product to favourite to comment"); 
        }
    }
    /**
     * Find a Product by a name given by the client
     *
     * @param namebyClient A name given by the client to the product
     */
    public Product FindProductbyName(String namebyClient){
        Product product = new Product(); 
        for (Map.Entry<String, Product> entry : favouriteProducts.entrySet()){
            if(entry.getKey()==namebyClient){
                product = entry.getValue();
            }
        }
        return product; 
    }
/**
     * Make a order to the Store Manager of a product found using a name given by the client. 
     * The quantity of the product may variate. 
     *
     * @param   namebyClient A name given by the client to the product
     * @param   OrderQuantity The quantity to the product of the order
     * @param   SM The Stock Manager who sells products     
     */
    public void MakeOrder(ArrayList<Product> favouriteOrder){

    }
/**
     * Make a order to the Store Manager of a product found in the Favourite List of the client. 
     * The quantity of the product is 1 of each. 
     *
     * @param   SM The Stock Manager who sells products  
     */
    public void MakeOrderFavourites(StockManager SM){
        
        SM.getInstance(); 
        HashMap favouriteOrder = new HashMap<Product, Integer>(); 
        for(Map.Entry<String, Product> entry : favouriteProducts.entrySet()){            
            favouriteOrder.put(entry.getValue(), 1);             
        }
        SM.FavouriteOrder(favouriteOrder);

    }
    
    @Override
    public int hashCode(){
      return Objects.hash(this.id, this.name); 
    }
    
    @Override
    public boolean equals(Object obj) {
        Client client = (Client) obj; 
     return (client.getName().equals(this.getName()) && client.getId() == (this.getId()));
        
    }
    
    public ArrayList PrepareOrder(){
        return null; 
    }
    
    protected void IncreaseOrderNumber(){
        this.orderNumber++; 
    }
    
    public Map<String, Product> getFavouriteProductList(){
        return this.favouriteProducts; 
    }
}
