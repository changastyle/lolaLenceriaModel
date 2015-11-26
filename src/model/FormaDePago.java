package model;

import javax.persistence.*;

@Entity
@Table(name="formasdepago")
public class FormaDePago 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String nombre;
    private int cantidadDePagos;

    public FormaDePago() {
        this.nombre = "";
        this.cantidadDePagos = 0 ;
    }

    public FormaDePago(String nombre, int cantidadDePagos) {
        this.nombre = nombre;
        this.cantidadDePagos = cantidadDePagos;
    }
    
    //<editor-fold desc="GYS:">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDePagos() {
        return cantidadDePagos;
    }

    public void setCantidadDePagos(int cantidadDePagos) {
        this.cantidadDePagos = cantidadDePagos;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "FormaDePago{" + "id=" + id + ", nombre=" + nombre + ", cantidadDePagos=" + cantidadDePagos + '}';
    }
    
    
    
    
}
