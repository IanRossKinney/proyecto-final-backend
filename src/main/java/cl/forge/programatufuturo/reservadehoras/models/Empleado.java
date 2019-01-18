package cl.forge.programatufuturo.reservadehoras.models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/*Estructura de modelamiento para las clases modelo
 * 1.Definir entidad y tabla correspondiente
 * 2.Contructores
 * 3.Setters y Getters
 * 4.Metodos del modelo*/

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @Column(name = "rut_empleado")      /*Llave primaria de Empleado*/
    private String rutEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name="ultimo_login_fecha")
    private Date ultimoLoginFecha;

    @Column(name="ultimo_login_hora")
    private Time ultimoLoginHora;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol idRol;

    public Empleado(){
    }

    public Empleado(String rutEmpleado, String nombre, String apellido, Integer telefono, String email, String password, Rol idRol) {
        this.rutEmpleado = rutEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = encriptar(password);
        this.ultimoLoginFecha=new java.sql.Date(new java.util.Date().getTime());
        this.ultimoLoginHora=new java.sql.Time(new java.util.Date().getTime());
        this.idRol = idRol;
    }


    //SETTERS AND GETTERS
    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimoLoginFecha() {
        return ultimoLoginFecha;
    }

    public void setUltimoLoginFecha(Date ultimoLoginFecha) {
        this.ultimoLoginFecha = ultimoLoginFecha;
    }

    public Time getUltimoLoginHora() {
        return ultimoLoginHora;
    }

    public void setUltimoLoginHora(Time ultimoLoginHora) {
        this.ultimoLoginHora = ultimoLoginHora;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    //Metodo de encriptacion de clave
    public String encriptar(String password){
        String result = DigestUtils.md5Hex(password);
        return result;
    }
}