/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gqs.tf_gqualidade.builder;

import com.gqs.tf_gqualidade.model.ItemDePedidoModel;
import java.util.List;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public interface ICestaBuilder {
    
    public List<ItemDePedidoModel> getItens();

    public void addOrigemAnimal();

    public void addGraos();

    public void addIndustrializados();

    public void addLegumesEFrutas();
}
