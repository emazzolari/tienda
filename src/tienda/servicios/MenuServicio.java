
package tienda.servicios;

public class MenuServicio {
    
    public static void menu () {
         ProductoServicio producto = new ProductoServicio();
          try {

                    producto.imprimirNombres();
                    System.out.println("------------------------------------------------");
                    producto.imprimirNombresYPrecios();
                    System.out.println("------------------------------------------------");
                    producto.imprimirProductosEntrePrecios();
                    System.out.println("------------------------------------------------");
                    producto.imprimirIncisoD();
               
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
         
    }
}
