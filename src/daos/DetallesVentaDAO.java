package daos;

import java.util.ArrayList;
import model.DetalleIngreso;
import model.Ingreso;
import model.Producto;

public class DetallesVentaDAO 
{
    public static java.util.ArrayList<model.DetalleVenta> findAll()
    {
        java.util.ArrayList<model.DetalleVenta> arr = new java.util.ArrayList<model.DetalleVenta>();
        
        for(Object o : daos.AbstractDAO.findAll(model.DetalleVenta.class))
        {
            arr.add((model.DetalleVenta) o);
        }
        
        
        return arr;
    }
    public static boolean save(model.DetalleVenta obj)
    {
        return daos.AbstractDAO.saveOneNew(obj);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        for(model.DetalleVenta aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.DetalleVenta getOne(int id)
    {
       return (model.DetalleVenta) daos.AbstractDAO.get(model.DetalleVenta.class, id);
    }
    public static boolean updateOne(int id, model.DetalleVenta nuevo)
    {
        boolean respuesta = false;
        
        model.DetalleVenta viejo = getOne(id);
        
        //Reemplazo valores:
        viejo.setVenta(nuevo.getVenta());
        viejo.setPrecioUnitario(nuevo.getPrecioUnitario());
        viejo.setProducto(nuevo.getProducto());
        viejo.setCantidad(nuevo.getCantidad());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(viejo);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.DetalleVenta nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.DetalleVenta viejo = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            viejo.setVenta(nuevo.getVenta());
            viejo.setPrecioUnitario(nuevo.getPrecioUnitario());
            viejo.setProducto(nuevo.getProducto());
            viejo.setCantidad(nuevo.getCantidad());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(viejo);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
