/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Valquíria Anacleto
 */
public interface Subject {
     public void remover(Observer observador);
     public void registrar(Observer observador);

    public abstract void notificar();
}
