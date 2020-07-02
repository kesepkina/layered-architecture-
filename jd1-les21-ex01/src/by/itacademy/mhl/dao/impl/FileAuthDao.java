package by.itacademy.mhl.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import by.itacademy.mhl.bean.UserInfo;
import by.itacademy.mhl.dao.AuthDao;
import by.itacademy.mhl.dao.DaoException;

public class FileAuthDao implements AuthDao {

	@Override
	public String authorization(String login, String password) throws DaoException {
		FileReader reader = null;

		boolean isUser, isExistingLogin;
		isUser = false;
		isExistingLogin = false;
		String[] params = null;

		try {
			reader = new FileReader("resources/users.txt");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(reader);

			String nextLine;

			while (scan.hasNextLine()) {
				nextLine = scan.nextLine();
				params = nextLine.split("\\s+");
				if (params[0].equals(login)) {
					isExistingLogin = true;
					if (params[1].equals(password)) {
						isUser = true;
					}
					break;
				}
			}

		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// log - error
					System.err.println(e);
				}
			}
		}

		if (isUser) {
			return params[5];
		} else if (isExistingLogin) {
			return "INCORRECT PASSWORD";
		} else {
			return "USER WITH THIS LOGIN DOESN'T EXIST";
		}
	}

	@Override
	public void registration(UserInfo newUser) {
		// TODO Auto-generated method stub

	}

}
