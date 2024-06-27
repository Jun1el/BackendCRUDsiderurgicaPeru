/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.isw.springsgbackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.springsgbackend.model.Cliente;
import uni.isw.springsgbackend.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.findById(id);
    }
    public void saveOrUpdateCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
    public List<Cliente> buscarPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
}
}
