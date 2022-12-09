package io;

import model.Sinhvien;

import java.io.*;
import java.util.ArrayList;

public class IOsinhvien<E> {
    public static File file = new File("D:\\Code gym\\Kiemtramodul2\\Sinhvien.csv");
    public static void write(ArrayList<Sinhvien> list) {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Sinhvien> read() {

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Sinhvien> temp = (ArrayList<Sinhvien>) ois.readObject();
            ois.close();
            fis.close();
            return temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
