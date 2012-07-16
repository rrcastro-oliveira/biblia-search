package santes.toni.bibliasearch.lucene;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Session;

import santes.toni.bibliasearch.HibernateConfig;
import santes.toni.bibliasearch.Versiculo;

public class GeraArquivoLivro {
	public static void main(String[] args) throws Exception {
		Session s = HibernateConfig.getSessionFactory().getCurrentSession();
		s.beginTransaction();

		List<Versiculo> Versiculos = s.createQuery("from biblia where versao='acf' order by liv, cap, nver").list();
		
		StringBuilder sb = new StringBuilder();
		
		for (Versiculo v : Versiculos) {
			sb.append(v.getTexto());
			sb.append('\n');
		}
		
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File("acf.txt")));
		
		stream.write(sb.toString().getBytes());
		stream.close();
		s.close();
	}
}
