package contenido.educativo.controller;

import org.springframework.web.bind.annotation.RestController;

import contenido.educativo.model.Contenido;
import contenido.educativo.servicio.ContenidoServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController @RequestMapping("/api/v1/contenidos")
public class ContenidoController {
@Autowired
private ContenidoServicio contenidoServicio;

@GetMapping
public List<Contenido> listarTodos() {
    return contenidoServicio.listarTodos();
}

@PostMapping
public Contenido guarContenido(Contenido contenido) {
    return contenidoServicio.guardar(contenido);
}
    



}
