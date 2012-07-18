package santes.toni.bibliasearch.lucene;

import santes.toni.bibliasearch.Livro;
import santes.toni.bibliasearch.Versao;

class Parser {

	public static String parseParams(String params, Versao versao) {
		String[] split = params.trim().replaceAll("\\s+", ":").split("[-,:]");
		if (split.length == 0)
			return null;
		
		return parsePrint(split, versao);
	}

	private static String parsePrint(String[] split, Versao versao) {
		StringBuilder sb = new StringBuilder("versao:");
		sb.append(versao.getSrt());
		
		int count = 0;
		String aux = " AND (";
		while (count <= split.length) {
			if (count >= split.length)
				break;
			String s = split[count++];
			
			Livro livro = Livro.get(s);
			if (livro == null)
				return null;
			
			sb.append(aux);
			sb.append("(livro:");
			sb.append(StringUtils.lpad(livro.getId()+"", "0", 3));

			if (count >= split.length)  {
				sb.append(')');
				break;
			}
			
			s = split[count++];
			try {
				int cap = Integer.parseInt(s);
				sb.append(" AND cap:");
				sb.append(StringUtils.lpad(cap+"", "0", 3));
			} catch (NumberFormatException e) {
				sb.append(')');
				count--;
				continue;
			}
			
			int vers1=0, vers2=0;
			if (count >= split.length)  {
				sb.append(')');
				break;
			}
			
			s = split[count++];
			try {
				vers1 = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				sb.append(')');
				count--;
				continue;
			}
			
			if (count >= split.length) {
				sb.append(" AND nver:");
				sb.append(StringUtils.lpad(vers1+"", "0", 3));
				sb.append(')');
				break;
			}
			s = split[count++];
			try {
				vers2 = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				sb.append(" AND nver:");
				sb.append(StringUtils.lpad(vers1+"", "0", 3));
				sb.append(')');
				count--;
				continue;
			}
			
			sb.append(" AND nver:[");
			sb.append(StringUtils.lpad(vers1+"", "0", 3));
			sb.append(" TO ");
			sb.append(StringUtils.lpad(vers2+"", "0", 3));
			sb.append("])");
			aux = " OR ";
		}
		sb.append(")");

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(Parser.parseParams("gn 1   5-8    jo   5 ex 2:4 lv 8 1 4", Versao.ACF));
	}
 
}
