/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cris.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MINEDUCYT
 */
public class ConexionAMYSQL {
    
     
    private static Connection ConnectionBD = null;
    public Connection getConnection (){
    
  
    
    
        try {
            String url ="jdbc:mysql://localhost:3306/laboratorio";
            String user="root";
            String password="root";
            
            ConnectionBD=DriverManager.getConnection(url,user,password);
            System.out.println("conexion exitosa");
            
            
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        
        }
    
    
       return ConnectionBD;
    }
    
    
    
    
}
