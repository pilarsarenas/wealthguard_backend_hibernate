package wealthguard.service;

public interface ITipoRecomendacionService {

    /**
     * Obtiene el mensaje de recomendación basado en el ID del tipo de
     * recomendación.
     *
     * @param idTipoRecomendacion El ID del tipo de recomendación para el cual
     * se desea obtener el mensaje.
     * @return El mensaje de recomendación correspondiente al ID proporcionado,
     * o null si no se encuentra.
     */
    public String obtenerMensajeRecomendacion(Integer idTipoRecomendacion);

    /**
     * Obtiene el mensaje de recomendación basado en el nombre del tipo de
     * recomendación.
     *
     * @param nombreTipoRecomendacion El nombre del tipo de recomendación para
     * el cual se desea obtener el mensaje.
     * @return El mensaje de recomendación correspondiente al nombre
     * proporcionado, o null si no se encuentra.
     */
    public String obtenerMensajeRecomendacionPorNombre(String nombreTipoRecomendacion);
}
