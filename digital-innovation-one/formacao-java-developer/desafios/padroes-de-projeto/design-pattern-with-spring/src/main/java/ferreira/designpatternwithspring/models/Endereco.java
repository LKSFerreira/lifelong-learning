package ferreira.designpatternwithspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco {

    @Id
    @Column(nullable = false, updatable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false, length = 100)
    private String complemento;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String localidade;

    @Column(nullable = false, length = 100)
    private String uf;

    @Column(nullable = false, length = 100)
    private Integer ibge;

    @Column(nullable = false, length = 100)
    private String gia;

    @Column(nullable = false, length = 100)
    private String ddd;

    @Column(nullable = false, length = 100)
    private String siafi;

}
