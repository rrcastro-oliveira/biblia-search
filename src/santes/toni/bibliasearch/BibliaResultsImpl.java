package santes.toni.bibliasearch;

import org.hibernate.FlushMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;



class BibliaResultsImpl implements BibliaResults
{

	private final Session s;
	private ScrollableResults cursor;

	public BibliaResultsImpl(String params, Versao versao)
	{
		s = HibernateConfig.getSessionFactory().getCurrentSession();
		
		s.beginTransaction();
		String sql = Parser.parseParams(params, versao);
		cursor = s.createQuery(sql).setReadOnly(true).setFetchSize(200).setCacheable(false).setFlushMode(FlushMode.COMMIT).scroll();
	}
	
	@Override
	public void close()
	{
		s.getTransaction().commit();
		if (s.isOpen()) {
			s.close();
		}
	}

	@Override
	public Versiculo next()
	{
		if (cursor.next())
			return (Versiculo) cursor.get(0);
		return null;
	}
	
}
