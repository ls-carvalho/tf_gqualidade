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
public class BasicaBuilder implements ICestaBuilder {

    private List<ItemDePedidoModel> itens = new ArrayList<>();

    @Override
    public void addOrigemAnimal() {
        //add 1 KG de Carne Suína
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(29), 1));
    }

    @Override
    public void addGraos() {
        //add Arroz Agulhinha Tipo 1
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(3), 1));
        //add Café Torrado e Moído
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(6), 1));
        //add Farinha de Trigo
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(9), 1));
        //add Feijão Carioca Tipo 1
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(11), 1));
    }

    @Override
    public void addIndustrializados() {
        //add Achocolatado em Pó
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(1), 1));
        //add Açúcar Refinado
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(2), 1));
        //add Biscoito Recheado (Sabores)
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(4), 1));
        //add Leite em Pó Integral
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(13), 1));
        //add Macarrão Espaguete
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(14), 1));
        //add Óleo de Soja
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(17), 1));
        //add Sal Refinado
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(20), 1));
        //add Agua Sanitária 1 Litro
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(38), 1));
        //add Creme Dental
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(24), 1));
        //add Detergente Liquido
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(39), 1));
        //add Lã de Aço
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(40), 1));
        //add Papel Higiênico
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(26), 1));
        //add Sabão em Pedra 200G
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(41), 1));
        //add Sabão em Pó Triplação 450G
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(42), 1));
        //add Sabonete (Fragrâncias)
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(27), 1));
    }

    @Override
    public void addLegumesEFrutas() {
        //add Farinha de Mandioca Temperada
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(10), 1));
        //add Polpa de Tomate
        this.itens.add(new ItemDePedidoModel(ProdutoDAO.getInstance().buscaProdutoPorCodigo(19), 1));
    }

    @Override
    public List<ItemDePedidoModel> getItens() {
        return this.itens;
    }

}
