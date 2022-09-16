package org.example;

import com.unimobile.uin.log.Log;

import com.unimobile.uin.config.ConfigDbInfo;

/**
 * Hello world!
 */
public class App {
    //    test(){
//        try {
//            ConfigDbInfo dbi = new ConfigDbInfo();
//            dbi.setAppName("HSMDecryptTool");
//            Log.init("HSMDecryptTool", dbi);
//            Log.Info("Logging initialized.");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        try {
            ConfigDbInfo dbi = new ConfigDbInfo();
            dbi.setAppName("HSMDecryptTool");
            Log.init("HSMDecryptTool", dbi);
            Log.Debug(Log.LOW, "initialized log successfully...");


        } catch (Exception ex) {
            System.out.println("Initialization log ERORR.");
            ex.printStackTrace();
        }

        Log.Info("===========================================");
        System.out.println("Hello World!");

    }
}
