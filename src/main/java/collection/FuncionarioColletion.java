/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;
import observer.Observer;
import observer.Subject;



/**
 *
 * @author Valquíria Anacleto
 */
public final class FuncionarioColletion implements Subject {
     private ArrayList<Funcionario> funcionarios;
     private ArrayList<Observer> observers;
    
     private static FuncionarioColletion instancia;

   private FuncionarioColletion() {
      
    }

   
   
     

    @Override
    public void remover(Observer observador) {
        observers.remove(observador);
        notificar();
    }

    @Override
    public void registrar(Observer observador) {
            observers.add(observador);
            notificar();
    }

    @Override
    public void notificar() {
          for (int i = 0; i < observers.size(); i++) {
            Observer ob =  observers.get(i);
            ob.update(funcionarios);
        }

        JOptionPane.showConfirmDialog(null, "notificado!");
    }
    
    
   public void add(Funcionario funcionario){
        funcionarios.add(funcionario);
        notificar();
    }
    
    public void remove(Funcionario funcionario){
        funcionarios.remove(funcionario);
        notificar();
    }
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
   
    
    
 public static FuncionarioColletion getInstance() {
        if (instancia == null) {
            instancia = new FuncionarioColletion();
        }
        return instancia;
    }
  

    

    }



