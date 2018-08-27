/**
 * @author Paulo Mateus
 * @date 27/08/2018
 * @email paulomatew@gmail.com
 * @project ConversorTexto
 */
public abstract class ConversorASCII {

	public static void main(String[] args) {
		String txt = "mé æáé i123";

		System.out.println(ConversorASCII.exec(txt, false));
	}

	/**
	 * Converterá String para ASCII, ignorando os nao ASCIIs. Ex méæáéi123, trará "meaei".
	 * Desconsiderando dígitos e caracteres especiais. APENAS LETRAS.
	 * @param txt String que será convertida para ASCI
	 * @param isUPPER vai trazer a String já em UPPERCASE ou LOWERCASE
	 * @return String convertida para ASCII
	 */
	public static String exec(String txt, boolean isUPPER) {
		StringBuilder sb = new StringBuilder();
		for(char in : txt.toCharArray()) {

			sb.append(String.valueOf(a(in, isUPPER)).trim());
			sb.append(String.valueOf(b(in, isUPPER)).trim());
			sb.append(String.valueOf(c(in, isUPPER)).trim());
			sb.append(String.valueOf(d(in, isUPPER)).trim());
			sb.append(String.valueOf(e(in, isUPPER)).trim());
			sb.append(String.valueOf(f(in, isUPPER)).trim());
			sb.append(String.valueOf(g(in, isUPPER)).trim());
			sb.append(String.valueOf(h(in, isUPPER)).trim());
			sb.append(String.valueOf(i(in, isUPPER)).trim());
			sb.append(String.valueOf(j(in, isUPPER)).trim());
			sb.append(String.valueOf(k(in, isUPPER)).trim());
			sb.append(String.valueOf(l(in, isUPPER)).trim());
			sb.append(String.valueOf(m(in, isUPPER)).trim());
			sb.append(String.valueOf(n(in, isUPPER)).trim());
			sb.append(String.valueOf(o(in, isUPPER)).trim());
			sb.append(String.valueOf(p(in, isUPPER)).trim());
			sb.append(String.valueOf(q(in, isUPPER)).trim());
			sb.append(String.valueOf(r(in, isUPPER)).trim());
			sb.append(String.valueOf(s(in, isUPPER)).trim());
			sb.append(String.valueOf(t(in, isUPPER)).trim());
			sb.append(String.valueOf(u(in, isUPPER)).trim());
			sb.append(String.valueOf(v(in, isUPPER)).trim());
			sb.append(String.valueOf(w(in, isUPPER)).trim());
			sb.append(String.valueOf(x(in, isUPPER)).trim());
			sb.append(String.valueOf(y(in, isUPPER)).trim());
			sb.append(String.valueOf(z(in, isUPPER)).trim());
			sb.append(space(in));//comente para não trazer espaço

		}

		return sb.toString().trim();
	}

	private static char a(char txt, boolean isUPPER) {
		final String pattern = "ÁáÂâÀàÅåÃãÄäaA";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'A' : 'a';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char b(char txt, boolean isUPPER) {
		final String pattern = "Bb";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'B' : 'b';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char c(char txt, boolean isUPPER) {
		final String pattern = "ÇçCc";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'C' : 'c';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char d(char txt, boolean isUPPER) {
		final String pattern = "Dd";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'D' : 'd';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char e(char txt, boolean isUPPER) {
		final String pattern = "ÉéÊêÈèËëEe";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'E' : 'e';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char f(char txt, boolean isUPPER) {
		final String pattern = "Ff";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'F' : 'f';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char g(char txt, boolean isUPPER) {
		final String pattern = "Gg";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'G' : 'g';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char h(char txt, boolean isUPPER) {
		final String pattern = "Hh";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'H' : 'h';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char i(char txt, boolean isUPPER) {
		final String pattern = "ÍíÎîÌìÏïIi";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'I' : 'i';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char j(char txt, boolean isUPPER) {
		final String pattern = "Jj";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'J' : 'j';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char k(char txt, boolean isUPPER) {
		final String pattern = "Kk";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'K' : 'k';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char l(char txt, boolean isUPPER) {
		final String pattern = "Ll";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'L' : 'l';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char m(char txt, boolean isUPPER) {
		final String pattern = "Mm";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'M' : 'm';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char n(char txt, boolean isUPPER) {
		final String pattern = "ÑñNn";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'N' : 'n';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char o(char txt, boolean isUPPER) {
		final String pattern = "ÓóÔôÒòØøÕõÖöOo";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'O' : 'o';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char p(char txt, boolean isUPPER) {
		final String pattern = "Pp";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'P' : 'p';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char q(char txt, boolean isUPPER) {
		final String pattern = "Qq";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'Q' : 'q';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char r(char txt, boolean isUPPER) {
		final String pattern = "Rr";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'R' : 'r';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char s(char txt, boolean isUPPER) {
		final String pattern = "Ss";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'S' : 's';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char t(char txt, boolean isUPPER) {
		final String pattern = "Tt";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'T' : 't';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char u(char txt, boolean isUPPER) {
		final String pattern = "ÚúÛûÙùÜüUu";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'U' : 'u';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char v(char txt, boolean isUPPER) {
		final String pattern = "Vv";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'V' : 'v';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char w(char txt, boolean isUPPER) {
		final String pattern = "Ww";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'W' : 'w';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char x(char txt, boolean isUPPER) {
		final String pattern = "Xx";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'X' : 'x';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char y(char txt, boolean isUPPER) {
		final String pattern = "ÝýYy";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'Y' : 'y';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static char z(char txt, boolean isUPPER) {
		final String pattern = "Zz";
		if(pattern.contains(String.valueOf(txt))) {
			return isUPPER ? 'Z' : 'z';
		} else {
			return Character.MIN_VALUE;
		}
	}
	private static String space(char txt) {
		final String pattern = " ";
		if(pattern.contains(String.valueOf(txt))) {
			return " ";
		} else {
			return "";
		}
	}
}
