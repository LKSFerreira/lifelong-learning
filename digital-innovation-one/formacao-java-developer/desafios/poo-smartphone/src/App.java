import models.Cellphone;
import models.IPhone;

public class App {
    public static void main(String[] args) throws Exception {
        Cellphone iPhoneLKS = new IPhone("+5517998765432");

        Cellphone iPhoneDIO = new IPhone("+5517991119222");

        iPhoneLKS.turnOn();
        iPhoneLKS.call(iPhoneDIO.getNumber(), iPhoneDIO);
        System.out.println();

        iPhoneDIO.turnOn();
        iPhoneLKS.call(iPhoneDIO.getNumber(), iPhoneDIO);
        System.out.println();

        ((IPhone) iPhoneLKS).playMusic();
        ((IPhone) iPhoneLKS).pauseMusic();
        ((IPhone) iPhoneLKS).selectMusic("Stairway to Heaven");
        System.out.println();

        ((IPhone) iPhoneLKS).openBrowser();
        ((IPhone) iPhoneLKS).newTab();
        ((IPhone) iPhoneLKS).refreshTab("www.linkedin.com/in/lucas-ferreira-developer");

    }
}
