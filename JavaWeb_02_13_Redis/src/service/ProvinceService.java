package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    String findAllJson() throws JsonProcessingException;
}
