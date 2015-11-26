package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="ventas")
public class Venta 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fechaDeLaVenta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkVendedor")
    private Vendedor vendedor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkFormaDePago")
    private FormaDePago formaDePago;

    public Venta() 
    {
        this.fechaDeLaVenta = new Date();
        this.vendedor = null;
        this.formaDePago = null;
    }

    public Venta(int id, Date fechaDeLaVenta, Vendedor vendedor, FormaDePago formaDePago) {
        this.id = id;
        this.fechaDeLaVenta = fechaDeLaVenta;
        this.vendedor = vendedor;
        this.formaDePago = formaDePago;
    }
    
    
    //<editor-fold desc="GYS">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaDeLaVenta() {
        return fechaDeLaVenta;
    }

    public void setFechaDeLaVenta(Date fechaDeLaVenta) {
        this.fechaDeLaVenta = fechaDeLaVenta;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
    //</editor-fold>

    @Override
    public String toString() 
    {
        return "Venta{" + "id=" + id + ", fechaDeLaVenta=" + fechaDeLaVenta + ", vendedor=" + vendedor + ", formaDePago=" + formaDePago + '}';
    }
    
    
    
}
