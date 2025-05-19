package contenido.educativo.controller;

import org.springframework.web.bind.annotation.RestController;

import contenido.educativo.model.Soporte;
import contenido.educativo.servicio.SoporteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Soporte guardarContenido(@RequestBody Soporte contenido) {
        return SoporteServicio.guardar(contenido);
    }

    @GetMapping("/id/{id}")
    public Soporte buscarPorId(@PathVariable Long id) {
        return SoporteServicio.buscarId(id);
    }

}
