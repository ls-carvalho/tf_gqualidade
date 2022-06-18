/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.model.PedidoModel;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public abstract class State {

    private static final String ERRO_1 = "Não é possivel usar esse metodo neste estado.";  // Compliant
    private PedidoModel pedido;

    protected State(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void concluir() { //avança para o proximo estágio do State
        throw new RuntimeException(ERRO_1);
    }

    public void incluir(int codigo, double quantidade) throws Exception { //inclui um elemento no pedido
        throw new RuntimeException(ERRO_1);
    }
    
    public void incluir(int tipo) throws Exception { //inclui uma cesta no pedido
        throw new RuntimeException(ERRO_1);
    }

    public void remover(int codigo, double quantidade) throws Exception { //remove o elemento do pedido
        throw new RuntimeException(ERRO_1);
    }

    public void remover(int tipo) throws Exception { //remove uma cesta do pedido
        throw new RuntimeException(ERRO_1);
    }
    
    public void cancelar() { //regride para o outro estágio do State
        throw new RuntimeException(ERRO_1);
    }

}
