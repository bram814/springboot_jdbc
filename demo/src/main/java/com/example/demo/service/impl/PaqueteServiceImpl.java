package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.impl.PaqueteDAOImpl;
import com.example.demo.model.EstudianteEntity;
import com.example.demo.service.PaqueteService;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private PaqueteDAOImpl paqueteDAOImpl;

    @Override
    public List<EstudianteEntity> get_data_student() throws Exception {
        return paqueteDAOImpl.get_data_student();
    }

    @Override
    public boolean insert_student(String nombre, String carnet) throws Exception {
        return paqueteDAOImpl.insert_student(nombre, carnet);
    }
    
    
    
}
