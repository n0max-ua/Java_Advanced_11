package ua.lviv.lgs.shared;

import java.util.List;

public interface AbstractCRUD<T> {
	T create(T t);

	T readById(Integer id);

	T update(Integer Id, T t);

	void delete(Integer id);

	List<T> readAll();
}
