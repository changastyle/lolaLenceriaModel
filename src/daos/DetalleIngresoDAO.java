package daos;

import model.Producto;

public class DetalleIngresoDAO 
{
    public static java.util.ArrayList<model.DetalleIngreso> findAll()
    {
        java.util.ArrayList<model.DetalleIngreso> arr = new java.util.ArrayList<model.DetalleIngreso>();
        
        for(Object o : daos.AbstractDAO.findAll(model.DetalleIngreso.class))
        {
            arr.add((model.DetalleIngreso) o);
        }
        
        return arr;
    }
    public static boolean save(model.DetalleIngreso obj)
    {
        return daos.AbstractDAO.saveOneNew(obj);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        for(model.DetalleIngreso aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.DetalleIngreso getOne(int id)
    {
       return (model.DetalleIngreso) daos.AbstractDAO.get(model.DetalleIngreso.class, id);
    }
    public static boolean updateOne(int id, model.DetalleIngreso nuevo)
    {
        boolean respuesta = false;
        
        model.DetalleIngreso viejo = getOne(id);
        
        //Reemplazo valores:
        viejo.setCantidad(nuevo.getCantidad());
        viejo.setIngreso(nuevo.getIngreso());
        viejo.setPrecioAlMomentoDeIngreso(nuevo.getPrecioAlMomentoDeIngreso());
        viejo.setProducto(nuevo.getProducto());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(viejo);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.DetalleIngreso nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.DetalleIngreso viejo = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            viejo.setCantidad(nuevo.getCantidad());
            viejo.setIngreso(nuevo.getIngreso());
            viejo.setPrecioAlMomentoDeIngreso(nuevo.getPrecioAlMomentoDeIngreso());
            viejo.setProducto(nuevo.getProducto());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(viejo);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
