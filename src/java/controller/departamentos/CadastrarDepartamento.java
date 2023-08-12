/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.departamentos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Departamento;
import model.modelDAO.EmpresaDAO;

/**
 *
 * @author eric
 */
@WebServlet(name = "CadastrarDepartamento", urlPatterns = {"/cadastrarDepartamento"})
public class CadastrarDepartamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensagem;
        String flag = request.getParameter("flag");

        if (flag.equals("CadastrarDepartamento")) {

            Departamento departamento
                    = new Departamento(request.getParameter("idDepartamento").toUpperCase(),
                            request.getParameter("nomeDepartamento").toUpperCase(),
                            request.getParameter("telefoneDepartamento"));

            int cadastro = new EmpresaDAO(Departamento.class).cadastrarDepartamento(departamento);

            switch (cadastro) {
                case 1:
                    List<Departamento> listDepartamento = new EmpresaDAO(Departamento.class).consultarDepartamento();
                    request.setAttribute("lista", listDepartamento);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("departamentoHTML/consultarDepartamento.jsp");
                    dispatcher.forward(request, response);
                    break;
                case 2:
                    mensagem = departamento.toString() + ", já está cadastrado.";
                    break;
                default:
                    mensagem = " Entre em contato com o administrador.";
                    break;
            }
        }
    }

}
