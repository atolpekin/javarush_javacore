package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        BufferedReader f1 = new BufferedReader(new FileReader(file1));
        BufferedReader f2 = new BufferedReader(new FileReader(file2));

        List<String> array1 = new ArrayList<>();
        List<String> array2 = new ArrayList<>();


        while (f1.ready()) {
            array1.add(f1.readLine());
        }

        while (f2.ready()) {
            array2.add(f2.readLine());
        }

        for (int i = 0; i < array1.size(); i ++){

            try {
                if (array1.get(i).equals(array2.get(0))){
                    lines.add(new LineItem(Type.SAME, array1.get(i)));
                    array2.remove(0);
                } else if (array1.get(i).equals(array2.get(1))){
                    lines.add(new LineItem(Type.ADDED, array2.get(0)));
                    array2.remove(0);
                    i--;
                } else {
                    lines.add(new LineItem(Type.REMOVED, array1.get(i)));
                }
            } catch (IndexOutOfBoundsException e){
                if (array1.size() > array2.size()){
                    lines.add(new LineItem(Type.REMOVED, array1.get(i)));
                }

                if (array1.size() < array2.size()){
                    lines.add(new LineItem(Type.ADDED, array2.get(0)));
                }
            }
        }

        for (LineItem i : lines) {
            System.out.println(i.type + " " + i.line);
        }

        reader.close();
        f1.close();
        f2.close();
    }




    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
