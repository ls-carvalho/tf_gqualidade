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
public abstract class State {

    private Pedido pedido;

    public State(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void concluir() { //avança para o proximo estágio do State
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }

    public void incluir() { //avança para o proximo estágio do State
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }

    public void remover() { //avança para o proximo estágio do State
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }

    public void cancelar() { //regride para o outro estágio do State
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }

}
