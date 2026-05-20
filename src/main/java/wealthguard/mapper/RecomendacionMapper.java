package wealthguard.mapper;

import org.springframework.stereotype.Component;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;
import wealthguard.entity.RecomendacionEntity;

@Component
public class RecomendacionMapper {

    // Metodo para convertir lo que llega del frontend en una entidad para la base
    // de datos
    public RecomendacionEntity convertirAEntity(RecomendacionRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        RecomendacionEntity entity = new RecomendacionEntity();

        entity.setUsuario(dto.getUsuario());
        entity.setTipoRecomendacion(dto.getTipoRecomendacion());
        entity.setFechaRecomendacion(dto.getFechaRecomendacion());
        return entity;

    }

    // Metodo para convertir lo que sale de la base de datos a DTO para el frontend
    public RecomendacionResponseDTO convertirADTO(RecomendacionEntity entity) {
        if (entity == null) {
            return null;
        }

        RecomendacionResponseDTO dto = new RecomendacionResponseDTO();

        dto.setId(entity.getId());
        dto.setUsuario(entity.getUsuario());
        dto.setTipoRecomendacion(entity.getTipoRecomendacion());
        dto.setFechaRecomendacion(entity.getFechaRecomendacion());
        return dto;

    }

}
