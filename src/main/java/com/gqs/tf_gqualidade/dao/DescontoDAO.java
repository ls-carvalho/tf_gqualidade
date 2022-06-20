/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.dao;

import com.gqs.tf_gqualidade.model.DescontoModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class DescontoDAO {

    private ArrayList<DescontoModel> descontos;
    private static DescontoDAO instance;

    private DescontoDAO() {
        descontos = new ArrayList<>();
        descontos.add(new DescontoModel("Promoção de Natal", 3));
        descontos.add(new DescontoModel("Desconto por tipo de produto (Papelaria)", 1));
        descontos.add(new DescontoModel("Desconto incentivo educação (Lápis)", 0.5));
    }

    public static DescontoDAO getInstance() {
        if (instance == null) {
            instance = new DescontoDAO();
        }
        return instance;
    }

    public List<DescontoModel> getDescontos() {
        return Collections.unmodifiableList(this.descontos);
    }

}
