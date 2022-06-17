/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import com.gqs.tf_gqualidade.Model.Pedido;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class CanceladoPeloEstabelecimento extends State {

    public CanceladoPeloEstabelecimento(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //reposição dos produtos
        super.getPedido().alterarState(new Reembolsado(super.getPedido()));
    }
}
