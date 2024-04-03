package ferreira.crudrestapidatajpa.models.form;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @NotNull(message = "O campo alunoId não pode ser nulo")
  @NotBlank(message = "O campo alunoId não pode ser em branco")
  @org.hibernate.validator.constraints.UUID(message = "'{validatedValue}' não é um UUID válido")
  private UUID alunoId;

  @NotNull(message = "O campo peso não pode ser nulo")
  private double peso;

  @NotNull(message = "O campo altura não pode ser nulo")
  private double altura;

}
