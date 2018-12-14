import java.util.Set; 
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Iterator; 
/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Product
{
    // An identifying number for this product.
    protected Integer id;
    // The name of this product.
    protected String name;
    // The quantity of this product in stock.
    protected Integer quantity;
    // A Set of Comments 
    protected Set<Comments> commentsList; 
    //Stock of product
    protected Integer stockMin;
    //Price of product
    protected Integer price;
    //Discount of product
    protected Float discount;
    //Times sold 
    protected Integer soldCount; 
    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * 
     * 
     */
    public Product()
    {
        this.id = 0;
        this.name = "";
        this.quantity = 0;
        this.commentsList = new HashSet<Comments>(); 
        this.stockMin=0;        
        this.price=0;
        this.discount=0.0f;
        this.soldCount=0; 
    }

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is 100.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(Integer id, String name, Integer quantity, Integer stockMin, Integer price)
    {
        if(id<0){
            id=id*(-1);
        }
        if(quantity<0){
            quantity=quantity*(-1);
        }

         if(stockMin<0){
            stockMin=stockMin*(-1);
        }
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.commentsList = new HashSet<Comments>(); 
        this.stockMin=stockMin;
        try{
            this.price=price;
        }
        catch(NumberFormatException e){
            this.price=Math.round(price); 
            System.out.println(e.getMessage()); 
        }
        
       this.discount=0.0f;
       this.soldCount=0; 
    }

    /**
     * Get id
     * @return The product's id.
     */
    public Integer getID()
    {
        return id;
    }

    /**
     * Get name
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get quantity
     * @return The quantity in stock.
     */
    public Integer getQuantity()
    {
        return this.quantity;
    }

    /**
     * Get the minimun stock
     * @return The stock Min.
     */
    public Integer getStock(){
        return this.stockMin;
    }
    /**
     * Get the price
     * @return The price of the product.
     */
    public Integer getPrice(){
        return this.price;
    }
    /**
     * Get the discount
     * @return The discount of the product.
     */
    public Float getDiscount(){
        return this.discount;
    }
    /**
     * Get soldCount
     * @return The times a product was sold.
     */
    public Integer getSoldCount()
    {
        return this.soldCount;
    }
    /**
     * Set soldCount
     * @param Integer _soldCount
     */
    public void setSoldCount(Integer _soldCount)
    {
        this.soldCount = _soldCount;
    }
    
    public void AddSold(Integer quantity){
        this.soldCount += quantity;         
    }
    /**
     * Show the id, name and the quantity in stock
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        
        return "id : "+ this.id + " Name : " +
        this.name +
        " stock level: " + this.quantity;
        
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(Integer amount)
    {
        if(amount > 0) {
            quantity += amount;
        }
        else {
            System.out.println("Attempt to restock " +
                name +
                " with a non-positive amount: " +
                amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sellOne()
    {
        if(quantity > 0) {
            quantity--;
        }
        else {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }

    /**
     * Sell the list of order .
     * An error is reported if there appears to be no stock.
     * @param Integer OrderQuantity The quantity of a product the client want to order
     */
    public void sellOrder(Integer OrderQuantity)
    {
        if(quantity >= OrderQuantity) {
            quantity = quantity - OrderQuantity;
            System.out.println(
                "Sold: "+OrderQuantity +" of " + name);
        }
        else {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }

    /**
     * Post a comment in a product.
     * An error is reported if the client has alredy commented this product.
     * @param Integer OrderQuantity The quantity of a product the client want to order.
     * @param String nameClient The name of the client who want to comment.
     */
    public void PostComment(String comment, String nameClient, Integer points){

        // !commentsList.contains(nameClient)
        if(!HasCommented(nameClient)){

            Comments newComment = new Comments(comment, nameClient, points);
            commentsList.add(newComment);

        } else {
            System.out.println("Error. The Client has alredy comment this product"); 
        }
    }
    /**
     * 
     * @param String nameClient The name of the client who want to coment
     * @return True if the client has commented
     * 
     */
    public boolean HasCommented(String nameClient){
        boolean aux = false; 
        Iterator<Comments> it = commentsList.iterator(); 
        while(it.hasNext() && !aux){
            Comments c = it.next();
            if(c.getNameClient().equals(nameClient)){
                aux=true;       
            }            
        }
        
        return aux; 
    }

    /**
     * Show all the comments that a product have.
     *  
     */
    public void ShowComments(){

        for (Comments comments : commentsList){
            comments.ShowComment();             
        }

    }
    
    public Integer getNumberOfComments(){
        return commentsList.size(); 
    }
    
    @Override
    public int hashCode(){
      return Objects.hash(this.id, this.name); 
    }
    
    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj; 
     return ((product.getName().equals(this.getName())) && (product.getID() == this.getID()) && (product.discount == this.discount));
        
    }
}
