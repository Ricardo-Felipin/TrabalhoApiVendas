package br.unipar.programacaoweb.apivenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String descricao;

    @Column(length = 20)
    private BigDecimal valor_unitario;


}
