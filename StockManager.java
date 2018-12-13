import java.util.ArrayList;
import java.util.Map; 
import java.util.HashMap; 
import java.util.Set; 
import java.util.HashSet; 
import java.util.Iterator; 
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    
    private String name; 
    // A list of the products.
    private ArrayList<Product> stock;
    // A list of the orders.
    private Map<Product, Integer> order;
    // A set of the Clients. 
    private Set<Client> clientsSet; 
    
    //Singleton
    private static StockManager SM; 
    
    private ArrayList<String> defaultComments; 
    
    /**
     * Initialise the stock manager.
     */
    private StockManager()
    {   
        this.name = ""; 
        this.stock = new ArrayList<Product>();
        this.order = new HashMap<Product, Integer>();
        this.clientsSet = new HashSet<Client>(); 
        this.defaultComments = new ArrayList<String>(); 
        InitializeDefaultComments();
        
    }
    
    private StockManager(String name){
     
        this.name=name; 
        this.stock = new ArrayList<Product>();
        this.order = new HashMap<Product, Integer>();
        this.clientsSet = new HashSet<Client>();
        this.defaultComments = new ArrayList<String>(); 
        InitializeDefaultComments();
    }
    
    public static StockManager getInstanceParametrized(String name){
        
        if(SM == null){
            SM = new StockManager(name); 
        }
        return SM ;
    }
    
    public static StockManager getInstance(){
     
        if(SM == null){
            SM = new StockManager(); 
        }/*else{
         System.out.println("Already exist a instance of StockManager");    
        }*/
        
     return SM;    
    }

    public void addClient(Client client){
        clientsSet.add(client); 
    }
    
    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(!findProductBool(item)){
            stock.add(item);
        }else{
            System.out.println("The product has alredy exists");
        }
    }
    
    /**
     * Delete a product to the list.
     * @param item The item to be deleted.
     */
    public void deleteProduct(Product item)
    {
        if(findProductBool(item)){
            stock.remove(item);
        }else{
            System.out.println("The product has alredy deleted");
        }
    }
    /**
     * 
     */
    public boolean findProductBool(Product item){
        boolean aux = false; 
        Iterator<Product> it = stock.iterator(); 
        while(it.hasNext() && !aux){
            Product product = it.next(); 
            if(product.equals(item)){
                aux=true;       
        }
    }
        return aux;
    }

    /**
     * Add a product to the order list.
     * @param item The item to be added.
     */
    public void addProductOrder(Integer OrderQuantity, Product item)
    {
        boolean aux = false; 
        for(Map.Entry<Product, Integer> entry : order.entrySet()){
            if(item.equals(entry.getKey())){
                aux=true; 
                Integer aux1 = entry.getValue() + OrderQuantity;
                entry.setValue(aux1);
                item.AddSold(OrderQuantity); 
            }
        }
        if(!aux){
        order.put(item, OrderQuantity);
        item.AddSold(OrderQuantity);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(Product product, int amount)
    {
        Product ProductoEncontrado=findProduct(product);
        if(ProductoEncontrado!=null){
            ProductoEncontrado.increaseQuantity(amount);
            System.out.println("Stock aumented with " + amount); 
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(Product item)
    {
        Product productReturn=new Product();
        boolean aux = true;
        Iterator<Product> it = stock.iterator(); 

        while(it.hasNext() && aux){
            Product product = it.next(); 
            if(product.equals(item)){
                productReturn = product; 
                aux = false; 
                System.out.println(productReturn.toString()); 
            }
        }
        if(aux) {
         System.out.println("The product does not exist");   
        }
        return productReturn;
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product getProduct(Integer id)
    {
        boolean aux = true;
        Product productReturn = new Product(); 
        for(Product product : stock){    
            if(id == product.getID()){            
                productReturn = product; 
                aux = false; 
            }
        }
        if(aux) {
         System.out.println("The product does not exist");   
         return null; 
        }
        return productReturn;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(Product product)
    {
        int quantity = 0; 
        Product ProductoEncontrado=findProduct(product);
        if(ProductoEncontrado!=null){
            quantity=ProductoEncontrado.getQuantity();
        }
        return quantity;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product : stock){
            System.out.println(product.toString()); 
        }
    }

    /**
     * Print details of all product who has less than the minimun
     * number of quantity in stock 
     *
     * @param product The product to search if there is enough stock
     * @param quantity The minimun quantity of a product
     * @return 0.
     */
    public boolean EnoughStock(Product product,Integer quantity)
    {
        boolean aux = false; 

        for(Product productstock : stock) {
            if((product.getName() == productstock.getName()) && (quantity < productstock.getQuantity())){
                aux=true;  
            }
        }
        if(!aux){
            System.out.println("There is not enough stock of " + product.getName() + " to make a order"); 
            System.out.println("Stock in store : " + product.getQuantity()); 
        } 

        return aux; 
    }
    /**
     * Make a order with a specific quantity
     * 
     * @param Integer OrderQuantity The quantity of the product in a order  
     * @param Product product
     */
    public void AddToOrder(Integer OrderQuantity, Product product){

        if(EnoughStock(product, OrderQuantity)){
            addProductOrder(OrderQuantity, product);
            product.sellOrder(OrderQuantity);
            System.out.println("Order done with success. You have ordered " + OrderQuantity + " of " + product.getName()); 
            CheckStock(product); 
        }
    }
    /**
     * Calculate the difference that we need to increment to the stock
     * 
     * @param Product product
     */
    public void CheckStock(Product product){
        if(numberInStock(product) < product.getStock()){
            Integer amount = product.getStock() - product.getQuantity(); 
            delivery(product, amount);
            System.out.println("Products in stock: " + product.getQuantity()); 
        }else{
            System.out.println("There is enough stock of " + product.getName() + " to make a deliver");    
        } 

    }
    
    /**
     * Go throught the map and go calling the method AddToOrder
     * 
     * @param HashMap map The map with the favourite products
     */
    public void FavouriteOrder(HashMap<Product, Integer> map){

        for(Map.Entry<Product, Integer> entry : map.entrySet()){
            if(stock.contains(entry.getKey())){
                System.out.println("The " + entry.getKey().getName() + " is now in order"); 
                AddToOrder(entry.getValue(),entry.getKey());  
            }else{
               System.out.println("The " + entry.getKey().getName() + " is not avalible"); 
            
            }
        }
    }
    
    public void MakeVipOrder(ArrayList<Product> favouriteOrder){
        for(Product product : favouriteOrder){
            AddToOrder(1, product);
        }
    }
    public void MakeStandardOrder(Product product){
        AddToOrder(50, product);     
    }
    
    public void InitializeDefaultComments(){
        this.defaultComments.add("Bad product");
        this.defaultComments.add("Not very good product");
        this.defaultComments.add("Good product");
        this.defaultComments.add("Very good product");
        this.defaultComments.add("Excellent product");
    }
    
    public String getDefaultComments (Integer points){
       return this.defaultComments.get(points);         
    }
    
    public void getMostCommented(){
        Integer aux = 0; 
        Product p = new Product(); 
        for(Product product : stock){
            if(product.getNumberOfComments() > aux){
            aux = product.getNumberOfComments(); 
            p = product; 
        }                    
        }  
        System.out.println("The product more commented is:" + p.getName()); 
    }
    
    
    public Client getBestClient(){
        
        Client bestClient = new Client(); 
        Float aux = 0.0f; 
        
        for(Client client : clientsSet){
            if( client.getMoneySpent() > aux){
                bestClient = client; 
                aux = client.getMoneySpent(); 
            }                         
        }
        
        
        System.out.println("The client who spent more money is " + bestClient.getName()); 
        
        return bestClient; 
    }
    
    
    public Product getMostSold(){
        Product mostSold = new Product(); 
        for (Map.Entry<Product, Integer> entry : order.entrySet()){
            if(entry.getValue() > mostSold.getSoldCount()){
                mostSold = entry.getKey(); 
            }
            
        }
        System.out.println("The best sold product is  " + mostSold.getName());
        return mostSold; 
    }
}
