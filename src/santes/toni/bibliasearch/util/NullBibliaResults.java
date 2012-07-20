package santes.toni.bibliasearch.util;

import santes.toni.bibliasearch.BibliaResults;
import santes.toni.bibliasearch.Versiculo;

public class NullBibliaResults implements BibliaResults {

	@Override
	public Versiculo next() {
		return null;
	}

	@Override
	public void close() {

	}

}
