package com.atlantis.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class Database {
    @Value("${db.mysql.username}")
    private String username;
    
    @Value("${db.mysql.password}")
    private String password;
    
    @Value("${db.mysql.path}")
    private String path;

    @Value("${db.mysql.timezone}")
    private String timezone;

    @Value("${db.mysql.schema}")
    private String nomeDb;

    private Connection connection;

    public Database(){}

    @PostConstruct
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(path + nomeDb + timezone, username, password);
        }
        catch(SQLException e){
            System.out.println("Errore connesione: " + e.getMessage());
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver non trovato");
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }
        catch(SQLException e){
            System.out.println("Errore chiusura connessione");
        }
    }

    public Connection getConnection(){
        return connection;
    }

 
}
