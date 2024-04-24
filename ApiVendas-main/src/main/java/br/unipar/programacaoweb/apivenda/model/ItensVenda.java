package br.unipar.programacaoweb.apivenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private BigDecimal valor_unitario;

    @Column(length = 20)
    private BigDecimal valor_total;

    @Column(length = 20)
    private BigDecimal quantidade;

    @Column(length = 20)
    private Integer fk_produto_id;

    @Column(length = 20)
    private Integer fk_Venda_id;

}
