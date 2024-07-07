package pe.edu.cibertec.ProyectoAPI.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Libro;
import pe.edu.cibertec.ProyectoAPI.repository.LibroRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Integer id, Libro libro) {
        Libro libroExistente = libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setFechaPublicacion(libro.getFechaPublicacion());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setPrecio(libro.getPrecio());
        libroExistente.setCantidadStock(libro.getCantidadStock());
        return libroRepository.save(libroExistente);
    }

    public void eliminarLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}
