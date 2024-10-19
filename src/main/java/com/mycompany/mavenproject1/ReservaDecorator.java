/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ReservaDecorator extends MaterialDecorator {
    private boolean reservado;

    public ReservaDecorator(Material material) {
        super(material);
        this.reservado = false;
    }

    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println(material.getDescricao() + " reservado.");
        } else {
            System.out.println(material.getDescricao() + " já está reservado.");
        }
    }

    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            System.out.println(material.getDescricao() + " reserva cancelada.");
        } else {
            System.out.println(material.getDescricao() + " não está reservado.");
        }
    }
}

