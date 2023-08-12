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
@WebServlet(name = "BuscarDepartamentos", urlPatterns = {"/BuscarDepartamentos"})
public class BuscarDepartamentos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flag = request.getParameter("flag");

        if (flag.equalsIgnoreCase("BuscarDepartamentos")) {

            FuncDAO dao = new FuncDAO();
            List<Departamento> listaDep = dao.findAllDep();

            request.setAttribute("listaDep", listaDep);
            request.getRequestDispatcher("./funcionarioHTML/cadastrarFuncionario.jsp")
                    .forward(request, response);
        } else if (flag.equalsIgnoreCase("listarFuncionarios")) {

            FuncDAO dao = new FuncDAO();
            List<Funcionario> listaFunc = dao.findAll();

            request.setAttribute("listaFunc", listaFunc);
            request.getRequestDispatcher("./funcionarioHTML/listarFuncionarios.jsp")
                    .forward(request, response);

        }

    }

}
