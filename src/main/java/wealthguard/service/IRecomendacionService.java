package wealthguard.service;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;

public interface IRecomendacionService {

    RecomendacionResponseDTO crearRecomendacion(RecomendacionRequestDTO recomendacionRequest);

    void eliminarRecomendacion(int idRecomendacion);

    List<RecomendacionResponseDTO> obtenerRecomendaciones(int idUsuario);

    List<RecomendacionResponseDTO> obtenerPorTipo(int idTipoRecomendacion);

    List<RecomendacionResponseDTO> obtenerPorUsuarioYTipo(int idUsuario, int idTipoRecomendacion);

    List<RecomendacionResponseDTO> obtenerRecomendacionesRecientes(int idUsuario);

    List<RecomendacionResponseDTO> obtenerPorRangoDeFechas(int idUsuario, LocalDateTime desde, LocalDateTime hasta);

    List<RecomendacionResponseDTO> buscarConFiltro(Integer idUsuario, Integer idTipoRecomendacion);

}