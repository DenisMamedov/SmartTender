package com.tender.main;

/**
 * Created by Денис on 12.01.2017.
 */
public class Message {

    protected static String flashMessage="";

    public static void setFlash(String msg){
        flashMessage = msg;
    }

    public static boolean hasFlash(){
        return flashMessage.isEmpty();
    }

    public static String getFlash(){
        String msg = flashMessage;
        flashMessage = "";
        return msg;
    }
}
