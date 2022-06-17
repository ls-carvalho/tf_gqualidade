/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.Model;

import State.NovoState;
import State.State;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Pedido {
    private int numero;
    private LocalDateTime data;
    private double valorTotal;
    private double valorTotalImpostos;
    private double valorFinalAPagar;
    private double valorTotalDescontos;
    private State estado;
    private List itemPedido;

    public Pedido() {
        this.estado = new NovoState(this);
        this.itemPedido = new ArrayList();
    }

    public List getItemPedido() {
        return itemPedido;
    }
    
    public void alterarState(State estado){
        this.estado = estado;
    }

    public State getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotalImpostos() {
        return valorTotalImpostos;
    }

    public void setValorTotalImpostos(double valorTotalImpostos) {
        this.valorTotalImpostos = valorTotalImpostos;
    }

    public double getValorFinalAPagar() {
        return valorFinalAPagar;
    }

    public void setValorFinalAPagar(double valorFinalAPagar) {
        this.valorFinalAPagar = valorFinalAPagar;
    }

    public double getValorTotalDescontos() {
        return valorTotalDescontos;
    }

    public void setValorTotalDescontos(double valorTotalDescontos) {
        this.valorTotalDescontos = valorTotalDescontos;
    }
    
    
}
