/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.modelDAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import model.entity.Acesso;
import model.entity.Departamento;

/**
 *
 * @author erick.nsilva2
 */
public class EmpresaDAO<E> {

    private EntityManagerFactory entityFactory;
    private EntityManager entityManager;
    private Class<E> classes;

    public EmpresaDAO() {
        this(null);
    }

    public EmpresaDAO(Class<E> classe) {
        this.classes = classe;
    }

    public void conectar() {
        entityFactory = Persistence.createEntityManagerFactory("WebSitePU");
        entityManager = entityFactory.createEntityManager();
    }

    public Acesso validarLogin(String login, String senha) {
        Acesso acesso;
        conectar();
        try {
            TypedQuery<Acesso> query = entityManager
                    .createNamedQuery("Acesso.findByEmailSenha", Acesso.class);

            query.setParameter("senhaFuncionario", senha);
            query.setParameter("funcionarioemail", login);
            acesso = query.getSingleResult();
            desconectar();
            return acesso;
        } catch (NoResultException e) {
            return null;
        }
    }

    public int cadastrarDepartamento(Object obj) {

        try {
            conectar();
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
            desconectar();
            return 1;
        } catch (RollbackException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        }
    }

    public List<E> consultarDepartamento() {
        conectar();
        try {
            String jpql = "SELECT e FROM " + classes.getName() + " e";

            TypedQuery<E> query = entityManager.createQuery(jpql, classes);

            List<E> lista = query.getResultList();

            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public Object consultarDepartamento(String id) {
        conectar();
        try {

            Object obj = entityManager.find(classes, id);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public Departamento consultarDepartamento2(String id) {
        conectar();
        try {

            Departamento departamento = entityManager.find(Departamento.class, id);
            return departamento;
        } catch (Exception e) {
            return null;
        }
    }

    public void alterar(Departamento id, String nome, String telefone) {

        conectar();
        try {

            Departamento departamento = entityManager.find(Departamento.class,
                    id.getIdDepartamento());

            if (departamento != null) {
                entityManager.getTransaction().begin();
                departamento.setNomeDepartamento(nome.toUpperCase());
                departamento.setFoneDepartamento(telefone.toUpperCase());
                entityManager.merge(departamento);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Não existe");
            }
            desconectar();
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            throw new NoSuchMethodError("Não existe.");
        }
    }

    public void remover(String dep) {

        conectar();
        try {

            Departamento departamento = entityManager.find(Departamento.class, dep);

            if (departamento != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(departamento);
                entityManager.getTransaction().commit();
            }
            desconectar();
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            throw new NoSuchMethodError("Não existe.");
        }
    }

    public void desconectar() {
        entityManager.close();
        entityFactory.close();
    }

}
