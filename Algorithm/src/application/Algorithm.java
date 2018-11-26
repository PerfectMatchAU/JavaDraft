package application;
/**
 * class of algorithm
 * @author Alexey Titov
 * @version 1.1
 * @data 11.2018
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {
	/**
	 * the function calculates rank for applicant using formula.
	 * @param a - applicant
	 * @param weight - weight of course
	 * @return rank for applicant
	 */
	private double calculateApplicantRank(Applicant a, Map<String,Integer> weight) {
		double rank=0;
		for (Map.Entry<String, Integer> entry : weight.entrySet()) {
			rank+=a.getCourseGrades().get(entry.getKey())*entry.getValue();
		}
		rank+=a.getAverage();
		if (a.isProjectNature())
			rank+=20;
		rank= rank/(weight.size()+1);
		return rank;
	}
	/*
	private List<Applicant> compareApplicantRank() {
		List<Applicant> newList = new ArrayList<Applicant>();
		return newList;
	}*/
	/**
	 * the function checks if applicant meets the requirements.
	 * @param minGrades	- minimum grades for course 
	 * @param Grades - grades of applicant
	 * @param minAverage - minimum average
	 * @param Average - average of applicant 
	 * @param minProjectNature - true, if applicant needs have nature project; false, otherwise
	 * @param ProjectNature - true, if applicant has nature project; false, otherwise 
	 * @return true, if applicant meets the requirements
	 */
	private boolean checkMin(Map<String, Integer> minGrades,Map<String, Integer> Grades, int minAverage, int Average, boolean minProjectNature, boolean ProjectNature) {
		try {
			if (minProjectNature && !ProjectNature)						//need project nature, but applicant have not 
				return false;
			if (Average<minAverage)										//average is less than the lower bound
				return false;
			for (Map.Entry<String, Integer> entry : Grades.entrySet()) {
				if (minGrades.get(entry.getKey())>entry.getValue())		//grade is less than the lower bound
					return false;
			}
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}
	/**
	 * the function matches applicants with universities 
	 * @param a - list of applicant 
	 * @param uF - list of faculties
	 * @return list of matches applicants with universities
	 */
	public Map<String, List<Applicant>> calculateAlgorithm(ArrayList<Applicant> a, Map<String,Faculty> uF){
		Map<String, List<Applicant>> result = new HashMap<String, List<Applicant>>();
		boolean flag=true;
		ArrayList<Applicant> tmpA = new ArrayList<Applicant>();
		tmpA = (ArrayList)a.clone();
		while (flag) {
			//-------------------------------------------------------SET APPLICANT-----------------------------------------
			int bound = tmpA.size();
			for (int i=bound-1;i>-1;--i) {
				Applicant tmp = tmpA.get(i);
				boolean un=true;
				while (un) {
					Faculty f = uF.get(tmp.getPreferencerList().get(tmp.preferencer));
					if (checkMin(f.getMinGrades(),tmp.getCourseGrades(),f.getMinAverage(),tmp.getAverage(),f.projectNature,tmp.isProjectNature())) {
						tmp.setRank(calculateApplicantRank(tmp,f.getFormulaWeights()));
						uF.get(tmp.getPreferencerList().get(tmp.preferencer)).addApplicant(tmp);
						un = false;
					}else
						tmp.preferencer++;
				}
				tmpA.remove(i);
			}
			//-------------------------------------------------------REMOVE APPLICANT--------------------------------------
			for (Map.Entry<String, Faculty> entry : uF.entrySet()) {
				Collections.sort(entry.getValue().getApplicants(), Applicant.AppRankComparator);
				int _bound = entry.getValue().getNumOfApplicants();
				int _size = entry.getValue().getApplicants().size();
				if (_bound<_size)
					for (int i=_size-1;i>=_bound;--i) {
						entry.getValue().getApplicants().get(i).preferencer++;
						tmpA.add(entry.getValue().getApplicants().get(i));
						entry.getValue().removeApplicant(entry.getValue().getApplicants().get(i));
					}
			}
			//------------------------------------------------------CHECK RESULT-------------------------------------------
			if (tmpA.isEmpty())
				flag = false;
		}
		//fill final result of matches
		for (Map.Entry<String, Faculty> entry : uF.entrySet()) {
			result.put(entry.getKey()+" "+entry.getValue().getFacultyName(), entry.getValue().getApplicants());
		}
		return result;
	}
}
