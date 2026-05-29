package wealthguard.service;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;

public interface IRecomendacionService {

    /**
     * Crea una nueva recomendación.
     *
     * @param recomendacionRequest datos necesarios para crear la recomendación
     * @return recomendación creada
     */
    RecomendacionResponseDTO crearRecomendacion(RecomendacionRequestDTO recomendacionRequest);

    /**
     * Elimina una recomendación por su identificador.
     *
     * @param idRecomendacion identificador de la recomendación a eliminar
     */
    void eliminarRecomendacion(int idRecomendacion);

    /**
     * Obtiene todas las recomendaciones de un usuario.
     *
     * @param idUsuario identificador del usuario
     * @return lista de recomendaciones del usuario
     */
    List<RecomendacionResponseDTO> obtenerRecomendaciones(int idUsuario);

    /**
     * Obtiene recomendaciones filtradas por tipo.
     *
     * @param idTipoRecomendacion identificador del tipo de recomendación
     * @return lista de recomendaciones del tipo indicado
     */
    List<RecomendacionResponseDTO> obtenerPorTipo(int idTipoRecomendacion);

    /**
     * Obtiene recomendaciones filtradas por usuario y tipo.
     *
     * @param idUsuario identificador del usuario
     * @param idTipoRecomendacion identificador del tipo de recomendación
     * @return lista de recomendaciones filtradas
     */
    List<RecomendacionResponseDTO> obtenerPorUsuarioYTipo(int idUsuario, int idTipoRecomendacion);

    /**
     * Obtiene las recomendaciones recientes de un usuario.
     *
     * @param idUsuario identificador del usuario
     * @return lista de recomendaciones recientes
     */
    List<RecomendacionResponseDTO> obtenerRecomendacionesRecientes(int idUsuario);

    /**
     * Obtiene recomendaciones dentro de un rango de fechas.
     *
     * @param idUsuario identificador del usuario
     * @param desde fecha inicial del rango
     * @param hasta fecha final del rango
     * @return lista de recomendaciones dentro del rango de fechas
     */
    List<RecomendacionResponseDTO> obtenerPorRangoDeFechas(int idUsuario, LocalDateTime desde, LocalDateTime hasta);

    /**
     * Busca recomendaciones aplicando filtros opcionales.
     *
     * @param idUsuario identificador del usuario (opcional)
     * @param idTipoRecomendacion identificador del tipo de recomendación (opcional)
     * @return lista de recomendaciones filtradas
     */
    List<RecomendacionResponseDTO> buscarConFiltro(Integer idUsuario, Integer idTipoRecomendacion);

}