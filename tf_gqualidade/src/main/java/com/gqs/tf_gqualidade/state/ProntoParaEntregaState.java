/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.folder.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class ProntoParaEntregaState extends State {

    public ProntoParaEntregaState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //aprova a operação
        System.out.println("Operação aprovada!");
        //muda de estado
        super.getPedido().alterarState(new EmRotaDeEntregaState(super.getPedido()));
    }

    @Override
    public void cancelar() {
        //cancela a operação
        System.out.println("Operação cancelada!");
        //muda de estado
        super.getPedido().alterarState(new CanceladoPeloEstabelecimentoState(super.getPedido()));
    }
}
