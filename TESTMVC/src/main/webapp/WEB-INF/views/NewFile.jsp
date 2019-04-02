<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored = "false" %>
     <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
 
  <script src="http://code.jquery.com/jquery-1.12.4.js"></script>
 
  <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <script>
 
  $(function() {
 
    $( ".datepicker" ).datepicker({
    	dateFormat : 'mm/dd/yy',
    	changeMonth : true,
    	changeYear : true,
    	yearRange: '-100y:c+nn',
    	maxDate: '-1d'
    	});
 
  });
 
  </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="datereciever" >
<p>Date: <input type= "text" class="datepicker" name="mydate"/></p>
<input type = "submit" value = "save"/>
 
</form>
</body>
</html>