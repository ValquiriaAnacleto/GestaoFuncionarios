/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import collection.FuncionarioColletion;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.InclusaoFuncionarioPresenter;

/**
 *
 * @author Valquíria Anacleto
 */
public class ExcluirFuncionarioCommand extends Command {

    private FuncionarioColletion funcionarios;
    private Funcionario funcionario;

    @Override
    public void execute(InclusaoFuncionarioPresenter presenter) {
        this.funcionarios = FuncionarioColletion.getInstance();

        for (int i = 0; i < funcionarios.getFuncionarios().size(); i++) {
            Funcionario funcionario = funcionarios.getFuncionarios().get(i);
            if (funcionario.getNome() == presenter.getView().getTxtNome().toString()) {
                funcionarios.remove(funcionario);
                JOptionPane.showMessageDialog(presenter.getView(), "Excluido com sucesso!");
            }
        }

    }
}
