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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author eric
 */
@WebServlet("/newServlet")
public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        List<Departamento> departamentos = new EmpresaDAO(Departamento.class).consultarDepartamento();

        JSONArray jsonArray = new JSONArray();
        for (Departamento departamento : departamentos) {
            JSONObject jsonDepartamentos = new JSONObject();
            jsonDepartamentos.put("Id", departamento.getIdDepartamento());
            jsonDepartamentos.put("nomeDepartamento", departamento.getNomeDepartamento());
            jsonDepartamentos.put("telefone", departamento.getFoneDepartamento());
            jsonArray.put(jsonDepartamentos);
        }

        String json = jsonArray.toString();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.setStatus(200);
    }

}
