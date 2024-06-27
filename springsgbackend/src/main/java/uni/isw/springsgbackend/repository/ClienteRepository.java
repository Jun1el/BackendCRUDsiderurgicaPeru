/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uni.isw.springsgbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.springsgbackend.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    List<Cliente> findByNombre(String nombre);
    Cliente findByEmail(String email);
}
