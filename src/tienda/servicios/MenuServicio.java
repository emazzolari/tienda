package tienda.servicios;

import java.util.Scanner;

public class MenuServicio {

    public static void menu() {

        Scanner leer = new Scanner(System.in);
        ProductoServicio producto = new ProductoServicio();
        FabricanteServicio fabricante = new FabricanteServicio();
        try {

            String x="";
            do{
            
            System.out.println("1-Ingresar un producto a la base de datos"
                    + "\n2-Ingresar un fabricante a la base de datos"
                    + "\n3-Lista el nombre de todos los productos que hay en la tabla producto."
                    + "\n4-Lista los nombres y los precios de todos los productos de la tabla producto"
                    + "\n5-Listar aquellos productos que su precio esté entre 120 y 202"
                    + "\n6-Buscar y listar todos los Portátiles de la tabla producto"
                    + "\n7-Listar el nombre y el precio del producto más barato"
                    + "\n8-Editar un producto con datos a elección");
            
            int opcion = leer.nextInt();
            
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el codigo del producto:");
                    int codigo = (leer.nextInt());
                    System.out.println("Ingrese el nombre del producto:");
                    String nombre = (leer.next());
                    System.out.println("Ingrese el precio del producto:");
                    double precio = (leer.nextDouble());
                    System.out.println("Ingrese el codigo del fabricante:");
                    int codigoFab = (leer.nextInt());
                    producto.crearProducto(codigo, nombre, precio, codigoFab);
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del fabricante:");
                    int codigoFabri = (leer.nextInt());
                    System.out.println("Ingrese el nombre del fabricante:");
                    String nombreFabri = (leer.next());
                    fabricante.crearFabricante(codigoFabri, nombreFabri);
                    fabricante.imprimirFabricantes();
                    break;
                case 3:
                    producto.imprimirNombres();
                    break;
                case 4:
                    producto.imprimirNombresYPrecios2();
                    break;
                case 5:
                    producto.imprimirProductosEntrePrecios();
                    break;
                case 6:
                    producto.imprimirIncisoD();
                    break;
                case 7:
                    producto.imprimirIncisoE();
                    break;
                case 8:
                    System.out.println("Ingrese el codigo del producto:");
                    int codigo1 = (leer.nextInt());
                    System.out.println("Ingrese el nombre del producto:");
                    String nombre1 = (leer.next());
                    System.out.println("Ingrese el precio del producto:");
                    double precio1 = (leer.nextDouble());
                    System.out.println("Ingrese el codigo del fabricante:");
                    int codigoFab1 = (leer.nextInt());
                    producto.modificarProducto(codigo1, nombre1, precio1, codigoFab1);
                    producto.imprimirNombres();
                    break;
            }
            System.out.println("Quiere realizar otra consulta");
            x = leer.next();
            }while (x.equalsIgnoreCase("si"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }
}
//case 9:
//                        System.out.println("¿Está seguro que desea salir del programa (S/N");
//
//                        String si = leer.next();
//
//                        if (si.equals("s")) {
//                            System.out.println("salir del programa");
//                            operacion = 0;
//                            break;
//                        } else {
//
//                            if (si.equals("n")) {
//                                System.out.println("continuar en el programa");
//                            }
//                            break;
//                        }
//                    default:
//                        System.out.println("el num es incorrecto");
//                
//                }
//             }while (operacion==0);
