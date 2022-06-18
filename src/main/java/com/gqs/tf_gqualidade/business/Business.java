/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.business;

import com.gqs.tf_gqualidade.model.ClienteModel;
import com.gqs.tf_gqualidade.model.PedidoModel;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Business {

    private PedidoModel pedido;

    public void criarPedido(String nomeCliente) {
        var cliente = new ClienteModel(nomeCliente);
        this.pedido = new PedidoModel(cliente);
    }

    public PedidoModel getPedido() {
        return pedido;
    }

}
