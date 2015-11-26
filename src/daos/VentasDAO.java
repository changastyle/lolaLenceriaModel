package daos;

import java.util.ArrayList;
import model.DetalleIngreso;
import model.DetalleVenta;
import model.Ingreso;
import model.Producto;
import model.Venta;

public class VentasDAO 
{
    public static java.util.ArrayList<model.Venta> findAll()
    {
        java.util.ArrayList<model.Venta> arr = new java.util.ArrayList<model.Venta>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Venta.class))
        {
            arr.add((model.Venta) o);
        }
        
        
        return arr;
    }
    public static boolean save(model.Ingreso obj)
    {
        return daos.AbstractDAO.saveOneNew(obj);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        
        for(model.Venta aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.Venta getOne(int id)
    {
       return (model.Venta) daos.AbstractDAO.get(model.Venta.class, id);
    }
    public static boolean updateOne(int id, model.Venta nuevo)
    {
        boolean respuesta = false;
        
        model.Venta viejo = getOne(id);
        
        //Reemplazo valores:
        viejo.setVendedor(nuevo.getVendedor());
        viejo.setFormaDePago(nuevo.getFormaDePago());
        viejo.setFechaDeLaVenta(nuevo.getFechaDeLaVenta());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(viejo);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.Venta nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.Venta viejo = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            viejo.setVendedor(nuevo.getVendedor());
            viejo.setFormaDePago(nuevo.getFormaDePago());
            viejo.setFechaDeLaVenta(nuevo.getFechaDeLaVenta());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(viejo);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
    public static  ArrayList<DetalleVenta> buscarDetalles( Venta venta)
    {
        ArrayList<DetalleVenta> arr = new ArrayList<DetalleVenta>();
        
        for(DetalleVenta detalle : daos.DetallesVentaDAO.findAll())
        {
            if(detalle.getVenta().getId() == venta.getId())
            {
                arr.add(detalle);
            }
        }
        
        
        return arr;
    }
}
