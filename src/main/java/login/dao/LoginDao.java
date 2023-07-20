package login.dao;

public interface LoginDao {

	String authenticate(String email, String password);

}