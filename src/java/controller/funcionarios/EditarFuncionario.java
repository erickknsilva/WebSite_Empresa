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

/**
 *
 * @author eric
 */
@WebServlet(name = "EditarFuncionario", urlPatterns = {"/editarFuncionario"})
public class EditarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String flag = request.getParameter("flag");
        if (flag.equals("editarFuncionario")) {

            FuncDAO dao = new FuncDAO();

            Funcionario func = dao.findByFunc(request.getParameter("id"));

            Departamento departamento = dao.findByDep(request.getParameter("departamento"));

            dao.update(func.getEmailFuncionario(), request.getParameter("nome"),
                    request.getParameter("cargo"), request.getParameter("salario"), departamento);

            List<Funcionario> listaFunc = dao.findAll();
            request.setAttribute("listaFunc", listaFunc);

            request.getRequestDispatcher("./funcionarioHTML/listarFuncionarios.jsp")
                    .forward(request, response);
        }
    }

}
