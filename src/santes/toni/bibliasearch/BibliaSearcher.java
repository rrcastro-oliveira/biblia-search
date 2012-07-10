package santes.toni.bibliasearch;


public class BibliaSearcher {
	
	private static BibliaSearcher instance = null;
	private BibliaSearcher(){}
	
	public static BibliaSearcher get() {
		if (instance == null) {
			instance = new BibliaSearcher();
		}
		
		return instance;	
	}
	
	public BibliaResults search(String params) {
		return new BibliaResultsImpl(params);
	}
	
	public BibliaResults get(Livro livro) {
		return new BibliaResultsImpl("@" + livro.getStrs()[0]);
	}
	
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		BibliaResults results = BibliaSearcher.get().get(Livro.GENESIS);
		Versiculo v = results.next();
		while (v != null) {
			System.out.println(v.getTexto());
			v = results.next();
		}
		results.close();
			
		System.out.println("levou: " + (System.currentTimeMillis()-l1));
	}
}
