<%-- 
    Document   : listagem
    Created on : 16 de nov. de 2023, 22:48:00
    Author     : drcj1
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Medicamentos"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Farma Dorinhos | Saúde e Bem-Estar, no Coração da Dorinhos!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleEstoque.css">
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="img/logo_farma_2.png" alt="logo_farma_2">
            </div>
                        
            <nav>
                <div class="indice">
                    <ul class="cabecalho">
                        <li><a href="inicio.html">Home</a></li>
                        <li><a href="cadastrar.html">Cadastro de Produto</a></li>
                        <li><a href="excluir.html ">Excluir Produto</a></li>
                        <li><a href="controller?flag=listar" target="centro">Lista de Produtos</a></li>
                        <li><a href="procurar.html">Procurar Produto</a></li>
                        <li><a href="alterar.html">Alterar Produto</a></li>
                        <li class="logout"><a href="index.html"><button>Logout</button></a></li>
                    </ul>
                </div>
            </nav>
        </header>

        <h2 class="titulo">
            Listagem de Medicamentos
        </h2>

        <%
            List<Medicamentos> ListarMedicamentos = (List<Medicamentos>) request.getAttribute("ListarMedicamentos");
            if (ListarMedicamentos == null) {
                ListarMedicamentos = new ArrayList<>(); // Inicializa a lista como vazia se for nula
            }
        %>

        <table class="tabela">
            <tr>
                <th>ID</th>
                <th>Tipo de Produto</th>
                <th>Nome do Produto</th>
                <th>Categoria Regulatória</th>
                <th>Classe Terapêutica</th>
                <th>Empresa de Registro</th>
                <th>Princípio Ativo</th>
            </tr>

            <% for (Medicamentos med : ListarMedicamentos) {%>
            <tr>                
                <td> <%= med.getId()%> </td>
                <td> <%= med.getTipoProduto()%> </td>
                <td> <%= med.getNomeProduto()%> </td>
                <td> <%= med.getCategoriaRegulatoria()%> </td>
                <td> <%= med.getClasseTerapeutica()%> </td>
                <td> <%= med.getEmpresaRegistro()%> </td>
                <td> <%= med.getPrincipioAtivo()%> </td>                
            </tr>
            <% }%>
        </table>

        <footer>
            <div class="barraInferior">
                <div class="logoSocial">
                    <img src="img/face.png" alt="face">
                    <img src="img/insta.png" alt="instagram">
                    <img src="img/twiter.png" alt="twiter">
                    <img src="img/linke.png" alt="linkedin">                  
                </div>

                <div class="copyRight">
                    <p>&copy; 2023 Farma Dorinhos</p>
                </div>
            </div>
        </footer>
    </body>
</html>
