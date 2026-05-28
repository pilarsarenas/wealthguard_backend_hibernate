package wealthguard.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wealthguard.entity.PresupuestoEntity;

@Repository
public interface PresupuestoRepository extends JpaRepository<PresupuestoEntity, Integer> {

    List<PresupuestoEntity> findByUsuarioId(Integer usuarioId);

    List<PresupuestoEntity> findByCategoriaId(Integer categoriaId);

    List<PresupuestoEntity> findByUsuarioIdAndCategoriaId(Integer usuarioId, Integer categoriaId);

    // Buscar presupuestos activos de un usuario (fecha actual dentro del rango)
    List<PresupuestoEntity> findByUsuarioIdAndFechaInicioBeforeAndFechaFinAfter(
        Integer usuarioId,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin
    );

    // Buscar presupuestos de un usuario dentro de un rango de fechas
    List<PresupuestoEntity> findByUsuarioIdAndFechaInicioBetween(
        Integer usuarioId,
        LocalDateTime desde,
        LocalDateTime hasta
    );

    void deleteByUsuarioId(Integer usuarioId);

}