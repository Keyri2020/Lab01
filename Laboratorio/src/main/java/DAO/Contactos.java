/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Contacto;
import com.cris.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MINEDUCYT
 */
public class Contactos {
    ConexionAMYSQL con = new ConexionAMYSQL();
       
    Connection conexion = con.getConnection();
    public ArrayList <Contacto> listadoContactos(){
        ArrayList<Contacto> list = null;
        try {
            list = new ArrayList<Contacto>();
            CallableStatement cb = conexion.prepareCall("select * from contactos");
            ResultSet resultado = cb.executeQuery();
            
            while (resultado.next()){
                Contacto contact = new Contacto();
                //llamar a el objeto de entidades
                contact.setIdContactos(resultado.getInt("Id"));
                contact.setNombre(resultado.getString("Nombre"));
                contact.setEdad(resultado.getInt("Edad"));
                contact.setEmail(resultado.getString("Email"));
                contact.setNumerodeTelefono(resultado.getString("Telefono"));
                list.add(contact);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        
        return list;
    }
    
    public void SaveContacts(Contacto contact){
        try {
            CallableStatement cb = conexion.prepareCall("insert into " + "contactos (Nombre,Edad,Email,NumeroDeTelefono)"
                + "values ('"+contact.getNombre()+"','"+contact.getEdad()+"','"+contact.getEmail()+"','"+contact.getNumerodeTelefono()+"')");
            cb.execute();
            JOptionPane.showMessageDialog(null, "Contacto agregado");
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error " +ex.toString());
        }
      
        
    }
    
    public void UpContacto(Contacto contact){
        try {
                CallableStatement cb = conexion.prepareCall("UPDATE contactos SET Nombre='"+contact.getNombre()+"', Edad='"+contact.getEdad()+"',Email='"+contact.getEmail()+"',NumeroDeTelefono='"+contact.getNumerodeTelefono()+"'  WHERE ID='"+contact.getIdContactos()+"'");
                cb.execute();
               
                JOptionPane.showMessageDialog(null,"Contacto actualizado","Mensaje sistems",1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error" + ex.toString(),"Mensaje sistems", 1);
            }
    }
    
    
    
    public void DeleteContact(Contacto contact)
    {
          try {
                CallableStatement cb_s = conexion.prepareCall("DELETE from contactos Where ID ='"+contact.getIdContactos()+"' ");
                cb_s.execute();
               
                JOptionPane.showMessageDialog(null,"Contacto Eliminado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error" + ex.toString());
            }
    }
    
    
    
    
}
