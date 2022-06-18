/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.business;

import com.gqs.tf_gqualidade.folder.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Business {

    private Pedido pedido;

    public void criarPedido() {
        this.pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }

}
