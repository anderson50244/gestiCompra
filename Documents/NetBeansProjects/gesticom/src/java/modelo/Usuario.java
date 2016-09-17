/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.TipoUsuario;
/**
 *
 * @author Anderson
 */
public class Usuario extends TipoUsuario{
    
    private String id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String contrasena;
    private int tipoUsu;
    
    
    public Usuario(){
    
    }
    
    public Usuario(String id,String nombre,String telefono,String direccion,String email,String contrasena,int tipoUsu){
    
        this.id=id;
        this.nombre=nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email=email;
        this.contrasena = contrasena;
        this.tipoUsu = tipoUsu;
    }

    public int getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(int tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

   

   
    
    public String getId(){
    
        return id;
    }
    
    public void setId(String id){
    
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
