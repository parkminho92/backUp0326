package com.kh.review.model.vo;

public class ReviewLHJ {
   /* REVIEW_NO */
   private int reviewNo;

   /* MEMBER_NO */
   private int memberNo;

   /* MOVIE_NO */
   private int movieNo;

   /* REVIEW_TEXT */
   private String reviewText;

   /* REVIEW_RATING */
   private int reviewRating;

   /* BLIND_STATUS */
   private String blindStatus;
   
   private String id;

   public ReviewLHJ() {
	   
   }

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public ReviewLHJ(int reviewNo, int memberNo, int movieNo, String reviewText, int reviewRating, String blindStatus,
		String id) {
	super();
	this.reviewNo = reviewNo;
	this.memberNo = memberNo;
	this.movieNo = movieNo;
	this.reviewText = reviewText;
	this.reviewRating = reviewRating;
	this.blindStatus = blindStatus;
	this.id = id;
}

public ReviewLHJ(int reviewNo, int memberNo, int movieNo, String reviewText, int reviewRating, String blindStatus) {
	super();
	this.reviewNo = reviewNo;
	this.memberNo = memberNo;
	this.movieNo = movieNo;
	this.reviewText = reviewText;
	this.reviewRating = reviewRating;
	this.blindStatus = blindStatus;
}

public int getReviewNo() {
	return reviewNo;
}

public void setReviewNo(int reviewNo) {
	this.reviewNo = reviewNo;
}

public int getMemberNo() {
	return memberNo;
}

public void setMemberNo(int memberNo) {
	this.memberNo = memberNo;
}

public int getMovieNo() {
	return movieNo;
}

public void setMovieNo(int movieNo) {
	this.movieNo = movieNo;
}

public String getReviewText() {
	return reviewText;
}

public void setReviewText(String reviewText) {
	this.reviewText = reviewText;
}

public int getReviewRating() {
	return reviewRating;
}

public void setReviewRating(int reviewRating) {
	this.reviewRating = reviewRating;
}

public String getBlindStatus() {
	return blindStatus;
}

public void setBlindStatus(String blindStatus) {
	this.blindStatus = blindStatus;
}

@Override
public String toString() {
	return "Review [reviewNo=" + reviewNo + ", memberNo=" + memberNo + ", movieNo=" + movieNo + ", reviewText="
			+ reviewText + ", reviewRating=" + reviewRating + ", blindStatus=" + blindStatus + ", id=" + id + "]";
}
   
   
}
