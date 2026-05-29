package wealthguard.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;
import wealthguard.entity.RecomendacionEntity;
import wealthguard.mapper.RecomendacionMapper;
import wealthguard.repository.RecomendacionRepository;
import wealthguard.service.IRecomendacionService;

@Service
public class RecomendacionServiceImpl implements IRecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private RecomendacionMapper recomendacionMapper;

    @Override
    public RecomendacionResponseDTO crearRecomendacion(RecomendacionRequestDTO recomendacionRequest) {
        // Valida que no exista ya una recomendación igual antes de guardar
        boolean yaExiste = recomendacionRepository.existeRecomendacion(
                recomendacionRequest.getUsuario().getId(),
                recomendacionRequest.getTipoRecomendacion().getId(),
                recomendacionRequest.getFechaRecomendacion()
        );
        if (yaExiste) {
            throw new RuntimeException("Ya existe una recomendación de ese tipo para ese usuario en esa fecha.");
        }

        RecomendacionEntity entity = recomendacionMapper.convertirAEntity(recomendacionRequest);
        RecomendacionEntity guardado = recomendacionRepository.save(entity);
        return recomendacionMapper.convertirADTO(guardado);
    }

    @Override
    public void eliminarRecomendacion(int idRecomendacion) {
        if (!recomendacionRepository.existsById(idRecomendacion)) {
            throw new RuntimeException("Recomendación no encontrada con id: " + idRecomendacion);
        }
        recomendacionRepository.deleteById(idRecomendacion);
    }

    @Override
    public List<RecomendacionResponseDTO> obtenerRecomendaciones(int idUsuario) {
        return recomendacionRepository.findByUsuarioId(idUsuario)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<RecomendacionResponseDTO> obtenerPorTipo(int idTipoRecomendacion) {
        return recomendacionRepository.findByTipoRecomendacionId(idTipoRecomendacion)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<RecomendacionResponseDTO> obtenerPorUsuarioYTipo(int idUsuario, int idTipoRecomendacion) {
        return recomendacionRepository.findByUsuarioIdAndTipoRecomendacionId(idUsuario, idTipoRecomendacion)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<RecomendacionResponseDTO> obtenerRecomendacionesRecientes(int idUsuario) {
        return recomendacionRepository.findByUsuarioIdOrderByFechaRecomendacionDesc(idUsuario)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<RecomendacionResponseDTO> obtenerPorRangoDeFechas(int idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        return recomendacionRepository.findByUsuarioIdAndFechaRecomendacionBetween(idUsuario, desde, hasta)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<RecomendacionResponseDTO> buscarConFiltro(Integer idUsuario, Integer idTipoRecomendacion) {
        return recomendacionRepository.buscarConFiltro(idUsuario, idTipoRecomendacion)
                .stream().map(recomendacionMapper::convertirADTO).collect(Collectors.toList());
    }

}