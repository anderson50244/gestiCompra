<%-- 
    Document   : frmConsultar
    Created on : 04-ago-2016, 21:55:45
    Author     : Anderson
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
        <script src="css/bootstrap/js/jquery.js"></script>
         <script src="js/jsMenu.js"></script>
    </head>
    <body>
        
        <table class="table table-striped">
		<thead>
                <th>Identificac&oacute;n</th>
		<th>Nombre</th>
		<th>Telefono</th>
                <th>Direcci&oacute;n</th>
		<th>Correo electronico</th>
                <th>Tipo de usuario</th>
		</thead>
                <tbody id="datos">
                    <% ArrayList<Usuario> listasUsuarios =(ArrayList<Usuario>) session.getAttribute("listaUsuarios");
                            
                           if(listasUsuarios==null){
                           
                               listasUsuarios=new ArrayList<Usuario>();
                               
                           }
                            
                           for(Usuario u : listasUsuarios){
                           
                    %>
                            <tr>
                                <td><div id="idel" ><%=u.getId() %></div></td>
                                <td><%=u.getNombre()%></td>
                                <td><%=u.getTelefono()%></td>
                                <td><%=u.getDireccion()%></td>
                                <td><%=u.getEmail()%></td>
                                <td><%=u.getTipoUsu() %></td>
                                <td><%=u.getDescripcion()%></td>
                                <td><input type="button"  name="<%=u.getId()%>" id="<%=u.getId()%>" class="btn btn-danger del" value="Eliminar"></td>
                            </tr>    
                    <%           
                           } 
                    
                    %>
		</tbody>

	</table>
    </body>
</html>
