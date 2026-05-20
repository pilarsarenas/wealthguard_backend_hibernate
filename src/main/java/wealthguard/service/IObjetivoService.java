package wealthguard.service;

import java.time.LocalDateTime;
import java.util.List;

import wealthguard.entity.ObjetivoEntity;

public interface IObjetivoService {

    /**
     * Crea un nuevo objetivo financiero para el usuario especificado. El
     * objetivo se asocia a una categoría específica y tiene un monto objetivo,
     * fecha de inicio y fecha de fin. El campo "completado" se establece
     * inicialmente en false.
     *
     * @param idUsuario ID del usuario al que pertenece el objetivo
     * @param idCategoria ID de la categoría asociada al objetivo
     * @param nombreObjetivo Nombre descriptivo del objetivo
     * @param cantidadoObjetivo Monto financiero que se desea alcanzar
     * @param fechaInicio Fecha y hora de inicio del objetivo
     * @param fechaFin Fecha y hora de fin del objetivo
     * @return
     */
    public boolean crearObjetivo(int idUsuario, int idCategoria, String nombreObjetivo, double cantidadoObjetivo, LocalDateTime fechaInicio, LocalDateTime fechaFin, Boolean completado);

    /**
     * Elimina un objetivo financiero existente por su ID. Solo se puede
     * eliminar un objetivo que pertenezca al usuario especificado.
     *
     * @param idObjetivo ID del objetivo a eliminar
     * @return true si la eliminación fue exitosa, false si no se encontró el
     * objetivo o no pertenece al usuario
     */
    public boolean eliminarObjetivo(int idObjetivo);

    /**
     * Edita un objetivo financiero existente. Solo se puede editar un objetivo
     * que pertenezca al usuario especificado. Se pueden actualizar todos los
     * campos del objetivo, incluyendo el nombre, monto, fechas y estado de
     * completado.
     *
     * @param idObjetivo ID del objetivo a editar
     * @param idCategoria ID de la nueva categoría asociada al objetivo
     * @param nombreObjetivo Nuevo nombre descriptivo del objetivo
     * @param cantidadoObjetivo Nuevo monto financiero que se desea alcanzar
     * @param fechaInicio Nueva fecha y hora de inicio del objetivo
     * @param fechaFin Nueva fecha y hora de fin del objetivo
     * @param completado Nuevo estado de completado del objetivo
     * @return true si la edición fue exitosa, false si no se encontró el
     * objetivo o no pertenece al usuario
     */
    public boolean editarObjetivo(int idObjetivo, int idCategoria, String nombreObjetivo, double cantidadoObjetivo, LocalDateTime fechaInicio, LocalDateTime fechaFin, Boolean completado);

    /**
     * Obtiene la lista de objetivos financieros del usuario especificado. Cada
     * objetivo incluye su ID, nombre, monto objetivo, fechas y estado de
     * completado.
     *
     * @param idUsuario ID del usuario
     * @return Lista de ObjetivoEntity que pertenecen al usuario
     */
    public List<ObjetivoEntity> obtenerObjetivos(int idUsuario);

    /**
     * Cambia el estado de completado de un objetivo financiero. Solo se puede
     * cambiar el estado de un objetivo que pertenezca al usuario especificado.
     *
     * @param idObjetivo ID del objetivo a actualizar
     * @param completado Nuevo estado de completado (true o false)
     * @return true si la actualización fue exitosa, false si no se encontró el
     * objetivo o no pertenece al usuario
     */
    public boolean cambiarEstadoCompletado(int idObjetivo, Boolean completado);

}
