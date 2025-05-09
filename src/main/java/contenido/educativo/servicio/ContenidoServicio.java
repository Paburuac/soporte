package contenido.educativo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contenido.educativo.model.Contenido;
import contenido.educativo.repository.ContenidoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContenidoServicio {
    @Autowired
    private ContenidoRepository contenidoRepository;
//listar(listo), buscar por id(listo), guardar (listo), borrar, actualizar (listo)
    public List<Contenido> listarTodos() {
        return contenidoRepository.findAll();
    }


    public Contenido buscarId(Long id) {
        return contenidoRepository.findById(id).get();
    }

    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public Contenido actualizar(Contenido actualizar) {
        return contenidoRepository.save(actualizar);
    }

    public void borrar(Contenido borrar) {
        contenidoRepository.delete(borrar);
    }
}
