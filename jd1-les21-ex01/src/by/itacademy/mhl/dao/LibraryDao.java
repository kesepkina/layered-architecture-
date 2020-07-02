package by.itacademy.mhl.dao;

import java.util.List;

import by.itacademy.mhl.bean.Note;

public interface LibraryDao {

	List<Note> allCatalog() throws DaoException;
	List<Note> findAllInCategory(String categoryName) throws DaoException;
	void add(Note newNote) throws DaoException;
	boolean edit(int id, Note editNote) throws DaoException;
}
