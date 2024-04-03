package models;

public abstract class Cellphone {

    private String number;   
    protected boolean isOn = false;

    public Cellphone(String number) {
        this.number = number;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void call(String number, Cellphone cellphone);
    
    public abstract void answer();

    public boolean isOn() {
        return isOn;
    }

    public String getNumber() {
        return number;
    }

}

