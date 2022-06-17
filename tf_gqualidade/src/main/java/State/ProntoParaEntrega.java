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
public class ProntoParaEntrega extends State {

    public ProntoParaEntrega(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        super.getPedido().alterarState(new EmRotaDeEntrega(super.getPedido()));
    }

    @Override
    public void cancelar() {
        super.getPedido().alterarState(new CanceladoPeloEstabelecimento(super.getPedido()));
    }
}
