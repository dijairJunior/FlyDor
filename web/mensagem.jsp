<%-- 
    Document   : mensagens
    Created on : 16 de nov. de 2023, 17:08:43
    Author     : drcj1
--%>

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

        <main>
            <div class="container">
                <p>
                    ${mensagem == null ? "Nenhuma mensagem disponível" : mensagem}
                </p>
            </div>
        </main>

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
