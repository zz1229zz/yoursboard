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
		<%@ include file="include/header.jsp" %>
		
        <div id="container">
			<%@ include file="include/search.jsp" %>

            <div id="board">
                <table>
                    <tr id="board_first">
                        <td id="no">No</td>
                        <td id="title">Title</td>
                        <td id="date">Date</td>
                    </tr>
                    
                    <c:set var="i" value="${count - ((pagination.curPage-1)*10)}"/>
                    <c:forEach var="row" items="${map.list }" varStatus="status">
	                    <tr>
	                        <td>${i}</td>
	                        <td><a id="title_a" href="${path }/board/view.do?index=${row.index}&curPage=${pagination.curPage}">${row.title }</a></td>
	                        <td><fmt:formatDate value="${row.date }" pattern="yyyy.MM.dd"/></td>
	                    </tr>
                    <c:set var="i" value="${i-1 }"/>
                    </c:forEach>
                </table>
                
				<div id="page">
					<c:if test="${pagination.curPage > 1}">
						<a href="${path }/board/main.do?curPage=${pagination.prevPage }">[이전]</a> 
					</c:if>
					
					<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
						<c:choose>
							<c:when test="${pageNum == pagination.curPage}">
								<span style="font-weight: bold;"><a href="${path }/board/main.do?curPage=${pageNum }">${pageNum }</a></span> 
							</c:when>
							
							<c:otherwise>
								<a href="${path }/board/main.do?curPage=${pageNum }">${pageNum }</a> 
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
						<a href="${path }/board/main.do?curPage=${pagination.nextPage }">[다음]</a> 
					</c:if>
					
					<button onclick="location.href='${path}/board/write.do'">글쓰기</button>
				</div><!-- page -->
            </div><!--board-->
        </div><!--container-->
        <!-- 총 게시글 수 : ${pagination.count } /    총 페이지 수 : ${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage } / 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt } -->
    </section>
</body>
</html>