/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.model.Pedido;
import com.gqs.tf_gqualidade.util.AvaliacaoUtil;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class ReembolsadoState extends State {

    public ReembolsadoState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //conclui a operação
        System.out.println("Operação concluida!");
        //avaliação do cliente
        AvaliacaoUtil.avaliacao();
        //pedido finalizado
        System.out.println("Pedido Finalizado!");
    }
}
