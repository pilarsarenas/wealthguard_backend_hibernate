package wealthguard.dto;

import java.time.LocalDateTime;

// Recibe los datos desde el frontend
public class TransaccionRequestDTO {

    private double cantidad;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer idCategoria;
    private Integer idUsuario;
    private Boolean tipoTransaccion; // true = ingreso, false = gasto


    public TransaccionRequestDTO() {
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Integer getIdCategoria() {
        return idCategoria;
    }   

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Boolean tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }


}
