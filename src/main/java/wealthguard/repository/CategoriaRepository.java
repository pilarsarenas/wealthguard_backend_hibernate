package wealthguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wealthguard.entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CategoriaEntity c WHERE LOWER(c.nombre) = LOWER(:nombre)")
	boolean existsByNombre(@Param("nombre") String nombre);

}

