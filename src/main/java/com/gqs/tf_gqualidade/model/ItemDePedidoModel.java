/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.model;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class ItemDePedidoModel {

    private ProdutoModel produto;
    private double quantidade;
    private double valorUnitario;
    private double valorTotal;

    public ItemDePedidoModel(ProdutoModel produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getPrecoUnitario();
        this.valorTotal = this.quantidade * this.valorUnitario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void aumentarQuantidade(double adicao){
        if(adicao > 0){
            this.quantidade += adicao;
        }else{
            throw new RuntimeException("Não pode-se adicionar 0 ou menos elementos no pedido!");
        }
    }
    
    public void diminuirQuantidade(double diminuicao){
        if(diminuicao <= this.quantidade){
            this.quantidade -= diminuicao;
        }else{
            throw new RuntimeException("Não se pode remover um valor maior que existe no pedido!");
        }
    }
    
}
