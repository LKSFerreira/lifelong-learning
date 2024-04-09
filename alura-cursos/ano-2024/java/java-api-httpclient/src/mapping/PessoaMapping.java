package mapping;

import com.google.gson.annotations.SerializedName;

public record PessoaMapping(String nome, int idade, String email, String cidade, @SerializedName("UF") String uf) {

}
