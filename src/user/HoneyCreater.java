/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.*;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

public class HoneyCreater {

    static HashMap<Integer, String> charactors = new HashMap<>();
    static HashMap<Integer, String> numeric = new HashMap<>();

    public static void main(String args[]) throws IOException {
        
        String Hybridhoneywords = Hybridhoneywords("shailesh@12345");
        System.out.println("Hybrid honeywords : " + Hybridhoneywords);
        System.out.println();
        
        String passmodelhoneywords = passmodelHoneyword("shailesh@12345");
        System.out.println("passmodel honeywords : " + passmodelhoneywords);
    	System.out.println();
    	
    	String chaffwordhoneywords = chaffwordhoneywords("shailesh@123456");
   	 	System.out.println("chaffword honeywords : " +chaffwordhoneywords);
    	
    	String chaffdigithoneywords = chaffdigithoneywords("shai5lesh@123");
   	 	System.out.println("chaffdigit honeywords : " +chaffdigithoneywords);
    	System.out.println();
    	
   	 	String takeatailhoneywords = Takeatailhoneywords("shailesh@12345");
   	 	System.out.println("takeatail honeywords : " +takeatailhoneywords);
   	 	System.out.println();
    }
    
    //==============  chaffwordhoneywords =========================================
    
    public static String chaffwordhoneywords(String password) throws IOException {
    	String words = "";
    	for (int a = 0; a < 30; a++) {
    	char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                    || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch >= 65 && ch <= 90) {
                    charactors.put(i, "UV");
                }
                if (ch >= 'a' && ch <= 'z') {
                    charactors.put(i, "LV");
                }
            } else if (ch >= 65 && ch <= 90) {
                charactors.put(i, "U");
            } else if (ch >= 'a' && ch <= 'z') {
                charactors.put(i, "L");
            } else if (ch >= '0' && ch <= '9') {
                charactors.put(i, ch+"");
            } else {
                charactors.put(i, ch+"");
            }
        }
        String Honeyword = "";

        for (int key : charactors.keySet()) {
            String value = charactors.get(key);
            if(value!="UV" && value!="LV" && value!="U" && value!="L"){
            	Honeyword = Honeyword + value;
            }
            switch (value) {
                case "UV":
                    Honeyword = Honeyword + getuppervowel();
                    break;
                case "LV":
                    Honeyword = Honeyword + getlowervowel();
                    break;
                case "U":
                    Honeyword = Honeyword + getupper();
                    break;
                case "L":
                    Honeyword = Honeyword + getlower();
                    break;
            }
        }
        String encrypthoney = Encrypt.encrypt(Honeyword);
        String encryptpassword = Encrypt.encrypt(password);
        if(a==14){
        	words = words+","+encryptpassword;
        }else{
        	words = words+","+encrypthoney;
        }
    	}
        return words;
    }

    //==============  chaffdigithoneywords =========================================
    
    public static String chaffdigithoneywords(String password) throws IOException {
    	String words = "";
    	for (int a = 0; a < 30; a++) {
    	char ch;
//    	int j = password.length() - 4;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                    || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch >= 65 && ch <= 90) {
                    charactors.put(i, ch+"");
                }
                if (ch >= 'a' && ch <= 'z') {
                    charactors.put(i, ch+"");
                }
            } else if (ch >= 65 && ch <= 90) {
                charactors.put(i, ch+"");
            } else if (ch >= 'a' && ch <= 'z') {
                charactors.put(i, ch+"");
            } else if (ch >= '0' && ch <= '9') {
            	
            	charactors.put(i, "NN");

            } else {
                charactors.put(i, ch+"");
            }
        }
        String Honeyword = "";

        for (int q=charactors.size()-1; q>=0; q-- ) {
            String value = charactors.get(q);

            if(value!="NN"){
            	Honeyword = value + Honeyword;
            }
            switch (value) {
                case "NN":
                    Honeyword =  getnumeric()+ Honeyword;
                    break;
            }
        }
        String encrypthoney = Encrypt.encrypt(Honeyword);
        
        String encryptpassword = Encrypt.encrypt(password);
        if(a==14){
        	words = words+","+encryptpassword;
        }else{
        	words = words+","+encrypthoney;
        }
    	}
        return words;
    }
    
    //==============  Takeatailhoneywords =========================================
    
    public static String Takeatailhoneywords(String password) throws IOException {
    	String words = "";
    	for (int i = 0; i < 30; i++) {
    		String digits = "";
    		for (int j = 0; j < 4; j++) {
    			digits = digits +getnumeric();
    		}
    		String Honeyword = password + digits;
    		String encrypthoney = Encrypt.encrypt(Honeyword);
            String encryptpassword = Encrypt.encrypt(password);
    		if(i==14){
            	words = words+","+encryptpassword;
            }else{
            	words = words+","+encrypthoney;
            }
    	}
    	return words;
    }
    
 //==============  passmodelHoneyword =========================================
    
    public static String passmodelHoneyword(String password) {
    	String words = "";
    	for (int a = 0; a < 30; a++) {
    	char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                    || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch >= 65 && ch <= 90) {
                    charactors.put(i, "UV");
                }
                if (ch >= 'a' && ch <= 'z') {
                    charactors.put(i, "LV");
                }
            } else if (ch >= 65 && ch <= 90) {
                charactors.put(i, "U");
            } else if (ch >= 'a' && ch <= 'z') {
                charactors.put(i, "L");
            } else if (ch >= '0' && ch <= '9') {
                charactors.put(i, "N");
            } else {
                charactors.put(i, "S");
            }
        }
        String Honeyword = "";

        for (int key : charactors.keySet()) {
            String value = charactors.get(key);
            switch (value) {
                case "UV":
                    Honeyword = Honeyword + getuppervowel();
                    break;
                case "LV":
                    Honeyword = Honeyword + getlowervowel();
                    break;
                case "U":
                    Honeyword = Honeyword + getupper();
                    break;
                case "L":
                    Honeyword = Honeyword + getlower();
                    break;
                case "N":
                    Honeyword = Honeyword + getnumeric();
                    break;
                case "S":
                    Honeyword = Honeyword + getspecial();
                    break;
            }
        }
        String encrypthoney = Encrypt.encrypt(Honeyword);
        String encryptpassword = Encrypt.encrypt(password);
        if(a==14){
        	words = words+","+encryptpassword;
        }else{
        	words = words+","+encrypthoney;
        }
    	}
        return words;
    }
    
    //==============  Hybridhoneywords =========================================
    
    public static String Hybridhoneywords(String password) throws IOException {
    	String words = "";
        for (int a = 1; a < 6; a++) {
            String Honeyword = findHoneyword(password);
            String encrypthoney = Encrypt.encrypt(Honeyword);
            String encryptpassword = Encrypt.encrypt(password);
            if (a==3) {
                words = words + "," + encryptpassword;
            } else {
                words = words + "," + encrypthoney;
            }
            
            for (int j = 0; j < Honeyword.length(); j++) {
                String honey[] = Honeyword.split("");
                String chr = honey[j];
                char ch = chr.charAt(0);
                if (ch >= '0' && ch <= '9') {
                    numeric.put(j, "N");
                }
            }
            for (int k = 0; k < 6; k++) {
                StringBuilder newHoneyword = new StringBuilder(Honeyword);
                for (int key : numeric.keySet()) {
                    String value = numeric.get(key);
                    switch (value) {
                        case "N":
                            newHoneyword.setCharAt(key, getnumeric().charAt(0));
                            break;
                    }
                }
                String encryptnewHoneyword = Encrypt.encrypt(newHoneyword+"");
                words = words+","+encryptnewHoneyword;
            }
        }
		return words;
     }

    public static String findHoneyword(String password) {
        char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                    || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch >= 65 && ch <= 90) {
                    charactors.put(i, "UV");
                }
                if (ch >= 'a' && ch <= 'z') {
                    charactors.put(i, "LV");
                }
            } else if (ch >= 65 && ch <= 90) {
                charactors.put(i, "U");
            } else if (ch >= 'a' && ch <= 'z') {
                charactors.put(i, "L");
            } else if (ch >= '0' && ch <= '9') {
                charactors.put(i, "N");
            } else {
                charactors.put(i, "S");
            }
        }
        String Honeyword = "";

        for (int key : charactors.keySet()) {
            String value = charactors.get(key);
            switch (value) {
                case "UV":
                    Honeyword = Honeyword + getuppervowel();
                    break;
                case "LV":
                    Honeyword = Honeyword + getlowervowel();
                    break;
                case "U":
                    Honeyword = Honeyword + getupper();
                    break;
                case "L":
                    Honeyword = Honeyword + getlower();
                    break;
                case "N":
                    Honeyword = Honeyword + getnumeric();
                    break;
                case "S":
                    Honeyword = Honeyword + getspecial();
                    break;
            }
        }
        return Honeyword;
    }
    
   //*************************************************************************************************************

    public static String getuppervowel() {
        Random RANDOM = new SecureRandom();
        String letters = "AEIOU";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }

    public static String getlowervowel() {
        Random RANDOM = new SecureRandom();
        String letters = "aeiou";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }

    public static String getupper() {
        Random RANDOM = new SecureRandom();
        String letters = "ABCDEFGHJKMNPQRSTUVWXYZ";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }

    public static String getlower() {
        Random RANDOM = new SecureRandom();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }

    public static String getnumeric() {
        Random RANDOM = new SecureRandom();
        String letters = "0123456789";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }

    public static String getspecial() {
        Random RANDOM = new SecureRandom();
        String letters = "@#$*+^";
        String pw = "";
        int index = (int) (RANDOM.nextDouble() * letters.length());
        pw += letters.substring(index, index + 1);
        return pw;
    }
}
