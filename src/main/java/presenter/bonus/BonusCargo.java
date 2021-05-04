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
public class BonusCargo implements CalculaBonus{

    @Override
    public void calcular(Funcionario funcionario) {
          String cargo = funcionario.getCargo();

        if (cargo.toUpperCase().equals("GERENTE")) {
              try {
                  funcionario.addBonus(new Bonus("Cargo:" + cargo, 100));
              } catch (Exception ex) {
                  Logger.getLogger(BonusCargo.class.getName()).log(Level.SEVERE, null, ex);
              }
        } else if (cargo.toUpperCase().compareTo("SECRETARIA") == 0) {
              try {
                  funcionario.addBonus(new Bonus("Cargo:" + cargo, 80));
              } catch (Exception ex) {
                  Logger.getLogger(BonusCargo.class.getName()).log(Level.SEVERE, null, ex);
              }
        } else if (cargo.toUpperCase().compareTo("PROGRAMADOR") == 0) {
              try {
                  funcionario.addBonus(new Bonus("Cargo:" + cargo, 50));
              } catch (Exception ex) {
                  Logger.getLogger(BonusCargo.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        
    }
    
}
