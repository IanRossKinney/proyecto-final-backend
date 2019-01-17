package cl.forge.programatufuturo.reservadehoras.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


/*Estructura de modelamiento para las clases modelo
 * 1.Definir entidad y tabla correspondiente
 * 2.Contructores
 * 3.Setters y Getters
 * 4.Metodos del modelo*/

@Entity
@Table(name = "horas")

public class Hora {

    @Id
    @Column(name = "id_hora")    /*Llave primaria de Hora*/
    private Integer id_hora;

    @Column(name = "tipo_hora")
    private String tipo_hora;

    @Column(name = "verificacion_mail")
    private String verificacion_mail;

    @Column(name="fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "rut_empleado")
    private Empleado rut_empleado;

    @ManyToOne
    @JoinColumn(name = "rut_cliente")
    private Cliente rut_cliente;

    public Hora(){
    }

    public Hora(Integer id_hora, String tipo_hora, Empleado rut_empleado, Cliente rut_cliente) {
        this.id_hora = id_hora;
        this.tipo_hora = tipo_hora;
        this.rut_empleado = rut_empleado;
        this.rut_cliente = rut_cliente;
        this.fecha=new java.sql.Date(new java.util.Date().getTime());
        this.hora=new java.sql.Time(new java.util.Date().getTime());
        this.verificacion_mail=null;
    }




    //GETTERS AND SETTERS
    public Integer getId_hora() {
        return id_hora;
    }

    public void setId_hora(Integer id_hora) {
        this.id_hora = id_hora;
    }

    public String getTipo_hora() {
        return tipo_hora;
    }

    public void setTipo_hora(String tipo_hora) {
        this.tipo_hora = tipo_hora;
    }

    public String getVerificacion_mail() {
        return verificacion_mail;
    }

    public void setVerificacion_mail(String verificacion_mail) {
        this.verificacion_mail = verificacion_mail;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Empleado getRut_empleado() {
        return rut_empleado;
    }

    public void setRut_empleado(Empleado rut_empleado) {
        this.rut_empleado = rut_empleado;
    }

    public Cliente getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(Cliente rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    //ToString

    @Override
    public String toString() {
        return "Hora{" +
                "id_hora=" + id_hora +
                ", tipo_hora='" + tipo_hora + '\'' +
                ", verificacion_mail='" + verificacion_mail + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", rut_empleado=" + rut_empleado +
                ", rut_cliente=" + rut_cliente +
                '}';
    }
}