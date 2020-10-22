package cz.upce.fei.inptp.zz.service;

import cz.upce.fei.inptp.zz.entity.PasswordDatabase;

import java.io.FileNotFoundException;

public interface PasswordDatabaseService {
    PasswordDatabase openPasswordDatabase(final String path, final String password) throws FileNotFoundException;
    PasswordDatabase createPasswordDatabase(final PasswordDatabase passwordDatabase);
    PasswordDatabase openOrCreatePasswordDatabase(final PasswordDatabase passwordDatabase);
    void savePasswordDatabase(final PasswordDatabase passwordDatabase);
}
