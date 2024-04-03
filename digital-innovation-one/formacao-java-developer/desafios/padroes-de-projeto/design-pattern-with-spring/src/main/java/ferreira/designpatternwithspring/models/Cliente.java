package ferreira.designpatternwithspring.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false, updatable = false, length = 36)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne
    private Endereco endereco;

    @Column(nullable = false, length = 10)
    private String numeroDoEndereco;

    @Column(nullable = false, length = 100)
    private String complementoDoEndereco;
}
