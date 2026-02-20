package app.cryptostatus.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCrypto(
    @JsonAlias("id") String id,
    @JsonAlias("name") String nome,
    @JsonAlias("symbol") String simbolo,
    @JsonAlias("current_price") double preco
){}