/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findBySenhaFuncionario", query = "SELECT a FROM Acesso a WHERE a.senhaFuncionario = :senhaFuncionario"),
    @NamedQuery(name = "Acesso.findByEmailSenha", query = "SELECT a FROM Acesso a where a.senhaFuncionario = :senhaFuncionario and "
            + "a.funcionarioemail = :funcionarioemail"),
    @NamedQuery(name = "Acesso.findByFuncionarioemail", query = "SELECT a FROM Acesso a WHERE a.funcionarioemail = :funcionarioemail")})
public class Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "senhaFuncionario")
    private String senhaFuncionario;

    @Id
    @Basic(optional = false)
    @Column(name = "Funcionario_email")
    private String funcionarioemail;

    @JoinColumn(name = "Funcionario_email", referencedColumnName = "emailFuncionario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Acesso() {
    }

    public Acesso(String funcionarioemail) {
        this.funcionarioemail = funcionarioemail;
    }

    public Acesso(String funcionarioemail, String senhaFuncionario) {
        this.funcionarioemail = funcionarioemail;
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getFuncionarioemail() {
        return funcionarioemail;
    }

    public void setFuncionarioemail(String funcionarioemail) {
        this.funcionarioemail = funcionarioemail;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionarioemail != null ? funcionarioemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.funcionarioemail == null && other.funcionarioemail != null) || (this.funcionarioemail != null && !this.funcionarioemail.equals(other.funcionarioemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Acesso[ funcionarioemail=" + funcionarioemail + " ]";
    }

}
