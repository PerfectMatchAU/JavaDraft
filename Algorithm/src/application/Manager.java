package application;
/**
 * class of manager
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
import java.util.Date;

public class Manager extends User{
	//variables
	public Date applicantDate;				//deadline for applicants
	public Date universityDate;				//deadline for universities
	/**
	 * constructor of class
	 * @param _login - login for superclass
	 * @param _passwd - password for superclass
	 */
	public Manager(String _login, String _passwd) {
		super(_login, _passwd);
	}
	/**
	 * the getter for applicantDate
	 * @return deadline for applicants
	 */
	public Date getApplicantDate() {
		return applicantDate;
	}
	/**
	 * the setter for applicantDate
	 * @param applicantDate - deadline for applicants
	 */
	public void setApplicantDate(Date applicantDate) {
		this.applicantDate = applicantDate;
	}
	/**
	 * the update for applicantDate
	 * @param applicantDate - new deadline for applicant
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateApplicantDate(Date applicantDate) {
		this.applicantDate = applicantDate;
		return true;
	}
	/**
	 * the getter for universityDate
	 * @return deadline for universities
	 */
	public Date getUniversityDate() {
		return universityDate;
	}
	/**
	 * the setter for universityDate
	 * @param universityDate - deadline for universities
	 */
	public void setUniversityDate(Date universityDate) {
		this.universityDate = universityDate;
	}
	/**
	 * the update for universityDate
	 * @param universityDate - new deadline for university
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateUniversityDate(Date universityDate) {
		this.universityDate = universityDate;
		return true;
	}
	/**
	 * the function runs algorithms for matches applicants with universities
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean runAlgorithm() {
		return true;
	}
	/**
	 * the function blocks users
	 * @param _turn - 1, block university; 2- block applicant
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean blockActivities(int _turn) {
		return true;
	}
	/**
	 * the function unblocks users
	 * @param _turn - 1, unblock university; 2- unblock applicant
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean unblockActivities(int _turn) {
		return true;
	}
	/**
	 * the function sends results to user
	 */
	private void sendResults() {
		
	}
}
