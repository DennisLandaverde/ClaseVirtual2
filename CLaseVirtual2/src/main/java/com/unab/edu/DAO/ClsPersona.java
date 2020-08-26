/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Persona;
import com.unab.edu.conexion.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author landa
 */
public class ClsPersona {
        ConexionBD conectar = new ConexionBD();
        Connection con = conectar.RetornodeConexion();
    
    public ArrayList <Persona> MostrarPersona()
    {
        ArrayList <Persona> Personas = new ArrayList<>();
        try {
            CallableStatement Statement = con.prepareCall("call SP_S_Persona()");
            ResultSet ResultadoDeConsulta = Statement.executeQuery();
            while (ResultadoDeConsulta.next()) {                
                Persona persona = new Persona();
                persona.setIdPersona(ResultadoDeConsulta.getInt("idPersona"));
                persona.setNombre(ResultadoDeConsulta.getString("Nombre"));
                persona.setApellido(ResultadoDeConsulta.getString("Apellido"));
                persona.setEdad(ResultadoDeConsulta.getInt("Edad"));
                persona.setSexo(ResultadoDeConsulta.getString("Sexo"));
                
                Personas.add(persona);
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        }
        return Personas;  
    }
    
    public void AgregarPersonas(Persona pers)
    {
        try {
            CallableStatement Statement = con.prepareCall("call SP_I_Persona(?,?,?,?)");
            Statement.setString("PNombre", pers.getNombre());
            Statement.setString("PApellido", pers.getApellido());
            Statement.setInt("PEdad", pers.getEdad());
            Statement.setString("PSexo", pers.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Agregado Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorarPersona(Persona pers)
    {
        try {

            CallableStatement Statement = con.prepareCall("call SP_D_Persona(?)");
            Statement.setInt("PIdPersonas", pers.getIdPersona());
            Statement.execute();

            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarPersona(Persona pers)
    {
        try {
            CallableStatement Statement = con.prepareCall("call SP_U_Persona(?,?,?,?,?)");
            Statement.setInt("PIdPersona", pers.getIdPersona());
            Statement.setString("PNombre", pers.getNombre());
            Statement.setString("PApellido", pers.getApellido());
            Statement.setInt("PEdad", pers.getEdad());
            Statement.setString("PSexo", pers.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
