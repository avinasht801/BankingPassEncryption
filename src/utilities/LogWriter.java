/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author test
 */
public class LogWriter {

  

    public static void writeLog(String content) {
        try {
            String currLog ="";// MainForm.txtLog1.getText().trim();
            String log = currLog + "\n" + content;
            System.out.println("" + log);

//            MainForm.txtLog1.setText(log);
//            MainForm.txtLog1.setCaretPosition(MainForm.txtLog1.getText().length() - 10);
        } catch (Exception e) {
        }
    }
}