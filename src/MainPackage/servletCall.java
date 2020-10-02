package MainPackage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DatabaseConnection;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class servletCall
 */
@WebServlet("/servletCall")
public class servletCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1 = new DatabaseConnection();
	JsonObject jsonObject;
	Connection con;
	String sendToMObile;
	ArrayList<studentinfo> studentList = new ArrayList<studentinfo>();
	studentinfo student = new studentinfo();
	String year = "100831";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletCall() {
		super();
		con = db1.dbconnection();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession htse = request.getSession(true);
		int additionOfnum = 0;

		String bankid = request.getParameter("username");

		int sha256 = ThreadLocalRandom.current().nextInt(1, 10 + 1);

		int md5op = ThreadLocalRandom.current().nextInt(1, 10 + 1);

		String IMEI = "";
		String IMSI = "";

		String sql = "select * from multifactordata where bankID='" + bankid
				+ "'";
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement(sql);
			// ps1.setString(1, "1" );

			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {

				IMEI = rs.getString("IMEI");
				IMSI = rs.getString("IMSI");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String correct = IMEI + IMSI + bankid;

		String sha256output = "";
		for (int i = 0; i < sha256; i++) {

			if (i == 0) {
				sha256output = sha256(correct);
			} else {
				sha256output = sha256(sha256output);
			}

		}

		String md5output = "";

		for (int i = 0; i < md5op; i++) {

			if (i == 0) {
				md5output = md5(sha256output);
			} else {
				md5output = md5(md5output);
			}

		}

		for (char c : md5output.toCharArray()) {

			additionOfnum = additionOfnum + (int) c;

		}

		String sql1 = "Update multifactordata Set OTP='" + additionOfnum
				+ "' Where bankID='" + bankid + "'";

		PreparedStatement ps11;

		try {
			ps11 = con.prepareStatement(sql1);
			System.out.println(sql1);
			int i = ps11.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("sha256", "" + sha256);
		request.setAttribute("md5op", "" + md5op);
		request.getRequestDispatcher("displayparameters.jsp").forward(request,
				response);

	}

	public static String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static final String md5(final String s) {
		final String MD5 = "MD5";
		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			// Create Hex String
			StringBuilder hexString = new StringBuilder();
			for (byte aMessageDigest : messageDigest) {
				String h = Integer.toHexString(0xFF & aMessageDigest);
				while (h.length() < 2)
					h = "0" + h;
				hexString.append(h);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
}
