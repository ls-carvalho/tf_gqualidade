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
public class NovoState extends State {

    public NovoState(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //validação do formulário
        super.getPedido().alterarState(new AguardandoPagamentoState(super.getPedido()));
    }

    @Override
    public void incluir() {
        //realiza a inclusão
    }

    @Override
    public void remover() {
        //realiza a remoção
    }

    @Override
    public void cancelar() {
        super.getPedido().alterarState(new CanceladoPeloCliente(super.getPedido()));
    }

}
