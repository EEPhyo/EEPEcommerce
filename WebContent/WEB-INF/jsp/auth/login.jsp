<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>

        body{
	      background-image: url('D:\EEPEcommerce\WebContent\WEB-INF\resource\frontedn_ui\images\img\ecommerce.jpg');	      
	      background-size: cover;
	      height: 100%;
	      margin: 0;
	      padding: 0;
	      display: flex;
	      justify-content: center;
	      align-items: center;
    	}
        
        .login{
            width: 30%;
            padding: 20px;
            margin-right:auto;
            margin-left:auto;
            margin-top:90px;

        }
        
        h2{			
            text-align: center; 
            margin-bottom:20px;
            font-weight: bold;          
        }
        
        button{
            padding:40%;
        }

        .ml-2{
            margin-left: 150px;
        }

          
    </style>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<body>
</head>
<body>
	 <div class="container">
        <div class="card login">
            <div class="card-body">
            <h2>Login Form</h2>	
            	 
           		 
                <form:form name="LoginProcess" action="LoginProcess" modelAttribute="bean" method="post"> 
                                   
                    <c:if test="${not empty error}">
                   			 <div class="alert alert-danger">${error}</div>
               			 </c:if>
                    <fieldset>
                        <div class="mb-3">
                            <form:label for="email" class="form-label" path="email">Email</form:label>
                            <form:input type="email" class="form-control" path="email" aria-describedby="emailHelp"/>
                            <form:errors path="email" cssClass="error" />
                        </div>
                     
                   
                   
                        <div class="mb-3">
                            <form:label for="password" class="form-label" path="password">Password</form:label>
                            <input type="password" class="form-control" path="password" id ="pass" aria-describedby="emailHelp"/>
                            <i class="fa fa-eye" id="toggle-confirmPassword"></i>
                            <form:errors path="password" cssClass="error" />
                        </div>
                   
                   		 <button type="reset" class="btn btn-secondary">Cancel</button>                 		                    
                        <button type="submit" class="btn btn-primary ml-2">Login</button>
                       
                    </fieldset>
                    <br>
                    <p>You don't have an account? <a href="/ClothingProj/register">Register here</a>.</p>

                </form:form>
            </div>
        </div>
    </div>
    
</body>
</html>