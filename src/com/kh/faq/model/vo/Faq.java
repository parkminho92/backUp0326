package com.kh.faq.model.vo;

public class Faq {
   /* FAQ_NO */
   private int faqNo;

   /* QUESTION */
   private String question;

   /* ANSWER */
   private String answer;
   
   public Faq() {
	   
   }


public Faq(int faqNo, String question, String answer) {
	super();
	this.faqNo = faqNo;
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

@Override
public String toString() {
	return "Faq [faqNo=" + faqNo + ", question=" + question + ", answer=" + answer + "]";
}
   

}
