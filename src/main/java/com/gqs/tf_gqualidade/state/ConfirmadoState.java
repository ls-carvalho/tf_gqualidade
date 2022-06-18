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
public class ConfirmadoState extends State {

    public ConfirmadoState(PedidoModel pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //aprova a operação
        System.out.println("Operação concluida!");
        //muda de estado
        super.getPedido().alterarState(new ProntoParaEntregaState(super.getPedido()));
    }

    @Override
    public void cancelar() {
        //cancela a operação
        System.out.println("Operação cancelada!");
        //muda de estado
        super.getPedido().alterarState(new CanceladoPeloEstabelecimentoState(super.getPedido()));
    }

}
