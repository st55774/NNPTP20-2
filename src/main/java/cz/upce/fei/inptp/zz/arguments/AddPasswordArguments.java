package cz.upce.fei.inptp.zz.arguments;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;
import cz.upce.fei.inptp.zz.converter.DateTimeParameterConverter;
import cz.upce.fei.inptp.zz.converter.PasswordParameterConverter;
import cz.upce.fei.inptp.zz.converter.TextParameterConverter;

/**
 * Parameter arguments for encrypt password to database.
 *
 * */
public class AddPasswordArguments {
    @Parameter(names = {"-title", "-t"}, required = true, converter = TextParameterConverter.class,
            description = "Title for the new password")
    private cz.upce.fei.inptp.zz.entity.Parameter.TextParameter title;

    @Parameter(names = {"-website", "-w"}, converter = TextParameterConverter.class,
            description = "Original website")
    private cz.upce.fei.inptp.zz.entity.Parameter.TextParameter website;

    @Parameter(names = {"-expiration", "-e"}, required = true, converter = DateTimeParameterConverter.class,
            description = "Expiration date of passwords")
    private cz.upce.fei.inptp.zz.entity.Parameter.DateTimeParameter expirationDateTime;

    @Parameter(names = {"-description", "-d"}, converter = TextParameterConverter.class,
            description = "Additional description")
    private cz.upce.fei.inptp.zz.entity.Parameter.TextParameter description;

    @Parameter(names = {"-database", "-file", "-f"}, required = true, converter = FileConverter.class,
            description = "Database file with encrypted passwords")
    private File passwordDatabase;

    @Parameter(names = {"-password", "-passwords", "-p"}, required = true, converter = PasswordParameterConverter.class,
            description = "Passwords to add to database")
    private List<cz.upce.fei.inptp.zz.entity.Parameter.PasswordParameter> passwords = new ArrayList<>();

    @Parameter(names = {"-master", "-m", "-mp"}, required = true, password = true, echoInput = true,
            converter = PasswordParameterConverter.class,
            description = "Master password to encrypt the file")
    private cz.upce.fei.inptp.zz.entity.Parameter.PasswordParameter masterPassword;

    public cz.upce.fei.inptp.zz.entity.Parameter.TextParameter getTitle() {
        return title;
    }

    public cz.upce.fei.inptp.zz.entity.Parameter.TextParameter getWebsite() {
        return website;
    }

    public cz.upce.fei.inptp.zz.entity.Parameter.DateTimeParameter getExpirationDateTime() {
        return expirationDateTime;
    }

    public cz.upce.fei.inptp.zz.entity.Parameter.TextParameter getDescription() {
        return description;
    }

    public File getPasswordDatabase() {
        return passwordDatabase;
    }

    public List<cz.upce.fei.inptp.zz.entity.Parameter.PasswordParameter> getPasswords() {
        return passwords;
    }

    public cz.upce.fei.inptp.zz.entity.Parameter.PasswordParameter getMasterPassword() {
        return masterPassword;
    }
}
