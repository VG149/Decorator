/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
// The component interface defines operations that can be
// altered by decorators.
// The component interface defines operations that can be
// altered by decorators.
// The component interface defines operations that can be
// altered by decorators.
public class Livro implements Material {
    private String titulo;
    
    public Livro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getDescricao() {
        return "Livro: " + titulo;
    }

    @Override
    public boolean isDisponivel() {
        return true; // Implementar lógica de disponibilidade
    }
}


// Outros tipos de materiais podem ser implementados aqui
