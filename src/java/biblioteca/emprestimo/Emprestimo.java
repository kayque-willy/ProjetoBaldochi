package biblioteca.emprestimo;

import java.sql.Date;

public class Emprestimo {

    /*---------- Atributos ----------*/
    private int id;
    private int exemplar_numero;
    private int associado_codigo;
    private Date data_emprestimo;
    private Date data_devolucao;
    private String status;
    private Double codigo;

    /*---------- Métodos ----------*/
    public void emprestimo() {

    }

    /*---------- Get e Set ----------*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExemplar_numero() {
        return exemplar_numero;
    }

    public void setExemplar_numero(int exemplar_numero) {
        this.exemplar_numero = exemplar_numero;
    }

    public int getAssociado_codigo() {
        return associado_codigo;
    }

    public void setAssociado_codigo(int associado_codigo) {
        this.associado_codigo = associado_codigo;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

}