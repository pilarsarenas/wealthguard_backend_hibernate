package wealthguard.mapper;

import org.springframework.stereotype.Component;

import wealthguard.dto.RecomendacionRequestDTO;
import wealthguard.dto.RecomendacionResponseDTO;
import wealthguard.entity.RecomendacionEntity;

@Component
public class RecomendacionMapper {

    public RecomendacionEntity convertirAEntity(RecomendacionRequestDTO recomendacionRequestDTO) {
        if (recomendacionRequestDTO == null) {
            return null;
        }

        RecomendacionEntity recomendacionEntity = new RecomendacionEntity();

        recomendacionEntity.setUsuario(recomendacionRequestDTO.getUsuario());
        recomendacionEntity.setTipoRecomendacion(recomendacionRequestDTO.getTipoRecomendacion());
        recomendacionEntity.setFechaRecomendacion(recomendacionRequestDTO.getFechaRecomendacion());
        return recomendacionEntity;

    }

    public RecomendacionResponseDTO convertirADTO(RecomendacionEntity recomendacionEntity) {
        if (recomendacionEntity == null) {
            return null;
        }

        RecomendacionResponseDTO recomendacionDTO = new RecomendacionResponseDTO();

        recomendacionDTO.setId(recomendacionEntity.getId());
        recomendacionDTO.setUsuario(recomendacionEntity.getUsuario());
        recomendacionDTO.setTipoRecomendacion(recomendacionEntity.getTipoRecomendacion());
        recomendacionDTO.setFechaRecomendacion(recomendacionEntity.getFechaRecomendacion());
        return recomendacionDTO;

    }

}
