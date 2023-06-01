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
  
	
	<link rel="stylesheet" href="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" href="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
	<link rel="stylesheet" href="$ {Pagecontext. Request. contextpath }/../resource/plugins/daterangepicker/daterangepicker.css">
</head>
	
<body class="hold-transition sidebar-mini layout-fixed">
		
		<jsp:include page="../layouts/header.jsp"></jsp:include>
		<jsp:include page="../layouts/sidebar.jsp"></jsp:include>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Create Category</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                <li class="breadcrumb-item"><a href="<c:url value='/category' />">Categories List</a></li>
                                <li class="breadcrumb-item active">create</li>
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
                                    <h3 class="card-title">Create Category Form</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
        
                                <form:form action="/ClothingProj/create" modelAttribute="bean" method="POST">
                                  
                                    <div class="card-body">
        
                                          <p style="color:red">All star(*) fields are required</p>
                                        
                                        <div class="form-group">
                                            <form:label for="name" path="name">Title <span style="color:red;">*</span></form:label>
                                            <form:input type="text" class="form-control" path="name" id="name" name="name" />
                                        	<form:errors path="name" style="color:red;" />
	                           		
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary">Create</button>
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
		
		
<!-- DataTables  & Plugins -->
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/jszip/jszip.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/pdfmake/pdfmake.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/pdfmake/vfs_fonts.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="$ {Pagecontext. Request. contextpath }/../resource/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="$ {Pagecontext. Request. contextpath }/../resource/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="$ {Pagecontext. Request. contextpath }/../resource/dist/js/demo.js"></script>

<jsp:include page="../layouts/script-index.jsp"></jsp:include>
		
</body>
</html>
       