import java.util.List;

/**
 * Clase creada para ser usada en la utilidad cargador
 * contiene el main del cargador. Se crea una instancia de la clase StockManager, una instancia de la clase Cargador
 * y se procesa el fichero de inicio, es decir, se leen todas las líneas y se van creando todas las instancias de la simulación
 * 
 * @version 6.0 -  16/11/2018 
 * @author Profesores DP
 */
public class Cargador {
    /**  
    número de elementos distintos que tendrá la simulación - StockManager, StandardClient, VipClient, HomeProduct, EntertainmentProduct, FoodProduct, Comment
     */
    static final int NUMELTOSCONF = 8;
    /**  
    atributo para almacenar el mapeo de los distintos elementos
     */
    static private DatoMapeo [] mapeo;

    private StockManager stockmanager;
    /**
     *  constructor parametrizado 
     *  @param e referencia a la instancia del patrón Singleton
     */
    Cargador(StockManager _stockmanager)  {
        stockmanager = _stockmanager;
        mapeo = new DatoMapeo[NUMELTOSCONF];
        mapeo[0]= new DatoMapeo("STOCKMANAGER", 2);
        mapeo[1]= new DatoMapeo("PRODUCTENTERTAINMENT", 6);
        mapeo[2]= new DatoMapeo("PRODUCTHOME", 7);
        mapeo[3]= new DatoMapeo("PRODUCTFOOD", 7);
        mapeo[4]= new DatoMapeo("CLIENTSTANDARD", 5);
        mapeo[5]= new DatoMapeo("CLIENTVIP", 5);
        mapeo[6]= new DatoMapeo("PRODUCTCLIENT", 4);
        mapeo[7]= new DatoMapeo("COMMENT", 4);
    }

    /**
     *  busca en mapeo el elemento leído del fichero inicio.txt y devuelve la posición en la que está 
     *  @param elto elemento a buscar en el array
     *  @return res posición en mapeo de dicho elemento
     */
    private int queElemento(String elto)  {
        int res=-1;
        boolean enc=false;

        for (int i=0; (i < NUMELTOSCONF && !enc); i++)  {
            if (mapeo[i].getNombre().equals(elto))      {
                res=i;
                enc=true;
            }
        }
        return res;
    }

    /**
     *  método que devuelve la que debe ser la unica instancia de la clase StockManager
     *  este metodo desaparecera cuando se implemente el patron Singleton
     *  @return stockmanager la instancia de la  clase StockManager
     */
    public StockManager obtenerStockManager (){
        return stockmanager.getInstance();
    }

    /**
     *  método que crea las distintas instancias de la simulación 
     *  @param elto nombre de la instancia que se pretende crear
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo de la instancia
     */
    public void crear(String elto, int numCampos, List<String> vCampos) {
        //Si existe elemento y el número de campos es correcto, procesarlo... si no, error
        int numElto = queElemento(elto);

        //Comprobación de datos básicos correctos
        if ((numElto!=-1) && (mapeo[numElto].getCampos() == numCampos))   {
            //procesar
            switch(numElto){
                case 0:    
                crearStockManager(numCampos,vCampos);
                break;
                case 1:
                crearEntertainmentProduct(numCampos,vCampos);
                break;
                case 2:
                crearHomeProduct(numCampos,vCampos);
                break;
                case 3:
                crearFoodProduct(numCampos,vCampos);
                break;
                case 4:
                crearStandardClient(numCampos,vCampos);
                break;
                case 5:
                crearVipClient(numCampos,vCampos);
                break;
                case 6:
                crearProductClient(numCampos,vCampos);
                break;
                case 7:
                crearComment(numCampos,vCampos);
                break;
            }
        }
        else
            System.out.println("ERROR Cargador::crear: Datos de configuración incorrectos... " + elto + "," + numCampos+"\n");
    }

    /**
     *  método que crea una instancia de la clase StockManager
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearStockManager(int numCampos, List<String> vCampos){
        System.out.println("Creado StockManager: " + vCampos.get(1) + "\n");
        //inicializar StockManager, cambiar por patron Singleton
        stockmanager = new StockManager(vCampos.get(1));
    }

    /**
     *  método que crea una instancia de la clase EntertainmentProduct
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearEntertainmentProduct(int numCampos, List<String> vCampos){
        System.out.println("Creado EntertainmentProduct: " + vCampos.get(2) + "\n");
        //inicializar EntertainmentProduct
        /*Product product = new EntertainmentProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)));
        stockmanager.addProduct(product);*/
        
        try{
            Product product = new EntertainmentProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)));
            stockmanager.addProduct(product);
            
        }catch(NumberFormatException e){
            Float input2 = Float.parseFloat(vCampos.get(5));
            Integer input1 = Integer.valueOf(input2.intValue());
            
            Product product = new EntertainmentProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), input1);
            stockmanager.addProduct(product);
            
        }
        
    }

    /**
     *  método que crea una instancia de la clase HomeProduct
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearHomeProduct(int numCampos, List<String> vCampos){
        System.out.println("Creado HomeProduct: " + vCampos.get(2) + "\n");
        //inicializar EntertainmentProduct
        try{
             Product product = new HomeProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)),
                vCampos.get(6));
             stockmanager.addProduct(product);
        
        }
        
        catch(NumberFormatException e){
             Float input2 = Float.parseFloat(vCampos.get(5));
             Integer input1 = Integer.valueOf(input2.intValue());
            
             Product product = new HomeProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), input1,
                vCampos.get(6));
             stockmanager.addProduct(product);
        }
        /*Product product = new HomeProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)),
                vCampos.get(6));
        stockmanager.addProduct(product);*/
    }

    /**
     *  método que crea una instancia de la clase FoodProduct
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearFoodProduct(int numCampos, List<String> vCampos){
        System.out.println("Creado FoodProduct: " + vCampos.get(2) + "\n");
        //inicializar EntertainmentProduct
        /*Product product = new FoodProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)),
                vCampos.get(6));
        stockmanager.addProduct(product);*/
        
        try{
            Product product = new FoodProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), Integer.parseInt(vCampos.get(5)),
                vCampos.get(6));
            stockmanager.addProduct(product);
            
        }catch(NumberFormatException e){
            Float input2 = Float.parseFloat(vCampos.get(5));
            Integer input1 = Integer.valueOf(input2.intValue());
          
            Product product = new FoodProduct(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)),
                Integer.parseInt(vCampos.get(4)), input1,
                vCampos.get(6));
            stockmanager.addProduct(product);
        }
    }

    /**
     *  método que crea una instancia de la clase StandardClient
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearStandardClient(int numCampos, List<String> vCampos){
        System.out.println("Creado StandardClient: " + vCampos.get(1) + "\n");
        //inicializar StandardClient
        StandardClient client = new StandardClient(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)), vCampos.get(4));
        stockmanager.addClient(client);
      
        
    }

    /**
     *  método que crea una instancia de la clase VipClient
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearVipClient(int numCampos, List<String> vCampos){
        System.out.println("Creado VipClient: " + vCampos.get(1) + "\n");
        //inicializar VipClient
        //StandardClient E CAMBIAU YOU
        VipClient client = new VipClient(Integer.parseInt(vCampos.get(1)),
                vCampos.get(2), Integer.parseInt(vCampos.get(3)), vCampos.get(4));
        stockmanager.addClient(client);
    }

    /**
     *  método que asocia una instancia de la clase Product a una de la clase Client
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearProductClient(int numCampos, List<String> vCampos){
        System.out.println("Leido ProductClient: " + vCampos.get(3) + "\n");
        //getProduct HE CAMBIAU YOU
        Product p = stockmanager.findProduct(Integer.parseInt(vCampos.get(2)));
        //asociar el producto p al cliente con id = Integer.parseInt(vCampos.get(1))
    }

    /**
     *  método que crear comentarios por defecto en la clase StockManager
     *  asociado a un cliente
     *  @param numCampos número de atributos que tendrá la instancia
     *  @param vCampos array que contiene los valores de cada atributo
     */
    private void crearComment(int numCampos, List<String> vCampos){
        System.out.println("Leido Comment: " + vCampos.get(1) + "\n");
        //almacenar el comentario en la clase StockManager

    }

}
