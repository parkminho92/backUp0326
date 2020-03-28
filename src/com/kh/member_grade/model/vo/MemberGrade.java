package com.kh.member_grade.model.vo;

public class MemberGrade {
   /* GRADE */
   private String grade;

   /* GRADE_CONDITION */
   private String gradeCondition;

   /* GRADE_BENEFIT */
   private String gradeBenefit;

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

public String getGradeCondition() {
	return gradeCondition;
}

public void setGradeCondition(String gradeCondition) {
	this.gradeCondition = gradeCondition;
}

public String getGradeBenefit() {
	return gradeBenefit;
}

public void setGradeBenefit(String gradeBenefit) {
	this.gradeBenefit = gradeBenefit;
}

public MemberGrade(String gradeCondition, String gradeBenefit) {
	this.gradeCondition = gradeCondition;
	this.gradeBenefit = gradeBenefit;
}

   
}
