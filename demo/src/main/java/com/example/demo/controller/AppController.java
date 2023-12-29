package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EstudianteEntity;
import com.example.demo.service.impl.PaqueteServiceImpl;

@RestController
@RequestMapping("/demo/v1")
public class AppController {

    @Autowired
    PaqueteServiceImpl paqueteServiceImpl;

    @GetMapping(value = "get_data")
    public ResponseEntity<Object> index() {

        try {
            List<EstudianteEntity> list = paqueteServiceImpl.get_data_student();
            if (!list.isEmpty()) {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }

        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
        }

        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "insert")
    public ResponseEntity<Object> insert_student(@RequestBody Map<String, String> param) {

        try {
            
            boolean flag = paqueteServiceImpl.insert_student(param.get("nombre"), param.get("carnet"));
            if (flag) {
                return new ResponseEntity<>("Success!", HttpStatus.OK);
            }

        } catch (Exception ex) {
            // TODO: handle exception
            return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
        }

        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

}
