<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<form action="/index" method="post">
			<label>Your Name:</label>
			<input name="name" type="text" class="name"><br>
			<label>Dojo Location:</label>
			<select name="location">
				<option value="San Jose">San Jose</option>
				<option value="Fremont">Fremont</option>
				<option value="Santa Clara">Santa Clara</option>
			</select><br>
			<label>Favorite language:</label>
			<select name="lang">
			    <option value="Java">Java</option>
			    <option value="HTML">HTML</option>
			    <option value="CSS">CSS</option>
			    <option value="JavaScript">JavaScript</option>
			    <option value="Python">Python</option>
			</select><br>
			<label>Comment (Optional) : </label>
			<textarea name="comment" rows="4" cols="25"></textarea><br>
			<input type="submit" value="Submit" name="submit">
		</form>
	</div>
</body>
</html>