/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Administrator
 */
public class sendEmailThread implements Runnable {

    String toemail = "";
    String Subject = "";
    String message = "";
    String Attachment = "";
    boolean withAttachment = false;

    public sendEmailThread(String temail, String sbject, String msg) {
        withAttachment = false;
        toemail = temail;
        Subject = sbject;
        message = msg;
    }

    public sendEmailThread(String temail, String sbject, String msg, String attachment) {

        withAttachment = true;
        toemail = temail;
        Subject = sbject;
        message = msg;
        Attachment = attachment;
    }

    @Override
    public void run() {

        try {
            if (withAttachment) {
                SimpleSendEmail SS = new SimpleSendEmail(toemail, Subject, message, Attachment);
            } else {
                SimpleSendEmail SS = new SimpleSendEmail(toemail, Subject, message);
            }
        } catch (Exception e) {
        }
    }
}