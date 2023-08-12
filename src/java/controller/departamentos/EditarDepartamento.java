/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.departamentos;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "EditarDepartamento", urlPatterns = {"/editarDepartamento"})
public class EditarDepartamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String flag = request.getParameter("flag");
        if (flag.equals("alterarDepartamento")) {

            EmpresaDAO dao = new EmpresaDAO(Departamento.class);
            Departamento d = (Departamento) dao.consultarDepartamento(request.getParameter("id"));

            dao.alterar(d, request.getParameter("nomeDepartamento"),
                    request.getParameter("telefoneDepartamento"));

            List<Departamento> lista = new EmpresaDAO(Departamento.class).consultarDepartamento();
            request.setAttribute("lista", lista);

            request.getRequestDispatcher("./departamentoHTML/consultarDepartamento.jsp")
                    .forward(request, response);
        }
    }

}
