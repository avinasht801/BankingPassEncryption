/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.HashMap;
import java.util.Map;

public class Pre_postfix {

	static HashMap<Integer, String> charactors = new HashMap<>();
	String prefixpass = "";
	String postfixpass = "";

	public static void main(String[] args) {
		Pre_postfix fix = new Pre_postfix();
		fix.prefix("mahendra@123456");
		fix.postfix("mahendra@123456");
	}

	public String prefix(String password) {
		char ch;
		for (int i = 0; i < password.length(); i++) {
			ch = password.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 65 && ch <= 90)) {
				charactors.put(i, "S");
			} else if (ch >= '0' && ch <= '9') {
				charactors.put(i, "N");
			} else {
				charactors.put(i, "SC");
			}
		}
		System.out.println("charactors :" + charactors);

		if (charactors.get(0).equals("S")) {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
		} else if (charactors.get(0).equals("N")) {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
		} else {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					prefixpass = prefixpass + chr;
				}
			}
		}
		System.out.println(prefixpass);
		return prefixpass;
	}

	public String postfix(String password) {
		char ch;
		for (int i = 0; i < password.length(); i++) {
			ch = password.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 65 && ch <= 90)) {
				charactors.put(i, "S");
			} else if (ch >= '0' && ch <= '9') {
				charactors.put(i, "N");
			} else {
				charactors.put(i, "SC");
			}
		}
		System.out.println("charactors :" + charactors);

		if (charactors.get(0).equals("S")) {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}

			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}

		} else if (charactors.get(0).equals("N")) {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}

			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}
		} else {
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("S")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}

			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("N")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}
			for (Map.Entry<Integer, String> entry : charactors.entrySet()) {
				String honey[] = password.split("");
				if (entry.getValue().equals("SC")) {
					String chr = honey[entry.getKey()];
					postfixpass = postfixpass + chr;
				}
			}
		}
		System.out.println(postfixpass);
		return postfixpass;
	}
}
