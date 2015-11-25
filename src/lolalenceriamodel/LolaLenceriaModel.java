package lolalenceriamodel;

import model.*;
import daos.*;

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
        for(DetalleIngreso  di : daos.DetalleIngresoDAO.findAll())
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
        
        
        DetalleIngreso det = new DetalleIngreso(daos.IngresosDAO.getOne(1), daos.ProductosDAO.getOne(38), 20, 200);
        daos.DetalleIngresoDAO.save(det);
    }
    
}
