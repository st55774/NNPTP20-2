/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.service.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.upce.fei.inptp.zz.entity.Password;

import java.util.List;

/**
 * Service for creating JSON files.
 *
 * @author Roman
 *
 */
public class JSONFileService implements JSONService {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String toJson(List<Password> passwords) throws JsonProcessingException {
        return objectMapper.writeValueAsString(passwords);
    }
    
    @Override
    public List<Password> fromJson(String json) throws JsonProcessingException {
        return  objectMapper.readValue(json, new TypeReference<List<Password>>(){});
    }
}
