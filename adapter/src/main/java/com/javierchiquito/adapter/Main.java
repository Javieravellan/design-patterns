package com.javierchiquito.adapter;

import com.javierchiquito.adapter.round.RoundHole;
import com.javierchiquito.adapter.round.RoundPeg;
import com.javierchiquito.adapter.round.SquarePeg;

import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        /**
         * clase cliente que interactua con la clase RoundHole
         * para hacer encajar objetos de tipo RoundPeg
         */
        log.info("DEMO PATRÓN DE DISEÑO ADAPTER");

        // encajar piezas redondas en el agujero hole
        RoundHole hole = new RoundHole(5);
        RoundPeg reoundPeg = new RoundPeg(5);

        if (hole.fits(reoundPeg)) {
            log.info("Pieza redonda de " + reoundPeg.getRadius() + "cm de radio cabe en agujero de 5cm de radio.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        //hole.fits(smallSqPeg); // not compile; interfaces no compatibles

        // Usando el adaptador para que pueda caber un cuadrado dentro de un un agujero circular
        SquarePegAdapter smSquareAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter lgSquareAdapter = new SquarePegAdapter(largeSqPeg);

        if (hole.fits(smSquareAdapter)) {
            log.info("Pieza cuadrada envuelta (adaptada) en un circulo de " + smSquareAdapter.getRadius() + "cm de radio cabe en agujero de 5cm de radio.");
        }

        if (!hole.fits(lgSquareAdapter)) {
            log.info("Pieza cuadrada envuelta (adaptada) en un circulo de " + lgSquareAdapter.getRadius() + "cm de diámetro NO cabe en agujero de 5cm de diámetro.");
        }
    }
}