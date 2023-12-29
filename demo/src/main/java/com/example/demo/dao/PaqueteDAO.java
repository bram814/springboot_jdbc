package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.EstudianteEntity;

public interface PaqueteDAO {
    
    public List<EstudianteEntity> get_data_student() throws Exception;

    public boolean insert_student(String nombre, String carnet) throws Exception;
}
