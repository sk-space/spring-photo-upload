<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Image File Upload</title>
</head>
<body>
	<h1>File Upload Example - JavaTpoint</h1>

	<h3 style="color: red">${filesuccess}</h3>
	<form:form method="post"
		action="${ pageContext.request.contextPath }/upload"
		enctype="multipart/form-data">
		<p>
			<label for="image">Choose Image</label>
		</p>
		<p>
			<input name="file" id="fileToUpload" type="file" />
		</p>
		<p>
			<input name="alt" type="text" />
		</p>
		<p>
			<input type="submit" value="Upload">
		</p>
	</form:form>
	
	<h2>Photo...</h2>
	<c:forEach var="p" items="${ pList }">
		<div style=" width:80px, height:100px; border:1px">
			<img alt="${ p.alt }" src="resources/uploads/${ p.photo }" width = "80px" height="100px" border="1px" >
		</div>
	</c:forEach>
	
</body>
</html>
