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
import presenter.bonus.CalculaBonus;

/**
 *
 * @author Valquíria Anacleto
 */
public class BonusTempoServico implements CalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        int tempo = funcionario.getTempoServicoEmAnos();
        double percentualBonus = 0;

        if (tempo == 0) {
            percentualBonus = 0.00;
        } else if (tempo >= 1 && tempo <= 5) {
            percentualBonus = 0.02;
        } else if (tempo >= 6 && tempo <= 10) {
            percentualBonus = 0.03;
        } else if (tempo >= 11 && tempo <= 15) {
            percentualBonus = 0.08;
        } else if (tempo >= 16 && tempo <= 20) {
            percentualBonus = 0.10;
        } else if (tempo >20) {
            percentualBonus = 0.15;
        }
        
        double salarioBase = funcionario.getSalario();
        double valorBonus = salarioBase * percentualBonus;
        
         Bonus bonus = new Bonus("Tempo de Serviço (Anos)", valorBonus);
        try {
            funcionario.addBonus(bonus);
        } catch (Exception ex) {
            Logger.getLogger(BonusTempoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
