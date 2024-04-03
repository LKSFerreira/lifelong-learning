package subsistema2.cep;

public class CepApi {
    private static CepApi singletonCepApi = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstancia() {
        return singletonCepApi;
    }

    public String getCidade(String cep) {
        return "São José do Rio Preto";
    }

    public String getEstado(String cep) {
        return "São Paulo";
    }
}
