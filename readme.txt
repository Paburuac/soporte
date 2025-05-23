# Proyecto de Contenido Educativo: Gestión de Soporte

Este proyecto es una aplicación Spring Boot que implementa una API RESTful para la gestión de solicitudes o tickets de soporte.

---

## Clases del Proyecto

### `contenido.educativo.model.Soporte`

Representa la **entidad** para un ticket de soporte. Define la estructura de los datos que se almacenarán en la base de datos para cada solicitud de soporte.

* **Atributos:**
    * `IdSoporte`: Identificador único del ticket (clave primaria, autoincremental).
    * `nombre`: Nombre del solicitante o descripción del ticket.
    * `correo`: Correo electrónico del solicitante (campo único y no nulo).
    * `TipoConsulta`: Tipo de consulta o problema.
    * `fechaCreacion`: Fecha de creación del ticket.
    * `fechaFinalizacion`: Fecha de finalización o cierre del ticket.
    * `url`: URL asociada al ticket (campo único y no nulo).
* **Anotaciones clave:**
    * `@Entity`: Marca la clase como una entidad JPA para mapeo a base de datos.
    * `@Data` (Lombok): Genera automáticamente getters, setters, `equals()`, `hashCode()`, y `toString()`.
    * `@AllArgsConstructor`, `@NoArgsConstructor` (Lombok): Generan constructores.
    * `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Para la clave primaria autogenerada.
    * `@Column(unique=true, nullable=false)`: Para definir restricciones de unicidad y no nulidad en las columnas de la base de datos.

### `contenido.educativo.servicio.SoporteServicio`

Define la **capa de servicio** o lógica de negocio para la gestión de tickets de soporte. Actúa como intermediario entre el controlador y el repositorio, orquestando las operaciones y aplicando la lógica transaccional.

* **Dependencias:**
    * `SoporteRepository` (inyectado vía `@Autowired`): Interfaz para la comunicación con la base de datos.
* **Métodos (Operaciones CRUD):**
    * `listarTodos()`: Recupera una lista de todos los tickets de soporte.
    * `buscarId(Long id)`: Busca un ticket por su identificador único.
    * `guardar(Soporte contenido)`: Guarda un nuevo ticket de soporte.
    * `actualizar(Soporte actualizar)`: Actualiza un ticket de soporte existente.
    * `borrar(Soporte borrar)`: Elimina un ticket de soporte.
* **Anotaciones clave:**
    * `@Service`: Indica que es un componente de servicio de Spring.
    * `@Transactional`: Asegura que los métodos se ejecuten dentro de una transacción de base de datos.

### `contenido.educativo.controller.SoporteController`

Actúa como el **controlador REST** para la entidad `Soporte`. Maneja las solicitudes HTTP entrantes y las mapea a las operaciones de servicio correspondientes.

* **URL Base:** `/api/v1/soporte` (definida por `@RequestMapping`).
* **Dependencias:**
    * `SoporteServicio` (inyectado vía `@Autowired`): Para acceder a la lógica de negocio.
* **Endpoints HTTP (Operaciones API):**
    * `GET /api/v1/soporte`: `listarTodos()` - Obtiene todos los tickets de soporte.
    * `GET /api/v1/soporte/id/{id}`: `buscarPorId(@PathVariable Long id)` - Busca un ticket por su ID.
    * `POST /api/v1/soporte`: `guardarContenido(@RequestBody Soporte soporte)` - Crea un nuevo ticket.
    * `PUT /api/v1/soporte`: `actualizarPorId(@RequestBody Soporte soporte)` - Actualiza un ticket existente.
    * `DELETE /api/v1/soporte`: `borrarSoporte(@RequestBody Soporte soporte)` - Elimina un ticket.
* **Anotaciones clave:**
    * `@RestController`: Combina `@Controller` y `@ResponseBody`, indicando que los métodos devuelven datos directamente en el cuerpo de la respuesta HTTP (ej. JSON).
    * `@RequestMapping`: Mapea las solicitudes web a métodos específicos.
    * `@PathVariable`: Extrae valores de la URL de la petición.
    * `@RequestBody`: Convierte el cuerpo de la petición HTTP (ej. JSON) en un objeto Java.

### `contenido.educativo.Application`

Es la **clase principal** de la aplicación Spring Boot. Es el punto de entrada desde donde se inicia y ejecuta todo el contexto de la aplicación.

* **Método principal:** `public static void main(String[] args)`: El método estándar de Java para iniciar la aplicación.
* **Anotaciones clave:**
    * `@SpringBootApplication`: Una anotación de conveniencia que habilita la configuración automática de Spring Boot, el escaneo de componentes (`@ComponentScan`) y la definición de configuración (`@Configuration`).
* **Función:**
    * `SpringApplication.run(Application.class, args);`: Inicia la aplicación Spring Boot, configura el entorno, y arranca el servidor embebido (como Tomcat) para que la API esté disponible.