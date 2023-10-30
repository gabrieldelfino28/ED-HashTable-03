package view;

import controller.DoceiraControl;
import model.Barra;

import java.util.Random;

public class Main {



    public static void main(String[] args){
	// write your code here
        Random rnd = new Random();
        DoceiraControl doc = new DoceiraControl();

        for (int i = 1; i <= 50; i++) { //Gerar 50 doces aleatórios com volume entre 50 e 280
            Barra barra = new Barra();
            barra.volume = rnd.nextInt(50, 280);
            try {
                doc.add(barra);
            }catch (Exception err) {
                System.err.println(err.getMessage());
            }
        }
        try {
            doc.listTable();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
