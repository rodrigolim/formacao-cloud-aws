package br.com.apiproduto.entity;

import lombok.Data;
import org.apache.el.lang.ELArithmetic;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    private BigDecimal valor;
    @Column
    private String descricao;

}
