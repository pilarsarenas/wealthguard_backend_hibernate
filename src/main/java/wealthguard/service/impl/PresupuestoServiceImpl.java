package wealthguard.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wealthguard.dto.PresupuestoRequestDTO;
import wealthguard.dto.PresupuestoResponseDTO;
import wealthguard.entity.PresupuestoEntity;
import wealthguard.mapper.PresupuestoMapper;
import wealthguard.repository.PresupuestoRepository;
import wealthguard.service.IPresupuestoService;

@Service
public class PresupuestoServiceImpl implements IPresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private PresupuestoMapper presupuestoMapper;

    @Override
    public PresupuestoResponseDTO crearPresupuesto(PresupuestoRequestDTO presupuestoRequest) {
        PresupuestoEntity entity = presupuestoMapper.convertirAEntity(presupuestoRequest);
        PresupuestoEntity guardado = presupuestoRepository.save(entity);
        return presupuestoMapper.convertirADTO(guardado);
    }

    @Override
    public void eliminarPresupuesto(int idPresupuesto) {
        if (!presupuestoRepository.existsById(idPresupuesto)) {
            throw new RuntimeException("Presupuesto no encontrado con id: " + idPresupuesto);
        }
        presupuestoRepository.deleteById(idPresupuesto);
    }

    @Override
    public PresupuestoResponseDTO editarPresupuesto(int idPresupuesto, PresupuestoRequestDTO presupuestoRequest) {
        PresupuestoEntity entity = presupuestoRepository.findById(idPresupuesto)
                .orElseThrow(() -> new RuntimeException("Presupuesto no encontrado con id: " + idPresupuesto));

        entity.setUsuario(presupuestoRequest.getUsuario());
        entity.setCategoria(presupuestoRequest.getCategoria());
        entity.setLimite(presupuestoRequest.getLimite());
        entity.setFechaInicio(presupuestoRequest.getFechaInicio());
        entity.setFechaFin(presupuestoRequest.getFechaFin());

        PresupuestoEntity actualizado = presupuestoRepository.save(entity);
        return presupuestoMapper.convertirADTO(actualizado);
    }

    @Override
    public List<PresupuestoResponseDTO> obtenerPresupuestos(int idUsuario) {
        List<PresupuestoEntity> presupuestos = presupuestoRepository.findByUsuarioId(idUsuario);
        return presupuestos.stream()
                .map(presupuestoMapper::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PresupuestoResponseDTO> obtenerPorCategoria(int idCategoria) {
        return presupuestoRepository.findByCategoriaId(idCategoria)
                .stream().map(presupuestoMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<PresupuestoResponseDTO> obtenerPresupuestosActivos(int idUsuario) {
        LocalDateTime ahora = LocalDateTime.now();
        return presupuestoRepository
                .findByUsuarioIdAndFechaInicioBeforeAndFechaFinAfter(idUsuario, ahora, ahora)
                .stream().map(presupuestoMapper::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public List<PresupuestoResponseDTO> obtenerPorUsuarioYCategoria(int idUsuario, int idCategoria) {
        return presupuestoRepository.findByUsuarioIdAndCategoriaId(idUsuario, idCategoria)
                .stream().map(presupuestoMapper::convertirADTO).collect(Collectors.toList());
    }

     @Override
    public List<PresupuestoResponseDTO> buscarConFiltro(Integer idUsuario, Integer idCategoria) {
        return presupuestoRepository.buscarConFiltro(idUsuario, idCategoria)
                .stream().map(presupuestoMapper::convertirADTO).collect(Collectors.toList());
    }

}