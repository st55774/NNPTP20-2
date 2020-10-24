package cz.upce.fei.inptp.zz.service.password;

import cz.upce.fei.inptp.zz.entity.PasswordDatabase;

import java.io.FileNotFoundException;

/**
 * Service for managing password files.
 *
 * @author Ondřej Chrbolka
 *
 * */
public interface PasswordDatabaseService {
    /**
     * It will open and read encrypted password file.
     *
     * @param path File path to password file.
     * @param password password to decrypt file.
     *
     * @return passwords database with information about file origin.
     * */
    PasswordDatabase openPasswordDatabase(final String path, final String password) throws FileNotFoundException;

    /**
     * It will save password to encrypted file.
     *
     * @param passwordDatabase instance of saved passwords.
     * */
    void savePasswordDatabase(final PasswordDatabase passwordDatabase);
}
