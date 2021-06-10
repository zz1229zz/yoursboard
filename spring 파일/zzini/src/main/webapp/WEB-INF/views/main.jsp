<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>yoursboard</title>
	<%@ include file="include/include.jsp" %>
	<link rel="stylesheet" href="${path }/css/main.css">
</head>
<body>
	<section>
        <header>
            <p>YOURSBOARD</p>
            <a>로그아웃</a>
            <span>${sessionScope.name}님</span>
        </header>

        <div id="container">
            
            <form action="">
	            <div id="search">
	                <input id="search_date" name="date" type="date">
	                <button id="search_btn" type="submit">GO</button>
	            </div><!--search-->
            </form>

            <div id="board">
                <table>
                    <tr id="board_first">
                        <td id="no">No</td>
                        <td id="title">Title</td>
                        <td id="date">Date</td>
                    </tr>
                    <c:set var="i" value="${count}"/>
                    <c:forEach var="row" items="${map.list }" varStatus="status">
	                    <tr>
	                        <td>${i}</td>
	                        <td>${row.title }</td>
	                        <td><fmt:formatDate value="${row.date }" pattern="yyyy.MM.dd"/></td>
	                    </tr>
                    <c:set var="i" value="${i-1 }"/>
                    </c:forEach>
                </table>
            </div><!--board-->
        </div><!--container-->
    </section>
</body>
</html>