/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        PrintWriter out = response.getWriter();

        String opc = request.getParameter("Opc");

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("tel");
        String direcc = request.getParameter("dir");
        String email = request.getParameter("email");
        String pass = request.getParameter("psw");
        String tipoU = request.getParameter("Tipo"); 
        
        UsuarioDAO usu = new UsuarioDAO();
        //Opciones de funciones
        if (opc.equals("1")) {
          
            int retorna = usu.siExist(id, email);

            if (retorna == 1) {
                out.print("El usuario que trata de registrar ya existe");
            } else {
                usu.insertar(id, nombre, telefono, direcc, email, pass,Integer.parseInt(tipoU));
                out.print("Usuario registrado con exito");
            }
        } else if (opc.equals("2")) {
            
            out.print(usu.datosUsuario(id));
            
        } else if (opc.equals("3")) {
            usu.modificar(id, nombre, telefono, direcc, email,Integer.parseInt(tipoU));
        }else if(opc.equals("4")){
           
            //creamos arrayList y lo igualamos a el metodo porque retorna un arrayList
            
           ArrayList<TipoUsuario> listaT=usu.carga_tipoUsu();
           
            //enviamos el arrayList al JSP para recorrerlo
            request.getSession().setAttribute("listaT", listaT);
            
            request.getRequestDispatcher("admin/usuario/frmUsuario.jsp").forward(request, response); 
        }else if(opc.equals("5")){
        
            ArrayList<Usuario> datos = usu.listaUsuarios();
            
            request.getSession().setAttribute("listaUsuarios", datos);

            getServletContext().getRequestDispatcher("/admin/usuario/frmConsultar.jsp").forward(request,response);
                       
            
        }else if(opc.equals("6")){
            
            usu.eliminarUsu(id);
            
        }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
   
}
