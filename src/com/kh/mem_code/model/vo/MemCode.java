package com.kh.mem_code.model.vo;

import com.kh.common.StringUtils;


public class MemCode {
   /* MEM_CODE */
   private int memCode;

   /* MEM_TYPE */
   private String memType;

   /* MEM_PRICE */
   private int memPrice;
   
   public MemCode() {
	   
   }

   public MemCode(int memCode, String memType, int memPrice) {
	super();
	this.memCode = memCode;
	this.memType = memType;
	this.memPrice = memPrice;
}

public int getMemCode() {
	return memCode;
}

public void setMemCode(int memCode) {
	this.memCode = memCode;
}

public String getMemType() {
	return memType;
}

public void setMemType(String memType) {
	this.memType = memType;
}

public int getMemPrice() {
	return memPrice;
}

public void setMemPrice(int memPrice) {
	this.memPrice = memPrice;
}

@Override
public String toString() {
	return "MemCode [memCode=" + memCode + ", memType=" + memType + ", memPrice=" + memPrice + "]";
}
   
public boolean isEqualsMemType(String memType) {
	   if(StringUtils.isEmpty(memType)) {
		   return false;
	   }
	   return this.memType.equals(memType);
   }

}
