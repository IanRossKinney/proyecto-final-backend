package cl.forge.programatufuturo.reservadehoras.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*Estructura de modelamiento para las clases modelo
 * 1.Definir entidad y tabla correspondiente
 * 2.Contructores
 * 3.Setters y Getters
 * 4.Metodos del modelo*/

@Entity
@Table(name="roles")
public class Rol {

    @Id
    @Column(name="id_rol")                             /*Llave primaria de Rol*/
    private Integer id_rol;

    @Column(name="nombre")
    private String nombre;

    public Rol(){
    }

    public Rol(Integer id_rol, String nombre) {
        this.id_rol = id_rol;
        this.nombre = nombre;
    }

    /*ToString*/
    @Override
    public String toString() {
        return "Rol{" +
                "id_rol=" + id_rol +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    //Getter and Setters
    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}