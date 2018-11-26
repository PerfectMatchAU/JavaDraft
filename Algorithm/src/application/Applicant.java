package application;
/**
 * class of applicant
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Applicant extends User{
	//variables
	private boolean projectNature;			//true, applicant has nature project
	private int projectGrade;				//project grade
	private String applicantName;			//name of applicant
	private int applicantid;				//id of applicant
	private int average;					//average of grades from Bachelor degree
	private Map<String, Integer> courseGrades = new HashMap<String, Integer>();				//list of grades
	private Map<Integer, String> preferencerList = new HashMap<Integer, String>();			//preference list of university
	public double rank;						//rank of applicant for calculate
	private String faculty;					//faculty where applicant want study
	public int preferencer=1; 				//index for preference list
	/**
	 * constructor of applicant
	 * @param _login - user login
	 * @param _passwd - user password
	 */
	public Applicant(String _login, String _passwd) {
		super(_login, _passwd);
	}
	/**
	 * the function adds course grade
	 * @param _course - name of course
	 * @param _grade - grade of course
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean addCourseGrades(String _course, int _grade) {
		this.courseGrades.put(_course, _grade);
		return true;
	}
	/**
	 * the getter projectNature
	 * @return true, if applicant has nature project
	 */
	public boolean isProjectNature() {
		return projectNature;
	}
	/**
	 * the getter faculty 
	 * @return name of faculty where applicant want study
	 */
	public String getFaculty() {
		return faculty;
	}
	/**
	 * the update faculty
	 * @param faculty - new faculty where applicant want study
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateFaculty(String faculty) {
		this.faculty = faculty;
		return true;
	}
	/**
	 * the setter projectNature
	 * @param projectNature - true, if applicant has nature project
	 */
	public void setProjectNature(boolean projectNature) {
		this.projectNature = projectNature;
	}
	/**
	 * the update projectNature
	 * @param projectNature - true, if applicant has nature project
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateProjectNature(boolean projectNature) {
		this.projectNature = projectNature;
		return true;
	}
	/**
	 * the getter projectGrade
	 * @return grade of project
	 */
	public int getProjectGrade() {
		return projectGrade;
	}
	/**
	 * the update projectGrade
	 * @param projectGrade - new grade of project
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateProjectGrade(int projectGrade) {
		this.projectGrade = projectGrade;
		return true;
	}
	/**
	 * the getter applicantName
	 * @return name of applicant
	 */
	public String getApplicantName() {
		return applicantName;
	}
	/**
	 * the setter applicantName
	 * @param applicantName - new name for applicant
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	/**
	 * the getter applicantid
	 * @return id of applicant
	 */
	public int getApplicantid() {
		return applicantid;
	}
	/**
	 * the setter applicantid
	 * @param applicantid - new id of applicant
	 */
	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}
	/**
	 * the getter average
	 * @return average
	 */
	public int getAverage() {
		return average;
	}
	/**
	 * the update average
	 * @param average - new average
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateAverage(int average) {
		this.average = average;
		return true;
	}
	/**
	 * the getter courseGrades
	 * @return list of grades
	 */
	public Map<String, Integer> getCourseGrades() {
		return courseGrades;
	}
	/**
	 * the update courseGrades
	 * @param courseGrades - new list of grades
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateCourseGrades(HashMap<String, Integer> courseGrades) {
		this.courseGrades.clear();
		this.courseGrades =(HashMap) courseGrades.clone();
		return true;
	}
	/**
	 * the getter preferenceList
	 * @return list of university
	 */
	public Map<Integer, String> getPreferencerList() {
		return preferencerList;
	}
	/**
	 * the update preferenceList
	 * @param preferencerList - new preferenceList
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updatePreferencerList(HashMap<Integer, String> preferencerList) {
		this.preferencerList.clear();
		this.preferencerList = (HashMap)preferencerList.clone();
		return true;
	}
	/**
	 * the getter rank
	 * @return rank of applicant
	 */
	public double getRank() {
		return rank;
	}
	/**
	 * the setter rank
	 * @param rank - new rank
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean setRank(double rank) {
		this.rank = rank;
		return true;
	}
	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return "Applicant [applicantName=" + applicantName + ", applicantid=" + applicantid + ", rank=" + rank
				+ ", faculty=" + faculty + ", preferencer=" + preferencer + "]";
	}
	/**
	 * Comparator for sorting the list by applicant rank
	 */
    public static Comparator<Applicant> AppRankComparator = new Comparator<Applicant>() {
    	public int compare(Applicant a1, Applicant a2) {
    		double rank1 = a1.getRank();
    		double rank2 = a2.getRank();		
    		if (rank1>rank2)
    			return 1;
    		if (rank1==rank2)
    			return 0;
    		return -1;
    	}};
}