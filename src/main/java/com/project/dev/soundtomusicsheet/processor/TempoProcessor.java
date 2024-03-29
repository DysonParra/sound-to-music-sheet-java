/*
 * @fileoverview    {TempoProcessor}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.soundtomusicsheet.processor;

import com.project.dev.soundtomusicsheet.struct.MusicSheet;
import com.project.dev.soundtomusicsheet.struct.symbol.MusicSymbol;
import com.project.dev.soundtomusicsheet.struct.symbol.Tempo;

/**
 * TODO: Description of {@code TempoProcessor}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class TempoProcessor {

    /**
     * FIXME: Description of {@code findLastTempo}. Busca en un objeto de tipo partitura el último
     * nodo tipo tempo.
     *
     * @param sheet El objeto de tipo partitura al que se le buscará el último nodo tipo tempo.
     * @return Una copia del último tempo de la partitura.
     */
    public Tempo findLastTempo(MusicSheet sheet) {
        MusicSymbol aux = sheet.getLast();                                      // Crea objeto musicSymbol apuntando al último nodo de la partitura.
        Tempo tempo = new Tempo("", 0);                                          // Crea apuntador a un nodo tipo tempo.

        do {                                                                    // Recorre la partitura.
            if ("Tempo".equals(aux.getClass().getSimpleName())) {               // Si el nodo actual es un tempo.
                tempo = (Tempo) aux;                                            // Almacena en aux la nota.
                break;                                                          // Sale del ciclo.
            }

            aux = aux.getPrev();                                                // Pasa al anterior nodo.
        } while (aux != sheet.getLast());                                         // Mientras no reccora toda la partitura.

        int value = tempo.getValue();                                           // Almacena el valor del tempo obtenido.
        String type = tempo.getType();                                          // ALmacena el tipo de tempo obtenido.
        tempo = new Tempo(type, value);                                         // Crea un nuevo nodo de tipo tempo.

        return tempo;                                                           // Devuelve el nodo tipo tempo.
    }
}
