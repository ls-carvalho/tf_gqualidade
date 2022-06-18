/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.business;

import com.gqs.tf_gqualidade.model.Cliente;
import com.gqs.tf_gqualidade.model.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Business {

    private Pedido pedido;

    public void criarPedido(String nomeCliente) {
        var cliente = new Cliente(nomeCliente);
        this.pedido = new Pedido(cliente);
    }

    public Pedido getPedido() {
        return pedido;
    }

}
