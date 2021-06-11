<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일기 상세보기</title>
	<%@ include file="include/include.jsp" %>
	<link rel="stylesheet" href="${path }/css/view.css">
</head>
<body>
	<section>
		<%@ include file="include/header.jsp" %>

        <div id="container">
			<%@ include file="include/search.jsp" %>

            <div id="board">
                <table>
                    <tr>
                        <td id="title">${dto.title }</td>
                    </tr>
                    <tr>
                        <td id="date"><fmt:formatDate value="${dto.date }" type="both"/></td>
                    </tr>
                    <tr>
                        <td id="content">${dto.content }</td>
                    </tr>
                </table>
            </div><!--board-->

            <div id="upload">
                <button id="edit_btn">수정</button>                   
                <button id="list_btn" onclick="location.href='${path}/board/main.do?curPage=${curPage}'">목록</button>
            </div>
        </div><!--container-->
    </section>
</body>
</html>