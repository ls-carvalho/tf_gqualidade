/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade;

import com.gqs.tf_gqualidade.business.Business;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Business b = new Business();
        
        b.criarPedido();//crio o pedido no estágio de 'Novo'
        
        b.getPedido().getEstado().incluir(1, 2);//incluo produtos
        b.getPedido().getEstado().incluir(1, 1);//incluo produtos
        b.getPedido().getEstado().incluir(13, 1);//incluo produtos
        
        b.getPedido().getEstado().remover(1, 1);//removo produtos
        
        b.getPedido().getEstado().incluir(6, 2);//incluo produtos
        
        b.getPedido().getEstado().concluir();//conclui o pedido e avança para o estágio de 'Aguardando Pagamento'
        
        b.getPedido().getEstado().concluir();//avança para 'Confirmado'
        
        b.getPedido().getEstado().concluir();//avança para 'Pronto para Entrega'
        
        b.getPedido().getEstado().concluir();//avança para 'Em Rota de Entrega'
        
        b.getPedido().getEstado().concluir();//avança para 'Entregue'
        
        b.getPedido().getEstado().concluir();//Operação finalizada
    }
}
