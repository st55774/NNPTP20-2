package cz.upce.fei.inptp.zz.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.upce.fei.inptp.zz.service.crypto.CryptoFileServiceModule;
import cz.upce.fei.inptp.zz.service.json.JSONFileServiceModule;
import cz.upce.fei.inptp.zz.service.password.PasswordDatabaseServiceModule;

/**
 * It provides the dependency injector for project.
 *
 * @author Ondřej Chrbolka
 *
 * */
public final class InstanceInjector {
    /**
     * To save dependency single instance
     * */
    private static Injector injector;

    private InstanceInjector(){
    }

    /**
     * It will return the single instance of dependency injector.
     *
     * @return dependency injector.
     * */
    public static Injector injector(){
        if(injector == null){
            injector = Guice.createInjector(
                    new PasswordDatabaseServiceModule(),
                    new JSONFileServiceModule(),
                    new CryptoFileServiceModule()
            );
        }

        return injector;
    }
}
