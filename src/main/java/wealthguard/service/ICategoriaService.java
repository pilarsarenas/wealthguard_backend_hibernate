package wealthguard.service;

import java.util.List;

public interface ICategoriaService {

    /**
     * Elimina una categoría global del sistema. Solo se pueden eliminar
     * categorías globales que no sean "General" o "Sin categoría".
     *
     * @param idCategoria ID de la categoría global a eliminar
     * @return true si la eliminación fue exitosa, false si no se encontró la
     * categoría o es una categoría protegida
     */
    public boolean eliminarCategoriaGlobal(int idCategoria);

    /**
     * Crea una nueva categoría global en el sistema.
     *
     * @param nombreCategoria Nombre de la nueva categoría global
     * @return true si la creación fue exitosa, false si ya existe una categoría
     * global con el mismo nombre
     */
    public boolean crearCategoriaGlobal(String nombreCategoria);

    /**
     * Obtiene la lista de categorías globales disponibles en el sistema.
     *
     * @return Lista de nombres de categorías globales, excluyendo "General" y
     * "Sin categoría"
     */
    public List<String> obtenerCategoriasGlobales();

    /**
     * Edita el nombre de una categoría global existente.
     *
     * @param idCategoria ID de la categoría global a editar
     * @param nuevoNombre Nuevo nombre para la categoría global
     * @return true si la edición fue exitosa, false si no se encontró la
     * categoría, es una categoría protegida o ya existe otra categoría global
     * con el nuevo nombre
     */
    public boolean editarCategoriaGlobal(int idCategoria, String nuevoNombre);

}
