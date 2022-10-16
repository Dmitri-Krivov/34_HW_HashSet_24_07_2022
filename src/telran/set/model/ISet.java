package telran.set.model;

public interface ISet<E> extends Iterable<E> {
boolean add (E element);
boolean remove(E element);
boolean contains(E elenents);
int size();
}
