package cl.forge.programatufuturo.reservadehoras.models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;
import java.sql.Time;

/*Estructura de modelamiento para las clases modelo
* 1.Definir entidad y tabla correspondiente
* 2.Contructores
* 3.Setters y Getters
* 4.Metodos del modelo*/

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @Column(name="rut_cliente")
    private String rut_cliente;

    @Column(name="nombre")
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
    private Date ultimo_login_fecha;

    @Column(name="ultimo_login_hora")
    private Time ultimo_login_hora;

    public Cliente(){
    }

    public Cliente(String rut_cliente, String nombre, String apellido, Integer telefono, String email, String password){
        this.rut_cliente = rut_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = encriptar(password);
        this.ultimo_login_fecha = new java.sql.Date(new java.util.Date().getTime());
        this.ultimo_login_hora = new java.sql.Time(new java.util.Date().getTime());
    }




    //GETTERS AND SETTERS
    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
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

    public Date getUltimo_login_fecha() {
        return ultimo_login_fecha;
    }

    public void setUltimo_login_fecha(Date ultimo_login_fecha) {
        this.ultimo_login_fecha = ultimo_login_fecha;
    }

    public Time getUltimo_login_hora() {
        return ultimo_login_hora;
    }

    public void setUltimo_login_hora(Time ultimo_login_hora) {
        this.ultimo_login_hora = ultimo_login_hora;
    }






    //ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "rut_cliente='" + rut_cliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                '}';
    }
    //Metodo de encriptacion de clave
    public String encriptar(String password) {

        String result = DigestUtils.md5Hex(password);
        return result;

    }





}