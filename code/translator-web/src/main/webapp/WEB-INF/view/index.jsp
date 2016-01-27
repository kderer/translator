<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
	<link rel="stylesheet" type="text/css"
		href="<spring:url value="/assets/jquery-mobile/jquery.mobile-1.4.5.min.css"/>">
	<link rel="stylesheet" type="text/css"
		href="<spring:url value="/assets/css/style.css"/>">
		
	<script type="text/javascript"
		src="<spring:url value="/assets/js/jquery-1.11.3.min.js"/>"></script>
	<script type="text/javascript"
		src="<spring:url value="/assets/jquery-mobile/jquery.mobile-1.4.5.min.js"/>"></script>
	<script type="text/javascript"
		src="<spring:url value="/assets/js/index.js"/>"></script>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><spring:message code="label.index.title" /></title>
</head>
<body>
	<div data-role="page">

		<div data-role="header">
			<h1>Translator</h1>
		</div>

		<div data-role="content">
			<form method="post" action="translate.request" id="translateForm">
				<div class="ui-grid-a">
				<div class="ui-block-a">
					<select name="fl" id="flSelect">
						<option value=""><spring:message code="label.select.from" /></option>
						<c:forEach items="${languages}" var="language">
							<option value="${language.code}"><spring:message
									code="${language.i18nKey}" /></option>
						</c:forEach>
					</select>
				</div>
					
				<div class="ui-block-b">
					<select name="tl" id="tlSelect">
						<option value="">
							<spring:message code="label.select.to" /></option>
						<c:forEach items="${languages}" var="language">
							<option value="${language.code}"><spring:message
									code="${language.i18nKey}" /></option>
						</c:forEach>
					</select>
				</div>
				</div>
				<div class="ui-grid-b textDiv">
					<textarea name="text" id="textInput"></textarea>                    
				</div>																
			</form>
			
			<div class="ui-grid-c requestPinyinDiv" style="display: none;" id="requestPinyinOutputDiv">
                <span id="requestPinyinOutput"> </span>
            </div>
            
            <div class="ui-field-contain responseTextDiv" style="display: none;" id="resultTextOutputDiv">
				<span id="resultTextOutput"> </span>
                <div class="responsePinyinDiv" style="display: none;" id="resultPinyinOutputDiv">
                    <span id="resultPinyinOutput"> </span>
                </div>
			</div>
		</div>
	</div>	
</body>
</html>