package cz.upce.fei.inptp.zz.service.password;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Dependency injector module for {@link PasswordDatabaseService} nad {@link JSONPasswordDatabaseService}
 *
 * @author Ondřej Chrbolka
 *
 * */
public class PasswordDatabaseServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PasswordDatabaseService.class).to(JSONPasswordDatabaseService.class).in(Singleton.class);
    }
}
