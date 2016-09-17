<%-- 
    Document   : frmUsuario
    Created on : 30/03/2016, 11:04:44 PM
    Author     : Anderson
--%>

<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.TipoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>AJAX JSP Servelts</title>
        <script src="css/bootstrap/js/jquery.js"></script>
        <script src="js/jsMenu.js"></script>
        <script>
            $(document).ready(function () {

            });
        </script>



    </head>
    <body>
        <p>
        <div class="container">
            
            <div class="row-fluid">
                <div class="span2"></div>
                <div class="span8">
                    <form role="form">

                        <div class="form-group">
                            <span class="label label-danger">*</span><label for="id">Identificacion</label>
                            <input type="text" class="form-control" id="txtid" name="txtid" required="required"/>
                        </div>
                        <div class="form-group">
                            <span class="label label-danger">*</span><label for="pwd">Nombre</label>
                            <input type="text" class="form-control" id="txtnombre" name="txtnombre" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Telefono</label>
                            <input type="text" class="form-control" id="txttel" name="txttel" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Direcci&oacute;n</label>
                            <input type="text" class="form-control" id="txtdir" name="txtdir" required="required">
                        </div>
                        <div class="form-group">
                            <span class="label label-danger">*</span><label for="pwd">Correo electronico</label>
                            <input type="email" class="form-control" id="txtemail" name="txtemail" required="required">
                        </div>
                        <div class="form-group">
                            <span class="label label-danger">*</span><label for="pwd">Contrase&ntilde;a</label>
                            <input type="password" class="form-control" id="txtpsw" name="txtpsw" required="required">
                        </div>
                        <div class="form-group">
                            <span class="label label-danger">*</span><label for="pwd">Tipo de usuario</label>
                            <select id="tipo" name="tipo" class="form-control">
                                <option value="">Seleccione..</option>
                                <% ArrayList<TipoUsuario> ListaT = (ArrayList<TipoUsuario>) request.getSession().getAttribute("listaT");
                                    if (ListaT == null) {
                                        ListaT = new ArrayList<TipoUsuario>();
                                    }
                                    for (TipoUsuario t : ListaT) {
                                %>          
                                <option value="<%=t.getIdT()%>"><%=t.getDescripcion()%></option>
                                <%
                                    }
                                %> 

                            </select>
                        </div>

                    </form>

                </div>

                <input type='button' value="Guardar" class='btn btn-default' id="btnEnviar" name='btnEnviar' />
            </div>

        </div>

    </body>
</html>
