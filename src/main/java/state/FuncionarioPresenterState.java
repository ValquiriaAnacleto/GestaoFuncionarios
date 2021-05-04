/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public abstract class FuncionarioPresenterState {

    protected InclusaoFuncionarioPresenter presenter;

    public FuncionarioPresenterState(InclusaoFuncionarioPresenter presenter) {
        this.presenter = presenter;

    }

    public void salvar() {
        throw new RuntimeException(" Não é possivel recuperar um registro a partir deste estado!");
    }

    public void cancelar() {
        presenter.getView().dispose();

    }

    public void editar() {
        throw new RuntimeException(" Não é possivel editar um registro a partir deste estado!");
    }

    public void excluir() {
        throw new RuntimeException(" Não é possivel excluir um registro a partir deste estado!");
    }

}
