package contenido.educativo.controller;

import org.springframework.web.bind.annotation.RestController;

import contenido.educativo.model.Soporte;
import contenido.educativo.servicio.SoporteServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> guardarContenido(@RequestBody Soporte soporte) {
        try {
            Soporte soporteGuardado = SoporteServicio.guardar(soporte);
            return ResponseEntity.status(HttpStatus.CREATED).body(soporteGuardado);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Correo o URL ya están registrados.");
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Soporte> soporteOptional = SoporteServicio.buscarId(id);

        if (soporteOptional.isPresent()) {
            return ResponseEntity.ok(soporteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Soporte> actualizarPorId(@RequestBody Soporte soporte) {
        if (soporte.getIdSoporte() == null) {
            return ResponseEntity.notFound().build();
        }
        Soporte soporteActualizado = SoporteServicio.actualizar(soporte);
        
        if (soporteActualizado == null) {
            return ResponseEntity.notFound().build(); // Si no se encontró en DB
        }
        return ResponseEntity.ok(soporteActualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> borrarSoporte(@RequestBody Soporte soporte) {
        try{
            SoporteServicio.borrar(soporte);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
