package com.example.demo.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Utilities {



    public void setIntegerOrNull(PreparedStatement pstmt, int index, String value) throws SQLException{

        if(value != null || value.isEmpty()){
            pstmt.setNull(index, Types.INTEGER);
        } else {
            pstmt.setInt(index, Integer.parseInt(value));
        }

    }

    public void setVarcharOrNull(PreparedStatement pstmt, int index, String value) throws SQLException{

        if(value != null || value.trim().isEmpty()){
            pstmt.setNull(index, Types.INTEGER);
        } else {
            pstmt.setString(index, String.valueOf(value));
        }

    }
    
}
