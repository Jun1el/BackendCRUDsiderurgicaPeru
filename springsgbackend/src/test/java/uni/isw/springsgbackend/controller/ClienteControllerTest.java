
package uni.isw.springsgbackend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uni.isw.springsgbackend.model.Cliente;
import uni.isw.springsgbackend.service.ClienteService;


@WebMvcTest(controllers=ClienteController.class)
@AutoConfigureMockMvc(addFilters=false)
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClienteService clienteService;
    @Autowired
    private ObjectMapper objectMapper;
    private Cliente cliente1,cliente2;
    @BeforeEach
    public void init(){
        cliente1=Cliente.builder()
                .apellido("Reeves")              
                .nombre("David")
                .empresa("Uni")
                .telefono("987423242")
                .email("hola123@gmail.com")
                .direccion("Av. Rimac 123").build();
        cliente2=Cliente.builder()
                .apellido("Escobar")              
                .nombre("Alejandro")
                .empresa("Bembos")
                .telefono("984325242")
                .email("hola456@gmail.com")
                .direccion("Av. Independecnia 678").build();      
    }
    /*
    @Test
        public void  ClienteController_Insert() throws Exception {                
        /*given(clienteService.saveOrUpdateCliente(any(Cliente.class))).willReturn(cliente1);
        ResultActions response = mockMvc.perform(post("/api/v1/cliente/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente1)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombres", CoreMatchers.is(cliente2.getNombre())));
             
        ResponseEntity<Cliente> mockResponseEntity = ResponseEntity.ok(cliente1);
    given(clienteService.saveOrUpdateCliente(any(Cliente.class))).willReturn(mockResponseEntity);
    ResultActions response = mockMvc.perform(post("/api/v1/cliente/insert")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(cliente1)));

    response.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", CoreMatchers.is(cliente1.getNombre()))); // Corrected assertion
    }
    */
}
