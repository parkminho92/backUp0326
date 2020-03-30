package com.kh.faq.model.vo;

public class Faq {
   /* FAQ_NO */
   private int faqNo;

   /* QUESTION */
   private String question;

   /* ANSWER */
   private String answer;
   
   /* TYPE */
   private String type;
   
   /* STATUS */
   private String status;
   
   public Faq() {
	   
   }

public Faq(int faqNo, String question, String answer, String type, String status) {

	super();
	this.faqNo = faqNo;
	this.question = question;
	this.answer = answer;
	this.type = type;
	this.status = status;
}

public Faq(int faqNo, String type, String question) {
	super();
	this.faqNo = faqNo;
	this.type = type;
	this.question = question;
}



public Faq(int faqNo, String type, String question, String answer) {
	super();
	this.faqNo = faqNo;
	this.type = type;
	this.question = question;
	this.answer = answer;
}

public int getFaqNo() {
	return faqNo;
}

public void setFaqNo(int faqNo) {
	this.faqNo = faqNo;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}

	public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", question=" + question + ", answer=" + answer + ", type=" + type + ", status="
				+ status + "]";
	}
}
