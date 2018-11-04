/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class StockDemo
{
    // The stock manager.
    private StockManager sww;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        sww = new StockManager();
        //sww.addProduct(new Product(132, "Clock Radio"));
        //sww.addProduct(new Product(37,  "Mobile Phone"));
        //sww.addProduct(new Product(23,  "Microwave Oven"));
    }
    
    
    public void StarWarsDemo(){
    
    // CREATE THE CLIENT    
    Client gameDP = new Client ("GameDP", 123, 50, "Caceres"); 
    
    Product figura = new Product(); 
    
    // DOES NOT EXIST 
    sww.findProduct(1);
    
    // DOES NOT EXIST 
    gameDP.findProductFavourite(figura);
    
    Product figura1 = new Product(1,"Figura Han Solo", 2, 3);
    
    sww.addProduct(figura1);
    
    Product figura2 = new Product(2, "Figura Luke Skywalker", 2, 3); 
    
    sww.addProduct(figura2);
    
    //CREARTE THE PRODUCTS
    
    Product figura3 = new Product(3, "Figura Leia Organa", 5, 3); 
    Product figura4 = new Product(4, "Figura Darth Vader", 5, 3); 
    Product figura5 = new Product(5, "Figura Obi-Wan Kenobi", 5, 3); 
    Product figura6 = new Product(6, "Figura Chewbacca", 5, 3); 
    Product figura7 = new Product(7, "Figura R2-D2", 5, 3); 
    Product figura8 = new Product(8, "Figura C-3PO", 5, 3); 
    Product figura9 = new Product(9, "Figura Kylo Ren", 4, 2); 
    Product figura10 = new Product(10, "Figura Conde Dooku", 4, 2); 
    Product figura11 = new Product(11, "Figura Padmé Amidala", 4, 2); 
    Product figura12 = new Product(12, "Figura Rey", 4, 2); 
    Product figura13 = new Product(13, "Figura Emperador Palpatine", 4, 1); 
    Product figura14 = new Product(14, "Figura Darth Maul", 4, 2); 
    Product figura15 = new Product(15, "Figura Jabba the Hutt", 4, 2); 
    Product figura16 = new Product(16, "Figura Yoda", 4, 2); 
    Product figura17 = new Product(17, "Figura General Hux", 4, 1); 
    Product figura18 = new Product(18, "Nave Enterprise ", 6, 2); 
    Product figura19 = new Product(19, "Nave Halcón Milenario ", 6, 2); 
    Product figura20 = new Product(20, "Nave Tie Figther ", 6, 2); 
    Product figura21 = new Product(21, "Nave X-Wing ", 6, 2); 
    Product figura22 = new Product(22, "Maqueta Alderaan ", 8, 2); 
    Product figura23 = new Product(23, "Maqueta Dagobah ", 8, 2); 
    Product figura24 = new Product(24, "Maqueta Hoth ", 8, 2); 
    Product figura25 = new Product(25, "Maqueta Corelia ", 8, 2); 
    
    // PUT IN STOCK
    
    sww.addProduct(figura3);
    sww.addProduct(figura4);
    sww.addProduct(figura5);
    sww.addProduct(figura6);
    sww.addProduct(figura7);
    sww.addProduct(figura8);
    sww.addProduct(figura9);
    sww.addProduct(figura10);
    sww.addProduct(figura11);
    sww.addProduct(figura12);
    sww.addProduct(figura13);
    sww.addProduct(figura14);
    sww.addProduct(figura15);
    sww.addProduct(figura16);
    sww.addProduct(figura17);
    sww.addProduct(figura18);
    sww.addProduct(figura19);
    sww.addProduct(figura20);
    sww.addProduct(figura21);
    sww.addProduct(figura22);
    sww.addProduct(figura23);
    sww.addProduct(figura24);
    sww.addProduct(figura25);
    
    
    
    // EXIST AND OK
    sww.findProduct(16);
    
    // DOES NOT EXIST 
    gameDP.findProductFavourite(figura16);
    }
    
    /**
     * 
     */
    /*
    public void StockDemoFavourite()
    {
        
        Client client = new Client ("Sosa",1234, 25, "Garrovillas"); 
        client.AddProductFavourite(manager.findProduct(132),"Radio Reloj");  
        client.AddProductFavourite(manager.findProduct(37), "Movi");
        client.AddProductFavourite(manager.findProduct(23), "Microndas wapo");
       
        
        System.out.println("We show the products in favouirte list of Client1 ");
        client.ShowProducts();
        
        
        Client client1 = new Client ("Federico",1235, 26, "Cabezuela");
        client1.AddProductFavourite(manager.findProduct(132),"Radio Reloj");  
        client1.AddProductFavourite(manager.findProduct(23), "Microndas pepino");
        
        System.out.println("We show the products in favouirte list of Client2 ");
        client1.ShowProducts();
        
        
        System.out.println("We TEST the Comments ");
        
        client.PostComment("Movi", "Muchus megatronis", 6);        
        client.PostComment("Movi", "Muchus megatronis1", 3);
        client.PostComment("Movi", "Muchus megatronis2", -3);
        
        System.out.println("If the Client do not have the product in his favourite list ");
        client1.PostComment("Movi", "Mu wenu", 2);
        
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
         
        System.out.println("TEST OF ORDER FAVOURITES/////////////////////////////////////////////////////////////");
        
        client.MakeOrderFavourites(manager);
    }*/
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    /*public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 5);
        manager.printProductDetails();
    }
    */
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
        Product product = sww.findProduct(id);
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
        return sww;
    }
   
}
