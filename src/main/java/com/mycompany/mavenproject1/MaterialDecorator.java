/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
public abstract class MaterialDecorator implements Material {
    protected Material material;

    public MaterialDecorator(Material material) {
        this.material = material;
    }

    @Override
    public String getDescricao() {
        return material.getDescricao();
    }

    @Override
    public boolean isDisponivel() {
        return material.isDisponivel();
    }
}


