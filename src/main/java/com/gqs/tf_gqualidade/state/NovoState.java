/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.builder.BasicaBuilder;
import com.gqs.tf_gqualidade.builder.EconimicaBuilder;
import com.gqs.tf_gqualidade.builder.EmpacotadorBuilder;
import com.gqs.tf_gqualidade.builder.ICestaBuilder;
import com.gqs.tf_gqualidade.builder.TopBuilder;
import com.gqs.tf_gqualidade.model.ItemDePedidoModel;
import com.gqs.tf_gqualidade.model.PedidoModel;
import com.gqs.tf_gqualidade.dao.PedidoDAO;
import com.gqs.tf_gqualidade.dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class NovoState extends State {

    public NovoState(PedidoModel pedido) {
        super(pedido);
        //System.out.println("Novo pedido!");
    }

    @Override
    public void concluir() {
        //validação do formulário
        if (super.getPedido().getQuantidadeItens() > 0) {
            //confirmar pedido
            //System.out.println("Pedido confirmado!");
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
        this.getPedido().adicionarItem(new ItemDePedidoModel(produto, quantidade));
        //confirma operação
        //System.out.println(quantidade + " unidades do produto " + produto.getNome() + " adicionado com sucesso!");
    }

    @Override
    public void incluir(int tipoCesta) throws Exception {
        //realiza a inclusão
        List<ItemDePedidoModel> itens;
        String tipo;
        switch (tipoCesta) {
            case 1: {
                //Cesta Economica
                tipo = "Econômica";
                ICestaBuilder builder = new EconimicaBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            case 2: {
                //Básica
                tipo = "Básica";
                ICestaBuilder builder = new BasicaBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            case 3: {
                //TOP
                tipo = "TOP";
                ICestaBuilder builder = new TopBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            default:
                throw new RuntimeException("Tipo inválido de cesta!");
        }
        //remove do estoque
        for (var item : itens) {
            ProdutoDAO.getInstance().baixaEstoque(item.getProduto().getCodigo(), item.getQuantidade());
        }
        //adiciono na cesta
        this.getPedido().adicionarCesta(itens);
        //confirma operação
        //System.out.println("Cesta " + tipo + " adicionada com sucesso!");
    }

    @Override
    public void remover(int codigo, double quantidade) throws Exception {
        //realiza a remoção
        var produto = ProdutoDAO.getInstance().buscaProdutoPorCodigo(codigo);
        var idp = this.getPedido().buscaItemPorProdutoItens(produto);
        //remove o item da lista
        this.getPedido().removerItem(idp, quantidade);
        //devolve ao estoque
        ProdutoDAO.getInstance().adicionaEstoque(codigo, quantidade);
        //confirma a operação
        //System.out.println(quantidade + " unidades do produto " + produto.getNome() + " removido com sucesso!");
    }

    @Override
    public void remover(int tipoCesta) throws Exception {
        //realiza a remoção
        List<ItemDePedidoModel> itens;
        String tipo;
        switch (tipoCesta) {
            case 1: {
                //Cesta Economica
                tipo = "Econômica";
                ICestaBuilder builder = new EconimicaBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            case 2: {
                //Básica
                tipo = "Básica";
                ICestaBuilder builder = new BasicaBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            case 3: {
                //TOP
                tipo = "TOP";
                ICestaBuilder builder = new TopBuilder();
                EmpacotadorBuilder empacotador = new EmpacotadorBuilder(builder);
                empacotador.empacotarCesta();
                itens = builder.getItens();
                break;
            }
            default:
                throw new RuntimeException("Tipo inválido de cesta!");
        }
        //remove o item da lista
        this.getPedido().removerCesta(itens);
        //devolve ao estoque
        for (var item : itens) {
            ProdutoDAO.getInstance().adicionaEstoque(item.getProduto().getCodigo(), item.getQuantidade());
        }
        //confirma a operação
        //System.out.println("Cesta " + tipo + " removido com sucesso!");
    }

    @Override
    public void cancelar() {
        //cancela a operação
        //System.out.println("Operação cancelada!");
        //muda de estado
        super.getPedido().alterarState(new CanceladoPeloClienteState(super.getPedido()));
    }

}
