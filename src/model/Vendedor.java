package model;

import javax.persistence.*;
@Entity
@Table(name="vendedores")
public class Vendedor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String apellido;

    public Vendedor()
    {
        this.nombre = "";
        this.apellido = "";
    }

    public Vendedor(String nombre, String apellido) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //<editor-fold desc="GYS">
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //</editor-fold>

    @Override
    public String toString() 
    {
        return "Vendedor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
    
}
