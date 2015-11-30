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
    private String password;
    private String email;

    public Vendedor()
    {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.password = "";
    }

    public Vendedor(String nombre, String apellido, String password, String email) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password + ", email=" + email + '}';
    }

    
    
    
    
    
}
