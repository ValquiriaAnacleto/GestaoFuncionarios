/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Valquíria Anacleto
 */
public class Bonus {
    private String tipo;
    private double valor;
    private String data;

    public Bonus(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
     
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Bonus{" + "tipo=" + tipo + ", valor=" + valor + ", data=" + data + '}';
    }
    
    
}
