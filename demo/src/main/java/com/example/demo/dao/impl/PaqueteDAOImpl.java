package com.example.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.PaqueteDAO;
import com.example.demo.model.EstudianteEntity;
import com.example.demo.util.Utilities;

@Repository
public class PaqueteDAOImpl extends JdbcDaoSupport implements PaqueteDAO {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @PostConstruct
    public void prueba() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        setDataSource(dataSource);
        System.out.println("DataSource Successfully!");
    }

    @Override
    public List<EstudianteEntity> get_data_student() throws Exception {

        String sql = "SELECT * FROM `db-example`.Estudiante";
        return getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(EstudianteEntity.class), new Object[] {});
    }

    @Override
    public boolean insert_student(String nombre, String carnet) throws Exception {

        try {
            String sql = "INSERT INTO `db-example`.Estudiante(nombre, carnet) values(?, ?)";

            getJdbcTemplate().update(sql, new Object[]{nombre, carnet});
            
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Se genero la expceion, motivo: " + e.getMessage());
        }

    }

}
