package contenido.educativo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Soporte {
    //nombre, tipo archivo, fecha creacion, fecha modificacion, tipo de curso, URL (ubicacion), booleano(deprecado, obsoleto), nivel curso

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long IdContenido; 

    private String nombre;

    @Column(unique=true, nullable=false)
    private String correo;

    private String tipoArchivo;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    private String tipoCurso;
    
    @Column(unique=true, nullable=false)
    private String url;

    private boolean deprecado;
    private String nivelCurso;

}
