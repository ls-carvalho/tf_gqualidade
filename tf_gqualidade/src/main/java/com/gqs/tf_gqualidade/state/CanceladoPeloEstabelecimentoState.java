/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.state;

import com.gqs.tf_gqualidade.folder.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class CanceladoPeloEstabelecimentoState extends State {

    public CanceladoPeloEstabelecimentoState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //devolver os produtos pro estoque (remoção de itens do pedido)
        super.getPedido().esvaziarListaItens();
        //avança para o proximo estágio
        super.getPedido().alterarState(new ReembolsadoState(super.getPedido()));
    }
}
