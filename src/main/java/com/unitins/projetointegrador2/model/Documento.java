package com.unitins.projetointegrador2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean assinadoAluno;

    private Date dataAssinaturaAluno;

    private boolean assinadoProfessor;

    private Date dataAssinaturaProfessor;

    private TipoDocumento tipoDocumento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssinadoAluno() {
        return assinadoAluno;
    }

    public void setAssinadoAluno(boolean assinadoAluno) {
        this.assinadoAluno = assinadoAluno;
    }

    public Date getDataAssinaturaAluno() {
        return dataAssinaturaAluno;
    }

    public void setDataAssinaturaAluno(Date dataAssinaturaAluno) {
        this.dataAssinaturaAluno = dataAssinaturaAluno;
    }

    public boolean isAssinadoProfessor() {
        return assinadoProfessor;
    }

    public void setAssinadoProfessor(boolean assinadoProfessor) {
        this.assinadoProfessor = assinadoProfessor;
    }

    public Date getDataAssinaturaProfessor() {
        return dataAssinaturaProfessor;
    }

    public void setDataAssinaturaProfessor(Date dataAssinaturaProfessor) {
        this.dataAssinaturaProfessor = dataAssinaturaProfessor;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
