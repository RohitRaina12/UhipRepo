<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<style>
body {
     background-image: url("https://images.unsplash.com/photo-1511895426328-dc8714191300?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"); fixed;
    background-size: cover;
}
*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    border-radius: 0.3em;
    background-color: lavender;
}

  input[type="text"] {
	width: 70%;
	border: 2px solid #aaa;
	border-radius: 4px;
	margin: 8px 0;
	outline: none;
	padding: 8px;
	box-sizing: border-box;
	transition: 3s ;
}
 input[type="radio"] {
	width: 10%;
	border: 2px solid #aaa;
	border-radius: 2px;
	margin: 4px 0;
	outline: none;
	padding: 8px;
	box-sizing: border-box;
	transition: 3s ;
}
input[type="text"]:focus {
	border-color: dodgerBlue;
	box-shadow: 0 0 8px 0 dodgerBlue;
}
.inputWithIcon input[type="text"]{
    padding-left: 40px;
    
}
.inputWithIcon {
    position: relative;
}
.inputWithIcon i{
    position: absolute;
    left: 0;
    top: 8px;
    padding: 9px 8px;
    color: #aaa;
    transition: 3s;
}
.inputWithIcon input[type="text"]:focus + i{
    color: dodgerBlue;
}

</style>

</head>
<body>
<div >
	<form:form modelAttribute="modelObj" role="form">
	
		
			<h1>Account Registration</h1>
			
				First Name
				<div class="inputWithIcon">
				<form:input type="text" path="firstName" placeholder="Enter First Name"/>
			    <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
			
				Last Name
				<div class="inputWithIcon">
				<form:input type="text" path="lastName" placeholder="Enter Last Name"/>
				<i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
			
				Email
				<div class="inputWithIcon">
				<form:input type="text" path="email" placeholder="Enter Email"/>
			    <i class="fa fa-envelope fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
			
				Password
				<div class="inputWithIcon">
				<form:input type="text" path="pwd" placeholder="Enter Password"/>
			    <i class="fa fa-lock fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
			    
				Date Of Birth
				<div class="inputWithIcon">
				<form:input type="text" path="dob" placeholder="Enter Date Of Birth"/>
			    <i class="fa fa-calendar fa-lg fa-fw" aria-hidden="true"></i>
			    </div> 
			    
				Gender
				<div >
				<form:radiobuttons items="${genderList}"  path="gender"  />
			    </div> 
			
				SSN
				<div class="inputWithIcon">
				<form:input type="text" path="ssn" placeholder="Enter SSN"/>
			    <i class="fa fa-list-alt fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
				Phone Number
				<div class="inputWithIcon">
				<form:input type="text" path="phNumber" placeholder="Enter Phone Number"/>
			    <i class="fa fa-phone fa-lg fa-fw" aria-hidden="true"></i>
			    </div>
			    
				Role
				<div>
				<form:select items="${role}"  path="role"  placeholder="Select Role"/>
			    </div>
				<input type="submit" value="Register">
			
	</form:form>
	</div>
</body>
</html>