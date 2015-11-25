package daos;

import model.Producto;

public class VendedoresDAO 
{
    public static java.util.ArrayList<model.Vendedor> findAll()
    {
        java.util.ArrayList<model.Vendedor> arr = new java.util.ArrayList<model.Vendedor>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Vendedor.class))
        {
            model.Vendedor aux = (model.Vendedor) o;
            arr.add(aux);
        }
        
        
        return arr;
    }
    public static boolean save(model.Vendedor obj)
    {
        return daos.AbstractDAO.saveOneNew(obj);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        
        for(model.Vendedor aux : findAll())
        {
            if(id == aux.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(aux);
            }
        }
        return respuesta;     
    }
    public static model.Vendedor getOne(int id)
    {
       return (model.Vendedor) daos.AbstractDAO.get(model.Vendedor.class, id);
    }
    public static boolean updateOne(int id, model.Vendedor nuevo)
    {
        boolean respuesta = false;
        
        model.Vendedor objDB = getOne(id);
        
        //Reemplazo valores:
        objDB.setNombre(nuevo.getNombre());
        objDB.setApellido(nuevo.getApellido());

        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(objDB);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.Vendedor nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.Vendedor objDB = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            objDB.setNombre(nuevo.getNombre());
            objDB.setApellido(nuevo.getApellido());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(objDB);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
