package cz.upce.fei.inptp.zz.service.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.upce.fei.inptp.zz.entity.Password;

import java.util.List;

/**
 * Service for creating and reading JSON files.
 *
 * */
public interface JSONService {
    /**
     * Create JSON format from passwords.
     *
     * @param passwords Passwords which will be convert to JSON.
     *
     * @return JSON formatted passwords.
     *
     * */
    String toJson(List<Password> passwords) throws JsonProcessingException;

    /**
     * Convert passwords from JSON format.
     *
     * @param json JSON formatted passwords.
     *
     * @return passwords from JSON.
     *
     * */
    List<Password> fromJson(String json) throws JsonProcessingException;
}
