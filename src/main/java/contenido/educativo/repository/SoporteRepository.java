package contenido.educativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contenido.educativo.model.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository <Soporte, Long>{

}
