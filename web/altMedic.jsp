<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Farma Dorinhos | Saúde e Bem-Estar, no Coração da Dorinhos!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleEstoque.css"
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
                <h1>Alterar Medicamento</h1>

                <form method="post" action="controller?flag=atualizar">
                    <fieldset class="cadItem">
                        <p>
                            <label for="id">ID:</label>
                            <input type="number" name="id" id="id" value="${medicamento.id}">
                        </p>
                        <label for="tipo_produto">Tipo:</label>
                            <input type="text" name="tipo_produto" id="tipo_produto" size="70" value="${medicamento.tipoProduto}">
                        </p>  
                        <p>
                            <label for="nome_produto">Nome:</label>
                            <input type="text" name="nome_produto" id="nome_produto" value="${medicamento.nomeProduto}">
                        </p> 
                        <p>
                            <label for="categoria_regulatoria">Categoria:</label>
                            <input type="text" name="categoria_regulatoria" id="categoria_regulatoria" value="${medicamento.categoriaRegulatoria}"> 
                        </p>
                        <p>
                            <label for="classe_terapeutica">Classe Terapeutica:</label>
                            <input type="text" name="classe_terapeutica" id="classe_terapeutica" value="${medicamento.classeTerapeutica}">
                        </p>
                        <p>
                            <label for="empresa_registro">Empresa:</label>
                            <input type="text" name="empresa_registro" id="empresa_registro" value="${medicamento.empresaRegistro}">
                        </p>
                        <p>
                            <label for="principio_ativo">Principio Ativo:</label>
                            <input type="text" name="principio_ativo" id="principio_ativo"value="${medicamento.principioAtivo}">
                        </p> 
                        <p>
                            <input type="submit" value="Salvar Alterações">  
                        </p>
                    </fieldset>
                </form> 
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
