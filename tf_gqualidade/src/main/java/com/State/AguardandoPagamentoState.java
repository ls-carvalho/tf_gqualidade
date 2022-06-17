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
public class AguardandoPagamentoState extends State {

    public AguardandoPagamentoState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //bussiness logic de remoção do estoque
        super.getPedido().alterarState(new ConfirmadoState(super.getPedido()));
    }

    @Override
    public void cancelar() {
        super.getPedido().alterarState(new CanceladoPeloCliente(super.getPedido()));
    }

}
