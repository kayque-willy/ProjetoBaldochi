package biblioteca.servlet;

import biblioteca.associado.Associado;
import biblioteca.associado.AssociadoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    /*--------- Atributos ---------*/
    private Associado associado;
    private AssociadoDAO dao;
    private int login;
    private String senha;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login = Integer.valueOf(request.getParameter("login"));
        senha = request.getParameter("senha");

        associado = new Associado();
        dao = new AssociadoDAO();

        if (login != 0 && senha != null) {
            associado = dao.consultar(login, senha);
            if (associado != null && associado.getCodigo() != 0) {
                request.getSession().setAttribute("usuario", associado.getNome());
                request.getSession().setAttribute("tipo", "associado");
                request.getSession().setAttribute("nivel", associado.getStatus());
                request.getSession().setAttribute("codigo", associado.getCodigo());
                // redireciona para página principal
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/index.jsp");
                //dispatcher.forward(request, response);
                response.sendRedirect("/biblioteca/pages/indexAssociado.jsp");
            } else {
                // redireciona para página de login com erro
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/loginErro.jsp");
                //dispatcher.forward(request, response);
                response.sendRedirect("/biblioteca/loginErro.jsp");
            }
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
