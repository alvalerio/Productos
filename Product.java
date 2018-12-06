import java.util.ArrayList; 
/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Product
{
    // An identifying number for this product.
    private Integer id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private Integer quantity;
    // ArrayList of Comments 
    private ArrayList<Comments> commentsList; 
    //Stock of product
    private Integer stockMin;
    //Price of product
    protected Float price;
    //Discount of product
    protected Float discount;
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
        this.commentsList = new ArrayList<Comments>(); 
        this.stockMin=0;
        this.price=0.0f;
        this.discount=0.0f;
    }

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is 100.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(Integer id, String name, Integer quantity, Integer stockMin, Float price)
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
        this.commentsList = new ArrayList<Comments>(); 
        this.stockMin=stockMin;
        this.price=price;
        this.discount=0.0f;
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
        if(quantity > OrderQuantity) {
            quantity = quantity - OrderQuantity;
            System.out.println(
                "Sold: "+OrderQuantity +" of " + name + " Stock : " + quantity);
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
        for (Comments comment : commentsList){
            if(comment.getNameClient() == nameClient){
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
}
