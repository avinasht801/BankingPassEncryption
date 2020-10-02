/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 		http://www.javacodeexamples.com/check-password-strength-in-java-example/668
 */
package user;

public class CheckPasswordStrength {

	public static int calculatePasswordStrength(String password) {

        int iPasswordScore = 0;

        if (password.length() < 5) {
            return 7;
        } else if (password.length() >= 15) {
            iPasswordScore += 6;
        } else if (password.length() >= 10) {
            iPasswordScore += 5;
        } else if (password.length() >= 8) {
            iPasswordScore += 4;
        } else if (password.length() >= 6) {
            iPasswordScore += 3;
        } else {
            iPasswordScore += 2;
        }

        /*
         * if password contains 2 digits, add 2 to score.
         * if contains 1 digit add 1 to score
         */
        if (password.matches("(?=.*[0-9].*[0-9]).*")) {
            iPasswordScore += 2;
        } else if (password.matches("(?=.*[0-9]).*")) {
            iPasswordScore += 1;
        }

        //if password contains 1 lower case letter, add 2 to score
        if (password.matches("(?=.*[a-z]).*")) {
            iPasswordScore += 2;
        }

        /*
         * if password contains 2 upper case letters, add 2 to score.
         * if contains only 1 then add 1 to score.
         */
        if (password.matches("(?=.*[A-Z].*[A-Z]).*")) {
            iPasswordScore += 2;
        } else if (password.matches("(?=.*[A-Z]).*")) {
            iPasswordScore += 1;
        }

        /*
         * if password contains 2 special characters, add 2 to score.
         * if contains only 1 special character then add 1 to score.
         */
        if (password.matches("(?=.*[~!@#$%^&*()_-].*[~!@#$%^&*()_-]).*")) {
            iPasswordScore += 3;
        } else if (password.matches("(?=.*[~!@#$%^&*()_-]).*")) {
            iPasswordScore += 2;
        }

        return iPasswordScore;
    }

    public static void main(String[] args) {
        int str = calculatePasswordStrength("abc                                                                                                                    ");
        System.out.println(str);
    }
}
