package daos;

import model.Producto;

public class DetallesIngresoDAO 
{
    public static java.util.ArrayList<model.DetalleIngreso> findAll()
    {
        java.util.ArrayList<model.DetalleIngreso> arr = new java.util.ArrayList<model.DetalleIngreso>();
        
        for(Object o : daos.AbstractDAO.findAll(model.DetalleIngreso.class))
        {
            model.DetalleIngreso aux = (model.DetalleIngreso) o;
            arr.add(aux);
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
        
        model.DetalleIngreso objDB = getOne(id);
        
        //Reemplazo valores:
        objDB.setCantidad(nuevo.getCantidad());
        objDB.setProducto(nuevo.getProducto());
        objDB.setPrecioAlMomentoDeIngreso(nuevo.getPrecioAlMomentoDeIngreso());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(objDB);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.DetalleIngreso nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.DetalleIngreso objDB = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            objDB.setCantidad(nuevo.getCantidad());
            objDB.setProducto(nuevo.getProducto());
            objDB.setPrecioAlMomentoDeIngreso(nuevo.getPrecioAlMomentoDeIngreso());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(objDB);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
