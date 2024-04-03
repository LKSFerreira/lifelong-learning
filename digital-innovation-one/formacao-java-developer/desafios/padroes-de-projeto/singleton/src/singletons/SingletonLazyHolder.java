package singletons;

/**
 * SingletonLazyHolder "Performatico" com tread-safe
 * 
 * @author Lucas Ferreira
 */

public class SingletonLazyHolder{

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }
}

