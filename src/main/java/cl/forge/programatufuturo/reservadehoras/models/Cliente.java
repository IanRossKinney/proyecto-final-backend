package cl.forge.programatufuturo.reservadehoras.models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.Timer;


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
    private String rutCliente;

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

    @Column(name="ultimo_login")
    private String ultimoLogin;




    public Cliente(){
    }

    public Cliente(String rutCliente, String nombre, String apellido, Integer telefono, String email, String password){
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = encriptar(password);
        this.ultimoLogin = dateToDate(new Date())+""+dateToTime(new Date());
    }


    //GETTERS AND SETTERS

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
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

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    //ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "rut_cliente='" + rutCliente + '\'' +
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



    public String dateToTime(Date date){
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(date);
    }

    public String dateToDate(Date date){
        DateFormat formatoFecha =new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(date);
    }

}