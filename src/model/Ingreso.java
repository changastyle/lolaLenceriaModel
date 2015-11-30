package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;


@Entity
@Table(name="ingresos")
public class Ingreso 
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private Date timestamp;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fkVendedor")
    private Vendedor vendedor;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "ingreso" , fetch = FetchType.EAGER)
    List<DetalleIngreso> detalles;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "ingreso" ,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<DetalleIngreso> detalles;*/

    public Ingreso() 
    {
        this.timestamp = new Date(0);
        this.vendedor = null;
        this.detalles = new ArrayList<DetalleIngreso>();
    }

    public Ingreso(Date timestamp, Vendedor vendedor )
    {
        this.timestamp = timestamp;
        this.vendedor = vendedor;
        this.detalles = new ArrayList<DetalleIngreso>();
    }


    
    //<editor-fold desc="GYS">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<DetalleIngreso> getDetalles() 
    {
        return detalles;
    }

    public void setDetalles(List<DetalleIngreso> detalles) {
        this.detalles = detalles;
    }
    //</editor-fold>
    
    //METODOS MUY IMPORTANTES:
    public void agregarDetalle(DetalleIngreso detalle)
    {
        this.detalles.add(detalle);
    }
    public void removeDetalle(DetalleIngreso detalle)
    {
        this.detalles.remove(detalle);
    }

    public double calcularGasto()
    {
        double gasto = 0 ;
        for(DetalleIngreso detalleIngreso : daos.IngresosDAO.buscarDetalles(this))
        {
            gasto += detalleIngreso.getPrecioAlMomentoDeIngreso();
        }
        return gasto;
    }
    public String imprimirDetalles()
    {
        String salida = "   {\n";
        
        for(DetalleIngreso dtIngreso : this.detalles)
        {
            salida += "     " + dtIngreso + "\n";
        }
        salida += "   }\n";
        
        return salida;
    }
    @Override
    public String toString() 
    {
        String toString =  "Ingreso\n";
        toString += "{\n";
        toString += "   id = " + id + "\n";
        toString += "   timestamp = " + timestamp + "\n";
        toString += "   vendedor = " + vendedor + "\n";
        toString += "   detalles:\n" + imprimirDetalles() + "";
        toString += "}";
        return  toString;
        
    }
    

    
    
    
    
    
}
