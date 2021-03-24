package com.example.filedemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String documentCode;

    private String numeroNfe;
    private String descricaoNfe;
    private String dataEmissao;
    private String baseCalculo;
    private String aliquota;
    private String valorIss;
    private String valorLiquidoNfe;
    private String prestadorCpf;
    private String prestadorCnpj;
    private String prestadorInscricaoEstadual;
    private String prestadorInscricaoMunicipal;
    private String prestadorRazaoSocial;
    private String prestadorEndereco;
    private String prestadorEnderecoNumero;
    private String prestadorEnderecoBairro;
    private String prestadorEnderecoCidade;
    private String prestadorEnderecoUf;
    private String prestadorEnderecoCep;
    private String servicoPrestadoNumero;
    private String servicoPrestadoSerie;
    private String servicoPrestadoQuantidade;
    private String servicoPrestadoValorUnitario;
    private String servicoPrestadoValorPis;
    private String servicoPrestadoValorCofins;
    private String servicoPrestadoValorIr;
    private String servicoPrestadoValorCsll;
    private String servicoPrestadoValorNaoBaseCalculo;
    private String servicoPrestadoValorAliquota;
    private String servicoPrestadoIssRetido;
    private String servicoPrestadoCodigoServico;
    private String servicoPrestadoDescricaoServico;
    private String servicoPrestadoDiscriminacaoServico;
    private String servicoPrestadoFaturaNumero;
    private String servicoPrestadoFaturaValor;
    private String servicoPrestadoFaturaFormaPagamento;
    private String servicoPrestadoFaturaValorExtenso;

    private String prestadorIdentificacaoCpf;
    private String prestadorIdentificacaoCnpj;

    private String tomadorIdentificacaoCpf;
    private String tomadorIdentificacaoCnpj;
    private String tomadorRazaoSocial;
    private String tomadorEndereco;
    private String tomadorEnderecoNumero;
    private String tomadorEnderecoComplemento;
    private String tomadorEnderecoBairro;
    private String tomadorEnderecoCidade;
    private String tomadorEnderecoUf;
    private String tomadorEnderecoCep;
    private String tomadorEnderecoContatoEmail;

    private String nfsCode;
    private String totalValue;
    private String iss;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNfsCode() {
        return nfsCode;
    }

    public void setNfsCode(String nfsCode) {
        this.nfsCode = nfsCode;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getNumeroNfe() {
        return numeroNfe;
    }

    public void setNumeroNfe(String numeroNfe) {
        this.numeroNfe = numeroNfe;
    }

    public String getDescricaoNfe() {
        return descricaoNfe;
    }

    public void setDescricaoNfe(String descricaoNfe) {
        this.descricaoNfe = descricaoNfe;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(String baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValorIss() {
        return valorIss;
    }

    public void setValorIss(String valorIss) {
        this.valorIss = valorIss;
    }

    public String getValorLiquidoNfe() {
        return valorLiquidoNfe;
    }

    public void setValorLiquidoNfe(String valorLiquidoNfe) {
        this.valorLiquidoNfe = valorLiquidoNfe;
    }

    public String getPrestadorCpf() {
        return prestadorCpf;
    }

    public void setPrestadorCpf(String prestadorCpf) {
        this.prestadorCpf = prestadorCpf;
    }

    public String getPrestadorCnpj() {
        return prestadorCnpj;
    }

    public void setPrestadorCnpj(String prestadorCnpj) {
        this.prestadorCnpj = prestadorCnpj;
    }

    public String getPrestadorInscricaoEstadual() {
        return prestadorInscricaoEstadual;
    }

    public void setPrestadorInscricaoEstadual(String prestadorInscricaoEstadual) {
        this.prestadorInscricaoEstadual = prestadorInscricaoEstadual;
    }

    public String getPrestadorInscricaoMunicipal() {
        return prestadorInscricaoMunicipal;
    }

    public void setPrestadorInscricaoMunicipal(String prestadorInscricaoMunicipal) {
        this.prestadorInscricaoMunicipal = prestadorInscricaoMunicipal;
    }

    public String getPrestadorRazaoSocial() {
        return prestadorRazaoSocial;
    }

    public void setPrestadorRazaoSocial(String prestadorRazaoSocial) {
        this.prestadorRazaoSocial = prestadorRazaoSocial;
    }

    public String getPrestadorEndereco() {
        return prestadorEndereco;
    }

    public void setPrestadorEndereco(String prestadorEndereco) {
        this.prestadorEndereco = prestadorEndereco;
    }

    public String getPrestadorEnderecoNumero() {
        return prestadorEnderecoNumero;
    }

    public void setPrestadorEnderecoNumero(String prestadorEnderecoNumero) {
        this.prestadorEnderecoNumero = prestadorEnderecoNumero;
    }

    public String getPrestadorEnderecoBairro() {
        return prestadorEnderecoBairro;
    }

    public void setPrestadorEnderecoBairro(String prestadorEnderecoBairro) {
        this.prestadorEnderecoBairro = prestadorEnderecoBairro;
    }

    public String getPrestadorEnderecoCidade() {
        return prestadorEnderecoCidade;
    }

    public void setPrestadorEnderecoCidade(String prestadorEnderecoCidade) {
        this.prestadorEnderecoCidade = prestadorEnderecoCidade;
    }

    public String getPrestadorEnderecoUf() {
        return prestadorEnderecoUf;
    }

    public void setPrestadorEnderecoUf(String prestadorEnderecoUf) {
        this.prestadorEnderecoUf = prestadorEnderecoUf;
    }

    public String getPrestadorEnderecoCep() {
        return prestadorEnderecoCep;
    }

    public void setPrestadorEnderecoCep(String prestadorEnderecoCep) {
        this.prestadorEnderecoCep = prestadorEnderecoCep;
    }

    public String getServicoPrestadoNumero() {
        return servicoPrestadoNumero;
    }

    public void setServicoPrestadoNumero(String servicoPrestadoNumero) {
        this.servicoPrestadoNumero = servicoPrestadoNumero;
    }

    public String getServicoPrestadoQuantidade() {
        return servicoPrestadoQuantidade;
    }

    public void setServicoPrestadoQuantidade(String servicoPrestadoQuantidade) {
        this.servicoPrestadoQuantidade = servicoPrestadoQuantidade;
    }

    public String getServicoPrestadoValorUnitario() {
        return servicoPrestadoValorUnitario;
    }

    public void setServicoPrestadoValorUnitario(String servicoPrestadoValorUnitario) {
        this.servicoPrestadoValorUnitario = servicoPrestadoValorUnitario;
    }

    public String getServicoPrestadoValorPis() {
        return servicoPrestadoValorPis;
    }

    public void setServicoPrestadoValorPis(String servicoPrestadoValorPis) {
        this.servicoPrestadoValorPis = servicoPrestadoValorPis;
    }

    public String getServicoPrestadoValorCofins() {
        return servicoPrestadoValorCofins;
    }

    public void setServicoPrestadoValorCofins(String servicoPrestadoValorCofins) {
        this.servicoPrestadoValorCofins = servicoPrestadoValorCofins;
    }

    public String getServicoPrestadoValorIr() {
        return servicoPrestadoValorIr;
    }

    public void setServicoPrestadoValorIr(String servicoPrestadoValorIr) {
        this.servicoPrestadoValorIr = servicoPrestadoValorIr;
    }

    public String getServicoPrestadoValorCsll() {
        return servicoPrestadoValorCsll;
    }

    public void setServicoPrestadoValorCsll(String servicoPrestadoValorCsll) {
        this.servicoPrestadoValorCsll = servicoPrestadoValorCsll;
    }

    public String getServicoPrestadoValorNaoBaseCalculo() {
        return servicoPrestadoValorNaoBaseCalculo;
    }

    public void setServicoPrestadoValorNaoBaseCalculo(String servicoPrestadoValorNaoBaseCalculo) {
        this.servicoPrestadoValorNaoBaseCalculo = servicoPrestadoValorNaoBaseCalculo;
    }

    public String getServicoPrestadoValorAliquota() {
        return servicoPrestadoValorAliquota;
    }

    public void setServicoPrestadoValorAliquota(String servicoPrestadoValorAliquota) {
        this.servicoPrestadoValorAliquota = servicoPrestadoValorAliquota;
    }

    public String getServicoPrestadoIssRetido() {
        return servicoPrestadoIssRetido;
    }

    public void setServicoPrestadoIssRetido(String servicoPrestadoIssRetido) {
        this.servicoPrestadoIssRetido = servicoPrestadoIssRetido;
    }

    public String getServicoPrestadoCodigoServico() {
        return servicoPrestadoCodigoServico;
    }

    public void setServicoPrestadoCodigoServico(String servicoPrestadoCodigoServico) {
        this.servicoPrestadoCodigoServico = servicoPrestadoCodigoServico;
    }

    public String getServicoPrestadoDescricaoServico() {
        return servicoPrestadoDescricaoServico;
    }

    public void setServicoPrestadoDescricaoServico(String servicoPrestadoDescricaoServico) {
        this.servicoPrestadoDescricaoServico = servicoPrestadoDescricaoServico;
    }

    public String getServicoPrestadoDiscriminacaoServico() {
        return servicoPrestadoDiscriminacaoServico;
    }

    public void setServicoPrestadoDiscriminacaoServico(String servicoPrestadoDiscriminacaoServico) {
        this.servicoPrestadoDiscriminacaoServico = servicoPrestadoDiscriminacaoServico;
    }

    public String getServicoPrestadoFaturaNumero() {
        return servicoPrestadoFaturaNumero;
    }

    public void setServicoPrestadoFaturaNumero(String servicoPrestadoFaturaNumero) {
        this.servicoPrestadoFaturaNumero = servicoPrestadoFaturaNumero;
    }

    public String getPrestadorIdentificacaoCpf() {
        return prestadorIdentificacaoCpf;
    }

    public void setPrestadorIdentificacaoCpf(String prestadorIdentificacaoCpf) {
        this.prestadorIdentificacaoCpf = prestadorIdentificacaoCpf;
    }

    public String getPrestadorIdentificacaoCnpj() {
        return prestadorIdentificacaoCnpj;
    }

    public void setPrestadorIdentificacaoCnpj(String prestadorIdentificacaoCnpj) {
        this.prestadorIdentificacaoCnpj = prestadorIdentificacaoCnpj;
    }

    public String getTomadorIdentificacaoCpf() {
        return tomadorIdentificacaoCpf;
    }

    public void setTomadorIdentificacaoCpf(String tomadorIdentificacaoCpf) {
        this.tomadorIdentificacaoCpf = tomadorIdentificacaoCpf;
    }

    public String getTomadorIdentificacaoCnpj() {
        return tomadorIdentificacaoCnpj;
    }

    public void setTomadorIdentificacaoCnpj(String tomadorIdentificacaoCnpj) {
        this.tomadorIdentificacaoCnpj = tomadorIdentificacaoCnpj;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public void setTomadorRazaoSocial(String tomadorRazaoSocial) {
        this.tomadorRazaoSocial = tomadorRazaoSocial;
    }

    public String getTomadorEndereco() {
        return tomadorEndereco;
    }

    public void setTomadorEndereco(String tomadorEndereco) {
        this.tomadorEndereco = tomadorEndereco;
    }

    public String getTomadorEnderecoNumero() {
        return tomadorEnderecoNumero;
    }

    public void setTomadorEnderecoNumero(String tomadorEnderecoNumero) {
        this.tomadorEnderecoNumero = tomadorEnderecoNumero;
    }

    public String getTomadorEnderecoComplemento() {
        return tomadorEnderecoComplemento;
    }

    public void setTomadorEnderecoComplemento(String tomadorEnderecoComplemento) {
        this.tomadorEnderecoComplemento = tomadorEnderecoComplemento;
    }

    public String getTomadorEnderecoBairro() {
        return tomadorEnderecoBairro;
    }

    public void setTomadorEnderecoBairro(String tomadorEnderecoBairro) {
        this.tomadorEnderecoBairro = tomadorEnderecoBairro;
    }

    public String getTomadorEnderecoCidade() {
        return tomadorEnderecoCidade;
    }

    public void setTomadorEnderecoCidade(String tomadorEnderecoCidade) {
        this.tomadorEnderecoCidade = tomadorEnderecoCidade;
    }

    public String getTomadorEnderecoUf() {
        return tomadorEnderecoUf;
    }

    public void setTomadorEnderecoUf(String tomadorEnderecoUf) {
        this.tomadorEnderecoUf = tomadorEnderecoUf;
    }

    public String getTomadorEnderecoCep() {
        return tomadorEnderecoCep;
    }

    public void setTomadorEnderecoCep(String tomadorEnderecoCep) {
        this.tomadorEnderecoCep = tomadorEnderecoCep;
    }

    public String getTomadorEnderecoContatoEmail() {
        return tomadorEnderecoContatoEmail;
    }

    public void setTomadorEnderecoContatoEmail(String tomadorEnderecoContatoEmail) {
        this.tomadorEnderecoContatoEmail = tomadorEnderecoContatoEmail;
    }

    public String getServicoPrestadoFaturaValor() {
        return servicoPrestadoFaturaValor;
    }

    public void setServicoPrestadoFaturaValor(String servicoPrestadoFaturaValor) {
        this.servicoPrestadoFaturaValor = servicoPrestadoFaturaValor;
    }

    public String getServicoPrestadoFaturaFormaPagamento() {
        return servicoPrestadoFaturaFormaPagamento;
    }

    public void setServicoPrestadoFaturaFormaPagamento(String servicoPrestadoFaturaFormaPagamento) {
        this.servicoPrestadoFaturaFormaPagamento = servicoPrestadoFaturaFormaPagamento;
    }

    public String getServicoPrestadoFaturaValorExtenso() {
        return servicoPrestadoFaturaValorExtenso;
    }

    public void setServicoPrestadoFaturaValorExtenso(String servicoPrestadoFaturaValorExtenso) {
        this.servicoPrestadoFaturaValorExtenso = servicoPrestadoFaturaValorExtenso;
    }

    public String getServicoPrestadoSerie() {
        return servicoPrestadoSerie;
    }

    public void setServicoPrestadoSerie(String servicoPrestadoSerie) {
        this.servicoPrestadoSerie = servicoPrestadoSerie;
    }
}
