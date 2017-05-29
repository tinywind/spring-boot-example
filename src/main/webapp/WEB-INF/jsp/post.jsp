<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="post" type="com.gogokwon.model.Post"--%>
<%--@elvariable id="u" type="com.gogokwon.util.GlobalControllerUtil"--%>


<tag:page write="false">

    <header class="intro-header" style="background-image: url('/img/post-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-heading">
                        <h1>${post.title}</h1>
                        <h2 class="subheading">${post.subtitle}</h2>
                        <span class="meta">Posted by <a href="#">gogokwon</a> on <fmt:formatDate value="${post.date}"
                                                                                                 pattern="yyyy-MM-dd"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post Content -->
    <article>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">${post.content}</div>
            </div>
        </div>
    </article>
    <c:if test="${post.fileUrl != null}">
        <div>
            첨부파일:
            <a target="_blank" href="/files/${post.fileUrl}">${u.filename(post.fileUrl)}</a>
        </div>
    </c:if>

    <div>
        <div class="fixed-action-btn horizontal">
            <a class="btn-floating btn-large red">
                <i class="large material-icons">mode_edit</i>
            </a>
            <ul>
                <li><a class="btn-floating red" href="/write/${post.id}"><i class="material-icons">modify</i></a></li>
                <li><a class="btn-floating yellow darken-1" href="/delete/${post.id}"><i class="material-icons">delete</i></a></li>
                <li><a class="btn-floating green" onclick="history.back()"><i class="material-icons">back</i></a></li>

                <c:if test="${post.fileUrl != null}">
                    <li><a class="btn-floating blue" target="_blank" href="/files/${post.fileUrl}"><i class="material-icons">file</i></a></li>
                </c:if>

            </ul>
        </div>
    </div>


</tag:page>