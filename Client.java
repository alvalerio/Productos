import java.util.Collection;
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 *//**/
public class Client
{
    // instance variables - replace the example below with your own

    private String name;
    private int id;
    private int age;
    private String actualLocation;

    /**
     * Constructor for objects of class Client
     */
    public Client()
    {
        this.name="";
        this.id=0;
        this.age=0;
        this.actualLocation="";

    }

    /**
     * Constructor Parametrized for objects of class Client
     */
    public Client(String name, int id, int age, String actualLocation){
        this.name=name;
        this.id=id;
        this.age=age;
        this.actualLocation=actualLocation;

    }

    /**
     * Get name
     *
     * @param  
     * @return    name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get Id
     *
     * @param  
     * @return    id
     */ 
    public int getId(){
        return this.id;
    }

    /**
     * Get Age
     *
     * @param  
     * @return    age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Get ActualLocation
     *
     * @param  
     * @return    actualLocation
     */
    public String getActualLocation(){
        return this.actualLocation;
    }

    /**
     * Set Name
     *
     * @param  name
     * @return    
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Set Id
     *
     * @param  id
     * @return    
     */ 
    public void setId(int id){
        this.id=id;
    }

    /**
     * Set Age
     *
     * @param  age
     * @return    
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * Set ActualLocation
     *
     * @param   actualLocation
     * @return    
     */
    public void setActualLocation(String actualLocation){
        this.actualLocation=actualLocation;
    }
    
}
