import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Browser {
	private List<String> cookies;
	private Object/*HttpURLConnection*//*HttpURLConnection*/ conn = null;
	private String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
	private boolean isHTTPS = false;

	public static void main(String[] args) throws Exception {

		new Browser(false).test();
	}

	public void test() throws Exception {
		String url1 = "http://example.com/wp-login.php";//Login page
		String url2 = "http://example.com/wp-admin/edit.php";//logged page to test

		// 1. Send a "GET" request, so you can extract the cookies/cache.
		String page1 = get(url1);

		// 2. Construct above post's content and then send a POST request for authentication
		Parameter[] p = new Parameter[] {new Parameter("log", "tronipm"), new Parameter("pwd", "hahahehehihi")};
		String page2 = post(url1, p);

		// 3. success then go to logged page.
		String page3 = get(url2);

		// 4. printing out the result
		String path2 = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\aa.html";
		Util.escreverEmArquivo(path2, page2, false);
		Desktop.getDesktop().open(new File(path2));
		String path3 = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\aa1.html";
		Util.escreverEmArquivo(path3, page3, false);
		Desktop.getDesktop().open(new File(path3));
	}

	public Browser(boolean isHTTPS) {
		this.isHTTPS = isHTTPS;
		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());		
	}

	private void getHeader() {
		Map<String, List<String>> map = ((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getHeaderFields();


		System.out.println("Printing Response Header...\n");

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
			+ " ,Value : " + entry.getValue());
		}

		String server = ((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getHeaderField("Server");

		if (server == null) {
			System.out.println("Key 'Server' is not found!");
		} else {
			System.out.println("--> Server: " + server + " <--");
		}
	}

	private String post(String url, Parameter[] params) throws Exception {
		String postParams = "";
		if(params!=null) {
			for(Parameter in: params) {
				postParams += in.toString() + "&";
			}
		}

		URL obj = new URL(url);

		if(isHTTPS) {
			conn = (HttpsURLConnection)obj.openConnection();
		} else {
			conn = (HttpURLConnection)obj.openConnection();
		}

		// Acts like a browser
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setUseCaches(false);
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestMethod("POST");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Host", "google.com");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("User-Agent", USER_AGENT);
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		if (cookies != null) {
			for (String cookie : cookies) {
				((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}

		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Connection", "keep-alive");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Referer", "google.com");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Content-Length", Integer.toString(postParams.length()));
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setDoOutput(true);
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setDoInput(true);

		// Send post request
		DataOutputStream wr = new DataOutputStream(((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getOutputStream());
		wr.write(postParams.getBytes(Util.UTF_8));
		wr.flush();
		wr.close();

		int responseCode = ((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);

		//getHeader();

		BufferedReader in = new BufferedReader(new InputStreamReader(((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//return new String(response.toString().getBytes(), Util.UTF_8);
		return response.toString();
	}

	private String get(String url) throws Exception {

		URL obj = new URL(url);
		if(isHTTPS) {
			conn = (HttpsURLConnection)obj.openConnection();
		} else {
			conn = (HttpURLConnection)obj.openConnection();
		}

		// default is GET
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestMethod("GET");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setUseCaches(false);

		// act like a browser
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("User-Agent", USER_AGENT);
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		if (cookies != null) {
			for (String cookie : cookies) {
				((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}
		int responseCode = ((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		//		getHeader();

		BufferedReader in = new BufferedReader(new InputStreamReader(((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Get the response cookies
		setCookies(((conn instanceof HttpURLConnection)?(HttpURLConnection)conn:(HttpsURLConnection)conn).getHeaderFields().get("Set-Cookie"));

		//		return new String(response.toString().getBytes(), Util.UTF_8);
		return response.toString();
	}

	public List<String> getCookies() {
		return cookies;
	}

	public void setCookies(List<String> cookies) {
		this.cookies = cookies;
	}


	class Parameter {
		private String id;
		private String value;

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Parameter(String id, String value) {
			super();
			this.id = id;
			this.value = value;
		}
		public String toString() {
			return getId()+"="+getValue();
		}
	}
}
