package controller;

import linkedlist.model.LinkedList;
import model.Barra;

public class DoceiraControl {

    private LinkedList<Barra>[] hashTable = new LinkedList[5];
    private final LinkedList<Barra> resto = new LinkedList<>();

    public DoceiraControl() {
        for (int i = 0; i < 5; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void add(Barra b) throws Exception {
        Classificar(b);
        if (b.peso == 60 || b.peso == 115 || b.peso == 160 || b.peso == 215 || b.peso == 280) {
            int pos = hash(b.peso);
            hashTable[pos].addLast(b);
        }
    }

    private void Classificar(Barra barra) throws Exception {
        if (barra.volume > 49 && barra.volume < 61) {
            barra.peso = 60;
            barra.nome = "Bombons";
        } else if (barra.volume > 99 && barra.volume < 111) {
            barra.peso = 115;
            barra.nome = "Pavês";
        } else if (barra.volume > 149 && barra.volume < 166) {
            barra.peso = 160;
            barra.nome = "Brigadeiros";
        } else if (barra.volume > 199 && barra.volume < 221) {
            barra.peso = 215;
            barra.nome = "Bolos";
        } else if (barra.volume > 259 && barra.volume < 281) {
            barra.peso = 280;
            barra.nome = "Ovos de Páscoa";
        } else {
            barra.nome = "Outros";
            barra.peso = barra.volume + 1;
            resto.addLast(barra);
            throw new Exception("Volume '" + barra.volume + "' não correspondente a Regra de negócio");
        }
    }

    public void listTable() throws Exception {
        if (!resto.isEmpty()) {
            System.err.println("\nLista de volumes que não correspondem a RN");
            resto.printList();
        }
        System.out.println("\n\nTable Hash:");
        for (int pos = 0; pos < 5; pos++) {
            if (!hashTable[pos].isEmpty()) {
                System.out.print("Hash: " + pos + " -> ");
                hashTable[pos].printList();
            }
        }

    }

    private int hash(int num) {
        return (int) (num / 50) - 1;
    }

}
