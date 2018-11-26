package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TEST {
	public static boolean runAlgorithm(Applicant ap1,Applicant ap2,Applicant ap3, University uB, University uM) {
		ArrayList<Applicant> ap = new ArrayList<Applicant>();
		Map<String,Faculty> u = new  HashMap<String,Faculty>();
		ap.add(ap1);	ap.add(ap2);	ap.add(ap3);
		u.put(uB.getUniversityName(), (Faculty) uB.getFacultyList().get(0));
		u.put(uM.getUniversityName(), (Faculty) uM.getFacultyList().get(0));
		Algorithm a = new Algorithm();
		Map<String, List<Applicant>> resultList=a.calculateAlgorithm(ap,u);
		for (Map.Entry<String, List<Applicant>> entry : resultList.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue().toString());
		}
		return true;
	}
	public static void main(String[] args) {
		//applicant
		Applicant ap1 = new Applicant("ap1","123");
		Applicant ap2 = new Applicant("ap2","123");
		Applicant ap3 = new Applicant("ap3","123");
		Applicant ap4 = new Applicant("ap4","123");
		Applicant ap5 = new Applicant("ap5","123");
		Applicant ap6 = new Applicant("ap6","123");
		//fill applicant
		//name
		ap1.setApplicantName("ap1");	ap2.setApplicantName("ap2");	ap3.setApplicantName("ap3");
		ap4.setApplicantName("ap4");	ap5.setApplicantName("ap5");	ap6.setApplicantName("ap6");
		//id
		ap1.setApplicantid(1);	ap2.setApplicantid(2);	ap3.setApplicantid(3);
		ap4.setApplicantid(4);	ap5.setApplicantid(5);	ap6.setApplicantid(6);
		//average
		ap1.updateAverage(70);	ap2.updateAverage(75);	ap3.updateAverage(80);
		ap4.updateAverage(85);	ap5.updateAverage(90);	ap6.updateAverage(95);
		//project nature
		ap1.updateProjectNature(true);	ap2.updateProjectNature(false);	ap3.updateProjectNature(true);
		ap4.updateProjectNature(false);	ap5.updateProjectNature(true);	ap6.updateProjectNature(false);
		//project grade
		ap1.updateProjectGrade(80);	ap2.updateProjectGrade(85);		ap3.updateProjectGrade(90);
		ap4.updateProjectGrade(90);	ap5.updateProjectGrade(100);	ap6.updateProjectGrade(70);
		//grades and rank for comp faculty
		HashMap<String, Integer> GradesComp = new HashMap<String, Integer>();
		GradesComp.put("Comp", 90);				GradesComp.put("Math", 80);				GradesComp.put("Cryptography", 80);
		GradesComp.put("Probability 1", 80);	GradesComp.put("Probability 2", 80);	GradesComp.put("Theory number", 80);
		HashMap<String, Integer> GradesLanguage = new HashMap<String, Integer>();
		GradesLanguage.put("English", 90);			GradesLanguage.put("Math", 80);				GradesLanguage.put("Spanish", 80);
		GradesLanguage.put("Portuguese", 80);		GradesLanguage.put("History", 80);			GradesLanguage.put("Literature", 80);
		
		ap1.updateCourseGrades(GradesComp);
		GradesComp.put("Math", 90);
		ap2.updateCourseGrades(GradesComp);
		GradesComp.put("Cryptography", 70);
		ap3.updateCourseGrades(GradesComp);
		
		ap4.updateCourseGrades(GradesLanguage);
		GradesComp.put("Spanish", 70);
		ap5.updateCourseGrades(GradesLanguage);
		GradesComp.put("History", 90);
		ap6.updateCourseGrades(GradesLanguage);
		//grades and rank for math faculty
		
		HashMap<Integer, String> myRank = new HashMap<Integer, String>();
		myRank.put(1, "berkley");	myRank.put(2,"mit");
		ap1.updatePreferencerList(myRank);
		ap2.updatePreferencerList(myRank);
		myRank.put(1, "b");	myRank.put(2,"m");
		myRank.put(2, "berkley");	myRank.put(1,"mit");
		ap3.updatePreferencerList(myRank);
		
		myRank.put(1, "b");	myRank.put(2,"m");
		myRank.put(1, "berkley");	myRank.put(2,"mit");
		ap4.updatePreferencerList(myRank);
		ap5.updatePreferencerList(myRank);
		myRank.put(1, "b");	myRank.put(2,"m");
		myRank.put(2, "berkley");	myRank.put(1,"mit");
		ap6.updatePreferencerList(myRank);
		
		//faculty
		ap1.updateFaculty("Comp");		ap2.updateFaculty("Comp");		ap3.updateFaculty("Comp");
		ap4.updateFaculty("Language");	ap5.updateFaculty("Language");	ap6.updateFaculty("Language");
		//universities
		//Berkley
		University uB = new University("uB","123");
		uB.setUniversityName("berkley");
		uB.setNumOfFaculties(2);
		Faculty fComp = new Faculty();
		fComp.setFacultyName("Comp");
		fComp.updateMinAverage(70);
		fComp.updateProjectGrade(80);
		fComp.updateProjectNature(false);
		fComp.updateNumOfApplicants(1);
		//
		fComp.updateFormulaWeights("Comp",1);			fComp.updateFormulaWeights("Math",1);			fComp.updateFormulaWeights("Cryptography",2);
		fComp.updateFormulaWeights("Probability 1",1);	fComp.updateFormulaWeights("Probability 2",2);	fComp.updateFormulaWeights("Theory number",2);
		//
		fComp.updateMinGrades("Comp",70);			fComp.updateMinGrades("Math",70);			fComp.updateMinGrades("Cryptography",70);
		fComp.updateMinGrades("Probability 1",70);	fComp.updateMinGrades("Probability 2",70);	fComp.updateMinGrades("Theory number",70);
		uB.addFaculty(fComp);
		
		Faculty fLanguage = new Faculty();
		fLanguage.setFacultyName("Language");
		fLanguage.updateMinAverage(70);
		fLanguage.updateProjectGrade(80);
		fLanguage.updateProjectNature(false);
		fLanguage.updateNumOfApplicants(2);
		//
		fLanguage.updateFormulaWeights("English",1);			fLanguage.updateFormulaWeights("Math",1);			fLanguage.updateFormulaWeights("Spanish",2);
		fLanguage.updateFormulaWeights("Portuguese",1);			fLanguage.updateFormulaWeights("History",2);		fLanguage.updateFormulaWeights("Literature",2);
		//
		fLanguage.updateMinGrades("English",70);			fLanguage.updateMinGrades("Math",70);			fLanguage.updateMinGrades("Spanish",70);
		fLanguage.updateMinGrades("Portuguese",70);			fLanguage.updateMinGrades("History",70);		fLanguage.updateMinGrades("Literature",70);
		uB.addFaculty(fLanguage);
		
		//MIT
		University uM = new University("uM","123");
		uM.setUniversityName("mit");
		uM.setNumOfFaculties(2);
		Faculty fComp2 = new Faculty();
		fComp2.setFacultyName("Comp");
		fComp2.updateMinAverage(70);
		fComp2.updateProjectGrade(80);
		fComp2.updateProjectNature(false);
		fComp2.updateNumOfApplicants(2);
		//
		fComp2.updateFormulaWeights("Comp",1);			fComp2.updateFormulaWeights("Math",1);			fComp2.updateFormulaWeights("Cryptography",2);
		fComp2.updateFormulaWeights("Probability 1",1);	fComp2.updateFormulaWeights("Probability 2",2);	fComp2.updateFormulaWeights("Theory number",2);
		//
		fComp2.updateMinGrades("Comp",70);			fComp2.updateMinGrades("Math",70);			fComp2.updateMinGrades("Cryptography",70);
		fComp2.updateMinGrades("Probability 1",70);	fComp2.updateMinGrades("Probability 2",70);	fComp2.updateMinGrades("Theory number",70);
		uM.addFaculty(fComp2);
		
		Faculty fLanguage2 = new Faculty();
		fLanguage2.setFacultyName("Language");
		fLanguage2.updateMinAverage(70);
		fLanguage2.updateProjectGrade(80);
		fLanguage2.updateProjectNature(false);
		fLanguage2.updateNumOfApplicants(1);
		//
		fLanguage2.updateFormulaWeights("English",1);			fLanguage2.updateFormulaWeights("Math",1);			fLanguage2.updateFormulaWeights("Spanish",2);
		fLanguage2.updateFormulaWeights("Portuguese",1);		fLanguage2.updateFormulaWeights("History",2);		fLanguage2.updateFormulaWeights("Literature",2);
		//
		fLanguage2.updateMinGrades("English",70);			fLanguage2.updateMinGrades("Math",70);			fLanguage2.updateMinGrades("Spanish",70);
		fLanguage2.updateMinGrades("Portuguese",70);		fLanguage2.updateMinGrades("History",70);		fLanguage2.updateMinGrades("Literature",70);
		uM.addFaculty(fLanguage2);
		//
		//
		//
		System.out.println("\n\n" +runAlgorithm(ap1, ap2, ap3, uB, uM));
	}

}
