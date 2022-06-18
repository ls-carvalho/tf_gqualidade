/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.Model;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class Desconto {
    private String tipo;
    private double valorDesconto;
    private double percentual;

    public Desconto(String tipo, double percentual) {
        this.tipo = tipo;
        this.percentual = percentual;
        this.valorDesconto = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
    
    
}
