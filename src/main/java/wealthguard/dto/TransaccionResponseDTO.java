package wealthguard.dto;


// Envia los datos al frontend
public class TransaccionResponseDTO {

    private Integer id;
    private double cantidad;
    private java.time.LocalDateTime fecha;
    private String descripcion;
    private String nombreCategoria;
    private Integer idCategoria;
    private Boolean tipoTransaccion;

    public TransaccionResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public java.time.LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(java.time.LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Boolean getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Boolean tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }


}
