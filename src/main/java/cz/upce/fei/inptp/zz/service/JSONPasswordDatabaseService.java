package cz.upce.fei.inptp.zz.service;

import cz.upce.fei.inptp.zz.entity.CryptoFile;
import cz.upce.fei.inptp.zz.entity.JSON;
import cz.upce.fei.inptp.zz.entity.Password;
import cz.upce.fei.inptp.zz.entity.PasswordDatabase;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.util.List;

public class JSONPasswordDatabaseService implements PasswordDatabaseService{

    @Override
    public PasswordDatabase openPasswordDatabase(String path, final String password) {
        String content = CryptoFile.readFile(new File(path), password);

        List<Password> passwordFromJSON = new JSON().fromJson(content);
        return new PasswordDatabase(path, password, passwordFromJSON);
    }

    @Override
    public PasswordDatabase createPasswordDatabase(final PasswordDatabase passwordDatabase) {
        throw new NotImplementedException();
    }

    @Override
    public PasswordDatabase openOrCreatePasswordDatabase(final PasswordDatabase passwordDatabase) {
        throw new NotImplementedException();
    }

    @Override
    public void savePasswordDatabase(PasswordDatabase passwordDatabase) {
        CryptoFile.writeFile(passwordDatabase);
    }
}
