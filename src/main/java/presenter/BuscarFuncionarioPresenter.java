/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.FuncionarioColletion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Funcionario;
import observer.Observer;
import state.FuncionarioPresenterState;

import state.VisualizacaoState;
import view.BuscarFuncionarioView;

/**
 *
 * @author Valquíria Anacleto
 */
public final class BuscarFuncionarioPresenter implements Observer {

    private BuscarFuncionarioView view;

    private FuncionarioPresenterState estado;
    private Funcionario funcionario;
    private FuncionarioColletion funcionarios;
    private DefaultTableModel table;
    private InclusaoFuncionarioPresenter presenter;
    private TableRowSorter sorter;
    private static BuscarFuncionarioPresenter instancia = null;

    public BuscarFuncionarioPresenter(FuncionarioColletion funcionarios) throws FileNotFoundException, IOException {
        view = new BuscarFuncionarioView().getInstance();
        view.setVisible(true);

        table = new DefaultTableModel(
                new Object[][][][]{},
                new String[]{"Nome", "Idade", "Função", "Salário Base(R$)"}) {

        };

        view.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setNumRows(0);
        view.getTabela().setModel(table);
        sorter = new TableRowSorter<TableModel>(table);
        view.getTabela().setRowSorter(sorter);

    }

    private void limpaTabela() {
        if (table.getRowCount() > 0) {
            for (int i = table.getRowCount() - 1; i > -1; i--) {
                table.removeRow(i);
            }
        }
    }

    private void buscaTabela() throws Exception {
        String nome = view.getTxtBuscaNome().getText();
        if (nome.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(nome));
        }
    }

    public FuncionarioPresenterState getEstado() {
        return estado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setEstado(FuncionarioPresenterState estado) {
        this.estado = estado;
    }

    ;
    
    public BuscarFuncionarioView getView() {
        return view;
    }

    public static BuscarFuncionarioPresenter getInstance(FuncionarioColletion funcionarios) throws IOException {
        if (instancia == null) {
            instancia = new BuscarFuncionarioPresenter(funcionarios);

        }
        return instancia;
    }

    @Override
    public void update(ArrayList<Funcionario> funcionarios) {
        limpaTabela();
        for (Funcionario funcionario : funcionarios) {
            table.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getIdade(),
                funcionario.getCargo(),
                funcionario.getSalario()
            });
        }
    }

    public void configurarListeners() {
        view.getBtnNovoFuncionarioVizualizacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InclusaoFuncionarioPresenter(funcionario);
            }
        });

        view.getBtnFecharVizualizacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                view.dispose();
            }
        });

        view.getBtnVizualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int linha = view.getTabela().getSelectedRow();
                Funcionario funcSelect = funcionarios.getFuncionarios().get(linha);
                new InclusaoFuncionarioPresenter(funcSelect);
            }
        });

        view.getBtnBuscaFuncionario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    buscaTabela();
                } catch (Exception ex) {
                    Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
