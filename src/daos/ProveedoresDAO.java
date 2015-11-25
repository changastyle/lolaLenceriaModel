package daos;

public class ProveedoresDAO 
{
    public static java.util.ArrayList<model.Proveedor> findAll()
    {
        java.util.ArrayList<model.Proveedor> arr = new java.util.ArrayList<model.Proveedor>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Proveedor.class))
        {
            model.Proveedor aux = (model.Proveedor) o;
            arr.add(aux);
        }
        return arr;
    }
    public static boolean save(model.Proveedor aux)
    {
        return daos.AbstractDAO.saveOneNew(aux);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        for(model.Proveedor marca : findAll())
        {
            if(id == marca.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(marca);
            }
        }
        return respuesta;     
    }
    public static model.Proveedor getOne(int id)
    {
       return (model.Proveedor) daos.AbstractDAO.get(model.Proveedor.class, id);
    }
    public static boolean updateOne(int id, model.Proveedor nuevo)
    {
        boolean respuesta = false;
        
        model.Proveedor auxDB = getOne(id);
        
        //Reemplazo valores:
        auxDB.setNombre(nuevo.getNombre());
        auxDB.setTelefono1(nuevo.getTelefono1());
        auxDB.setTelefono2(nuevo.getTelefono2());
        auxDB.setEmail(nuevo.getEmail());
        auxDB.setWeb(nuevo.getWeb());
        auxDB.setDireccionFisica(nuevo.getDireccionFisica());
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(auxDB);
        
        return respuesta;
    }
    public static boolean updateMany(String[] ids, model.Proveedor nuevo)
    {
        boolean respuesta = false;
        /*
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(String id : ids)
        {
            model.Marcas productoEnDB = getOne(Integer.parseInt(id));
        
            //Reemplazo valores:
            productoEnDB.setNombreProducto(productoActualizado.getNombreProducto());
            //productoEnDB.setNumeroSerie(productoActualizado.getNumeroSerie());
            productoEnDB.setMarca(productoEnDB.getMarca());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(productoEnDB);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);*/
        return respuesta;
    }
}
