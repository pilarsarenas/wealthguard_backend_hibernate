package wealthguard.service;

import java.util.List;

import wealthguard.dto.CategoriaRequestDTO;
import wealthguard.dto.CategoriaResponseDTO;

public interface ICategoriaService {

    /**
     * Elimina una categoría global del sistema. Solo se pueden eliminar
     * categorías globales que no sean "General" o "Sin categoría".
     *
     * @param idCategoria ID de la categoría global a eliminar
     * @return true si la eliminación fue exitosa, false si no se encontró la
     * categoría
     */
    public boolean eliminarCategoriaGlobal(int idCategoria);

    /**
     * Crea una nueva categoría global en el sistema.
     *
     * @param nombreCategoria DTO que contiene el nombre de la categoría global a crear
     * @return true si la creación fue exitosa, false si ya existe una categoría
     * global con el mismo nombre
     */
    public CategoriaResponseDTO crearCategoriaGlobal(CategoriaRequestDTO nombreCategoria);

    /**
     * Obtiene la lista de categorías globales disponibles en el sistema.
     *
     * @return Lista de nombres de categorías globales
     */
    public List<CategoriaResponseDTO> obtenerCategoriasGlobales();

    /**
     * Edita el nombre de una categoría global existente.
     *
     * @param idCategoria ID de la categoría global a editar
     * @param nuevoNombre Nuevo nombre para la categoría global
     * @return El objeto {@link CategoriaResponseDTO} con los datos actualizados de la categoría, o null si no se encontró la categoría
     */
    public CategoriaResponseDTO editarCategoriaGlobal(int idCategoria, CategoriaRequestDTO nuevoNombre);

}
