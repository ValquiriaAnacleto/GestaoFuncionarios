/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import collection.FuncionarioColletion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class VisualizacaoState extends FuncionarioPresenterState {

    private FuncionarioColletion funcionarios;

    public VisualizacaoState( InclusaoFuncionarioPresenter presenter) {
        super(presenter);
        this.funcionarios = funcionarios;
        listeners(presenter);
        
        presenter.getView().getBtnSalvar().setEnabled(false);
        presenter.getView().getBtnExcluir().setEnabled(true);
        presenter.getView().getBtnEditar().setEnabled(true);
        presenter.getView().getBtnEditar().setEnabled(true);
        presenter.getView().getTxtNome().setEnabled(false);
        presenter.getView().getTxtIdade().setEnabled(false);
        presenter.getView().getTxtAdmissao().setEnabled(false);
        presenter.getView().getTxtSalario().setEnabled(false);
        presenter.getView().getTxtFaltas().setEnabled(false);
        presenter.getView().getCkcFuncionarioMes().setEnabled(false);

        presenter.getView().getCboBonus().setEnabled(false);
        presenter.getView().getCboCargo().setEnabled(false);
    }
         private void listeners(InclusaoFuncionarioPresenter presenter){
         presenter.getView().getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    excluir();
                }catch(Exception ex){
                    JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error!", 0);
                }
            }
        });
             presenter.getView().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                editar();
            }
        });
              presenter.getView().getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cancelar();
            }
        });
      
    }


    @Override
    public void salvar() {

    }

}
