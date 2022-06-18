/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.dao;

import com.gqs.tf_gqualidade.folder.Imposto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class ImpostoDAO {

    private ArrayList<Imposto> impostos;
    private static ImpostoDAO instance;

    private ImpostoDAO() {
        impostos = new ArrayList<>();
        impostos.add(new Imposto("ISS", 2));
        impostos.add(new Imposto("ICMS", 7));
    }

    public static ImpostoDAO getInstance() {
        if (instance == null) {
            instance = new ImpostoDAO();
        }
        return instance;
    }

    public void adicionaImposto(Imposto imposto) {
        if (!this.getImpostos().contains(imposto)) {
            this.impostos.add(imposto);
        } else {
            throw new RuntimeException("Imposto " + imposto.getNome() + " já existente na lista!");
        }
    }

    public void removeImposto(Imposto imposto) {
        if (this.getImpostos().contains(imposto)) {
            this.impostos.remove(imposto);
        } else {
            throw new RuntimeException("Imposto " + imposto.getNome() + " não existente na lista!");
        }
    }

    public Imposto buscaImpostoPorNome(String nome) {
        for (Imposto imposto : impostos) {
            if (imposto.getNome().equalsIgnoreCase(nome)) {
                return imposto;
            }
        }
        throw new RuntimeException("Imposto " + nome + " não encontrado!");
    }

    public List<Imposto> getImpostos() {
        return Collections.unmodifiableList(this.impostos);
    }

    public int getNroImpostos() {
        return this.impostos.size();
    }
}
