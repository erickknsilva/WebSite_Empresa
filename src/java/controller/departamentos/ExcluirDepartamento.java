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
@WebServlet(name = "ExcluirDepartamento", urlPatterns = {"/excluirDepartamento"})
public class ExcluirDepartamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpresaDAO dao = new EmpresaDAO();
        Departamento dep = new Departamento(request.getParameter("id"));
        dao.remover(dep.getIdDepartamento());

        List<Departamento> listDepartamento = new EmpresaDAO(Departamento.class).consultarDepartamento();

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("./departamentoHTML/consultarDepartamento.jsp");
        request.setAttribute("lista", listDepartamento);
        dispatcher.forward(request, response);

    }

}
