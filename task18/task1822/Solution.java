package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

      int id = Integer.parseInt(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       
        FileInputStream pervyi = new FileInputStream(reader.readLine());




                ArrayList<String> keksik = new ArrayList<String>();
                ArrayList<String> bulka = new ArrayList<String>();
        boolean skazki = false;
        int ind = 0;
        while (pervyi.available()>0)
        {
            int lolik = pervyi.read();
            char[] clolik = Character.toChars(lolik);
            if (lolik != 13) {
                    if (lolik != 10)
                {

                    if (lolik != 32 && skazki == false)//если не пробел и записывается в первый массив
                    {
                        try {
                            keksik.set(ind, keksik.get(ind) + clolik[0]);

                        } catch (Exception e) {
                            keksik.add(ind, "" + clolik[0]);

                        }
                    } else if (lolik == 32 && skazki == false)// если пробел и записывается в первый массив
                    {
                        //bulka.add(ind, " ");
                        skazki = true;                           //начать записывать во второй
                    } else if (skazki == true)//записывается во второй массив
                    {
                        try {
                            bulka.set(ind, bulka.get(ind) + clolik[0]);
                        } catch (Exception e) {
                            bulka.add(ind, clolik[0] + "");
                        }
                    }
                }

            }
           if (lolik == 13)
            {

                skazki = false;
                ind++;
            }

        }
        for (int i = 0; i < keksik.size(); i++) {

            if (Integer.parseInt(keksik.get(i)) == id) {
              //  System.out.print(keksik.get(i));
                System.out.println(bulka.get(i));
            }
        }
        reader.close();
        pervyi.close();



    }
}
