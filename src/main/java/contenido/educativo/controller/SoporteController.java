package contenido.educativo.controller;

import org.springframework.web.bind.annotation.RestController;

import contenido.educativo.model.Soporte;
import contenido.educativo.servicio.SoporteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController @RequestMapping("/api/v1/soporte")
public class SoporteController {

    @Autowired
    private SoporteServicio SoporteServicio;

    @GetMapping
    public List<Soporte> listarTodos() {
        return SoporteServicio.listarTodos();
    }

    @PostMapping
    public Soporte guardarContenido(@RequestBody Soporte soporte) {
        return SoporteServicio.guardar(soporte);
    }

    @GetMapping("/id/{id}")
    public Soporte buscarPorId(@PathVariable Long id) {
        return SoporteServicio.buscarId(id);
    }

    @PutMapping
    public Soporte actualizarPorId(@RequestBody Soporte soporte) {
        return SoporteServicio.actualizar(soporte);
    }

    @DeleteMapping
    public void borrarSoporte(@RequestBody Soporte soporte) {
        SoporteServicio.borrar(soporte);
    }
}
