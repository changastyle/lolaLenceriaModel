package daos;

import java.util.ArrayList;
import model.DetalleIngreso;
import model.Producto;
import model.Proveedor;

public class ProductosDAO 
{
    public static model.Producto getOne(int id)
    {
       return (model.Producto) daos.AbstractDAO.get(model.Producto.class, id);
    }
    public static model.Producto getOneByNumeroDeSerie(int numeroDeSerie)
    {
       model.Producto respuesta = null;
       for(Producto producto : findAll())
       {
           if(producto.getNumeroSerie() == numeroDeSerie)
           {
               respuesta = producto;
           }
       }
       return respuesta;
    }
    public static java.util.ArrayList<model.Producto> findAll()
    {
        java.util.ArrayList<model.Producto> arr = new java.util.ArrayList<model.Producto>();
        
        for(Object o : daos.AbstractDAO.findAll(model.Producto.class))
        {
            model.Producto aux = (model.Producto) o;
            arr.add(aux);
        }
       
        return arr;
    }
    public static boolean save(model.Producto producto)
    {
        return daos.AbstractDAO.saveOneNew(producto);
    }
    public static boolean remove(int id)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        for(model.Producto producto : findAll())
        {
            if(id == producto.getId())
            {
                respuesta = daos.AbstractDAO.deleteOne(producto);
            }
        }
        return respuesta;     
    }
    private static boolean remove(Producto obj)
    {
        boolean respuesta = false;
        model.Producto p = null;
        
        respuesta = daos.AbstractDAO.deleteOne(obj);

        return respuesta;     
    }
    public static ArrayList<DetalleIngreso> asociados(Producto obj)
    {
        ArrayList<DetalleIngreso> asociados = new ArrayList<DetalleIngreso>();
        
        for(DetalleIngreso aux : daos.DetallesIngresoDAO.findAll())
        {
            if(aux.getProducto().getId() == obj.getId())
            {
                asociados.add(aux);
            }
        } 
        return asociados;
    }
    public static boolean removeWithoutFuckingTheModel(model.Producto obtToDelete, model.Producto nuevoEncargado)
    {
        boolean respuesta = remove(obtToDelete);
        if(!respuesta)
        {
            //System.out.println("ASOCIADOS:");
            for( DetalleIngreso socio : asociados(obtToDelete))
            {
                //System.out.println(" -> "+ socio);
                socio.setProducto(nuevoEncargado);
                daos.DetallesIngresoDAO.updateOne(socio.getId(), socio);
            }
            
            respuesta = remove(obtToDelete);
        }
        return respuesta;  
    }
    public static boolean updateOne(int id, model.Producto nuevo)
    {
        boolean respuesta = false;
        
        model.Producto viejo = getOne(id);
        
        //Reemplazo valores:
        viejo.setNombreProducto(nuevo.getNombreProducto());
        viejo.setNumeroSerie(nuevo.getNumeroSerie());
        viejo.setMarca(nuevo.getMarca());
        
        
        //Inserto en DB:
        respuesta = daos.AbstractDAO.updateOne(viejo);
        
        return respuesta;
    }
    public static boolean updateMany(int[] ids, model.Producto nuevo)
    {
        boolean respuesta = false;
        
        //Creo un array donde meter los productos actualizados:
        java.util.ArrayList<Object> arrDeProductosActualizados = new java.util.ArrayList<Object>();
        
        for(int id : ids)
        {
            model.Producto viejo = getOne(id);
        
            //Reemplazo valores:
            viejo.setNombreProducto(nuevo.getNombreProducto());
            viejo.setNombreProducto(nuevo.getNombreProducto());
            //viejo.setNumeroSerie(nuevo.getNumeroSerie());
            viejo.setMarca(nuevo.getMarca());

            //Agrego el producto actualizado al array de productos actualizados:
            arrDeProductosActualizados.add(viejo);
            
        }
        //Inserto Todos en DB:
        respuesta = daos.AbstractDAO.updateAll(arrDeProductosActualizados);
        return respuesta;
    }
}
