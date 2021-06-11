<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일기 작성</title>
	<%@ include file="include/include.jsp" %>
	<link rel="stylesheet" href="${path }/css/main.css">
</head>
<body>
	<section>
		<%@ include file="include/header.jsp" %>

        <div id="container">
            <form action="${path }/board/insert.do">
				<%@ include file="include/search.jsp" %>

                <table id="write">
                    <tr>
                        <td id="write_first">제목</td>
                        <td><input type="text" name="title" id="title"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea name="content" id="content" cols="140" rows="25"></textarea></td>
                    </tr>
                </table>

                <div id="upload">
                    <button id="upload_btn" type="submit">등록</button>
                    <label for="file">파일 첨부</label>                    
                    <input id="file" type="file">
                </div>
            </form>
        </div><!--container-->

    </section>
</body>
</html>