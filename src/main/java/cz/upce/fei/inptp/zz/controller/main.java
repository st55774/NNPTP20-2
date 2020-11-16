package cz.upce.fei.inptp.zz.controller;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import cz.upce.fei.inptp.zz.arguments.AddPasswordArguments;
import cz.upce.fei.inptp.zz.entity.PasswordDatabase;
import cz.upce.fei.inptp.zz.injector.InstanceInjector;
import cz.upce.fei.inptp.zz.entity.Password;
import cz.upce.fei.inptp.zz.service.password.PasswordDatabaseService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Enterprise password manager - in console
 * - uses strong industry-based encryption algorithm
 * - stores your passwords and relevent information
 * - allows you to simply manage all stored informations
 * 
 * 
 */
public class main {
    /**
     * Error code for bad input parameters
     * */
    private static final int BAD_ARGUMENTS = 1;

    public static void main(String[] args) {
        AddPasswordArguments arguments = new AddPasswordArguments();
        try{
            JCommander.newBuilder()
                    .addObject(arguments)
                    .build()
                    .parse(args);
        } catch (ParameterException ex){
            System.err.println(ex.getMessage());
            System.exit(BAD_ARGUMENTS);
        }

        List<Password> pwds = new ArrayList<>();
        for (int i = 0; i < arguments.getPasswords().size(); ++i){
            String textPassword = arguments.getPasswords().get(i).getPassword();
            pwds.add(new Password(i, textPassword));
        }

        PasswordDatabaseService databaseService = InstanceInjector.injector().getInstance(PasswordDatabaseService.class);
        databaseService.savePasswordDatabase(new PasswordDatabase(new File("test.txt"), "password", pwds));

        try {
            String read = databaseService.openPasswordDatabase(new File("test.txt"), "password").getPassword();
            System.out.println(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
   
}
