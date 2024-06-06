package tools;

import com.google.gson.Gson;
import user.UserData;

import java.io.*;
import java.util.Scanner;

public class LocalStorage {


    public static void saveJsonString(String data, String filename) {
        try {
            PrintWriter out = new PrintWriter(filename);
            out.print(data);
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    public static String loadJsonString(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                PrintWriter pw = new PrintWriter(file);
                pw.close();
                return null;
            }
            Scanner in = new Scanner(file);
            if (in.hasNext()) return in.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static UserData loadUseData() {
        Gson gson = new Gson();
        if (!fileExists("userInfo.json")) return null;
        return gson.fromJson(LocalStorage.loadJsonString("userInfo.json"), UserData.class);
    }

}
