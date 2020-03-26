package com.kh.still_image.model.vo;

public class StillImage {
   /* ADDFILE_NO */
   private int addfileNo;

   /* ORIGIN_NAME */
   private String originName;

   /* MODIFY_NAME */
   private String modifyName;
   
   private String savePath;

   /* LEVEL */
   private int level;

   /* MOVIE_NO */
   private int movieNo;

public StillImage() {
	super();
	// TODO Auto-generated constructor stub
}

public StillImage(int addfileNo, String originName, String modifyName, String savePath, int level, int movieNo) {
	super();
	this.addfileNo = addfileNo;
	this.originName = originName;
	this.modifyName = modifyName;
	this.savePath = savePath;
	this.level = level;
	this.movieNo = movieNo;
}

public int getAddfileNo() {
	return addfileNo;
}

public void setAddfileNo(int addfileNo) {
	this.addfileNo = addfileNo;
}

public String getOriginName() {
	return originName;
}

public void setOriginName(String originName) {
	this.originName = originName;
}

public String getModifyName() {
	return modifyName;
}

public void setModifyName(String modifyName) {
	this.modifyName = modifyName;
}

public String getSavePath() {
	return savePath;
}

public void setSavePath(String savePath) {
	this.savePath = savePath;
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public int getMovieNo() {
	return movieNo;
}

public void setMovieNo(int movieNo) {
	this.movieNo = movieNo;
}

@Override
public String toString() {
	return "StillImage [addfileNo=" + addfileNo + ", originName=" + originName + ", modifyName=" + modifyName
			+ ", savePath=" + savePath + ", level=" + level + ", movieNo=" + movieNo + "]";
}


   
   

}
