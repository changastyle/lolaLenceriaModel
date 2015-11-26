package daos;

import java.util.ArrayList;
import model.DetalleIngreso;
import model.Ingreso;
import model.Producto;

public class FormasDePagoDAO 
{
    public static java.util.ArrayList<model.FormaDePago> findAll()
    {
        java.util.ArrayList<model.FormaDePago> arr = new java.util.ArrayList<model.FormaDePago>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Ingreso.class))
        {
            arr.add((model.FormaDePago) o);
        }
        
        
        return arr;
    }
    public static boolean save(model.FormaDePago obj)
    {
        return daos.AbstractDAO.saveOneNew(obj);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        for(model.FormaDePago aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.FormaDePago getOne(int id)
    {
       return (model.FormaDePago) daos.AbstractDAO.get(model.FormaDePago.class, id);
    }
    public static boolean updateOne(int id, model.FormaDePago nuevo)
    {
        boolean respuesta = false;
        
        model.FormaDePago viejo = getOne(id);
        
        //Reemplazo valores:
        viejo.setNombre(nuevo.getNombre());
        viejo.setCantidadDePagos(nuevo.getCantidadDePagos());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(viejo);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.FormaDePago nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.FormaDePago viejo = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            viejo.setNombre(nuevo.getNombre());
            viejo.setCantidadDePagos(nuevo.getCantidadDePagos());
            //objDB.setDetalles(nuevo.getDetalles());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(viejo);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
