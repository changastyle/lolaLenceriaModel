package model;

import javax.persistence.*;

@Entity
@Table(name="detalleventa")
public class DetalleVenta 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkVenta")
    private Venta venta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkProducto")
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public DetalleVenta() 
    {
        this.venta = null;
        this.producto = null;
        this.cantidad = 0 ;
        this.precioUnitario = 0;
    }

    public DetalleVenta(Venta venta, Producto producto, int cantidad, double precioUnitario) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    //<editor-fold desc="GYS">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
     //</editor-fold>

    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }
    
    
    
}
