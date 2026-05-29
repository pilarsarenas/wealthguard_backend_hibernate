package wealthguard.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import wealthguard.entity.RecomendacionEntity;

@Repository
public interface RecomendacionRepository extends JpaRepository<RecomendacionEntity, Integer> {

    List<RecomendacionEntity> findByUsuarioId(Integer usuarioId);

    List<RecomendacionEntity> findByTipoRecomendacionId(Integer tipoRecomendacionId);

    List<RecomendacionEntity> findByUsuarioIdAndTipoRecomendacionId(
        Integer usuarioId,
        Integer tipoRecomendacionId
    );

    List<RecomendacionEntity> findByUsuarioIdAndFechaRecomendacionBetween(
        Integer usuarioId,
        LocalDateTime desde,
        LocalDateTime hasta
    );

    List<RecomendacionEntity> findByUsuarioIdOrderByFechaRecomendacionDesc(Integer usuarioId);

    // Verifica si ya existe una recomendación del mismo tipo para ese usuario en esa fecha
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RecomendacionEntity r " +
           "WHERE r.usuario.id = :usuarioId AND r.tipoRecomendacion.id = :tipoRecomendacionId " +
           "AND r.fechaRecomendacion = :fecha")
    boolean existeRecomendacion(
        @Param("usuarioId") Integer usuarioId,
        @Param("tipoRecomendacionId") Integer tipoRecomendacionId,
        @Param("fecha") LocalDateTime fecha
    );

    // Busca recomendaciones con filtros opcionales por usuario y tipo
    @Query("SELECT r FROM RecomendacionEntity r WHERE " +
           "(:usuarioId IS NULL OR r.usuario.id = :usuarioId) AND " +
           "(:tipoRecomendacionId IS NULL OR r.tipoRecomendacion.id = :tipoRecomendacionId)")
    List<RecomendacionEntity> buscarConFiltro(
        @Param("usuarioId") Integer usuarioId,
        @Param("tipoRecomendacionId") Integer tipoRecomendacionId
    );

    @Transactional
    void deleteByUsuarioId(Integer usuarioId);

}