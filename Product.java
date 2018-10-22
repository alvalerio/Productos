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
    }
    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(Integer id, String name)
    {
        this.id = id;
        this.name = name;
        this.quantity = 100;
        this.commentsList = new ArrayList<Comments>(); 
        this.stockMin=50;
    }

    /**
     * @return The product's id.
     */
    public Integer getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public Integer getQuantity()
    {
        return this.quantity;
    }
    /**
     * @return The stock Min.
     */
    public Integer getStock(){
        return this.stockMin;
    }

    /**
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
    
    public void PostComment(String comment, String nameClient, Integer points){
        if( NotInList(nameClient)){
            Comments newComment = new Comments(comment, nameClient, points);
            commentsList.add(newComment);
        } else {
            System.out.println("Error. The Client has alredy comment this product"); 
        }
    }

    public boolean NotInList(String nameClient){
        boolean aux = true; 
        for (Comments comments : commentsList){
            if(comments.getNameClient() == nameClient){
                aux = false; 
            }
        }
        return aux; 

    }
    
    public void ShowComments(){
        
        for (Comments comments : commentsList){
            comments.ShowComment();             
        }
    
    }
}
