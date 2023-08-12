/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.funcionarios;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Departamento;
import model.entity.Funcionario;
import model.funcionarioDAO.FuncDAO;
import model.modelDAO.EmpresaDAO;

/**
 *
 * @author eric
 */
@WebServlet(name = "CadastrarFuncionarios", urlPatterns = {"/cadastrarFuncionarios"})
public class CadastrarFuncionarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String mensagem;
        String flag = request.getParameter("flag");

        if (flag.equalsIgnoreCase("cadastrarFuncionarios")) {
            FuncDAO dao = new FuncDAO();

            Departamento dep = dao.findByDep(request.getParameter("departamento"));

            Funcionario funcionario = new Funcionario(request.getParameter("nome"),
                    request.getParameter("email"), request.getParameter("cargo"),
                    request.getParameter("salario"), dep);

            int cadastro = dao.save(funcionario);

            switch (cadastro) {
                case 1:
                    mensagem = funcionario.toString() + "cadastrado com sucesso.";
                    response.getWriter().print(mensagem);
                    break;
                case 2:
                    mensagem = funcionario.toString() + ", já está cadastrado.";
                    response.getWriter().print(mensagem);
                    break;
                default:
                    mensagem = " Entre em contato com o administrador.";
                    response.getWriter().print(mensagem);
                    break;
            }
        }
    }

}
