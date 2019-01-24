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

    @Column(name = "estado")
    private String estado;

    @Column(name="fecha")
    private String fecha;

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

    public Hora(Integer idHora, String tipoHora, String fecha, String hora, Empleado rutEmpleado) {
        this.idHora = idHora;
        this.tipoHora = tipoHora;
        this.verificacionMail = null;
        this.estado = null;
        this.fecha = fecha;
        this.hora = hora;
        this.rutEmpleado = rutEmpleado;
        this.rutCliente = null;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", rutEmpleado=" + rutEmpleado +
                ", rutCliente=" + rutCliente +
                '}';
    }


}