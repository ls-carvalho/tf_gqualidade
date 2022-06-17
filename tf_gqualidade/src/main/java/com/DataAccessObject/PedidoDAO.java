/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import com.gqs.tf_gqualidade.Model.Pedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class PedidoDAO {

    private ArrayList<Pedido> pedidos;
    private static PedidoDAO instance;

    private PedidoDAO() {
        pedidos = new ArrayList<>();
    }

    public static PedidoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoDAO();
        }
        return instance;
    }

    void adicionaPedido(Pedido pedido) {
        //valida campos
        pedidos.add(pedido);
    }

    void removePedido(Pedido pedido) {
        //busca o pedido
        pedidos.remove(pedido);
    }

    public Pedido buscaPedidoPorNumero(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        throw new RuntimeException("Pedido com o número " + numero + " não encontrado!");
    }

    public List<Pedido> getProdutos() {
        return Collections.unmodifiableList(pedidos);
    }

    public int getNroProdutos() {
        return pedidos.size();
    }

}
