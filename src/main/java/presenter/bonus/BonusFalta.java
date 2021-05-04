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
public class BonusFalta implements CalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        int faltas = funcionario.getNumeroFaltas();
        double salario = funcionario.getSalario();
        double percentualBonus = 0;
       
         if (faltas == 0) {
            percentualBonus = 0.10;
        } else if (faltas >=1 && faltas <= 3) {
            percentualBonus = 0.05;
        } else if (faltas >= 4 && faltas <= 5) {
            percentualBonus = 0.01;
        } else if (faltas >6) {
            percentualBonus = 0.01;
            

    }
          double valorBonus = salario * percentualBonus;
         Bonus bonus = new Bonus("Assiduidade", valorBonus);
        try {
            funcionario.addBonus(bonus);
        } catch (Exception ex) {
            Logger.getLogger(BonusFalta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
