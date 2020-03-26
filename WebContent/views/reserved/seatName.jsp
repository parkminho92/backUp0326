<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	String[] seatNos = request.getParameterValues("seatNo");
	int idx = 0;
	for(String seatNo: seatNos) {
		int s = Integer.parseInt(seatNo);
		String seatName = ""; 
		switch((s-1)/4){
			case 0: seatName += "A"; break;
			case 1: seatName += "B"; break;
			case 2: seatName += "C"; break;
			case 3: seatName += "D"; break;
		} 
	
		switch((s)%4){
			case 1: seatName += "1"; break;
			case 2: seatName += "2"; break;
			case 3: seatName += "3"; break;
			case 0: seatName += "4"; break;
		}
		if (idx != 0) {
			out.print(", ");
		}
		out.print(seatName);
		idx++;
	}
%>

</body>
</html>