/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MINEDUCYT
 */
public class Contacto {
    
    
    int idContactos;
    String Nombre;
    int Edad;
    String Email;

    public int getIdContactos() {
        return idContactos;
    }

    public void setIdContactos(int idContactos) {
        this.idContactos = idContactos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNumerodeTelefono() {
        return NumerodeTelefono;
    }

    public void setNumerodeTelefono(String NumerodeTelefono) {
        this.NumerodeTelefono = NumerodeTelefono;
    }
    String NumerodeTelefono;


   
}
