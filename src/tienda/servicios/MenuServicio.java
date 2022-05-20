package tienda.servicios;

public class MenuServicio {

    public static void menu() {
        ProductoServicio producto = new ProductoServicio();
        FabricanteServicio fabricante= new FabricanteServicio();
        try {

          //  producto.crearProducto(12, "Esteban", 10, 6);
           // fabricante.crearFabricante(11, "Marisol");
            fabricante.imprimirFabricantes();
            producto.imprimirNombres();
            System.out.println("------------------------------------------------");
            producto.imprimirNombresYPrecios();
            System.out.println("------------------------------------------------");
            producto.imprimirProductosEntrePrecios();
            System.out.println("------------------------------------------------");
            producto.imprimirIncisoD();
            System.out.println("------------------------------------------------");
            producto.imprimirIncisoE();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }
}
