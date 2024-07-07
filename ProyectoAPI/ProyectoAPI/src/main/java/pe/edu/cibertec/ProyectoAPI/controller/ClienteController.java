package pe.edu.cibertec.ProyectoAPI.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoAPI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoAPI.service.ClienteService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.obtenerClientes();
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
