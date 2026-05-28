package wealthguard.mapper;

import org.springframework.stereotype.Component;

import wealthguard.dto.PresupuestoRequestDTO;
import wealthguard.dto.PresupuestoResponseDTO;
import wealthguard.entity.PresupuestoEntity;

@Component
public class PresupuestoMapper {

    // Metodo para convertir lo que llega del frontend en una entidad para la base
    // de datos
    public PresupuestoEntity convertirAEntity(PresupuestoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        PresupuestoEntity entity = new PresupuestoEntity();

        entity.setUsuario(dto.getUsuario());
        entity.setCategoria(dto.getCategoria());
        entity.setLimite(dto.getLimite());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());

        return entity;

    }

    // Metodo para convertir lo que sale de la base de datos a DTO para el frontend
    public PresupuestoResponseDTO convertirADTO(PresupuestoEntity entity) {
        if (entity == null) {
            return null;
        }

        PresupuestoResponseDTO dto = new PresupuestoResponseDTO();

        dto.setId(entity.getId());
        dto.setUsuario(entity.getUsuario());
        dto.setCategoria(entity.getCategoria());
        dto.setLimite(entity.getLimite());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());

        return dto;
    }
}
