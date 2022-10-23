package com.jeanlima.springrestapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "estoque", fetch = FetchType.LAZY)
    private Set<Produto> produtos;

    @Column
    private Integer quantidade;


    public Estoque() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", produtos='" + getProdutos() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            "}";
    }
   

}
