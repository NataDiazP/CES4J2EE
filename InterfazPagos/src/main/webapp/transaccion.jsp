<%-- 
    Document   : empresa
    Created on : 20/03/2015, 09:31:09 PM
    Author     : natad_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transacción</title>
        <link href="./css/partials.css" rel="stylesheet" type="text/css" />
        <link href="./css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body style="margin-top: 0;">
        <div>  <!--ESTILO DE FONDO-->   
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

        </div>
        <div class="fuente_formularios" style="margin-left: 450px; margin-top: 55px;">

            <table border="0" width="400" cellspacing="5">
                <tbody>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Tipo de pago: </td>
                        <td><select class="lista">
                                <option>Seleccione...</option>
                                <option>Crédito</option>
                                <option>De contado</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Cuenta de origen: </td>
                        <td><input class="input" type="text" name="ctaOrigen" size="20" placeholder="Número de cuenta"></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Cuenta de destino: </td>
                        <td><input class="input" type="text" name="ctaDestino" size="20" placeholder="Número de cuenta"></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Valor a transferir </td>
                        <td><input class="input" type="text" name="valorTransfer" size="20" placeholder="Valor a transferir"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Cuotas de pago: </td>
                        <td><input class="input" type="text" name="cuotasPago" size="20" placeholder="Número de cuotas"></td>
                    </tr>
                </tbody>
            </table>

            <div class="div_botones">
                <button name="action" value="Crear" class="boton">Crear</button>
                <button name="action" value="Consultar" class="boton">Consultar</button>
                <button name="action" value="Modificar" class="boton">Modificar</button>
                <button name="action" value="Eliminar" class="boton">Eliminar</button>
            </div>


        </div>
    </body>
</html>
