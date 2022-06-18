/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.dao;

import com.gqs.tf_gqualidade.folder.Desconto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class DescontoDAO {

    private ArrayList<Desconto> descontos;
    private static DescontoDAO instance;

    private DescontoDAO() {
        descontos = new ArrayList<>();
        descontos.add(new Desconto("Promoção de Natal", 3));
        descontos.add(new Desconto("Desconto por tipo de produto (Papelaria)", 1));
        descontos.add(new Desconto("Desconto incentivo educação (Lápis)", 0.5));
    }

    public static DescontoDAO getInstance() {
        if (instance == null) {
            instance = new DescontoDAO();
        }
        return instance;
    }

    public void adicionaDesconto(Desconto desconto) {
        if (!this.getDescontos().contains(desconto)) {
            this.descontos.add(desconto);
        } else {
            throw new RuntimeException("Desconto " + desconto.getTipo()+ " já existente na lista!");
        }
    }

    public void removeDesconto(Desconto desconto) {
        if (this.getDescontos().contains(desconto)) {
            this.descontos.remove(desconto);
        } else {
            throw new RuntimeException("Desconto " + desconto.getTipo() + " não existente na lista!");
        }
    }

    public Desconto buscaDescontoPorNome(String nome) {
        for (Desconto desconto : descontos) {
            if (desconto.getTipo().equalsIgnoreCase(nome)) {
                return desconto;
            }
        }
        throw new RuntimeException("Desconto " + nome + " não encontrado!");
    }

    public List<Desconto> getDescontos() {
        return Collections.unmodifiableList(this.descontos);
    }

    public int getNroDescontos() {
        return this.descontos.size();
    }
}
