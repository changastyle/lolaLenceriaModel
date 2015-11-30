

import model.*;
import daos.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LolaLenceriaModel 
{
    public static void main(String[] args) 
    {
        int opcion = 0;
        while(opcion != 99)
        {
            System.out.println("Lola lenceira CGI:");
            System.out.println("1. cargar un nuevo producto:");
            System.out.println("2. ver producto cargados:");
            System.out.println("3. ingreso de mercaderia:");
            System.out.print("Seleccione opcion:");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:  System.out.println("cargado= " + daos.ProductosDAO.save(cargarNuevoProducto()));;break;
                case 2:  mostrarProductosCargados();break;
                case 3:  ingresoDeMercaderia();break;
                case 99: opcion = 99;System.exit(0); ; break;
            }
        }
        /*
        Ingreso ingreso = new Ingreso(new Date(), new Vendedor("Nicolas", "Grossi", "descargar", "ngrossi@gmail.com.ar"));
        Proveedor prove =  new Proveedor("IMAZ", "imaz@gmail.com", "http://imaz.com", "v2");
        Producto p = new Producto((int) (Math.random()*1000), "producto xxx",prove );
        Producto p2 = new Producto(50, "producto xx2",prove );
        Producto p3 = new Producto(51, "producto xx3",prove );
        Producto p4 = new Producto(52, "producto xx4",prove );
        DetalleIngreso dtDetalleIngreso = new DetalleIngreso(ingreso, p , 50, 200);
        DetalleIngreso dtDetalleIngreso2 = new DetalleIngreso(ingreso, p2, 5, 12);
        DetalleIngreso dtDetalleIngreso3 = new DetalleIngreso(ingreso, p3, 15, 120);
        DetalleIngreso dtDetalleIngreso4 = new DetalleIngreso(ingreso, p4, 25, 14);
        
        ArrayList<DetalleIngreso> detalles = new ArrayList<DetalleIngreso>();
        detalles.add(dtDetalleIngreso);
        detalles.add(dtDetalleIngreso2);
        detalles.add(dtDetalleIngreso3);
        detalles.add(dtDetalleIngreso4);
        
        ingreso.setDetalles(detalles);
        System.out.println(daos.IngresosDAO.save(ingreso) +"|"+ daos.IngresosDAO.findAll().size());
        
        for(Ingreso i : daos.IngresosDAO.findAll())
        {
            System.out.println(i);
        }*/
        
        
        //System.out.println("dtDetalleIngreso.save = "  + daos.DetallesIngresoDAO.save(dtDetalleIngreso));
        //System.out.println("dtDetalleIngreso.remove = "+ daos.DetallesIngresoDAO.remove(dtDetalleIngreso));
        //System.out.println("Producto.remove = " + daos.ProductosDAO.removeWithoutFuckingTheModel(p,p2));
        /*if(!daos.ProveedoresDAO.remove(daos.ProveedoresDAO.getOne(2)))
        {
            System.out.println("ASOCIADOS:");
            for(Producto peeeee : daos.ProveedoresDAO.asociados(daos.ProveedoresDAO.getOne(2)))
            {
                System.out.println(" -> "+ peeeee);
                peeeee.setMarca(proveedor2);
                daos.ProductosDAO.updateOne(peeeee.getId(), peeeee);
            }
            
            daos.ProveedoresDAO.remove(daos.ProveedoresDAO.getOne(2));
        }
        else
        {
            System.out.println("REMOVE PROVEEDOR:");
        }*/
        
       // System.out.print("add: " + daos.ProductosDAO.save(p));
        //System.out.println("remove:" + daos.ProductosDAO.remove(p));
        /*Vendedor vNew = new Vendedor("Nicolas", "Grossi", "1234", "ngrossi@tecnoaccion.com.ar");
        daos.VendedoresDAO.save(vNew);*/
        
        //Ingreso ingresoNew = new Ingreso(new Date(), /*daos.VendedoresDAO.getOne(7)*/ new Vendedor("nicolas", "Rubino", "123", "nrubino@gmail.com"));
        //daos.IngresosDAO.save(ingresoNew);
        
        //DetalleIngreso detIngNew = new DetalleIngreso(ingresoNew, /*daos.ProductosDAO.getOne(45)*/new Producto(1234, "producto1" , new Proveedor("proveedor1", "proveedor@gmail.com", "http://www.com.ar", "v2")), 5, 20);
        //daos.DetallesIngresoDAO.save(detIngNew);
        
        /*ingresoNew.agregarDetalle(detIngNew);
        System.out.println("ingreso : " + ingresoNew);
        daos.IngresosDAO.save(ingresoNew);*/
        
        /*
        System.out.println("Vendedores:");
        for(Vendedor  v : daos.VendedoresDAO.findAll())
        {
            System.out.println(v);
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
        
        System.out.println("Productos:");
        for(Producto p : daos.ProductosDAO.findAll())
        {
            System.out.println(p);
        }
        System.out.println("");
        
        System.out.println("Proveedores:");
        for(Proveedor m : daos.ProveedoresDAO.findAll())
        {
            System.out.println(m);
        }
        System.out.println("");
        
        
        /*for(Ingreso ingresoo : daos.IngresosDAO.findAll())
        {
            daos.IngresosDAO.remove(ingresoo.getId());
        }
       /* System.out.println(daos.IngresosDAO.buscarDetalles(daos.IngresosDAO.getOne(4)).size());
        for(DetalleIngreso dtDetalleIngreso : daos.IngresosDAO.buscarDetalles(daos.IngresosDAO.getOne(4)))
        {
            System.out.println(dtDetalleIngreso);
        }*/
        
        //System.out.println("GASTO:" +  daos.IngresosDAO.getOne(4).calcularGasto()  );
        /*Ingreso ingreso = new Ingreso(new Date(), daos.VendedoresDAO.getOne(1));*/
                
        
       /* DetalleIngreso det = new DetalleIngreso(daos.IngresosDAO.getOne(4), daos.ProductosDAO.getOne(39), 20, 200);
        daos.DetallesIngresoDAO.save(det);*/
    }

    private static Producto cargarNuevoProducto()
    {
        Producto p = new Producto();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre Producto:"); String nombreProducto = sc.nextLine();
        System.out.print("Numero de Serie Producto:"); int numeroSerie = sc.nextInt();
        p.setNombreProducto(nombreProducto);
        p.setNumeroSerie(numeroSerie);
        p.setMarca(new Proveedor("pepe", "pepe@gmail.com", "http://www.pepe.com.ar","v3"));
        return p;
    }

    private static void mostrarProductosCargados() 
    {
        System.out.println("Productos cargados:");
        
        for(Producto p: daos.ProductosDAO.findAll())
        {
            System.out.println(p);
        }
    }

    private static Ingreso ingresoDeMercaderia() 
    {
        Ingreso ingreso = new Ingreso();
        ingreso.setTimestamp(new Date());
        ingreso.setVendedor(new Vendedor("Nicolas", "Grossi", "123456", "ngrossi@"));
        
        Scanner sc = new Scanner(System.in);
        
        boolean seguirCargando = true;
        while(seguirCargando)
        {
            System.out.println("3-1 agregar detalle.");
            System.out.println("3-2 ver detalles cargados.");
            System.out.println("3-3 quitar detalle.");
            System.out.println("3-4 ok.");
            System.out.println("3-5 cancelar.");
            int opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    DetalleIngreso dtIngreso = new DetalleIngreso();
                    
                    System.out.println("Seleccionar Producto:");
                    for(Producto producto : daos.ProductosDAO.findAll())
                    {
                        System.out.println( producto.getNumeroSerie() + " - " + producto.getNombreProducto());
                    }
                    System.out.print("numero de serie: ");
                    int numeroSerie = sc.nextInt();
                    
                    if(daos.ProductosDAO.getOneByNumeroDeSerie(numeroSerie) != null)
                    {
                        System.out.print("ingrese cantidad que ingresa:");
                        int cantidad = sc.nextInt();
                        System.out.print("ingrese precio:");
                        int precio = sc.nextInt();
                        
                        dtIngreso.setCantidad(cantidad);
                        dtIngreso.setProducto(daos.ProductosDAO.getOneByNumeroDeSerie(numeroSerie));
                        dtIngreso.setPrecioAlMomentoDeIngreso(precio);
                        dtIngreso.setIngreso(ingreso);
                        
                        ingreso.agregarDetalle(dtIngreso);
                        System.out.println("ingreso : " + daos.IngresosDAO.save(ingreso));
                    }
                    else
                    {
                        System.out.println("El producto con numero de serie: " + numeroSerie + " no existe!");
                    }
                    
                ;break;
                case 2:
                    for(DetalleIngreso dt : ingreso.getDetalles())
                    {
                        System.out.println("" + dt);
                    }
                break;
                case 3:
                    for(int i = 0 ; i < ingreso.getDetalles().size() ; i++)
                    {
                        System.out.println(i + " -> " + ingreso.getDetalles().get(i));
                    }
                    System.out.print("cual queres sacar:");
                    int indiceEliminado = sc.nextInt();
                    
                    if(ingreso.getDetalles().get(indiceEliminado) != null)
                    {
                        ingreso.getDetalles().remove(indiceEliminado);
                        System.out.println("Quitado con exito!");
                    }
                break;
                case 4:
                    
                    seguirCargando = false;
                    
                break;
                case 5:
                    ingreso = null;
                    seguirCargando = false;
                break;
            }
            
        }
        return ingreso;
    }
    
}
