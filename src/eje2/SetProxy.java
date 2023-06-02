package eje2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetProxy implements Set<Telefono> {

	private Integer       puntero;
	private Set<Telefono> set;
	private PersonaDao    personaDao;

	public SetProxy(int idPersona, PersonaDao personaDao) {
		this.puntero    = idPersona;
		this.set        = new HashSet<>();
		this.personaDao = personaDao;
	}

	@Override
	public int size() {

		return set.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public Iterator<Telefono> iterator() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public Object[] toArray() {

		this.set = this.personaDao.telefonos(this.puntero);

		return this.set.toArray();

	}

	@Override
	public <T> T[] toArray(T[] a) {

		// Aca haria la consulta con idPersona, y traigo la lista de telefonos
		return null;
	}

	@Override
	public boolean add(Telefono e) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Telefono> c) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public void clear() {
		// TODO Esbozo de método generado automáticamente

	}

}
