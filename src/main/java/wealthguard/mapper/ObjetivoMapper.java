package wealthguard.mapper;

import org.springframework.stereotype.Component;

import wealthguard.dto.ObjetivoRequestDTO;
import wealthguard.entity.ObjetivoEntity;

@Component
public class ObjetivoMapper {

    public ObjetivoEntity convertirAEntity (ObjetivoRequestDTO objetivoRequestDTO){
        if (objetivoRequestDTO == null) {
            return null;
        }

        ObjetivoEntity objetivoEntity = new ObjetivoEntity();
        
        objetivoEntity.setUsuario(objetivoRequestDTO.getUsuarioId());
        objetivoEntity.setCantidadObjetivo(objetivoRequestDTO.getCantidadObjetivo());
        objetivoEntity.setCategoriaId(objetivoRequestDTO.getCategoriaId());
        objetivoEntity.setFechaInicio(objetivoRequestDTO.getFechaInicio());
        objetivoEntity.setFechaFin(objetivoRequestDTO.getFechaFin());
        objetivoEntity.setCompletado(objetivoRequestDTO.getCompletado());

        return objetivoEntity;
    }

}
