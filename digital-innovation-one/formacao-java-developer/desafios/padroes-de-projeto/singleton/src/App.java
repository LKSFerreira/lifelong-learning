import singletons.SingletonEager;
import singletons.SingletonLazy;
import singletons.SingletonLazyHolder;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        SingletonLazy singletonLazy = SingletonLazy.getInstancia();
        System.out.println(singletonLazy);
        SingletonLazy outraSingletonLazy = SingletonLazy.getInstancia();
        System.out.println(outraSingletonLazy);

        if (singletonLazy == outraSingletonLazy && singletonLazy.equals(outraSingletonLazy)) {
            System.out.println("Mesma instância do SingletonLazy");
        } else {
            System.out.println("Instâncias diferentes do SingletonLazy");
        }

        System.out.println("========================================");

        SingletonEager singletonEager = SingletonEager.getInstancia();
        System.out.println(singletonEager);
        SingletonEager outraSingletonEager = SingletonEager.getInstancia();
        System.out.println(outraSingletonEager);

        if (singletonEager == outraSingletonEager && singletonEager.equals(outraSingletonEager)) {
            System.out.println("Mesma instância do SingletonEager");
        } else {
            System.out.println("Instâncias diferentes do SingletonEager");
        }

        System.out.println("========================================");

        SingletonLazyHolder singletonLazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(singletonLazyHolder);
        SingletonLazyHolder outraSingletonLazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(outraSingletonLazyHolder);

        if (singletonLazyHolder == outraSingletonLazyHolder && singletonLazyHolder.equals(outraSingletonLazyHolder)) {
            System.out.println("Mesma instância do SingletonLazyHolder");
        } else {
            System.out.println("Instâncias diferentes do SingletonLazyHolder");
        }

    }
}
