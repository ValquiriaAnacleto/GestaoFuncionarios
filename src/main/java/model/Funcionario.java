/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Valquíria Anacleto
 */
public class Funcionario {

    private String nome;
    private int idade;
    private double salario;
    private String cargo;
    private String admissao;
    private String bonus;
    private int numeroFaltas;
     private boolean funcionarioDoMes;
    private int tempoServicoEmAnos;
    private double distanciaServico;

    
     private ArrayList<Bonus> bonusRecebidos = new ArrayList<>();

    public Funcionario(String nome, int idade, double salario, String cargo, String bonus, int numeroFaltas, boolean funcionarioDoMes, String admissao) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
        this.bonus = bonus;
        this.numeroFaltas = numeroFaltas;
        this.funcionarioDoMes = funcionarioDoMes;
        this.admissao = admissao;
    }

   

    public double getDistanciaServico() {
        return distanciaServico;
    }

    public void setDistanciaServico(double distanciaServico) {
        this.distanciaServico = distanciaServico;
    }
    
    
    
    public int getTempoServicoEmAnos() {
        return tempoServicoEmAnos;
    }

    public void setTempoServicoEmAnos(int tempoServicoEmAnos) {
        this.tempoServicoEmAnos = tempoServicoEmAnos;
    }

    public ArrayList<Bonus> getBonusRecebidos() {
        return bonusRecebidos;
    }

        public void addBonus(Bonus bonus) throws Exception {
        if (bonus != null) {
            bonusRecebidos.add(bonus);
        } else {
            throw new Exception("Informe um bonus válido");
        }
    }   
    
    

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

  

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }
    
    


    
    
}
