<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="intro" type="jave.lang.String"--%>
<%--@elvariable id="posts" type="org.springframework.data.domain.Page<com.gogokwon.model.Post>"--%>
<%--@elvariable id="author" type="java.lang.String"--%>

<tag:page title="${title}" intro="${intro}">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <c:forEach items="${posts.content}" var="post" varStatus="status">
                <div class="post-preview">
                    <a href="/post/${post.id}">
                        <h2 class="post-title">${post.title}</h2>
                        <h3 class="post-subtitle">${post.subtitle}</h3>
                    </a>
                    <p class="post-meta">Posted by <a href="#">${author}</a> on
                        <fmt:formatDate value="${post.date}" pattern="yyyy-MM-dd"/></p>
                </div>
                <hr>
            </c:forEach>
            <!-- Pager -->
            <ul class="pager">
                <c:if test="${posts.hasPrevious()}">
                    <li class="prev">
                        <a href="/?page=${posts.previousPageable().pageNumber}">&larr; Previous Posts</a>
                    </li>
                </c:if>
                <c:if test="${posts.hasNext()}">
                <li class="next">
                    <a href="/?page=${posts.nextPageable().pageNumber}">Older Posts &rarr;</a>
                </li>
                </c:if>
            </ul>
        </div>
    </div>
</tag:page>