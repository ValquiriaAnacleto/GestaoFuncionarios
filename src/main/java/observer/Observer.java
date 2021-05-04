/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author Valquíria Anacleto
 */
public interface Observer {
      public void update(ArrayList<Funcionario> funcionarios);
}
