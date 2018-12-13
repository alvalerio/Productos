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
        sww = sww.getInstance();
    }
    
    public void Entrega3DEMO(){
    System.out.println("Preparing the Simulation...\n"); 
    
    
    
    
    
    }
    
    
    /*
    public void Entrega2Demo(){
  
     System.out.println("Preparing the order...\n");   
        
     System.out.println("Getting the price of the order of a Vip Client...");
     VipClient VipClient = new VipClient(2, "BICTOR", 21, "VVA"); 
     Product hp = new HomeProduct(1, "Nintendo DS", 100,10, 1000, ""); 
     Product ep = new EntertainmentProduct(2, "XBOX ONE", 100, 10, 100); 
     Product fp = new FoodProduct(3, "RA", 100, 10, 10, ""); 
    
     VipClient.AddProductFavourite(hp, "hp");
     VipClient.AddProductFavourite(ep, "ep");   
     VipClient.AddProductFavourite(fp, "fp");   
     
     sww.addClient(VipClient);
     sww.addProduct(hp);
     sww.addProduct(ep);
     sww.addProduct(fp);
     System.out.println(VipClient.GetPriceOrder(VipClient.PrepareOrder())); 
     
     
     System.out.println("Getting the price of the order of a Standard Client...");
     
     StandardClient StClient = new StandardClient(1, "Dukino", 20, "CBZL");    
     
     StClient.AddProductFavourite(hp,"hps");
     StClient.AddProductFavourite(ep, "eps");   
     StClient.AddProductFavourite(fp, "fps");     
     sww.addClient(StClient);
     
     
     System.out.println(StClient.GetPriceOrder(StClient.PrepareOrder())); 
     
     System.out.println("The price of all order has alredy calculated\n");
     
     System.out.println("Making the VIP order...");
     VipClient.MakeVipOrder(VipClient.PrepareOrder());
     
     System.out.println("/////////////////////////");
     System.out.println("Making the STANDARD order...");
     StClient.MakeStandardOrder(StClient.PrepareOrder());
     System.out.println("Order done with success\n");
     
     System.out.println("Posting comments vip ...");
     VipClient.PostComment("hp");
     VipClient.PostComment("ep");
     VipClient.PostComment("fp");
     
     System.out.println("Posting comments std ...");
     StClient.PostComment("hps"); 
     StClient.PostComment("eps");
     StClient.PostComment("fps");
     
     StandardClient StClientCom = new StandardClient(3, "RAFA", 7, "LADRON"); 
     sww.addClient(StClientCom);
     StClientCom.AddProductFavourite(ep,"hpcomm");
     StClientCom.PostComment("hpcomm");
     
     
     System.out.println("Getting more commented product ...");
     sww.getMostCommented();
     
     
     System.out.println("Getting best client");
     sww.getBestClient(); 
    }
    /*
    
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
    
    //OUR TEST
    System.out.println("OurTest");
    gameDP.AddProductFavourite(sww.findProduct(3),"Leia");  
    gameDP.AddProductFavourite(sww.findProduct(4), "Darth Vader");
    gameDP.AddProductFavourite(sww.findProduct(9), "Kylo Ren");
    System.out.println("We show the products in favouirte list of Client1 ");
    gameDP.ShowProducts();
    
    Client gameDP1 = new Client("GameDP1", 124, 60, "Caceres");
    gameDP1.AddProductFavourite(sww.findProduct(3),"Leia Organa");
    gameDP1.AddProductFavourite(sww.findProduct(9), "Kylo");
    System.out.println("We show the products in favouirte list of Client2 ");
    gameDP1.ShowProducts();
    
    //Test Comments
    System.out.println("We TEST the Comments ");
    gameDP.PostComment("Darth Vader", "Very good product", 6);        
    gameDP.PostComment("Darth Vader", "Bad product", 3);
    gameDP.PostComment("Darth Vader", "Good product", -3);
    
    System.out.println("If the Client do not have the product in his favourite list ");
    gameDP1.PostComment("Darth Vader", "Bad Product", 2);
    
    figura4.ShowComments();
    
    System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
    gameDP.MakeOrder("Darth Vader", 4, sww);
    
    System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
    gameDP.MakeOrder("Darth Vader", 6, sww);
    
    System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
    gameDP1.MakeOrder("Darth Vader", 6, sww);
    
    System.out.println("TEST OF ORDER/////////////////////////////////////////////////////////////");
        
    gameDP1.MakeOrder("Leia Organa", 4, sww);
    
    System.out.println("TEST OF ORDER FAVOURITES/////////////////////////////////////////////////////////////");
        
    gameDP.MakeOrderFavourites(sww);
    
    }
    */
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
  /*  public void demo()
    {
        // Show details of all of the products.
        sww.printProductDetails();
        // Take delivery of 5 items of one of the products.
        sww.delivery(3, 5);
        sww.printProductDetails();
    }*/
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
  /*  public void showDetails(int id)
    {
        Product product = getProduct(id);
        if(product != null) {
            System.out.println(product.toString());
        }
    }/*
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
   /* public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }*/
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
   
   /* public Product getProduct(int id)
    {
        Product product = sww.findProduct(id);
        if(product == null) {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }/*

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return sww;
    }
   
}
