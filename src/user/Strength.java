package user;

public class Strength {
//	public static void main(String args[]) {
	
	public static String Passalgo(String password) {
		String algomodel = "";
		int letter = 0;
		int special = 0;
		int number = 0;

		char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (ch >= 65 && ch <= 90) {
            	letter++;
            } else if (ch >= 'a' && ch <= 'z') {
            	letter++;
            } else if (ch >= '0' && ch <= '9') {
            	number++;
            } else {
            	special++;
            }
        }
        System.out.println("letter "+letter);
        System.out.println("special "+special);
        System.out.println("number "+number);
        
        int lenth = password.length();
        int mid = lenth/2;
        
        if(special >= mid){
        	algomodel = "hybridmodel";
        }
        else if(letter==3 && special==1 && number==2){
        	algomodel = "passwordmodel";
    	}
        else if(letter==2 && special==2 && number==2){
        	algomodel = "takeatail";
    	}
        else if(letter==1 && special==3 && number==2){
        	algomodel = "passwordmodel";
    	}
        else{
        	algomodel = "chaffdigit";
        }
		return algomodel;
	}
}
