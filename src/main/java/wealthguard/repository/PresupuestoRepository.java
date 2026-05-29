package wealthguard.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import wealthguard.entity.PresupuestoEntity;

@Repository
public interface PresupuestoRepository extends JpaRepository<PresupuestoEntity, Integer> {

    List<PresupuestoEntity> findByUsuarioId(Integer usuarioId);
    List<PresupuestoEntity> findByCategoriaId(Integer categoriaId);
    List<PresupuestoEntity> findByUsuarioIdAndCategoriaId(Integer usuarioId, Integer categoriaId);
    List<PresupuestoEntity> findByUsuarioIdAndFechaInicioBeforeAndFechaFinAfter(
        Integer usuarioId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    List<PresupuestoEntity> findByUsuarioIdAndFechaInicioBetween(
        Integer usuarioId, LocalDateTime desde, LocalDateTime hasta);
    @Transactional
    void deleteByUsuarioId(Integer usuarioId);

}