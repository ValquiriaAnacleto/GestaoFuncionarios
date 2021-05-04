/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import command.SalvarFuncionarioCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class InclusaoState extends FuncionarioPresenterState {

   

 public InclusaoState(InclusaoFuncionarioPresenter presenter) {
        super(presenter);
      presenter.getView().setEnabled(false);
    // presenter.getView().getTxtNome().setText(" ");
   
     presenter.getView().getTxtFaltas().setText(" ");
     presenter.getView().getTxtIdade().setText(" ");
     presenter.getView().getTxtSalario().setText(" ");
     presenter.getView().getTxtAdmissao().setText(" ");
     presenter.getView().getCbOFuncionarioMes().setText(" ");
      presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getBtnEditar().setEnabled(false);
        presenter.getView().getBtnFechar().setEnabled(true);
    
     presenter.getView().setEnabled(true);
     
       presenter.getView().getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    salvar();
                    
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!!", 0);
                    System.out.println(ex.getMessage());
                }
            }
        });
        presenter.getView().getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cancelar();
            }
        });

     presenter.getView().setVisible(true);
     
             
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
