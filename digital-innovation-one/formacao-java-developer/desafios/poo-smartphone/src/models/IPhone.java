package models;

import interfaces.IBrowser;
import interfaces.IPlayerMusic;

public class IPhone extends Cellphone implements IPlayerMusic, IBrowser {

    public IPhone(String number) {
        super(number);
    }

    public void startVoiceMail() {
        System.out.println("Starting iPhone voice mail");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on iPhone press and hold the power button");
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off iPhone press and hold the power button");
        this.isOn = false;
    }

    @Override
    public void call(String number, Cellphone cellphone) {
        if (this.isOn) {
            System.out.println("Calling " + number + " on iPhone");
            if (!cellphone.isOn) {
                System.out.println("Leaving a voice mail to " + number);
                return;
            } else {
                cellphone.answer();
            }
        } else {
            System.out.println("Can't call " + number + " on iPhone because it is off");
        }
    }

    @Override
    public void answer() {
        if (isOn) {
            System.out.println("Answering iPhone");
        }
    }

    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void openBrowser() {
        System.out.println("Opening browser on iPhone...");
        System.out.println("www.github.com/LKSFerreira");
    }

    @Override
    public void newTab() {
        System.out.println("Opening new tab in browser on iPhone...");
        System.out.println("www.linkedin.com/in/lucas-ferreira-developer");
    }

    @Override
    public void refreshTab(Object tab) {
        System.out.println("Refreshing tab in browser on iPhone...");
        System.out.println(tab.toString() + " refreshed");

    }

    @Override
    public void playMusic() {
        System.out.println("Playing music on iPhone...");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Pausing music on iPhone...");
    }

    @Override
    public void selectMusic(String music) {
        System.out.println("Selecting music on iPhone...");
        System.out.println("Playing " + music + " on iPhone...");
    }

}
