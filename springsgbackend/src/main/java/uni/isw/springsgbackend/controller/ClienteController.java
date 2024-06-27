package uni.isw.springsgbackend.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uni.isw.springsgbackend.model.Cliente;
import uni.isw.springsgbackend.service.ClienteService;

@RestController
@RequestMapping(path="api/v1/cliente")
public class ClienteController {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    ClienteService clienteService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getClientes(){
        List<Cliente> listaClientes=null;
        try{
            listaClientes=clienteService.getClientes();
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaClientes,HttpStatus.OK);
    }
    @RequestMapping(value="/search", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> searchCliente(@RequestBody Optional<Cliente> cliente){
        try{
            cliente=clienteService.getCliente(cliente.get().getClienteid());
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cliente.get(),HttpStatus.OK);
    }
    @RequestMapping(value="/insert", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
        try{
            clienteService.saveOrUpdateCliente(cliente);
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
        try{
            clienteService.saveOrUpdateCliente(cliente);
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> deleteCliente(@RequestBody Optional<Cliente> cliente){
        try{
            cliente=clienteService.getCliente(cliente.get().getClienteid());
            if(cliente.isPresent())
                clienteService.deleteCliente(cliente.get().getClienteid());
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cliente.get(),HttpStatus.OK);
    }   
    @RequestMapping(value="/buscarPorNombre", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Cliente>> buscarPorNombre(@RequestParam String nombre){
    List<Cliente> clientesEncontrados;
    try{
        clientesEncontrados = clienteService.buscarPorNombre(nombre);
    }catch(Exception e){
        logger.error("Error inesperado", e);
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(clientesEncontrados, HttpStatus.OK);
}
}
