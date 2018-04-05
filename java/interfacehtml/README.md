Usage example (supports http and https):
```JAVA
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
```
