import java.util.ArrayList;
import java.util.Map; 
import java.util.HashMap; 
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    // A list of the orders.
    private Map<Integer, Product> order;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        this.stock = new ArrayList<Product>();
        this.order = new HashMap<Integer, Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Add a product to the order list.
     * @param item The item to be added.
     */
    public void addProductOrder(Integer OrderQuantity, Product item)
    {
        order.put(OrderQuantity, item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product ProductoEncontrado=findProduct(id);
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
    public Product findProduct(int id)
    {
        Product productReturn=new Product();
        
        for (Product product : stock){
            if(product.getID()==id){
                productReturn = product;              
            }
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
    public int numberInStock(int id)
    {
        int quantity = 0; 
        Product ProductoEncontrado=findProduct(id);
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
        if(numberInStock(product.getID()) < product.getStock()){
            Integer amount = product.getStock() - product.getQuantity(); 
            delivery(product.getID(), amount);
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
}
