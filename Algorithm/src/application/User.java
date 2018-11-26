package application;
/**
 * class of user
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
public class User {
	//variables
	protected String login;			//login for sign in
	protected String passwd;		//password for sign in
	/**
	 * constructor of class
	 * @param _login - user login
	 * @param _passwd - user password
	 */
	public User(String _login, String _passwd) {
		this.passwd=_passwd;
		this.login= _login;
	}
	/**
	 * the setter for login
	 * @param _login - new login for user
	 */
	public void setLogin(String _login) {
		this.login= _login;
	}
	/**
	 * the getter for login
	 * @return user login 
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * the setter for password
	 * @param _passwd - new password
	 */
	public void setPasswd(String _passwd) {
		this.passwd=_passwd;
	}
	/**
	 * the getter for password
	 * @return user password
	 */
	public String getPasswd() {
		return passwd;
	}
	
}
