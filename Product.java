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
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;
    // ArrayList of Comments 
    private ArrayList<Comments> commentsList; 

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
        this.commentsList = new ArrayList<Comments>(); 
    }

    /**
     * @return The product's id.
     */
    public int getID()
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
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +
               name +
               " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
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
}
