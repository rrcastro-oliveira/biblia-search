package santes.toni.bibliasearch;


public class BibliaDao {
	
	private static BibliaDao instance = null;
	private BibliaDao(){}
	
	public static BibliaDao get() {
		if (instance == null) {
			instance = new BibliaDao();
		}
		
		return instance;	
	}
	
	public BibliaResults pesquisar(String params) {
		return new BibliaResultsImpl(params);
	}
	
	
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		BibliaResults results = BibliaDao.get().pesquisar("search \"Jesus chorou\"");
		Versiculo v = results.next();
		while (v != null) {
			System.out.println(v.getTexto());
			v = results.next();
		}
		results.close();
			
		System.out.println("levou: " + (System.currentTimeMillis()-l1));
	}
}
