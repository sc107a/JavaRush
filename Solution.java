package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sourseFileName = reader.readLine();
            ArrayList<Integer> arrayList = new ArrayList<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(sourseFileName);
                while (fileInputStream.available() > 0) {arrayList.add(fileInputStream.read());}
                fileInputStream.close();
            } catch (FileNotFoundException e) {System.out.println("Файл тю-тю");}
            ArrayList<String> stringList = new ArrayList<>();
            ArrayList<Character> charArray = new ArrayList<>();
                for (int k = 0; k < arrayList.size(); k++) {
                    Integer x = arrayList.get(k);
                    if (x != 10 ) { charArray.add((char)arrayList.get(k).intValue());}
                    else {
                        String str="";
                        for (int i=0; i<charArray.size(); i++){
                            str = str.concat(charArray.get(i).toString());
                        }
                        stringList.add(str);
                        charArray.clear();
                    }
                    if (k == arrayList.size()-1){
                        String str="";
                        for (int i=0; i<charArray.size(); i++){
                            str = str.concat(charArray.get(i).toString());
                        }
                        stringList.add(str);
                        charArray.clear();
                    }
                }
                //фильтруем пробелы и создаем список Integer
                ArrayList<Integer> integerList = new ArrayList<>();
                for (String s : stringList){if (!s.equals("")) integerList.add(Integer.parseInt(s));}
                //отделяем нечетные от четных
            ArrayList<Integer> sortedArray = new ArrayList<>();
            for (Integer i : integerList){if (i%2==0) sortedArray.add(i);}
            Collections.sort(sortedArray);
            for (Integer i : sortedArray) System.out.println(i);


    }
}




