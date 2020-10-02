package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sendmail.SimpleSendEmail;
import Database.DatabaseConnection;
import mesage91.*;
/**
 * Servlet implementation class CALogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		
			int id;
			String query = "select * from userdetails where username = '" + username + "'";
			ResultSet rs = (ResultSet) db.getResultSet(query);
			try {
				if (rs.next()) {
					id = rs.getInt("id");

						String passwdrstpolicy = rs.getString("policy");
						String email = rs.getString("email");
						String mobile = rs.getString("mobile");
						String[] passwd = rs.getString("password").split(",");
						
						String actualpass = Encrypt.decrypt(passwd[14]);
						
						if (actualpass.equals(password)) {
							session.setAttribute("user", username);

							out.println("<script type=\"text/javascript\">");
							out.println("alert('Login Successfully')");
							out.println("location=\"home.jsp\"");
							out.println("</script>");
						} else {
							count++;
							System.out.println(count);
							if (count < 3) {
									for (int i = 0; i < passwd.length; i++) {
										if (password.equals(Encrypt.decrypt(passwd[i]))) {
											if(passwdrstpolicy.equals("prefix"))
											{
												Pre_postfix fix = new Pre_postfix();
												String newpass = fix.prefix(actualpass);
												String words = HoneyCreater.Hybridhoneywords(newpass);
									        	words = words.substring(1);
												query = "Update userdetails set password='"+words+"' where id = '" + id + "'";
												db.getUpdate(query);
												
												System.out.println("Its honey word");
												SimpleSendEmail sendEmail = new SimpleSendEmail();
												sendEmail.send(email,"Banking Password Encryption Reset", "Your New Password is "+newpass);
												//SendSms.Way2SMS(mobile, "Your New Password is "+newpass);

												response.sendRedirect("mainhome.jsp");
											}
											else
											{
												Pre_postfix fix = new Pre_postfix();
												String newpass = fix.postfix(actualpass);
												String words = HoneyCreater.Hybridhoneywords(newpass);
									        	words = words.substring(1);
												query = "Update userdetails set password='"+words+"' where id = '" + id + "'";
												db.getUpdate(query);
												
												System.out.println("Its honey word");
												SimpleSendEmail sendEmail = new SimpleSendEmail();
												sendEmail.send(email,"Unauthorized Access!!! Banking Password Encryption Reset", "Your New Password is "+newpass);
												//SendSms.Way2SMS(mobile, "Your New Password is "+newpass);
												  mesage91.SendSms.sendmessageto91(mobile, "Your New Password is "+newpass );
												response.sendRedirect("mainhome.jsp");
											}
										}
										else {
											out.println("<script type=\"text/javascript\">");
											out.println("alert('Wrong username or password')");
											out.println("location=\"index.jsp\"");
											out.println("</script>");
										}
									}
								}
						}					
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('No user found of this username')");
					out.println("location=\"index.jsp\"");
					out.println("</script>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
