package wealthguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wealthguard.entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{

	// Método para verificar si existe una categoría global con el mismo nombre (ignorando mayúsculas)
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CategoriaEntity c WHERE LOWER(c.nombre) = LOWER(:nombre)")
	boolean existsByNombre(@Param("nombre") String nombre);

	// Método para buscar categorías con filtros dinámicos.
	// Permite filtrar por usuarioId (para categorías personalizadas) y por nombre (para ambas globales y personalizadas).
	// Si usuarioId es null, se buscan solo categorías globales. Si nombre es null, no se filtra por nombre.
	// Devuelve una lista de categorias [0] sera el id del usuario y [1] sera el nombre de la categoria
	@Query("SELECT c FROM CategoriaEntity c WHERE " +
			"(:usuarioId IS NULL OR c.usuario.id = :usuarioId) AND " +
			"(:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))")
	List<CategoriaEntity> buscarConFiltro(
		@Param("usuarioId") Integer usuarioId,
		@Param("nombre") String nombre
	);

}
