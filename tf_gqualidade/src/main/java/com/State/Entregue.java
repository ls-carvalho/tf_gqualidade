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
public class Entregue extends State {

    public Entregue(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void concluir() {
        //avaliação do cliente
        //pedido finalizado
    }
}
