package wealthguard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import wealthguard.dto.CategoriaRequestDTO;
import wealthguard.dto.CategoriaResponseDTO;
import wealthguard.entity.CategoriaEntity;
import wealthguard.mapper.CategoriaMapper;
import wealthguard.repository.CategoriaRepository;

public class CategoriaServiceImpl {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public boolean eliminarCategoriaGlobal(int idCategoria) {

        if (categoriaRepository.existsById(idCategoria)) {
            // Aquí se podría agregar lógica adicional para verificar si la categoría es "General" o "Sin categoría"
            categoriaRepository.deleteById(idCategoria);
            return true;
        } else {
            return false; // No se encontró la categoría

        }
    }

    public CategoriaResponseDTO crearCategoriaGlobal(CategoriaRequestDTO nombreCategoria) {

        CategoriaEntity categoriaEntidad = categoriaMapper.convertirAEntity(nombreCategoria);

        if (categoriaRepository.existsByNombre(categoriaEntidad.getNombre())) {
            return null; // Ya existe una categoría global con el mismo nombre
        } else {
            CategoriaEntity categoriaGuardada = categoriaRepository.save(categoriaEntidad);
            return categoriaMapper.convertirADTO(categoriaGuardada); // Retorna el DTO de la categoría creada
        }
        
    }

    public List<CategoriaResponseDTO> obtenerCategoriasGlobales() {
        // Implementación del método para obtener la lista de categorías globales
        return null; // Placeholder, reemplazar con la lógica real
    }

    public CategoriaResponseDTO editarCategoriaGlobal(int idCategoria, String nuevoNombre) {
        // Implementación del método para editar el nombre de una categoría global existente
        return null; // Placeholder, reemplazar con la lógica real
    }

}
