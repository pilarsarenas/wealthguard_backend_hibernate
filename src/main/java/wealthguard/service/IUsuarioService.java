package wealthguard.service;

import java.util.List;

import wealthguard.entity.UsuarioEntity;
import wealthguard.exception.UsuarioException;

public interface IUsuarioService {

    /**
     * Actualiza los datos del perfil del usuario. El usuario DEBE tener ID para
     * poder actualizarse.
     *
     * @param usuario Entidad con ID y datos nuevos a actualizar
     * @return UsuarioEntity con los datos actualizados
     * @throws UsuarioException si el usuario no existe o el nick ya está en uso
     */
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) throws UsuarioException;

    /**
     * Elimina de forma permanente la cuenta del usuario y todos sus datos
     * asociados. Operación irreversible.
     *
     * @param idUsuario ID del usuario a eliminar
     * @return true si la eliminación fue exitosa, false si no se encontró el
     * usuario
     */
    public boolean eliminarCuenta(int idUsuario);

    /**
     * Genera un fichero con todo el historial financiero del usuario para
     * cumplir con el derecho de portabilidad (RGPD).
     *
     * @param idUsuario ID del usuario
     * @return Array de bytes del fichero generado (PDF o CSV)
     */
    public byte[] exportarDatos(int idUsuario);

    /**
     * Cambia la contraseña del usuario siguiendo estos pasos: 1. Verifica que
     * passwordAntigua coincide con la almacenada (BCrypt) 2. Hashea
     * passwordNueva con BCrypt 3. Actualiza fechaUltimoCambioPassword a
     * LocalDateTime.now()
     *
     * @param idUsuario ID del usuario
     * @param passwordAntigua Contraseña actual en texto plano para verificar
     * @param passwordNueva Nueva contraseña en texto plano para hashear y
     * guardar
     * @return true si el cambio fue exitoso
     * @throws UsuarioException si la contraseña antigua es incorrecta o el
     * usuario no existe
     */
    public boolean cambiarPassword(int idUsuario, String passwordAntigua, String passwordNueva) throws UsuarioException;

    /**
     * Carga los datos del usuario para mostrarlos en la pantalla de perfil.
     *
     * @param idUsuario ID del usuario autenticado
     * @return UsuarioEntity con todos sus datos, incluida la URL de fotoPerfil
     */
    public UsuarioEntity obtenerPerfil(int idUsuario);

    /**
     * Actualiza la foto de perfil del usuario. Guarda los bytes de la imagen en
     * servidor o S3 y almacena la URL resultante en el campo fotoPerfil del
     * usuario.
     *
     * @param idUsuario ID del usuario
     * @param imagen Bytes de la imagen (JPG/PNG)
     * @return URL o ruta donde quedó almacenada la imagen
     * @throws UsuarioException si el usuario no existe
     */
    public String actualizarFotoPerfil(int idUsuario, byte[] imagen) throws UsuarioException;

    /**
     * Elimina una categoría personalizada del usuario. Solo se pueden eliminar
     * categorías que no sean "General" o "Sin categoría".
     *
     * @param idCategoria ID de la categoría a eliminar
     * @param idUsuario ID del usuario propietario de la categoría
     * @return true si la eliminación fue exitosa, false si no se encontró la
     * categoría o no pertenece al usuario
     */
    public boolean eliminarCategoriaUsuario(int idCategoria, int idUsuario);

    /**
     * Crea una nueva categoría personalizada para el usuario.
     *
     * @param nombreCategoria Nombre de la nueva categoría
     * @param idUsuario ID del usuario propietario de la categoría
     * @return true si la creación fue exitosa, false si ya existe una categoría
     * con el mismo nombre para ese usuario
     */
    public boolean crearCategoriaUsuario(String nombreCategoria, int idUsuario);

    /**
     * Obtiene la lista de categorías personalizadas del usuario.
     *
     * @param idUsuario ID del usuario
     * @return Lista de nombres de categorías personalizadas, excluyendo
     * "General" y "Sin categoría"
     */
    public List<String> obtenerCategoriasUsuario(int idUsuario);

}
