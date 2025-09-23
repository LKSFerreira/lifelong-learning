package praticando;

public class ConversorTemperaturaPadrao implements IConversorTemperatura{

    private double grauCelsius;
    private double grauFahrenheit;

    @Override
    public double celsiusParaFahrenheit() {
        return (grauFahrenheit - 32) / 1.8;
    }

    @Override
    public double fahrenheitParaCelsius() {
        return grauCelsius * 1.8 + 32;
    }
    
}
