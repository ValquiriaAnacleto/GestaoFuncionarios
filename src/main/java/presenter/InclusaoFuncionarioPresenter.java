/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;


import model.Funcionario;
import state.FuncionarioPresenterState;
import state.InclusaoState;
import state.VisualizacaoState;

import view.IncluirFuncionarioView;

/**
 *
 * @author Valquíria Anacleto
 */
public class InclusaoFuncionarioPresenter {

    private FuncionarioPresenterState estado;
    private Funcionario funcionario;
    private IncluirFuncionarioView view;
   
   

    public InclusaoFuncionarioPresenter( Funcionario funcionario) {
          this.view = new IncluirFuncionarioView();
        this.funcionario = funcionario  ;

      
       
     
        if (funcionario != null) {
             this.setEstado(new VisualizacaoState(this));
        } else {
             this.setEstado(new InclusaoState(this));

        }
    }

    public void salvar() {
        estado.salvar();
    }

    public void excluir() {
        estado.excluir();
    }

    public void cancelar() {
        estado.cancelar();
    }

    public void editar() {
        estado.editar();
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setEstado(FuncionarioPresenterState estado) {
        this.estado = estado;
    }

        public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public IncluirFuncionarioView getView() {
        return view;
    }

    

    

    public void limpaCampos() {
        view.getTxtNome().setText("");
        view.getTxtIdade().setText("");
        view.getTxtSalario().setText("");
        view.getTxtAdmissao().setText("");
        view.getTxtFaltas().setText("");

    }

}
