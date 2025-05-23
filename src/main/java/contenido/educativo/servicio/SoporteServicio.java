package contenido.educativo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contenido.educativo.model.Soporte;
import contenido.educativo.repository.SoporteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SoporteServicio {
    @Autowired
    private SoporteRepository SoporteRepository;

    public List<Soporte> listarTodos() {
        return SoporteRepository.findAll();
    }

    public Optional<Soporte> buscarId(Long id) {
        return SoporteRepository.findById(id);
    }

    public Soporte guardar(Soporte contenido) {
        return SoporteRepository.save(contenido);
    }

    public Soporte actualizar(Soporte actualizar) {
        return SoporteRepository.save(actualizar);
    }

    public void borrar(Soporte borrar) {
        SoporteRepository.delete(borrar);
    }
}
