/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import collection.FuncionarioColletion;
import model.Funcionario;
import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class RecuperarRegistroFuncionarioCommand  extends Command{

   private FuncionarioColletion funcionarios;


      @Override
    public void execute(InclusaoFuncionarioPresenter presenter) {
        if (funcionarios.getFuncionarios() != null) {
            
            Funcionario funcionario = (Funcionario) funcionarios.getFuncionarios() ;
            InclusaoFuncionarioPresenter   inclusaoFuncionarioPresenter  = new  InclusaoFuncionarioPresenter (presenter.getFuncionario());
            
            
        }
    };

   
}
    

