/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.polijic.APP_Pagos.FC;

import co.edu.polijic.APP_Pagos.Negocio.MgrTarjeta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Casa
 */
@WebServlet(urlPatterns = {"/FCTarjeta"})
public class FCTarjeta extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        RequestDispatcher dispatcher;

        /*Enumeration<String> parametros = request.getParameterNames();
         while (parametros.hasMoreElements()) {
         System.out.println("**" + parametros.nextElement());
         }*/
        MgrTarjeta mgrTarjeta = new MgrTarjeta();
        Tarjeta tarjeta = new Tarjeta();
        switch (request.getParameter("action")) {
            case "Crear":
                tarjeta.setOpfranquicia(request.getParameter("franquicia"));
                tarjeta.setOpestadotarjeta(request.getParameter("estadoTarjeta"));
                tarjeta.setOptipotarjeta(request.getParameter("tipoTarjeta"));
                tarjeta.setNmtarjeta(Integer.valueOf(request.getParameter("numeroTarjeta")));
                tarjeta.setDsmesvencimiento(request.getParameter("mesVencimiento"));
                tarjeta.setDsaniovencimiento(request.getParameter("anioVencimiento"));
                tarjeta.setCdseguridad(Integer.valueOf(request.getParameter("codSeguridadTarjeta")));
                tarjeta.setDsnombretitular(request.getParameter("nombreTitular"));
                String res = mgrTarjeta.registrarTarjeta(tarjeta) == true ? "Registro almacenado satisfactoriamente" : "Error al intentar guardar el registro";
                dispatcher = request.getRequestDispatcher("tarjeta.jsp?msg=" + res);
                dispatcher.forward(request, response);
                break;
            case "Consultar":
                //int nmTarjeta = Integer.valueOf(request.getParameter("numeroTarjeta"));
                //String res = mgrTarjeta.bus(tarjeta) == true ? "Registro almacenado satisfactoriamente" : "Error al intentar guardar el registro";
                //dispatcher = request.getRequestDispatcher("tarjeta.jsp?msg=" + res);
                //dispatcher.forward(request, response);
                break;
            case "Modificar":
                break;
            case "Eliminar":
                break;
            default:
                throw new Exception("Parametro de envio invalido");
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
        } catch (Exception ex) {
            Logger.getLogger(FCTarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(FCTarjeta.class.getName()).log(Level.SEVERE, null, ex);
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
