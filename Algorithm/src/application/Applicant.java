package application;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Applicant extends User{
	//variables
	private boolean projectNature;
	private int projectGrade;
	private String applicantName;
	private int applicantid;
	private int average;
	private Map<String, Integer> courseGrades = new HashMap<String, Integer>();
	private Map<Integer, String> preferencerList = new HashMap<Integer, String>();
	public double rank;
	private String faculty;
	public int preferencer=1; 
	//constructors
	public Applicant(String _login, String _passwd) {
		super(_login, _passwd);
	}
	//set information
	public boolean addCourseGrades(String _course, int _grade) {
		this.courseGrades.put(_course, _grade);
		return true;
	}
	public boolean isProjectNature() {
		return projectNature;
	}
	public String getFaculty() {
		return faculty;
	}
	public boolean updateFaculty(String faculty) {
		this.faculty = faculty;
		return true;
	}
	public void setProjectNature(boolean projectNature) {
		this.projectNature = projectNature;
	}
	public boolean updateProjectNature(boolean projectNature) {
		this.projectNature = projectNature;
		return true;
	}
	public int getProjectGrade() {
		return projectGrade;
	}
	public boolean updateProjectGrade(int projectGrade) {
		this.projectGrade = projectGrade;
		return true;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public int getApplicantid() {
		return applicantid;
	}
	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}
	public int getAverage() {
		return average;
	}
	public boolean updateAverage(int average) {
		this.average = average;
		return true;
	}
	public Map<String, Integer> getCourseGrades() {
		return courseGrades;
	}
	public boolean updateCourseGrades(HashMap<String, Integer> courseGrades) {
		this.courseGrades.clear();
		this.courseGrades =(HashMap) courseGrades.clone();
		return true;
	}
	public Map<Integer, String> getPreferencerList() {
		return preferencerList;
	}
	public boolean updatePreferencerList(HashMap<Integer, String> preferencerList) {
		this.preferencerList.clear();
		this.preferencerList = (HashMap)preferencerList.clone();
		return true;
	}
	public double getRank() {
		return rank;
	}
	public boolean setRank(double rank) {
		this.rank = rank;
		return true;
	}
	//toString()
	@Override
	public String toString() {
		return "Applicant [applicantName=" + applicantName + ", applicantid=" + applicantid + ", rank=" + rank
				+ ", faculty=" + faculty + ", preferencer=" + preferencer + "]";
	}
	
	 /*Comparator for sorting the list by applicant rank*/
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