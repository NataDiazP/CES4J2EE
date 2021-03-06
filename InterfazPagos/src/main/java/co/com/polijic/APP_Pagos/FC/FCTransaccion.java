/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.polijic.APP_Pagos.FC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jms.*;
/**
 *
 * @author Casa
 */
@WebServlet(name = "FCTransaccion", urlPatterns = {"/FCTransaccion"})
public class FCTransaccion extends HttpServlet {
    @Resource(mappedName = "jms/pagosQueueInput")
    private Queue QueueInput;
    @Resource(mappedName = "jms/pagosQueueOutput")
    private Queue QueueOutput;
    @Resource(mappedName = "jms/pagosConnectionFactory")
    private QueueConnectionFactory connectionFactory;
    /**
     * Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FCTransaccion</title>");            
            out.println("</head>");
            out.println("<body>");
            sendMessage(out);
            out.println("<h1>Servlet FCTransaccion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
    }
    
      private void sendMessage(PrintWriter out) {
        QueueConnection connection = null;
        QueueSession session = null;
        QueueSender sender = null;
        try {
            connection = connectionFactory.createQueueConnection();
            connection.start();
            session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            sender = session.createSender(QueueOutput);
            TextMessage msg = session.createTextMessage();
            msg.setText("Mensaje de prueba");
            msg.setStringProperty("RECIPIENT", "MDB");
            msg.setJMSReplyTo(QueueOutput);
            sender.send(msg);
            out.println("<h1>Message sent successfully</h1>");
        } catch (JMSException ex) {
            Logger.getLogger(FCTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            out.println("<h1>Sending message failed</h1>");
        } finally {
            if (sender != null) {
                try {
                    sender.close();
                } catch (JMSException ex) {
                    Logger.getLogger(FCTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException ex) {
                    Logger.getLogger(FCTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(FCTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
