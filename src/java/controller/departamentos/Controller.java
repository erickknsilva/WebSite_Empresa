package controller.departamentos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Acesso;
import model.entity.Departamento;
import model.modelDAO.EmpresaDAO;

/**
 *
 * @author erick.nsilva2
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        String mensagem;
        String arquivo;
        List<Departamento> listaTeste = new EmpresaDAO().consultarDepartamento();
        if (flag.equals("login")) {

            String senha = request.getParameter("senha");
            String login = request.getParameter("usuario");

            Acesso acesso = new EmpresaDAO().validarLogin(login, senha);

            if (acesso == null) {
                mensagem = "Desculpe, Usuario não encontrado! <br>"
                        + "faça seu cadastro ou verifique o login de acesso. ";
                arquivo = "MensagemErro.jsp";

            } else {
                String nome = acesso.getFuncionario().getNomeFuncionario();
                String cargo = acesso.getFuncionario().getCargoFuncionario();

                if (cargo.equalsIgnoreCase("Gerente")) {
                    mensagem = "Bem-vindo, " + nome;
                    arquivo = "AcessoGerente.jsp";

                } else if (cargo.equalsIgnoreCase("Vendedor")) {
                    mensagem = "Bem-vindo, " + nome;
                    arquivo = "AcessoVendedor.jsp";

                } else {
                    mensagem = "Bem-vindo, " + nome;
                    arquivo = "AcessoOutro.jsp";
                }
            }//fim do else interno
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(arquivo);
            dispatcher.forward(request, response);
            //fim do if externo
        }

    }

}
