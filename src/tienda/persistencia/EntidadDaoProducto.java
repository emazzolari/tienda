package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.servicios.ProductoServicio;

public final class EntidadDaoProducto extends DAO {

    public void guardar(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el mascota");
            }
            String sql = "INSERT INTO Producto (nombre, codigo, precio, codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getCodigo() + "' ," + producto.getCodigoFabricante() + "' ," + producto.getPrecio() + "' );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " nombre = '" + producto.getNombre() + "' , codigo = '" + producto.getCodigo() + "' , codigoFabricante = " + producto.getCodigoFabricante() + "' , precio = " + producto.getPrecio()
                    + " WHERE codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE id = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setCodigoFabricante(resultado.getInt(2));
                producto.setNombre(resultado.getString(3));
                producto.setPrecio(resultado.getInt(4));

                // Producto usuario = productoServicio.buscarProductoPorCodigo(codigo);
                // producto.setUsuario(usuario);
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    

    public Collection<Producto> listarProductosEntrePrecios() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto Where precio>120 and precio<202";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
               // producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
               // producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
