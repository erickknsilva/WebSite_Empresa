package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-11T20:55:21")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> idDepartamento;
    public static volatile ListAttribute<Departamento, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Departamento, String> nomeDepartamento;
    public static volatile SingularAttribute<Departamento, String> foneDepartamento;

}