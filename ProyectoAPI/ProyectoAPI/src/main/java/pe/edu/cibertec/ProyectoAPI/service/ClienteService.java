package pe.edu.cibertec.ProyectoAPI.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoAPI.repository.ClienteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
