/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import command.SalvarFuncionarioCommand;
import presenter.InclusaoFuncionarioPresenter;
import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class EdicaoState  extends FuncionarioPresenterState {

    public EdicaoState(InclusaoFuncionarioPresenter presenter) {
        super(presenter);
         presenter.getView().getBtnSalvar().setEnabled(true);
      presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getBtnEditar().setEnabled(false);
           
        presenter.getView().getTxtNome().setEnabled(true);
        presenter.getView().getTxtIdade().setEnabled(true);
        presenter.getView().getTxtAdmissao().setEnabled(true);
        presenter.getView().getTxtSalario().setEnabled(true);
        presenter.getView().getTxtFaltas().setEnabled(true);
        presenter.getView().getCkcFuncionarioMes().setEnabled(true);

        presenter.getView().getCboBonus().setEnabled(false);
        presenter.getView().getCboCargo().setEnabled(false);
    }
    
     @Override
    public void salvar() {
             new SalvarFuncionarioCommand().execute(presenter   );              
        presenter.setEstado(new VisualizacaoState(presenter));

    }
    
     @Override
    public void cancelar() {
          presenter.getView().dispose();
    }
    
}
