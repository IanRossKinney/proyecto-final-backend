package cl.forge.programatufuturo.reservadehoras.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;



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
    private String idHora;

    @Column(name = "tipo_hora")
    private String tipoHora;

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

    public Hora(String idHora, String tipoHora, String fecha, String hora, Empleado rutEmpleado) {
        this.idHora = idHora;
        this.tipoHora = tipoHora;
        this.estado = "Disponible";
        this.fecha = fecha;
        this.hora = hora;
        this.rutEmpleado = rutEmpleado;
        this.rutCliente = null;
    }
    public Hora(String tipoHora){
        this.tipoHora=tipoHora;
    }


    public String getIdHora() {
        return idHora;
    }

    public void setIdHora(String idHora) {
        this.idHora = idHora;
    }

    public String getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(String tipoHora) {
        this.tipoHora = tipoHora;
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

    //Obtener fecha de formato date HTML
    public String modificarFecha(String fecha){
        String nuevaFecha="";
        for (int i = 0; i <10 ; i++) {
            nuevaFecha+=fecha.charAt(i);
        }
        return nuevaFecha;
    }
    //Generador de id para hora


    public String crearID() {
        return UUID.randomUUID().toString();
    }



    @Override
    public String toString() {
        return "Hora{" +
                "idHora=" + idHora +
                ", tipoHora='" + tipoHora + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", rutEmpleado=" + rutEmpleado +
                ", rutCliente=" + rutCliente +
                '}';
    }
}