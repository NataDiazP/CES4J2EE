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
        <title>Tarjeta</title>
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
                <img style="position: absolute; margin-top: -10px; margin-left: 30px;" src="images/avion.png" border="0" width=190px;" >
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
        
        <form action="FCTarjeta" method="post">
        <div style="margin-top: 55px;">
        
        <div class="fuente_formularios" style="margin-left: 300px;">
            <table border="0" width="400" cellspacing="5">
                <tbody>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Número Tarjeta: </td>
                        <td><input class="input" type="text" name="numeroTarjeta" size="20" placeholder="Número de Tarjeta"></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Nombre Titular: </td>
                        <td><input class="input" type="text" name="nombreTitular" size="20" placeholder="Nombre Completo"></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Tipo Tarjeta: </td>
                        <td><select name = "tipoTarjeta"class="lista">
                                <option value="">Seleccione...</option>
                                <option value="1">Débito</option>
                                <option value="2">Crédito</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Franquicia: </td>
                        <td><select name="franquicia" class="lista">
                                <option>Seleccione...</option>
                                <option value="1">Visa</option>
                                <option value="2">Mastercard</option>
                            </select></td>
                    </tr>
                    <!--
                    <tr>
                        <td class="rojo">*</td>
                        <td>Mes de vencimiento: </td>
                        <td><select class="lista">
                                <option>Seleccione...</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Año de vencimiento: </td>
                        <td><select class="lista">
                                <option>Seleccione...</option>
                                <option>2013</option>
                                <option>2014</option>
                                <option>2015</option>
                                <option>2016</option>
                                <option>2017</option>
                                <option>2018</option>
                                <option>2019</option>
                                <option>2020</option>
                                <option>2021</option>
                                <option>2022</option>
                                <option>2023</option>
                                <option>2024</option>
                                <option>2025</option>
                                <option>2026</option>
                                <option>2027</option>
                                <option>2028</option>
                                <option>2029</option>
                                <option>2030</option>
                                <option>2031</option>
                                <option>2032</option>
                                <option>2033</option>
                                <option>2034</option>
                                <option>2035</option>
                                <option>2036</option>
                                <option>2037</option>
                                <option>2038</option>
                                <option>2039</option>
                                <option>2040</option>
                                <option>2041</option>
                                <option>2042</option>
                                <option>2043</option>
                                <option>2044</option>
                                <option>2045</option>
                                <option>2046</option>
                                <option>2047</option>
                                <option>2048</option>
                                <option>2049</option>
                                <option>2050</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Código de seguridad: </td>
                        <td><input class="input" type="text" name="codSeguridadTarjeta" size="20" placeholder="Código de Seguridad"></td>
                    </tr>  
                    <tr>
                        <td class="rojo">*</td>
                        <td>Estado Tarjeta: </td>
                        <td><select class="lista">
                                <option>Seleccione...</option>
                                <option>Activa</option>
                                <option>Inactiva</option>
                            </select></td>
                    </tr> -->
                </tbody>
            </table>

        </div>

        <div class="fuente_formularios" style="margin-left: 690px; margin-top: -135px;">
            <table border="0" width="400" cellspacing="5">
                <tbody>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Mes de vencimiento: </td>
                        <td><select name="mesVencimiento" class="lista">
                                <option>Seleccione...</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Año de vencimiento: </td>
                        <td><select name = "anioVencimiento" class="lista">
                                <option>Seleccione...</option>
                                <option value="2013">2013</option>
                                <option value="2014">2014</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                                <option value="2026">2026</option>
                                <option value="2027">2027</option>
                                <option value="2028">2028</option>
                                <option value="2029">2029</option>
                                <option value="2030">2030</option>
                                <option value="2031">2031</option>
                                <option value="2032">2032</option>
                                <option value="2033">2033</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td class="rojo">*</td>
                        <td>Código de seguridad: </td>
                        <td><input class="input" type="text" name="codSeguridadTarjeta" size="20" placeholder="Código de Seguridad"></td>
                    </tr>  
                    <tr>
                        <td class="rojo">*</td>
                        <td>Estado Tarjeta: </td>
                        <td><select name="estadoTarjeta" class="lista">
                                <option>Seleccione...</option>
                                <option value="1">Activa</option>
                                <option value="2">Inactiva</option>
                            </select></td>
                    </tr>
                </tbody>
            </table>
        </div>
            
        </div>
        
        <div class="div_botones2">
                <button name="action" type="submit" value="Crear" class="boton">Crear</button>
                <button name="action" type="submit" value="Consultar" class="boton">Consultar</button>
                <button name="action" type="submit" value="Modificar" class="boton">Modificar</button>
                <button name="action" type="submit" value="Eliminar" class="boton">Eliminar</button>
        </div>
        
         <br>
        <b><a style="color:red">
                <%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%>
        </a></b>
        <input
        </form>
    </body>
</html>
