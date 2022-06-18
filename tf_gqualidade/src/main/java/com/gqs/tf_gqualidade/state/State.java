/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.model.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public abstract class State {

    private static final String ERRO_1 = "Não é possivel usar esse metodo neste estado.";  // Compliant
    private Pedido pedido;

    protected State(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void concluir() { //avança para o proximo estágio do State
        throw new RuntimeException(ERRO_1);
    }

    public void incluir(int codigo, double quantidade) throws Exception { //avança para o proximo estágio do State
        throw new RuntimeException(ERRO_1);
    }

    public void remover(int codigo, double quantidade) throws Exception { //avança para o proximo estágio do State
        throw new RuntimeException(ERRO_1);
    }

    public void cancelar() { //regride para o outro estágio do State
        throw new RuntimeException(ERRO_1);
    }

}
