/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.guia06.control;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.edu.uesocc.ingenieria.prn335_2018.flotadatalib.definicion.TipoParte;

/**
 *
 * @author stany
 */
@WebServlet(name="ServletCRUD", urlPatterns={"/ServletCRUD"})
public class ServletCRUD extends HttpServlet {
    @Inject 
     Utilidades utilidad;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCRUD</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index.html\">Volver al index</a>");
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
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guia06</title>");            
            out.println("</head>");
            out.println("<body>");
            
            List <TipoParte> results=utilidad.selectAll();
            int conta=0;
            out.println("<h2>TipoParte</h2>");
            out.println("<a href=\"index.html\">Volver al index</a>");
            
            out.println("<TABLE BORDER>");
            out.println("<TR>");
            out.println("<TH>IdTipoParte</TH> <TH>nombre</TH>  <TH>Activo</TH>  <TH>Observaciones</TH>  </TR>");
            while(null!=results.get(conta)){
            String res= results.get(conta).getNombre();
            int n=results.get(conta).getIdTipoParte();  
            boolean ac=results.get(conta).getActivo();
            String obser=results.get(conta).getObservaciones();
            out.println("<TR><TD>" +n+ "</TD><TD>"+res+"</TD><TD>"+ac+"</TD><TD>"+obser+"</TD></TR>");   
            conta++;
                }
            out.println("</TABLE>");

            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
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
