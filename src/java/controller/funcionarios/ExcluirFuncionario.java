/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.funcionarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Funcionario;
import model.funcionarioDAO.FuncDAO;

/**
 *
 * @author eric
 */
@WebServlet(name = "ExcluirFuncionario", urlPatterns = {"/excluirFuncionario"})
public class ExcluirFuncionario extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        FuncDAO dao = new FuncDAO();
        
        dao.delete(req.getParameter("id"));
        
        List<Funcionario> lista = dao.findAll();
        req.setAttribute("listaFunc", lista);
        req.getRequestDispatcher("./funcionarioHTML/listarFuncionarios.jsp")
                .forward(req, resp);
        
    }
    
}
