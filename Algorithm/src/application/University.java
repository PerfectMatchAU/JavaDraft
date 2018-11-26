package application;
/**
 * class of university
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
import java.util.ArrayList;
import java.util.List;
public class University extends User{
	//variables
	public String universityName;									//university name
	private List<Faculty> facultyList=new ArrayList<Faculty>();		//list of faculties
	private int numOfFaculties=0;									//number of faculties
	/**
	 * constructor of university
	 * @param _login - user login
	 * @param _passwd - user password
	 */
	public University(String _login, String _passwd) {
		super(_login, _passwd);
	}
	/**
	 * the getter for universityName 
	 * @return universityName
	 */
	public String getUniversityName() {
		return universityName;
	}
	/**
	 * the setter for universityName 
	 * @param universityName - new university name
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	/**
	 * the getter for facultyList
	 * @return list of faculties in the university
	 */
	public List getFacultyList() {
		return facultyList;
	}
	/**
	 * the setter for facultyList
	 * @param facultyList - new faculty list
	 */
	public void setFacultyList(ArrayList<Faculty> facultyList) {
		this.facultyList.clear();
		this.facultyList = (ArrayList)facultyList.clone();
	}
	/**
	 * the getter for NumOfFaculties
	 * @return
	 */
	public int getNumOfFaculties() {
		return numOfFaculties;
	}
	/**
	 * the setter for NumOfFaculties
	 * @param numOfFaculties - new number of faculties
	 */
	public void setNumOfFaculties(int numOfFaculties) {
		this.numOfFaculties = numOfFaculties;
	}
	/**
	 * the function adds new faculty to list 
	 * @param _newFaculty - new faculty
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean addFaculty(Faculty _newFaculty) {
		this.facultyList.add(_newFaculty);
		setNumOfFaculties(this.numOfFaculties+1);
		return true;
	}
	/**
	 * the function removes faculty from list
	 * @param _oldFaculty - faculty for remove
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean removeFaculty(Faculty _oldFaculty) {
		this.facultyList.remove(_oldFaculty);
		setNumOfFaculties(this.numOfFaculties-1);
		return true;
	}
}
