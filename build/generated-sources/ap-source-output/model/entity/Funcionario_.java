package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.Acesso;
import model.entity.Departamento;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-11T20:55:21")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Departamento> idDepartamento;
    public static volatile SingularAttribute<Funcionario, String> salarioFuncionario;
    public static volatile SingularAttribute<Funcionario, String> emailFuncionario;
    public static volatile SingularAttribute<Funcionario, Acesso> acesso;
    public static volatile SingularAttribute<Funcionario, String> cargoFuncionario;
    public static volatile SingularAttribute<Funcionario, String> nomeFuncionario;

}