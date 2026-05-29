package wealthguard.service;

import java.util.List;

import wealthguard.dto.PresupuestoRequestDTO;
import wealthguard.dto.PresupuestoResponseDTO;

public interface IPresupuestoService {

  /**
   * Crea un nuevo presupuesto.
   * 
   * @param presupuestoRequest DTO con los datos del presupuesto a crear
   * @return DTO con los datos del presupuesto creado
   */
  public PresupuestoResponseDTO crearPresupuesto(PresupuestoRequestDTO presupuestoRequest);

  /**
   * Elimina un presupuesto existente por su ID.
   * 
   * @param idPresupuesto ID del presupuesto a eliminar
   */
  public void eliminarPresupuesto(int idPresupuesto);

  /**
   * Edita un presupuesto existente.
   * 
   * @param idPresupuesto      ID del presupuesto a editar
   * @param presupuestoRequest DTO con los nuevos datos del presupuesto
   * @return DTO con los datos actualizados
   */
  public PresupuestoResponseDTO editarPresupuesto(int idPresupuesto, PresupuestoRequestDTO presupuestoRequest);

  /**
   * Obtiene la lista de presupuestos de un usuario.
   * 
   * @param idUsuario ID del usuario
   * @return Lista de PresupuestoResponseDTO
   */
  public List<PresupuestoResponseDTO> obtenerPresupuestos(int idUsuario);

  public List<PresupuestoResponseDTO> obtenerPorCategoria(int idCategoria);

  public List<PresupuestoResponseDTO> obtenerPresupuestosActivos(int idUsuario);

  public List<PresupuestoResponseDTO> obtenerPorUsuarioYCategoria(int idUsuario, int idCategoria);
}