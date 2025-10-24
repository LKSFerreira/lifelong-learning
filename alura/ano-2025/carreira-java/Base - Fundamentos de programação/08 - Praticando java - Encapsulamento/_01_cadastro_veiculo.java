class Veiculo {
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo(String modelo, String placa, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo [modelo=" + modelo + ", placa=" + placa + ", ano=" + ano + "]";
    }

}

public class _01_cadastro_veiculo {

    public static void main(String[] args) {

        Veiculo veiculo1 = new Veiculo("Toyota Corolla", "ABC-1234", 2020);
        Veiculo veiculo2 = new Veiculo("Honda Civic", "XYZ-5678", 2019);

        System.out.println(veiculo1);
        System.out.println(veiculo2);

    }

}