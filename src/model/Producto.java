
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="productos")
public class Producto 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private int id;
    @Expose
    @Column( name="numeroSerie" , unique=true)
    private int numeroSerie;
    @Expose
    private String nombreProducto;
    @ManyToOne()
    @Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE})
    @JoinColumn(name="fkProveedor")
    private Proveedor marcaAsociada;
   

    public Producto() 
    {
        this.numeroSerie = -1;
        this.nombreProducto = "";
        this.marcaAsociada = null;
    }

    public Producto(int numeroSerie, String nombreProducto, Proveedor marcaAsociada) 
    {
        this.numeroSerie = numeroSerie;
        this.nombreProducto = nombreProducto;
        this.marcaAsociada = marcaAsociada;
    }
    
    
    //<editor-fold desc="GYS:">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Proveedor getMarca() {
        return marcaAsociada;
    }
    public void setMarca(Proveedor marca) {
        this.marcaAsociada = marca;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", nombreProducto=" + nombreProducto + ", marca=" + marcaAsociada + '}';
    }

    

    
    

    public String toJSON() {
        Gson  gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        
        String JSON = gson.toJson(this);
        
        return JSON;
    }
    
    
    
    
    
}
