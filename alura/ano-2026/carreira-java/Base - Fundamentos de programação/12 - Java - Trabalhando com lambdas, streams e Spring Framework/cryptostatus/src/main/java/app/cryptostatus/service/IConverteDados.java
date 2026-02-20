package app.cryptostatus.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IConverteDados {
    <T> T converteJsonParaObjeto(String json, Class<T> dadosCrypto) throws JsonMappingException, JsonProcessingException;
}
