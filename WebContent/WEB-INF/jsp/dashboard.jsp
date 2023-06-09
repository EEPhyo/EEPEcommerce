<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ecommerce Management</title>	
  

    
    <jsp:include page="./layouts/top-html-start-head-tag.jsp"></jsp:include>
  
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
	
</head>
	
<body class="hold-transition sidebar-mini layout-fixed">
		
		<jsp:include page="./layouts/header.jsp"></jsp:include>
		<jsp:include page="./layouts/sidebar.jsp"></jsp:include>
		
		
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>User List</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">User List</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

      <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header" style="display: inline;">
                            <h3 class="card-title">Ecommerce Management</h3>
             			 </div>     			 
             			                      
                          <div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										  <thead class="text-center">
										    <tr>
										      <th>Name</th>
										      <th>Email</th>
										      <th>Phone No</th>
										      <th>Address</th>
										      <th>Role</th>
										      <th>created_date</th>
										      <th>created_user</th>
										      <th>Enabled</th>
										      <th>Locked</th>
										    </tr>
										  </thead>
										  <tbody class="text-center">
										    <c:forEach items="${lists}" var="user">     
										      <tr>
										        <td class="align-middle">${user.name}</td>
										        <td class="align-middle">${user.email}</td>
										        <td class="align-middle">${user.phone_number}</td>
										        <td class="align-middle">${user.address}</td>
										         <td class="align-middle">${user.role_name}</td>
										        <td class="align-middle">${user.created_date}</td>
										        <td class="align-middle">${user.role_name}</td>
										        <td class="align-middle">-</td>
										        <td class="align-middle">-</td>
										      </tr>
										    </c:forEach>
										  </tbody>
								</table>			                                       
                      	  </div>
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>

<jsp:include page="./layouts/footer.jsp"></jsp:include>
		
		
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



<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resource/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/resource/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resource/dist/js/adminlte.min.js"></script>

<script src="${pageContext.request.contextPath}/resource/dist/js/demo.js"></script>
<!-- AdminLTE for demo purposes -->

<!-- Page specific script -->
<jsp:include page="./layouts/script-index.jsp"></jsp:include>		
<!-- Page specific script -->


</body>
</html>