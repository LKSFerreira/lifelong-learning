package models;

public class Carro {

    private String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        return (int) marca.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Carro other = (Carro) obj;
        return marca == null && other.marca != null ? false :
        marca == null && other.marca == null ? true :
        marca.equals(other.marca);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro [marca = " + marca + "]";
    }

    

}
