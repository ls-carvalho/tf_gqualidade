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
public class EmRotaDeEntregaState extends State {

    public EmRotaDeEntregaState(Pedido pedido) {
        super(pedido);
    }
    
    @Override
    public void concluir() {
        //conclui a operação
        System.out.println("Operação concluida!");
        //muda de estado
        super.getPedido().alterarState(new EntregueState(super.getPedido()));
    }
}
