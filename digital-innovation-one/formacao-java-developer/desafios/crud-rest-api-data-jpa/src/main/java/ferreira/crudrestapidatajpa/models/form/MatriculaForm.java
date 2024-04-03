package ferreira.crudrestapidatajpa.models.form;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

  @NotBlank(message = "O campo alunoId não pode ser vazio")
  @Positive(message = "O campo alunoId deve ser um número positivo")
  private UUID alunoId;

}
