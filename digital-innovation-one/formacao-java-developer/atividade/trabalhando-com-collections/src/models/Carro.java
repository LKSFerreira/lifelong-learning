package models;

public class Carro {
    private String modelo;
    private Double consumoKML;

    public Carro(String modelo, Double consumoKML) {
        this.modelo = modelo;
        this.consumoKML = consumoKML;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getConsumoKML() {
        return consumoKML;
    }

    public void setConsumoKML(Double consumoKML) {
        this.consumoKML = consumoKML;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((consumoKML == null) ? 0 : consumoKML.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro other = (Carro) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (consumoKML == null) {
            if (other.consumoKML != null)
                return false;
        } else if (!consumoKML.equals(other.consumoKML))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carro [ modelo = " + modelo + ", consumo = " + consumoKML +"KM/L ]";
    }

    
}
