/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class EmprestimoDecorator extends MaterialDecorator {
    private boolean emprestado;

    public EmprestimoDecorator(Material material) {
        super(material);
        this.emprestado = false;
    }

    public void emprestar() {
        if (!emprestado && material.isDisponivel()) {
            emprestado = true;
            System.out.println(material.getDescricao() + " emprestado.");
        } else {
            System.out.println(material.getDescricao() + " não está disponível para empréstimo.");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println(material.getDescricao() + " devolvido.");
        } else {
            System.out.println(material.getDescricao() + " não foi emprestado.");
        }
    }

    @Override
    public boolean isDisponivel() {
        return !emprestado && material.isDisponivel();
    }
}

