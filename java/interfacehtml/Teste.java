package com.tronipm.java.interfacehtml;

import java.util.*;
import java.lang.*;
import java.util.regex.*;

class Teste {

	//        static final String[] testcases = new String[] {
	//            "'Tumblr' is an amazing app",
	//        "Tumblr is an amazing 'app'",
	//        "Tumblr is an 'amazing' app",
	//        "Tumblr is 'awesome' and 'amazing' ",
	//        "Tumblrs users' are disappointed ",
	//        "Tumblr's 'acquisition' complete but users' loyalty doubtful"
	//        };

	static final String[] testcases = new String[] {
			"href=\"javascript:void(0);\" class=\"font-minus\" id=\"smallerFont\" title='Modificar para o modo de alto contraste' style=\"center;\""
	};

	public static void main (String[] args) throws java.lang.Exception {
		Pattern p1 = Pattern.compile(".\"([^\"]*?)\"(?:$|\\s)", Pattern.MULTILINE);
		Pattern p2 = Pattern.compile(".'([^']*?)'(?:$|\\s)", Pattern.MULTILINE);
		//        Pattern p = Pattern.compile("(?:^|\\s)'([^']*?)'(?:$|\\s)", Pattern.MULTILINE);
		for (String arg : testcases) {
			System.out.println(arg);
			//            System.out.print("Input: "+arg+" -> Matches: ");
			Matcher m1 = p1.matcher(arg);
			Matcher m2 = p2.matcher(arg);
			//			if (m1.find()) {
			//				System.out.println(m1.group().toString().substring(2, m1.group().length()-2));

			ArrayList<String> stringaux = new ArrayList<>();
			boolean t1 = false;
			boolean t2 = false;
			while (m1.find() || m2.find() ) {
				Matcher current = null;
				if(m1.find()) {
					current = m1;
				} else if(m2.find()) {
					System.out.println("AAAAAAAAAAAAAAAAAAAA");
					//						m2.find();
					current = m2;
				} else {
					continue;
				}
				String argAus = arg.trim();
				for(String in1 : stringaux) {
					argAus = argAus.replace(in1, "").trim();
				}

				String title = argAus.split("=")[0].trim();
				stringaux.add(title);
				String contentComQuotes = current.group().toString().substring(0, current.group().length()-1);
				String contentSemQuotes = contentComQuotes.substring(2, current.group().length()-2);
				stringaux.add(contentComQuotes);

				System.out.println(title + " ||| " + contentSemQuotes + " || " + contentComQuotes);

				//t1=false;
			}


			//				while (m2.find()) {
			//					String argAus = arg.trim();
			//					for(String in1 : stringaux) {
			//						argAus = argAus.replace(in1, "").trim();
			//					}
			//
			//					String title = argAus.split("=")[0].trim();
			//					stringaux.add(title);
			//					String contentComQuotes = m2.group().toString().substring(0, m2.group().length()-1);
			//					String contentSemQuotes = contentComQuotes.substring(2, m2.group().length()-2);
			//					stringaux.add(contentComQuotes);
			//
			//					System.out.println(title + " ||| " + contentSemQuotes + " || " + contentComQuotes);
			//				}

			//				Matcher m2 = p2.matcher(arg);
			//
			//				while (m2.find()) {
			//					String title = arg.replace(m2.group().toString().substring(0, m2.group().length()-1), "").split("=")[0];
			//					System.out.println(title + ": " + m2.group().toString().substring(2, m2.group().length()-2));
			//				}
			//
			//				System.out.println();
			//			} else {
			//				System.out.println("NONE");
			//			}
		} 
	}
}