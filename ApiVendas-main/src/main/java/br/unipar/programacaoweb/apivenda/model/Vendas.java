package br.unipar.programacaoweb.apivenda.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private BigDecimal total;

    @Column(length = 20)
    private String observacoes;

    @Column(length = 20)
    private Integer fk_cliente_id;

}
