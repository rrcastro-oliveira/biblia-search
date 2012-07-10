package santes.toni.bibliasearch;

public class Parser {

	public static String parseParams(String params) {
		String[] split = params.trim().split("[ ,:,-]");
		if (split.length == 0)
			return null;
		
		if (split[0].startsWith("@")) {
			split[0] = split[0].substring(1);
			return parsePrint(split);
		}
		else {
			StringBuilder sqlBuilder = new StringBuilder(
					"from biblia where (1=2)");
			int count = 0;
			while (count <= split.length) {
				if (count >= split.length)
					break;
				String s = split[count++];
				sqlBuilder.append(" or (text like '%");
				sqlBuilder.append(s);
				sqlBuilder.append("%')");
			}
			sqlBuilder.append(" and (versao='acf') order by liv, cap, nver");
			return sqlBuilder.toString();
		}
		
	}

	private static String parsePrint(String[] split) {
		StringBuilder sqlBuilder = new StringBuilder(
				"from biblia where (1=2)");

		int count = 0;
		while (count <= split.length) {
			if (count >= split.length)
				break;
			String s = split[count++];
			Livro livro = Livro.get(s);
			if (livro == null)
				return null;
			
			sqlBuilder.append(" or (liv=");
			sqlBuilder.append(livro.getId());

			if (count >= split.length) {
				sqlBuilder.append(')');
				break;
			}
			s = split[count++];
			try {
				int cap = Integer.parseInt(s);
				sqlBuilder.append(" and cap=");
				sqlBuilder.append(cap);
			} catch (NumberFormatException e) {
				sqlBuilder.append(')');
				count--;
				continue;
			}
			
			int vers1=0, vers2=0;
			if (count >= split.length) {
				sqlBuilder.append(')');
				break;
			}
			s = split[count++];
			try {
				vers1 = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				sqlBuilder.append(')');
				count--;
				continue;
			}
			
			if (count >= split.length) {
				sqlBuilder.append(" and nver=");
				sqlBuilder.append(vers1);
				sqlBuilder.append(')');
				break;
			}
			s = split[count++];
			try {
				vers2 = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				sqlBuilder.append(" and nver=");
				sqlBuilder.append(vers1);
				sqlBuilder.append(')');
				count--;
				continue;
			}
			
			sqlBuilder.append(" and (nver>=");
			sqlBuilder.append(vers1);
			sqlBuilder.append(" and nver<=");
			sqlBuilder.append(vers2);
			sqlBuilder.append("))");
		}

		sqlBuilder.append(" and (versao='acf') order by liv, cap, nver");
		return sqlBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(Parser.parseParams("@gn @1 5"));
	}

}
