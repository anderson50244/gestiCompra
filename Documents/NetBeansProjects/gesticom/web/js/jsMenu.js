$(document).ready(function () {


    $("#txtidmod").blur(function () {

        var idUsu = $("#txtidmod").val();
        var concatValor = '';
       
        $.get('UsuarioServlet?Opc=2', {id: idUsu}, function (data) {
           
            datos = data.split(",");
            if (datos != "") {

                $("#txtnombre").val(datos[0]);
                $("#txttel").val(datos[1]);
                $("#txtdir").val(datos[2]);
                $("#txtemail").val(datos[3]);
                $("#tipo").append("<option value="+datos[5]+" selected='selected'>"+datos[4]+"</option>");

                    var valorActual=($("#tipo").val())
                    
                    $("#tipo option").each(function(){
                       
                        if(valorActual==$(this).val()){
                            
                        $("#tipo option[value='"+$(this).val()+"']").remove()
                         $("#tipo").append("<option value="+datos[5]+" selected='selected'>"+datos[4]+"</option>");  
                        }
                       
                    })
                $(".confirm").html("<div></div>");
            } else {

                $(".confirm").html("<div class='alert alert-danger'>No existen datos del usuario<button type='button' class='close' data-dismiss='alert'>&times;</button></div>");
                $('#txtnombre').val("");
                $('#txttel').val("");
                $("#txtdir").val("");
                $("#txtemail").val("");
                $("#txtpsw").val("");
                $("#tipo").val("");
            }


        });
        
        

    });
    
    

    $('#btnEnviar').click(function () {
        
        var idUsu = $('#txtid').val();
        var nombreUsu = $('#txtnombre').val();
        var telUsu = $('#txttel').val();
        var dirUsu = $("#txtdir").val();
        var emailUsu = $("#txtemail").val();
        var pswUsu = $("#txtpsw").val();
        var tipoUsu=$("#tipo").val();
        

        if (idUsu != "" && nombreUsu != "" && emailUsu != "" && pswUsu != "" && tipoUsu !="") {

            $.get('UsuarioServlet?Opc=1', {id: idUsu, nombre: nombreUsu, tel: telUsu, dir: dirUsu, email: emailUsu, psw: pswUsu,Tipo:tipoUsu}, function (data) {

                $('#txtid').val("");
                $('#txtnombre').val("");
                $('#txttel').val("");
                $("#txtdir").val("");
                $("#txtemail").val("");
                $("#txtpsw").val("");
                $("#tipo").val("");

                $(".confirm").html("<div class='alert alert-success'>" + data + "<button type='button' class='close' data-dismiss='alert'>&times;</button></div>");

            });


        } else {

            $(".confirm").html("<div class='alert alert-info'>Sus datos estan incompletos!<button type='button' class='close' data-dismiss='alert'>&times;</button></div>");
        }



    });



    $("#btnMod").click(function () {

        var idUsu = $("#txtidmod").val();
        var nombre = $("#txtnombre").val();
        var tel = $("#txttel").val();
        var direccion = $("#txtdir").val();
        var email = $("#txtemail").val();
        var tipo =$("#tipo").val();

        $.get('UsuarioServlet?Opc=3', {id: idUsu, nombre: nombre, tel: tel, dir: direccion, email: email,Tipo:tipo}, function (data) {

            $('#txtid').val(idUsu);
            $('#txtid').focus();


            $(".confirm").html("<div class='alert alert-success'>Usuario actualizado con exito<button type='button' class='close' data-dismiss='alert'>&times;</button></div>");

        })

    })
    ///FUNCION PARA PASAR PARAMETROS DEL SERVLET OPCION 4 A LA LISTA JSP DE LOS TIPOS DE USUARIOS
    $.ajax({
        type: "POST",
        url: "UsuarioServlet?Opc=4",
        success: function (data)
        {
          
        }
    });
    
    //FUNCION PARA ELIMINAR EL USUARIO
    $(".del").click(function(){
       id=$(this).attr('id');
       opc=6;
       $.ajax({
            data:{'id':id,'Opc':opc},
            url:'UsuarioServlet',
            type:'GET',
            success:function(data){
                
               setTimeout($("#contenedorUsu").load("UsuarioServlet?Opc=5")
               ,5000);
            }
       });
       $.get('UsuarioServlet?Opc=6',{id:id},function(data){
           
            $(".confirm").html("<div class='alert alert-success'>Usuario eliminado con exito<button type='button' class='close' data-dismiss='alert'>&times;</button></div>");
       })
        
    });
    
    

})

/*FUNCION PARA CARGAR LOS ENLACES EN LA MOSMA PAGINA*/
function mostrarContenido(page) {
    var pagina = page;

    $.post(pagina + ".jsp", {variable: pagina}, function (data) {

        $("#contenedor").html(data);
    });
}

function mostrarContenidoUser(page) {
    var pagina = page;
    
    $.post(pagina + ".jsp", {variable: pagina}, function (data) {
        
        $("#contenedorUsu").html(data);
    });
}
function actualizarDatos() {

    $('#txtid').blur();

}

function mostrarContenidoServlet(page){
    
    var servlet = page;
    $.post(servlet,{variable:servlet},function(data){
        
        $("#contenedorUsu").html(data);
        
    });
    
}
