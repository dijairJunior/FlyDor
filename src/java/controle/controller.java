/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FarmaciaDao;
import model.Medicamentos;

/**
 *
 * @author drcj1
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

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
        String flag, mensagem;

        flag = request.getParameter("flag");
        if (flag.equals("cadastrar")) {
            String tp, np, cr, ct, er, pa;
            tp = request.getParameter("tipo_produto");
            np = request.getParameter("nome_produto");
            cr = request.getParameter("categoria_regulatoria");
            ct = request.getParameter("classe_terapeutica");
            er = request.getParameter("empresa_registro");
            pa = request.getParameter("principio_ativo");

            //fazer o cadastro
            Medicamentos medicamentos = new Medicamentos();
            medicamentos.setTipoProduto(tp);
            medicamentos.setNomeProduto(np);
            medicamentos.setClasseTerapeutica(ct);
            medicamentos.setCategoriaRegulatoria(cr);
            medicamentos.setEmpresaRegistro(er);
            medicamentos.setPrincipioAtivo(pa);

            //Chamar o metodo salvar
            int resultado = new FarmaciaDao().salvarProdutos(medicamentos);
            if (resultado == 1) { //salvou
                mensagem = "Produto cadastrado com sucesso";
            } else { //Não salvou (deu erro)
                mensagem = "Erro ao cadastrar produto";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
            disp.forward(request, response);

        } else if (flag.equals("excluir")) {
            Integer codigoMedicamento = Integer.parseInt(request.getParameter("id"));
            int resultado = new FarmaciaDao().excluirProduto(codigoMedicamento);

            if (resultado == 1) {
                mensagem = "Medicamento excluido com sucesso";
            } else {
                mensagem = "Medicamento não cadastrado";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
            disp.forward(request, response);

        } else if (flag.equals("alterar")) {
            String id = request.getParameter("id");
            // Buscar o medicamento pelo ID
            Medicamentos medicamento = new FarmaciaDao().buscarMedicamentoPorId(Integer.parseInt(id));

            if (medicamento != null) {
                // Encaminhar o medicamento para a página de alteração
                request.setAttribute("medicamento", medicamento);
                RequestDispatcher disp = request.getRequestDispatcher("altMedic.jsp");
                disp.forward(request, response);
            } else {
                mensagem = "Medicamento não encontrado";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
                disp.forward(request, response);
            }

        } else if (flag.equals("listar")) {
            // Listar produtos
            List<Medicamentos> lista = new FarmaciaDao().listarMedicamentos();

            request.setAttribute("ListarMedicamentos", lista);
            RequestDispatcher disp = request.getRequestDispatcher("listagem.jsp");
            disp.forward(request, response);

        } else if (flag.equals("localizar")) {
            String principioAtivo = request.getParameter("principioAtivo");
            // Adicione logs de depuração
            System.out.println("Princípio Ativo a ser pesquisado: " + principioAtivo);

            List<Medicamentos> resultados = new FarmaciaDao().procurarProduto(principioAtivo);

            // Adicione logs de depuração
            System.out.println("Número de resultados encontrados: " + resultados.size());

            request.setAttribute("Resultados", resultados);
            RequestDispatcher disp = request.getRequestDispatcher("localizar.jsp");
            disp.forward(request, response);

        } else if (flag.equals("atualizar")) {
            // Processar os dados do formulário e atualizar o medicamento no banco de dados
            try {
                String idStr = request.getParameter("id");

                if (idStr != null && !idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);

                    String nomeProduto = request.getParameter("nome_produto");
                    // Repita para os outros campos

                    // Valide os dados conforme necessário
                    if (nomeProduto == null || nomeProduto.isEmpty()) {
                        throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
                    }
                    // Adicione validações para outros campos se necessário

                    // Busque o medicamento no banco de dados
                    FarmaciaDao farmaciaDao = new FarmaciaDao();
                    Medicamentos medicamento = farmaciaDao.buscarMedicamentoPorId(id);

                    if (medicamento == null) {
                        throw new IllegalArgumentException("Medicamento não encontrado para o ID fornecido.");
                    }

                    // Atualize os dados do medicamento
                    medicamento.setNomeProduto(nomeProduto);
                    // Atualize para os outros campos conforme necessário

                    // Salve as alterações no banco de dados
                    farmaciaDao.atualizarProduto(medicamento);

                    // Exemplo de mensagem de sucesso
                    mensagem = "Alterações salvas com sucesso!";
                } else {
                    throw new IllegalArgumentException("ID inválido ou ausente na solicitação.");
                }
            } catch (Exception e) {
                // Em caso de erro, capture a exceção e forneça uma mensagem de erro
                mensagem = "Erro ao salvar alterações: " + e.getMessage();
            }

            // Encaminhe para a página de mensagem
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
            disp.forward(request, response);
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
