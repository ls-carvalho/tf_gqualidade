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
public class ConfirmadoState extends State {

    public ConfirmadoState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        super.getPedido().alterarState(new ProntoParaEntrega(super.getPedido()));
    }

    @Override
    public void cancelar() {
        super.getPedido().alterarState(new CanceladoPeloEstabelecimento(super.getPedido()));
    }

}
