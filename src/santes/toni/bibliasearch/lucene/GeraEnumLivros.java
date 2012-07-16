package santes.toni.bibliasearch.lucene;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Session;

import santes.toni.bibliasearch.HibernateConfig;

public class GeraEnumLivros {
	public static void main(String[] args) throws Exception {
		Session s = HibernateConfig.getSessionFactory().getCurrentSession();
		s.beginTransaction();

		List<Livro> livros = s.createQuery("from livros").list();
		StringBuilder sb = new StringBuilder();
		for (Livro livro : livros) {
			sb.append(livro.getNome().toUpperCase().replaceAll("1", "I_").replaceAll("2", "II_").replaceAll("3", "III_"));
			sb.append('(');
			sb.append(livro.getId());
			sb.append(", new int[]{");
			for (int i = 0; i < livro.getCaps(); i++) {
				Object count = s.createSQLQuery(
						"select count(*) from biblia  where liv="
								+ livro.getId() + " and cap=" + (i + 1) + " and versao='acf'")
						.uniqueResult();
				sb.append(count);
				sb.append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("}),\n");
		}
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("teste.txt")));
		stream.write(sb.toString().getBytes());
		stream.close();
		s.close();
	}
}
