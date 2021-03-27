package com.mercurio.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;
    private String description;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    private Metadata metadata;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<MetadataList> metadataList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
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

    public String getServicoPrestadoSerie() {
        return servicoPrestadoSerie;
    }

    public void setServicoPrestadoSerie(String servicoPrestadoSerie) {
        this.servicoPrestadoSerie = servicoPrestadoSerie;
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

    public List<MetadataList> getMetadataList() {
        return metadataList;
    }

    public void setMetadataList(List<MetadataList> metadataList) {
        this.metadataList = metadataList;
    }
}
