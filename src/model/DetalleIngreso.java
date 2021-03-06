package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="detalleingreso")
public class DetalleIngreso 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne()
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name="fkIngreso")
    private Ingreso ingreso;
    @OneToOne()
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name="fkProducto")
    private Producto producto;
    private int cantidad;
    private double precioAlMomentoDeIngreso;

    public DetalleIngreso() 
    {
        this.ingreso = null;
        this.producto = null;
        this.cantidad = 0 ;
        this.precioAlMomentoDeIngreso = 0;
        this.ingreso = null;
    }
    public DetalleIngreso(Ingreso ingreso, Producto producto, int cantidad, double precioAlMomentoDeIngreso) 
    {
        this.ingreso = ingreso;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioAlMomentoDeIngreso = precioAlMomentoDeIngreso;
        this.ingreso = ingreso;
    }
    
    //<editor-fold desc="GYS">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioAlMomentoDeIngreso() {
        return precioAlMomentoDeIngreso;
    }

    public void setPrecioAlMomentoDeIngreso(double precioAlMomentoDeIngreso) {
        this.precioAlMomentoDeIngreso = precioAlMomentoDeIngreso;
    }
    
    ///</editor-fold>

    @Override
    public String toString() 
    {
        String s = "DetalleIngreso:{'id':" + id + ",";
        s+= "'cantidad': " + cantidad + ",";
        s+= "'precioAlMomentoDeIngreso' :'" + precioAlMomentoDeIngreso + ",";
        s+= "'producto': " + producto.getId()+" | "+producto.getNombreProducto()  + ",";
        //s+= "'ingreso' : " +  ingreso + "";
        s+= "}";
        
        return s;
    }

    
    
    
    
    
}
