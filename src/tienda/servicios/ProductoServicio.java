package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.EntidadDaoProducto;

public class ProductoServicio {

    private EntidadDaoProducto dao;

    public ProductoServicio() {
        this.dao = new EntidadDaoProducto();
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el nombre");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró el nombre del producto indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {
          
            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirNombres() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.getNombre()+ "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void imprimirNombresYPrecios() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductosEntrePrecios();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                   // if(u.getPrecio()>120 && u.getPrecio()<202)
                    System.out.println("Nombre: "+u.getNombre()+" | "+" Precio: "+u.getPrecio()+ "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
     
         public void imprimirProductosEntrePrecios() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductosEntrePrecios();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                   // if(u.getPrecio()>120 && u.getPrecio()<202)
                    System.out.println("Nombre: "+u.getNombre()+" | "+" Precio: "+u.getPrecio()+ "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
     
     
 public Collection<Producto> listarProductosEntrePrecios() throws Exception {

        try {
          
            Collection<Producto> productos = dao.listarProductosEntrePrecios();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

 public void imprimirIncisoD() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    if(u.getNombre().equalsIgnoreCase("Portátil Yoga 520"))
                    System.out.println("Nombre: "+u.getNombre()+ "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
