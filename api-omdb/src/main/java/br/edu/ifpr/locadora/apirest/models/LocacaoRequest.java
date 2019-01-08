
package br.edu.ifpr.locadora.apirest.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
    "cliente",
    "data",
    "devolucao",
    "valor",
    "filme"
})
public class LocacaoRequest {

	@JsonProperty("id")
    private long id;
    @JsonProperty("cliente")
    private long cliente;
    @JsonProperty("data")
    private Date data;
    @JsonProperty("devolucao")
    private Date devolucao;
    @JsonProperty("valor")
    private BigDecimal valor;
    @JsonProperty("filme")
    private String filme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }
    
    @JsonProperty("cliente")
    public long getCliente() {
        return cliente;
    }

    @JsonProperty("cliente")
    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    @JsonProperty("data")
    public Date getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Date data) {
        this.data = data;
    }

    @JsonProperty("devolucao")
    public Date getDevolucao() {
        return devolucao;
    }

    @JsonProperty("devolucao")
    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    @JsonProperty("valor")
    public BigDecimal getValor() {
        return valor;
    }

    @JsonProperty("valor")
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @JsonProperty("filme")
    public String getFilme() {
        return filme;
    }

    @JsonProperty("filme")
    public void setFilme(String filme) {
        this.filme = filme;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}