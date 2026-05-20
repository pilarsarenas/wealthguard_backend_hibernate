package wealthguard.service;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.entity.RecomendacionEntity;

public interface IRecomendacionService {

    /**
     * Genera una recomendación personalizada para un usuario específico. La
     * recomendación se basa en el análisis de los datos financieros del
     * usuario, como sus ingresos, gastos, presupuestos y objetivos financieros.
     *
     * @param idUsuario ID del usuario para el cual se generará la recomendación
     * @param idTipoRecomendacion ID del tipo de recomendación que se desea
     * generar (por ejemplo, ahorro, inversión, reducción de gastos, etc.)
     * @param fechaRecomendacion Fecha y hora en la que se generará la
     * recomendación
     * @return Una cadena de texto que contiene la recomendación personalizada
     * para el usuario.
     */
    public boolean crearRecomendacion(int idUsuari, int idTipoRecomendacion, LocalDateTime fechaRecomendacion);

    /**
     * Elimina una recomendación existente por su ID.
     *
     * @param idRecomendacion ID de la recomendación a eliminar
     * @return true si la eliminación fue exitosa, false si no se encontró la
     * recomendación o no pertenece al usuario
     */
    public boolean eliminarRecomendacion(int idRecomendacion);

    /**
     * Obtiene la lista de recomendaciones del usuario especificado. Cada
     * recomendación incluye su ID, tipo y fecha.
     *
     * @param idUsuario ID del usuario
     * @return Lista de RecomendacionEntity que pertenecen al usuario
     */
    public List<RecomendacionEntity> obtenerRecomendaciones(int idUsuario);

}
