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
public class SalvarFuncionarioCommand extends Command {

    private FuncionarioColletion funcionarios = FuncionarioColletion.getInstance();

    @Override
    public void execute(InclusaoFuncionarioPresenter presenter) {

        String nome = presenter.getView().getTxtNome().getText();
        float salario = Float.parseFloat(presenter.getView().getTxtNome().getText());
        String admissao = presenter.getView().getTxtAdmissao().getText();
        int idade = Integer.parseInt(presenter.getView().getTxtIdade().getText());
        int numeroFaltas = Integer.parseInt(presenter.getView().getTxtFaltas().getText());
        boolean funcionarioDoMes = presenter.getView().getCkcFuncionarioMes().isSelected();
        String cargoSelecionado = presenter.getView().getCboCargo().getSelectedItem().toString();
        String bonusSelecionado = presenter.getView().getCboBonus().getSelectedItem().toString();
        int faltas = Integer.parseInt(presenter.getView().getTxtFaltas().getText());

        Funcionario funcionario = new Funcionario(nome, idade, salario, cargoSelecionado, bonusSelecionado, numeroFaltas, funcionarioDoMes, admissao);
        try {
            funcionarios.getInstance().add(funcionario);

            System.out.println(funcionarios.getFuncionarios().indexOf(0));
            JOptionPane.showMessageDialog(null,"Funcionário salvo com sucesso!");
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage());
           
        }
    }
;

}
