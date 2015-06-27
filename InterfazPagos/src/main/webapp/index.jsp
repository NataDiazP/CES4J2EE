<%-- 
    Document   : index
    Created on : 20/03/2015, 11:02:20 AM
    Author     : natad_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagos Despegar</title>
        <link href="./css/main.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript">
            //Ajusta el tamaño de un iframe al de su contenido interior para evitar scroll
            function autofitIframe(id) {
                if (!window.opera && document.all && document.getElementById) {
                    id.style.height = id.contentWindow.document.body.scrollHeight;
                } else if (document.getElementById) {
                    id.style.height = id.contentDocument.body.scrollHeight + "px";
                }
            }

            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
        </script>
    </head>
    <body>
        <div>
            <img style="position: absolute; margin-top: 350px; margin-left: 350px; z-index: -1;" src="images/logo_despegar.png" border="0" width=700px;" >
        </div>
        <div>
            <img style="position: absolute; margin-top: -10px; margin-left: 1150px" src="images/pagos.png" border="0" width=140px;" >
        </div>
        <div>
            <img style="position: absolute; margin-top: -10px; margin-left: 30px" src="images/avion.png" border="0" width=190px;" >
        </div>
        <div style="margin-top: 40px;" id="contenedor">
            <div class="header">
                <h1><em>Bienvenido a la plataforma de pagos <br> de Despegar.com</em></h1>
            </div>
        </div>
        <div class="arrowlistmenu">
            <h3 class="menuheader">
                <a href="index.jsp" target="_self">Inicio</a>
            </h3>
            <h3 class="menuheader">
                <a href="tarjeta.jsp" target="_self">Tarjeta</a>
            </h3>
            <h3 class="menuheader">
                <a href="transaccion.jsp" target="_self">Transacci&oacute;n</a>
            </h3>
            <h3 class="menuheader Noexpandable">
                <a href="registroTransaccion.jsp" target="_self">Registro Transacci&oacute;n</a>
            </h3>
        </div>

    </body>
</html>
