package contenido.educativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contenido.educativo.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository <Contenido, Long>{

}
