/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginUsers;

public class loginUsers extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String PERSISTENCE_UNIT_NAME = "FlyDorPU";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("nome");
        String password = request.getParameter("senha");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = emf.createEntityManager();

            // Consulta o banco para obter o usuário
            LoginUsers user = em.createNamedQuery("LoginUsers.findByNome", LoginUsers.class)
                    .setParameter("nome", username)
                    .getSingleResult();

            if (user != null && user.getSenha().equals(password)) {
                // Usuário autenticado com sucesso
                response.sendRedirect("inicio.html"); // Redirecionar para a página de sucesso
            } else {
                // Falha na autenticação
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Credenciais inválidas");
            }
        } catch (NoResultException e) {
            // Usuário não encontrado
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("Usuário não encontrado");
        } catch (Exception e) {
            // Tratar outras exceções aqui e possivelmente registrar em logs
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Erro interno no servidor");
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
