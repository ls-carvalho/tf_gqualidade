/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.model.ItemDePedido;
import com.gqs.tf_gqualidade.model.Pedido;
import com.gqs.tf_gqualidade.dao.PedidoDAO;
import com.gqs.tf_gqualidade.dao.ProdutoDAO;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class NovoState extends State {

    public NovoState(Pedido pedido) {
        super(pedido);
        System.out.println("Novo pedido!");
    }

    @Override
    public void concluir() {
        //validação do formulário
        if (super.getPedido().getQuantidadeItens() > 0) {
            //confirmar pedido
            System.out.println("Pedido confirmado!");
            //incluir na PedidoDAO
            PedidoDAO.getInstance().adicionaPedido(super.getPedido());
            //avança de estado
            super.getPedido().alterarState(new AguardandoPagamentoState(super.getPedido()));
        } else {
            //negar pedido
            throw new RuntimeException("Não se pode realizar pedido com zero itens!");
        }
    }

    @Override
    public void incluir(int codigo, double quantidade) throws Exception {
        //realiza a inclusão
        var produto = ProdutoDAO.getInstance().buscaProdutoPorCodigo(codigo);
        //remove do estoque
        ProdutoDAO.getInstance().baixaEstoque(codigo, quantidade);
        //adiciono na lista de produtos
        this.getPedido().adicionarItem(new ItemDePedido(produto, quantidade));
        //confirma operação
        System.out.println(quantidade + " unidades do produto " + produto.getNome() + " adicionado com sucesso!");
    }

    @Override
    public void remover(int codigo, double quantidade) throws Exception {
        //realiza a remoção
        var produto = ProdutoDAO.getInstance().buscaProdutoPorCodigo(codigo);
        var idp = this.getPedido().buscaItemPorProduto(produto);
        //remove o item da lista
        this.getPedido().removerItem(idp, quantidade);
        //devolve ao estoque
        ProdutoDAO.getInstance().adicionaEstoque(codigo, quantidade);
        //confirma a operação
        System.out.println(quantidade + " unidades do produto " + produto.getNome() + " removido com sucesso!");

    }

    @Override
    public void cancelar() {
        //cancela a operação
        System.out.println("Operação cancelada!");
        //muda de estado
        super.getPedido().alterarState(new CanceladoPeloClienteState(super.getPedido()));
    }

}
