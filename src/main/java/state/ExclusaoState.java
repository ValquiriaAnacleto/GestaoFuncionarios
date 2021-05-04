/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import command.ExcluirFuncionarioCommand;
import presenter.BuscarFuncionarioPresenter;
import presenter.InclusaoFuncionarioPresenter;
import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class ExclusaoState  extends FuncionarioPresenterState {

    public ExclusaoState(InclusaoFuncionarioPresenter presenter) {
        super(presenter);
    }



    
    
     @Override
    public void excluir() {
        new ExcluirFuncionarioCommand().execute(presenter);
    }
    @Override
    public void cancelar() {
          presenter.getView().dispose();
    }
    
    
    
}
