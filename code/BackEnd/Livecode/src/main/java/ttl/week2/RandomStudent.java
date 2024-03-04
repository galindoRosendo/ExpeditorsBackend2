package ttl.week2;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStudent {

   public static void main(String[] args) {
      int [] iarr = new int[10];
      int [] iarr2 = { 0, 25, 54, 220 };

      String [] names = {
            "Alan Morales Rueda",
            "Andre Uys",
            "Audomaro Gonzalez",
            "Caio Henrique",
            "Chris Valencia",
            "Daniel Lee",
            "Humberto Rojas",
            "Javier Mendoza",
            "Joao Alonso",
            "Luis Barraza Hernandez",
            "Mariana Duarte",
            "Miguel Angel Rodriguez",
            "Rosendo Galindo",
            "Sean Jaw",
            "Tiffany Yee",
            "Vincent Vu",
            "Nathaniel Schieber",
            "Dylan McClain",
            "Grant Stampfli",
      };

      for(int i = 0; i < 10; i++) {
         String result = getRandomStudent(names);
         System.out.println("result: " + result);
      }
   }

   public static String getRandomStudent(String [] array) {
      int num = ThreadLocalRandom.current().nextInt(array.length);

      String result = array[num];
      return result;
   }
}
