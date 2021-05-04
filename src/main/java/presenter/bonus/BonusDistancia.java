/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.bonus;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bonus;
import model.Funcionario;

/**
 *
 * @author Valquíria Anacleto
 */
public class BonusDistancia implements CalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        double distancia= funcionario.getDistanciaServico();
        double salario = funcionario.getSalario();
        double percentualBonus = 0;
        
         if (distancia> 150) {
            percentualBonus = 0.20;
        } else if (distancia> 100) {
           percentualBonus = 0.10;
        } else if (distancia> 50) {
           percentualBonus = 0.05;
        }
         
         
        double salarioBase = funcionario.getSalario();
        double valorBonus = salarioBase * percentualBonus;
        
         Bonus bonus = new Bonus("Distancia Serviço", valorBonus);
        try {
            funcionario.addBonus(bonus);
        } catch (Exception ex) {
            Logger.getLogger(BonusDistancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
