/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Dicionario implements Material {
    private String idioma;
    
    public Dicionario(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String getDescricao() {
        return "Dicionário: " + idioma;
    }

    @Override
    public boolean isDisponivel() {
        return true; // Implementar lógica de disponibilidade
    }
}
