package pe.edu.cibertec.ProyectoAPI.model.bd;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String editorial;
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    private String genero;
    private BigDecimal precio;
    private Integer cantidadStock;
}
