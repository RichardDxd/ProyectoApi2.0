package pe.edu.cibertec.ProyectoAPI.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoAPI.model.bd.Libro;
import pe.edu.cibertec.ProyectoAPI.service.LibroService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.obtenerLibros();
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        Libro libroActualizado = libroService.actualizarLibro(id, libro);
        return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
