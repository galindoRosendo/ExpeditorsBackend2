package ttl.students;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class studentsService {
    static String[] studentsArray = new String[] {
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
            "Grant Stampfli"
    };
    public static void main(String[] args){

    }
    public static void CallStudents() {
        System.out.println(studentsArray[ThreadLocalRandom.current().nextInt(18)]);
        System.out.println(studentsArray[ThreadLocalRandom.current().nextInt(18)]);
        System.out.println(studentsArray[ThreadLocalRandom.current().nextInt(18)]);
    }
    public static Integer CallIntsArray(){
        Integer[] intsArray = new Integer[10];

        for (int i = 0; i < 10; i++) {
            intsArray[i] = i*i;
        }
        return intsArray[5];
    }
    public static Integer[] CreateArray(Integer size, Integer limit) {
        Integer[] intArray = new Integer[size];
        for (int i = 0; i < limit; i++) {
            intArray[i] = ThreadLocalRandom.current().nextInt(limit);
        }
        return intArray;
    }

    public static List<Integer> CreateList(Integer size, Integer limit) {
        List<Integer> ListArray = new ArrayList<>(size);

        for (int i = 0; i < limit; i++) {
            ListArray.add(ThreadLocalRandom.current().nextInt(limit));
        }
        return ListArray;
    }

}
