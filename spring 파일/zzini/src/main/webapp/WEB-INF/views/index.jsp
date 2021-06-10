<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<%@ include file="include/include.jsp" %>
	<link rel="stylesheet" href="${path }/css/index.css">
</head>
<body>
    <section>
        <div id="container">
			<form action="${path }/member/login_check.do" method="post">
			
				<c:if test="${message == 'error' }">
					<div style="color:red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
				</c:if>
				
	            <div>
	                <p>LOGIN</p>
	            </div>
	
	            <div>
	                <input type="text" placeholder="ID" name="id" required><br>
	                <input type="password" placeholder="PASSWORD" name="passwd" required>
	            </div>
	
	            <div id="bottom">
	                <button type="submit">로그인</button><br>
	                <a href="">아이디 찾기</a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp<a href="">비밀번호 찾기</a>
	            </div>
            </form>
        </div>
    </section>
</body>
</html>