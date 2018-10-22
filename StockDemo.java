/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 * Dukito
 */
/*Valerio*/
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
    }
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public void StockDemoFavourite()
    {
        
        Client client = new Client ("Sosa",1234, 25, "Garrovillas"); 
        client.AddProductFavourite(manager.findProduct(132),"Radio Reloj");  
        client.AddProductFavourite(manager.findProduct(37), "Movi");
        client.AddProductFavourite(manager.findProduct(23), "Microndas wapo");
        client.AddProductFavourite(manager.findProduct(25), "Marihuana");
        client.ShowProducts();
        
        
    /*    Client client1 = new Client ("Federico",1235, 26, "Cabezuela");
        client1.AddProductFavourite(manager.findProduct(132),"Radio Reloj");  
        client1.AddProductFavourite(manager.findProduct(23), "Microndas pepino");
        client1.ShowProducts();
        
        client.PostComment("Movi", "Muchus megatronis", 6);
        client1.PostComment("Movi", "Mu wenu", 2);
        client.PostComment("Movi", "Muchus megatronis1", 3);
        
        Product mobile = manager.findProduct(37);
        mobile.ShowComments();
        
        System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
        client.MakeOrder("Movi", 30, manager);
        
        System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
        client.MakeOrder("Movi", 60, manager);
        
        System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
        client1.MakeOrder("Movi", 60, manager);
        
        System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
        client1.MakeOrder("Radio Reloj", 40, manager);
        */
        System.out.println("TEST OF ORDER FAVOURITES/////////////////////////////////////////////////////////////");
        
        client.MakeOrderFavourites(manager);
    }
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 5);
        manager.printProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        if(product != null) {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        if(product == null) {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
