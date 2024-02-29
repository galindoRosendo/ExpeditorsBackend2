package ttl.loops;

import java.util.Scanner;

public class casesService {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int start = 0, end = 0, counterFor = 0, counterWhile = 0;
        for (int i = 0; i < 2; i++) {
            switch (i){
                case 0:
                    System.out.println("Type initial value:");
                    start = Integer.parseInt(reader.nextLine());
                    break;
                case 1:
                    System.out.println("Type final value:");
                    end = Integer.parseInt(reader.nextLine());
                    break;
            }
        }
        counterFor = forLoop(start, end);
        counterWhile = whileLoop(start, end);

        System.out.println(STR."The total numbers counter in for loop divisibles by 3 and 7 are:\{counterFor}");
        System.out.println(STR."The total numbers counter in while loop divisibles by 3 and 7 are:\{counterWhile}");
    }
    public static int forLoop(int start, int end){
        int counterDiv = 0;
        for (int i = start; i <= end; i++) {
            if (i % 3 == 0){
                counterDiv++;
            }
            if (i % 7 == 0){
                counterDiv++;
            }
        }
        return counterDiv;
    }

    public static int whileLoop(int start, int end){
        int control = start, counterDiv = 0;

        while(control <= end){
            if (control % 3 == 0){
                counterDiv++;
            }
            if (control % 7 == 0){
                counterDiv++;
            }
            control++;
        }
        return counterDiv;
    }
}
