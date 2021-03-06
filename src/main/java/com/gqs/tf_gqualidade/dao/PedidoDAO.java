/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.dao;

import com.gqs.tf_gqualidade.model.PedidoModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class PedidoDAO {

    private ArrayList<PedidoModel> pedidos;
    private static PedidoDAO instance;

    private PedidoDAO() {
        pedidos = new ArrayList<>();
    }

    public static PedidoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoDAO();
        }
        return instance;
    }

    public void adicionaPedido(PedidoModel pedido) {
        //valida campos
        pedidos.add(pedido);
    }

    public int getNroPedidos() {
        return pedidos.size();
    }

}
