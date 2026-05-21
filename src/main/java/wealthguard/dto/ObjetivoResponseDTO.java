package wealthguard.dto;

public class ObjetivoResponseDTO {

    private Integer id;
    private String nombre;
    private Double cantidadObjetivo;
    private Integer categoriaId;
    private String fechaInicio;
    private String fechaFin;
    private Boolean completado;

    public ObjetivoResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadObjetivo() {
        return cantidadObjetivo;
    }

    public void setCantidadObjetivo(Double cantidadObjetivo) {
        this.cantidadObjetivo = cantidadObjetivo;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

}
