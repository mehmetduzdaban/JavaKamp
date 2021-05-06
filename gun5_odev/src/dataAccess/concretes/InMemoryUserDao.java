package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> users;

	public InMemoryUserDao() {
		this.users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullan�c� eklendi : " + user.getFirstName() + " " + user.getLastName() + " - "
				+ user.getEmail() + " - Do�rulama : " + (user.isVerified() == true ? "Evet" : "Hay�r"));
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� g�ncellendi : " + user.getFirstName() + " " + user.getLastName() + " - "
				+ user.getEmail() + " - Do�rulama : " + (user.isVerified() == true ? "Evet" : "Hay�r"));
	}

	@Override
	public void delete(User user) {
		int result = this.users.indexOf(user);
		this.users.remove(result);
		System.out.println("Kullan�c� silindi.");
	}

	@Override
	public User getById(int id) {
		return this.users.get(id);
	}

	@Override
	public User getByMail(String email) {
		return this.users.stream().filter((user) -> user.getEmail() == email).findFirst().orElse(null);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
