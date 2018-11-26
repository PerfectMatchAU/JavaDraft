package application;
/**
 * class of faculty
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty {
	//variables
	protected String facultyName;			//faculty name
	protected int minAverage;				//minimum average of faculty
	protected boolean projectNature;		//true, faculty requires nature project from applicant
	protected int projectGrade;				//minimum project grade
	protected int numOfApplicants;			//number of applicant that faculty wants study
	protected Map<String, Integer> minGrades=new HashMap<String, Integer>();				//list minimum grades
	protected Map<String, Integer> formulaWeights=new HashMap<String, Integer>();;			//list with grade weight 
	protected List<Applicant> applicants=new ArrayList<Applicant>();						//list of applicants
	/**
	 * constructor of faculty
	 */
	public Faculty() {
	}
	/**
	 * the getter facultyName
	 * @return faculty name
	 */
	public String getFacultyName() {
		return facultyName;
	}
	/**
	 * the setter facultyName
	 * @param facultyName - faculty name
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	/**
	 * the getter minAverage
	 * @return minimum average
	 */
	public int getMinAverage() {
		return minAverage;
	}
	/**
	 * the update minAverage
	 * @param minAverage - minimum average for faculty
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateMinAverage(int minAverage) {
		this.minAverage = minAverage;
		return true;
	}
	/**
	 * the getter project nature
	 * @return true, if faculty requires nature project from applicant
	 */
	public boolean isProjectNature() {
		return projectNature;
	}
	/**
	 * the update projectNature
	 * @param projectNature - new value projectNature
	 * @return  faculty requires nature project from applicant
	 */
	public boolean updateProjectNature(boolean projectNature) {
		this.projectNature = projectNature;
		return true;
	}
	/**
	 * the getter projectGrade
	 * @return minimum project grade that faculty requires
	 */
	public int getProjectGrade() {
		return projectGrade;
	}
	/**
	 * the update projectGrade
	 * @param projectGrade - new minimum project grade of faculty
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateProjectGrade(int projectGrade) {
		this.projectGrade = projectGrade;
		return true;
	}
	/**
	 * the function getter numOfApplicant
	 * @return numOfApplicant
	 */
	public int getNumOfApplicants() {
		return numOfApplicants;
	}
	/**
	 * the update numOfApplicant
	 * @param numOfApplicants - new numberr of applicant for faculty
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateNumOfApplicants(int numOfApplicants) {
		this.numOfApplicants = numOfApplicants;
		return true;
	}
	/**
	 * the getter minGrades
	 * @return list of minimum grades of course 
	 */
	public Map<String, Integer> getMinGrades() {
		return minGrades;
	}
	/**
	 * the update minGrades
	 * @param minGrades - new minimum grades for cource
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateMinGrades(HashMap<String, Integer> minGrades) {
		this.minGrades.clear();
		this.minGrades = (HashMap)minGrades.clone();
		return true;
	}
	/**
	 * the getter formulaWeights
	 * @return list of weights of grades
	 */
	public Map<String, Integer> getFormulaWeights() {
		return formulaWeights;
	}
	/**
	 * the update formulaWeights
	 * @param formulaWeights - new weights of grades
	 */
	public void updateFormulaWeights(HashMap<String, Integer> formulaWeights) {
		this.formulaWeights.clear();
		this.formulaWeights = (HashMap)formulaWeights.clone();
	}
	/**
	 * the getter applicants
	 * @return list of applicants in faculty
	 */
	public List<Applicant> getApplicants() {
		return applicants;
	}
	/**
	 * 
	 * @param applicants
	 */
	public void setApplicants(ArrayList<Applicant> applicants) {
		this.applicants.clear();
		this.applicants = (ArrayList) applicants.clone();
	}
	/**
	 * 
	 * @param _newApplicant
	 * @return
	 */
	public boolean addApplicant(Applicant _newApplicant) {
		this.applicants.add(_newApplicant);
		return true;
	}
	/**
	 * 
	 * @param _oldApplicant
	 * @return
	 */
	public boolean removeApplicant(Applicant _oldApplicant) {
		this.applicants.remove(_oldApplicant);
		return true;
	}
	/**
	 * 
	 * @param _course
	 * @param _grade
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateMinGrades(String _course, int _grade) {
		this.minGrades.put(_course, _grade);
		return true;
	}
	/**
	 * 
	 * @param _course
	 * @param _weight
	 * @return true, if it was able to update; false, otherwise
	 */
	public boolean updateFormulaWeights(String _course, int _weight) {
		this.formulaWeights.put(_course, _weight);
		return true;
	}
	/**
	 * toString for Faculty
	 */
	@Override
	public String toString() {
		return "Faculty [facultyName=" + facultyName + ", numOfApplicants=" + numOfApplicants + ", applicants="
				+ applicants + "]";
	}
}
