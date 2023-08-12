/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.funcionarioDAO;

import java.util.List;
import javassist.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import model.entity.Departamento;
import model.entity.Funcionario;

/**
 *
 * @author eric
 */
public class FuncDAO {

    private EntityManagerFactory managerFactroy;
    private EntityManager manager;

    public FuncDAO() {
    }

    public void conectar() {
        this.managerFactroy = Persistence.createEntityManagerFactory("WebSitePU");
        this.manager = this.managerFactroy.createEntityManager();
    }

    public void desconectar() {
        this.manager.close();
        this.managerFactroy.close();
    }

    public List<Funcionario> findAll() {
        try {
            conectar();
            String sql = "SELECT f FROM" + Funcionario.class + "f";
            List<Funcionario> lista = this.manager
                    .createNamedQuery("Funcionario.findAll", Funcionario.class)
                    .getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public int save(Funcionario obj) {
        try {

            conectar();
            this.manager.getTransaction().begin();
            this.manager.persist(obj);
            this.manager.getTransaction().commit();
            desconectar();

            return 1;
        } catch (RollbackException e) {
            e.printStackTrace();
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
    }

    public void delete(String id) {
        try {
            conectar();
            Funcionario func = this.manager.find(Funcionario.class, id);
            if (func != null) {
                this.manager.getTransaction().begin();
                this.manager.remove(func);
                this.manager.getTransaction().commit();
                desconectar();
            }

        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            throw new NoSuchMethodError("Não existe.");
        }
    }

    public void update(String id, String nomeFuncionario, String cargoFuncionario,
            String salarioFuncionario, Departamento idDep) {

        try {
            conectar();
            Funcionario funcionario = manager.find(Funcionario.class, id);

            if (funcionario != null) {
                manager.getTransaction().begin();
                funcionario.setNomeFuncionario(nomeFuncionario);
                funcionario.setCargoFuncionario(cargoFuncionario);
                funcionario.setSalarioFuncionario(salarioFuncionario);
                funcionario.setIdDepartamento(idDep);
                manager.merge(funcionario);
                manager.getTransaction().commit();

            } else {
                throw new NotFoundException("Não existe.");
            }
            desconectar();
        } catch (NoSuchMethodError | NotFoundException e) {
            e.printStackTrace();
            throw new NoSuchMethodError("Não existe.");
        }
    }

    public Funcionario findByFunc(String id) {
        try {
            conectar();
            Funcionario funcionario = this.manager.find(Funcionario.class, id);
            desconectar();
            return funcionario;
        } catch (Exception e) {
            return null;
        }
    }

    public Departamento findByDep(String idDep) {
        try {
            conectar();
            Departamento departamento = this.manager.find(Departamento.class, idDep);
            desconectar();
            return departamento;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Departamento> findAllDep() {
        try {
            conectar();
            TypedQuery<Departamento> query = this.manager
                    .createNamedQuery("Departamento.findAll", Departamento.class);

            List<Departamento> lista = query.getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

}
