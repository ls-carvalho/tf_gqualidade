/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gqs.tf_gqualidade.util;

import java.util.Scanner;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class AvaliacaoUtil {

    private AvaliacaoUtil() {
    }
    
    public static void avaliacao() {
        //System.out.println("Por favor, avalie o Atendimento do Pedido entre 1 e 5.");
        int avaliacao;
        try ( var sc = new Scanner(System.in)) {
            do {
                //System.out.println("Insira um número de 1 a 5!");
                //avaliacao = sc.nextInt(); //removido pra testes
                avaliacao = 5;
            } while (avaliacao < 1 || avaliacao > 5);
        }
        //System.out.println("Avaliação final do usuário: " + avaliacao + "!");
    }
}
