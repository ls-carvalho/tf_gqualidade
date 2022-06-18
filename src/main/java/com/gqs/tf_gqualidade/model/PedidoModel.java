/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.model;

import com.gqs.tf_gqualidade.dao.DescontoDAO;
import com.gqs.tf_gqualidade.dao.ImpostoDAO;
import com.gqs.tf_gqualidade.dao.PedidoDAO;
import com.gqs.tf_gqualidade.state.NovoState;
import com.gqs.tf_gqualidade.state.State;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class PedidoModel {

    private int numero;
    private LocalDateTime data;
    private double valorTotal;
    private double valorTotalImpostos;
    private double valorFinalAPagar;
    private double valorTotalDescontos;
    private State estado;
    private List<ItemDePedidoModel> cesta;
    private List<ItemDePedidoModel> itens;
    private List<ImpostoModel> impostos;
    private List<DescontoModel> descontos;
    private ClienteModel cliente;

    public PedidoModel(ClienteModel cliente) {
        this.numero = PedidoDAO.getInstance().getNroPedidos() + 1;
        this.data = LocalDateTime.now();
        this.valorTotal = 0;
        this.valorTotalImpostos = 0;
        this.valorFinalAPagar = 0;
        this.valorTotalDescontos = 0;
        this.estado = new NovoState(this);
        this.cesta = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.impostos = ImpostoDAO.getInstance().getImpostos();
        this.descontos = DescontoDAO.getInstance().getDescontos();
        this.cliente = cliente;
    }

    public void adicionarCesta(List<ItemDePedidoModel> cesta) {
        //adiciona a cesta na lista
        for (var item : cesta) { //this.getCesta().addAll(cesta);
            this.getCesta().add(item);
            //adiciona o valor a conta
            this.valorTotal += item.getProduto().getPrecoUnitario() * item.getQuantidade();
        }
        calculaValores();
    }

    public void removerCesta(List<ItemDePedidoModel> cesta) {
        for (var item : cesta) {
            if (!this.getCesta().contains(item)) {
                throw new RuntimeException("Esse pedido não contém essa cesta!");
            }
        }
        for (var item : cesta) {
            if (this.buscaItemPorProdutoCesta(item.getProduto()).getQuantidade() == item.getQuantidade()) {
                this.getCesta().remove(item);
                //remove o valor da conta
                this.valorTotal -= item.getProduto().getPrecoUnitario() * item.getQuantidade();
                calculaValores();
            } else if (this.buscaItemPorProdutoCesta(item.getProduto()).getQuantidade() > item.getQuantidade()) {
                this.buscaItemPorProdutoCesta(item.getProduto()).diminuirQuantidade(item.getQuantidade());
                //remove o valor a conta
                this.valorTotal -= item.getProduto().getPrecoUnitario() * item.getQuantidade();
                calculaValores();
            } else if (this.buscaItemPorProdutoCesta(item.getProduto()).getQuantidade() < item.getQuantidade()) {
                throw new RuntimeException("Não é possivel remover mais produtos do tipo " + item.getProduto().getNome() + "do que constam na cesta!");
            }
        }
    }

    public List<ItemDePedidoModel> getCesta() {
        return cesta;
    }

    public List<ImpostoModel> getImpostos() {
        return impostos;
    }

    public List<DescontoModel> getDescontos() {
        return descontos;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void esvaziarListaItens() {
        if (this.getItens().isEmpty()) {
            throw new RuntimeException("Não se pode esvaziar uma lista de produtos vazia!");
        }
        for (ItemDePedidoModel idp : this.getItens()) {
            this.removerItem(idp, idp.getQuantidade());
        }
    }

    public void adicionarItem(ItemDePedidoModel item) {
        //adiciona o item na lista
        this.getItens().add(item);
        //adiciona o valor a conta
        this.valorTotal += item.getProduto().getPrecoUnitario() * item.getQuantidade();
        calculaValores();
    }

    private void calculaValores() {
        this.valorFinalAPagar = this.valorTotal;
        //calcula os descontos e aplica-os
        this.valorTotalDescontos += calculaDescontos(valorFinalAPagar);
        this.valorFinalAPagar -= this.valorTotalDescontos;
        //calcula os impostos e aplica-os
        this.valorTotalImpostos += calculaImpostos(valorFinalAPagar);
        this.valorFinalAPagar += this.valorTotalImpostos;
    }

    private double calculaDescontos(double valorBase) {
        var perc = 0;
        for (DescontoModel desconto : this.descontos) {
            perc += desconto.getPercentual();
        }
        return (valorBase * perc) / 100;
    }

    private double calculaImpostos(double valorBase) {
        var perc = 0;
        for (ImpostoModel imposto : this.impostos) {
            perc += imposto.getPercentual();
        }
        return (valorBase * perc) / 100;
    }

    public ItemDePedidoModel buscaItemPorProdutoCesta(ProdutoModel produto) {
        for (ItemDePedidoModel idp : this.getCesta()) {
            if (idp.getProduto().getCodigo() == produto.getCodigo()) {
                return idp;
            }
        }
        throw new RuntimeException("Produto com o código " + produto.getCodigo() + " não encontrado na lista da cesta!");
    }

    public ItemDePedidoModel buscaItemPorProdutoItens(ProdutoModel produto) {
        for (ItemDePedidoModel idp : this.getItens()) {
            if (idp.getProduto().getCodigo() == produto.getCodigo()) {
                return idp;
            }
        }
        throw new RuntimeException("Produto com o código " + produto.getCodigo() + " não encontrado na lista de itens!");
    }

    public void removerItem(ItemDePedidoModel item, double quantidade) {
        if (this.getItens().contains(item)) {
            if (this.buscaItemPorProdutoItens(item.getProduto()).getQuantidade() == quantidade) {
                this.getItens().remove(item);
                //remove o valor a conta
                this.valorTotal -= item.getProduto().getPrecoUnitario() * item.getQuantidade();
                calculaValores();
            } else if (this.buscaItemPorProdutoItens(item.getProduto()).getQuantidade() > quantidade) {
                this.buscaItemPorProdutoItens(item.getProduto()).diminuirQuantidade(quantidade);
                //remove o valor a conta
                this.valorTotal -= item.getProduto().getPrecoUnitario() * quantidade;
                calculaValores();
            } else if (this.buscaItemPorProdutoItens(item.getProduto()).getQuantidade() < quantidade) {
                throw new RuntimeException("Não é possivel remover mais produtos do tipo " + item.getProduto().getNome() + "do que constam na lista!");
            }
        } else {
            throw new RuntimeException("Produto com o código " + item.getProduto().getCodigo() + " não encontrado na lista de itens!");
        }
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public List<ItemDePedidoModel> getItens() {
        return itens;
    }

    public void alterarState(State estado) {
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
