/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.FuncionarioColletion;
import java.io.IOException;
import view.JanelaPrincipal;

/**
 *
 * @author Valquíria Anacleto
 */
public class FuncionarioPresenter {
    private static FuncionarioPresenter  instance = null;
    private JanelaPrincipal view;
    private FuncionarioColletion funcionarios;
    
    
    FuncionarioPresenter() throws IOException{
        view = new JanelaPrincipal();
        funcionarios = FuncionarioColletion.getInstance();
        registrarObservers();
        
    }
    
    public static  FuncionarioPresenter getInstance() throws Exception {
        if (instance == null) {
            instance = new  FuncionarioPresenter();
        }
        return instance;
    }
    
        public void registrarObservers() throws IOException{
         BuscarFuncionarioPresenter obs1 = new BuscarFuncionarioPresenter(funcionarios);
         
         obs1.getView().setVisible(false);
         funcionarios.registrar(obs1);
     
        }
    

    public JanelaPrincipal getView() {
        return view;
    }
}
