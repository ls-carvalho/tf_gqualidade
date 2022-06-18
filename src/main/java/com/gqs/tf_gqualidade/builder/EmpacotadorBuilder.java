/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.builder;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class EmpacotadorBuilder {

    private ICestaBuilder builder;

    public EmpacotadorBuilder(ICestaBuilder builder) {
        this.builder = builder;
    }

    public ICestaBuilder getBuilder() {
        return builder;
    }

    public void empacotarCesta() {
        this.builder.addGraos();
        this.builder.addIndustrializados();
        this.builder.addLegumesEFrutas();
        this.builder.addOrigemAnimal();
    }
}
