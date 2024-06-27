package uni.isw.springsgbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long clienteid;
    
    private String nombre;
    private String apellido;
    private String empresa;
    private String telefono;
    private String email;
    private String direccion;
}
