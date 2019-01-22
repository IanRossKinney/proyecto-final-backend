package cl.forge.programatufuturo.reservadehoras.models;

import javax.persistence.*;
import java.util.Date;



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
    private Integer idHora;

    @Column(name = "tipo_hora")
    private String tipoHora;

    @Column(name = "verificacion_mail")
    private String verificacionMail;

    @Column(name="fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name = "rut_empleado")
    private Empleado rutEmpleado;

    @ManyToOne
    @JoinColumn(name = "rut_cliente")
    private Cliente rutCliente;

    public Hora(){
    }


    public Hora(Integer idHora, String tipoHora,Date fecha, String hora, Empleado rutEmpleado, Cliente rutCliente) {
        this.idHora = idHora;
        this.tipoHora = tipoHora;
        this.rutEmpleado = rutEmpleado;
        this.rutCliente = rutCliente;
        this.fecha=fecha;
        this.hora=hora;
        this.verificacionMail=null;
    }

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    public String getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(String tipoHora) {
        this.tipoHora = tipoHora;
    }

    public String getVerificacionMail() {
        return verificacionMail;
    }

    public void setVerificacionMail(String verificacionMail) {
        this.verificacionMail = verificacionMail;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Empleado getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(Empleado rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public Cliente getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Cliente rutCliente) {
        this.rutCliente = rutCliente;
    }

    //ToString
    @Override
    public String toString() {
        return "Hora{" +
                "idHora=" + idHora +
                ", tipoHora='" + tipoHora + '\'' +
                ", verificacionMail='" + verificacionMail + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", rutEmpleado=" + rutEmpleado +
                ", rutCliente=" + rutCliente +
                '}';
    }
}