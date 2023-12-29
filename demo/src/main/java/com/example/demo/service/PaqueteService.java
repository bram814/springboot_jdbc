package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EstudianteEntity;

public interface PaqueteService {
    

    public List<EstudianteEntity> get_data_student() throws Exception;

    public boolean insert_student(String nombre, String carnet) throws Exception;

}
