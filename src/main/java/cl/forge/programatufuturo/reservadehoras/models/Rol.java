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
    private Integer idRol;

    @Column(name="nombre")
    private String nombre;

    public Rol(){
    }

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    /*ToString*/
    @Override
    public String toString() {
        return "Rol{" +
                "id_rol=" + idRol +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    //Getter and Setters

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}