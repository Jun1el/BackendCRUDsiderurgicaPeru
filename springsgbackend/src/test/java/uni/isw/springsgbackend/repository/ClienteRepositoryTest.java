package uni.isw.springsgbackend.repository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uni.isw.springsgbackend.model.Cliente;
@DataJpaTest
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2)
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    public void ClienteRepository_Listar(){
        Cliente cliente1=Cliente.builder()
                .apellido("Reeves")              
                .nombre("David")
                .empresa("Uni")
                .telefono("987423242")
                .email("hola123@gmail.com")
                .direccion("Av. Rimac 123").build();
        Cliente cliente2=Cliente.builder()
                .apellido("Escobar")              
                .nombre("Alejandro")
                .empresa("Bembos")
                .telefono("984325242")
                .email("hola456@gmail.com")
                .direccion("Av. Independecnia 678").build();
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        //se pone a prueba el metodo de obtener todos los clientes
        List<Cliente> clienteList = (List<Cliente>) clienteRepository.findAll();
        Assertions.assertThat(clienteList).isNotNull();
        Assertions.assertThat(clienteList.size()).isEqualTo(2);
        //Añadí una verificación adicional para asegurar que los nombres en la lista son los que esperamos
        Assertions.assertThat(clienteList).extracting(Cliente::getNombre).containsExactly("David", "Alejandro");
    }
    
    @Test
    public void ClienteRepository_Find_Name() {
    Cliente cliente1 = Cliente.builder()
            .apellido("Reeves")
            .nombre("David")
            .empresa("Uni")
            .telefono("987423242")
            .email("hola123@gmail.com")
            .direccion("Av. Rimac 123").build();
    clienteRepository.save(cliente1);

    List<Cliente> clientes = clienteRepository.findByNombre("David");
    Assertions.assertThat(clientes).isNotEmpty();
    Assertions.assertThat(clientes.get(0).getNombre()).isEqualTo("David");
}
    @Test
    public void ClienteRepository_Update() {
    Cliente cliente = Cliente.builder()
            .apellido("Reeves")
            .nombre("David")
            .empresa("Uni")
            .telefono("987423242")
            .email("hola123@gmail.com")
            .direccion("Av. Rimac 123").build();
    clienteRepository.save(cliente);

    cliente.setNombre("John");
    clienteRepository.save(cliente);

    Cliente updatedCliente = clienteRepository.findById(cliente.getClienteid()).orElse(null);
    Assertions.assertThat(updatedCliente).isNotNull();
    Assertions.assertThat(updatedCliente.getNombre()).isEqualTo("John");
}
    @Test
    public void ClienteRepository_Delete() {
    Cliente cliente = Cliente.builder()
            .apellido("Reeves")
            .nombre("David")
            .empresa("Uni")
            .telefono("987423242")
            .email("hola123@gmail.com")
            .direccion("Av. Rimac 123").build();
    clienteRepository.save(cliente);

    clienteRepository.delete(cliente);

    Cliente deletedCliente = clienteRepository.findById(cliente.getClienteid()).orElse(null);
    Assertions.assertThat(deletedCliente).isNull();
}
    public void ClienteRepository_FindByEmail() {
        Cliente cliente = Cliente.builder()
                .apellido("Reeves")
                .nombre("David")
                .empresa("Uni")
                .telefono("987423242")
                .email("hola123@gmail.com")
                .direccion("Av. Rimac 123").build();
        clienteRepository.save(cliente);

        Cliente foundCliente = clienteRepository.findByEmail("hola123@gmail.com");
        Assertions.assertThat(foundCliente).isNotNull();
        Assertions.assertThat(foundCliente.getEmail()).isEqualTo("hola123@gmail.com");
    }
}
