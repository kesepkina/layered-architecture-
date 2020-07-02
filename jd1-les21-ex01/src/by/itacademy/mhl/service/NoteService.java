package by.itacademy.mhl.service;

import by.itacademy.mhl.bean.Note;

public interface NoteService {

	void add(Note note) throws ServiceException;

	boolean edit(int id, Note editNote) throws ServiceException;
}
