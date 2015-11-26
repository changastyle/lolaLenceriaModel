package lolalenceriamodel;

import model.*;
import daos.*;
import java.util.Date;

public class LolaLenceriaModel 
{
    public static void main(String[] args) 
    {
        System.out.println("Proveedores:");
        for(Proveedor m : daos.ProveedoresDAO.findAll())
        {
            System.out.println(m);
        }
        System.out.println("");
        System.out.println("Productos:");
        for(Producto p : daos.ProductosDAO.findAll())
        {
            System.out.println(p);
        }
        System.out.println("");
        System.out.println("Ingresos:");
        for(Ingreso i : daos.IngresosDAO.findAll())
        {
            System.out.println(i);
        }
        System.out.println("");
        
       
        
        System.out.println("Detalle Ingreso:");
        for(DetalleIngreso  di : daos.DetallesIngresoDAO.findAll())
        {
            System.out.println(di);
        }
        System.out.println("");
        
        System.out.println("Vendedores:");
        for(Vendedor  v : daos.VendedoresDAO.findAll())
        {
            System.out.println(v);
        }
        System.out.println("");
        
        System.out.println(daos.IngresosDAO.buscarDetalles(daos.IngresosDAO.getOne(4)).size());
        for(DetalleIngreso dtDetalleIngreso : daos.IngresosDAO.buscarDetalles(daos.IngresosDAO.getOne(4)))
        {
            System.out.println(dtDetalleIngreso);
        }
        
        System.out.println("GASTO:" +  daos.IngresosDAO.getOne(4).calcularGasto()  );
        /*Ingreso ingreso = new Ingreso(new Date(), daos.VendedoresDAO.getOne(1));*/
                
        
       /* DetalleIngreso det = new DetalleIngreso(daos.IngresosDAO.getOne(4), daos.ProductosDAO.getOne(39), 20, 200);
        daos.DetallesIngresoDAO.save(det);*/
    }
    
}
