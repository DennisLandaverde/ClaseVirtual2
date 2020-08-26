/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author landa
 */
public class ConexionBD {
   
    private Connection conexion;
    
    public ConexionBD() 
    {
        try {

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Clase1", "root", "root");
            System.out.println("Conectando 1%...");
            System.out.println("Conectando 10%...");
            System.out.println("Conectando 25%...");
            System.out.println("Conectando 40%...");
            System.out.println("Conectando 50%...");
            System.out.println("Conectando 65%...");
            System.out.println("Conectando 85%...");
            System.out.println("Conectando 99%...");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Conectado");

        } catch (Exception e) {
            System.out.println("Error de Conexion" + e);
        }
    }
    
    public Connection RetornodeConexion()
    {
        return conexion;
        
    }
}
