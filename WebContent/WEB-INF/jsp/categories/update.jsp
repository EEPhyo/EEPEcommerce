<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce Management</title>	
    
    <jsp:include page="../layouts/top-html-start-head-tag.jsp"></jsp:include>  
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/daterangepicker/daterangepicker.css">
</head>
	
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">	
		<jsp:include page="../layouts/header.jsp"></jsp:include>
		<jsp:include page="../layouts/sidebar.jsp"></jsp:include>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Update Category</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                <li class="breadcrumb-item"> <a href="<c:url value='/category' />">Categories List</a></li>
                                <li class="breadcrumb-item active">update</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>
            
            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <c:if test="${not empty error}">
                   			 <div class="alert alert-danger">${error}</div>
               			 </c:if>
                            
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Update Category Form</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
        
                                <form:form action="/ClothingProj/update" modelAttribute="bean" method="POST">
                               
                                 
                                 
								    <div class="card-body">
								          <p style="color:red">All star(*) fields are required</p>
								        
								          <form:input type="hidden" name="category_id" path="category_id" value="${category.category_id}" />
								          
								        <div class="form-group">
								            <form:label for="name" path="name">Title <span style="color:red">*</span></form:label>
								            <form:input type="text" class="form-control" path="name" id="name" name="name" />
								        </div>
								    </div>
								    <!-- /.card-body -->
								    <div class="card-footer">
								        <button type="submit" class="btn btn-primary">Update</button>
								        <a href="<c:url value='/category' />" class="btn btn-default" style="float: right;">Cancel</a>
								    </div>
								</form:form>

                            </div>                            
                            
                        </div>
                        
                    </div>
                </div>
             
            
            </section>
         </div>
        
        
   <jsp:include page="../layouts/footer.jsp"></jsp:include>
  
</div>		
		
<!-- DataTables  & Plugins -->
<script src="${pageContext.request.contextPath}/resource/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/jszip/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resource/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resource/dist/js/demo.js"></script>

<jsp:include page="../layouts/script-index.jsp"></jsp:include>
		
</body>
</html>
       