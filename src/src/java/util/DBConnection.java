/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;

/**
 *
 * @author TALHA
 */
public abstract class DBConnection {

    public Connection c;

    public Connection connect() {
        if (this.c == null) {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/news",
                                "postgres", "12345");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return c;
        }
        
        return c;
    }
    
}
