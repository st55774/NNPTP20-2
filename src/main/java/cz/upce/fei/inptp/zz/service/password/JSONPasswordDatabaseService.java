package cz.upce.fei.inptp.zz.service.password;

import com.google.inject.Inject;
import cz.upce.fei.inptp.zz.entity.Password;
import cz.upce.fei.inptp.zz.entity.PasswordDatabase;
import cz.upce.fei.inptp.zz.service.crypto.CryptoService;
import cz.upce.fei.inptp.zz.service.json.JSONFileService;

import java.io.File;
import java.util.List;

/**
 * Service for creating and reading password files using JSON.
 *
 * @author Ondřej Chrbolka
 *
 * */
public class JSONPasswordDatabaseService implements PasswordDatabaseService {

    private CryptoService cryptoService;

    @Inject
    public JSONPasswordDatabaseService(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @Override
    public PasswordDatabase openPasswordDatabase(String path, final String password) {
        String content = cryptoService.readFile(new File(path), password);

        List<Password> passwordFromJSON = new JSONFileService().fromJson(content);
        return new PasswordDatabase(path, password, passwordFromJSON);
    }

    @Override
    public void savePasswordDatabase(PasswordDatabase passwordDatabase) {
        cryptoService.writeFile(passwordDatabase);
    }
}
