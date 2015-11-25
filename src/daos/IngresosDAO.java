package daos;

import model.Producto;

public class IngresosDAO 
{
    public static java.util.ArrayList<model.Ingreso> findAll()
    {
        java.util.ArrayList<model.Ingreso> arr = new java.util.ArrayList<model.Ingreso>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Ingreso.class))
        {
            model.Ingreso aux = (model.Ingreso) o;
            arr.add(aux);
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
        model.Producto p = null;
        
        for(model.Ingreso aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.Ingreso getOne(int id)
    {
       return (model.Ingreso) daos.AbstractDAO.get(model.Ingreso.class, id);
    }
    public static boolean updateOne(int id, model.Ingreso nuevo)
    {
        boolean respuesta = false;
        
        model.Ingreso objDB = getOne(id);
        
        //Reemplazo valores:
        objDB.setTimestamp(nuevo.getTimestamp());
        objDB.setVendedor(nuevo.getVendedor());
        //objDB.setDetalles(nuevo.getDetalles());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(objDB);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.Ingreso nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.Ingreso objDB = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            objDB.setTimestamp(nuevo.getTimestamp());
            objDB.setVendedor(nuevo.getVendedor());
            //objDB.setDetalles(nuevo.getDetalles());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(objDB);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
