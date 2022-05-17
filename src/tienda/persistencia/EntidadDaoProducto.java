package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.servicios.ProductoServicio;

public final class EntidadDaoProducto extends DAO {

    private final ProductoServicio productoServicio;

    public EntidadDaoProducto() {
        this.productoServicio = new ProductoServicio();
    }

    public void guardar(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el mascota");
            }
            String sql = "INSERT INTO Mascota (apodo, raza, idUsuario) "
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
            String sql = "DELETE FROM tienda WHERE id = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM tienda WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setCodigoFabricante(resultado.getInt(2));
                producto.setNombre(resultado.getString(3));
                producto.setPrecio(resultado.getInt(4));
                Integer idUsuario = resultado.getInt(5);
                
                //llegue hasta aca
                
                Producto usuario = productoServicio.buscarProductoPorCodigo(codigo);
                producto.setUsuario(usuario);
            }
            desconectarBase();
            return mascota;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Mascota> listarMascotas() throws Exception {
        try {
            String sql = "SELECT * FROM Mascota ";
            consultarBase(sql);
            Mascota mascota = null;
            Collection<Mascota> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Mascota();
                mascota.setId(resultado.getInt(1));
                mascota.setApodo(resultado.getString(2));
                mascota.setRaza(resultado.getString(3));
                Integer idUsuario = resultado.getInt(4);
                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
                mascota.setUsuario(usuario);
                mascotas.add(mascota);
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}

