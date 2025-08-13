package com.vti.backend.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    // Sua thong so neu may cua ban khac
    private static final String URL  = "jdbc:mysql://127.0.0.1:3306/final_exam?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1111";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
