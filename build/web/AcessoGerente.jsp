<%-- 
    Document   : AcessoGerente
    Created on : 25 de mar. de 2023, 20:47:26
    Author     : eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt_br">
    <head>

        <title>Acesso Gerente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/conf.css">
        <link rel="stylesheet" type="text/css" href="./css/acessoGerente.css">

    </head>
    <body>
        <header>

            <h1>ek2Soft</h1>
            <p style="margin-right:1vh">${mensagem}</p>
        </header>

        <nav>
            <div class="topnav" id="myTopnav">
                <a href="#home" class="active">Home</a>

                <div class="dropdown">
                    <button class="dropbtn">Departamento
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content" target="conteudo">
                        <a href="consultarDepartamento?flag=ConsultarDepartamento" target="conteudo">Listar</a>
                        <a href="departamentoHTML/cadastrarDepartamento.html" target="conteudo">Cadastrar</a>
                        <a href="departamentoHTML/editarDep.html" target="conteudo">Alterar</a>
                        <a href="departamentoHTML/excluirDep.html" target="conteudo">Exluir</a>
                        <a href="departamentoHTML/pesquisarDep.html" target="conteudo">Pesquisar</a>
                    </div>
                </div>

                <div class="dropdown">
                    <button class="dropbtn">Funcionario
                        <i class="fa fa-caret-down"></i>
                    </button>

                    <div class="dropdown-content" target="conteudo">
                        <a href="BuscarDepartamentos?flag=listarFuncionarios" target="conteudo">Listar</a>
                        <a href="funcionarioHTML/alterarFuncionario.html" target="conteudo">Alterar</a>
                        <a href="BuscarDepartamentos?flag=BuscarDepartamentos" target="conteudo" >Cadastrar</a>
                        <a href="funcionarioHTML/excluirFuncionario.html" target="conteudo">Excluir</a>
                    </div>
                </div>

                <div class="dropdown">
                    <button class="dropbtn">Acesso
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content" target="conteudo">
                        <a href="acessoHTML/consultarAcesso.html" target="conteudo">Consultar</a>
                        <a href="acessoHTML/alterarAcesso.html" target="conteudo">Alterar</a>
                        <a href="acessoHTML/cadastrarAcesso.html" target="conteudo">Cadastrar</a>
                        <a href="acessoHTML/exluirAcesso.html" target="conteudo">Excluir</a>
                    </div>
                </div>

                <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
            </div>
        </nav>

        <main>
            <iframe src="aberturaIframe.html" name="conteudo"></iframe>
        </main>

        <footer>
            <center><h1>EK2Soft</h1></center>
        </footer>

        <script src="acessoGerente.js"></script>
    </body>
</html>
