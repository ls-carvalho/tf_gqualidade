/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.builder;

import com.gqs.tf_gqualidade.dao.ProdutoDAO;
import com.gqs.tf_gqualidade.model.ItemDePedidoModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class TopBuilder implements ICestaBuilder {

    private List<ItemDePedidoModel> itens = new ArrayList<>();

    @Override
    public void addOrigemAnimal() {
        //add 1 KG de Carne Bovina
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(28), 1));
        //add Sardinha
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(21), 1));
        //add Leite Integral UHT 1 Litro
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(32), 2));
    }

    @Override
    public void addGraos() {
        //add Arroz Agulhinha Tipo 1
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(3), 6));
        //add Café Torrado e Moído
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(6), 1));
        //add Farinha de Trigo
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(9), 1));
        //add Feijão Carioca Tipo 1
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(11), 3));
        //add Fubá Mimoso
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(12), 1));
    }

    @Override
    public void addIndustrializados() {
        //add Açúcar Refinado
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(2), 1));
        //add Biscoito Recheado (Sabores)
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(4), 1));
        //add Macarrão Espaguete
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(14), 1));
        //add Óleo de Soja
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(17), 2));
        //add Sal Refinado
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(20), 1));
        //add Macarrão Parafuso
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(15), 1));
    }

    @Override
    public void addLegumesEFrutas() {
        //add Polpa de Tomate
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(19), 1));
    }

    @Override
    public List<ItemDePedidoModel> getItens() {
        return this.itens;
    }

}
