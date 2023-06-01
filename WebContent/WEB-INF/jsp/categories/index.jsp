<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce Management</title>	
  

    
   <jsp:include page="../layouts/top-html-start-head-tag.jsp"></jsp:include>
  
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.6/dist/sweetalert2.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.6/dist/sweetalert2.min.css">
</head>

<body class="hold-transition sidebar-mini layout-fixed">
		
		<jsp:include page="../layouts/header.jsp"></jsp:include>
        <jsp:include page="../layouts/sidebar.jsp"></jsp:include>
	<div class="content-wrapper">
    
    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Categories List</h3>
                            <a href="/ClothingProj/setupaddCategory" class="btn btn-primary" style="float: right;">Add New Category</a>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead class="text-center">
                                    <tr>
                                        <th>No.</th>
                                        <th>Title</th>
                                        <th>Created At</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                
                                <tbody class="text-center">
									 <c:forEach items="${categories}" var="category">                                   
                                 	  <tr>                                                        
                                       <td class="align-middle">${category.category_id}</td>         
                                       <td class="align-middle">${category.name }</td>
                                       <td class="align-middle">${category.created_date }
                                        <td class="align-middle">
                                                                                        
                                          <a href="/ClothingProj//setupdateCategory/${category.category_id}"
   											class="btn btn-info btn-sm"><i class="fas fa-edit"></i></a>                                                             
                                                                                   
                                             <a href="/ClothingProj/deleteCategory/${category.category_id}"
											    class="btn btn-danger btn-sm delete_btn"
											    onclick="event.preventDefault(); deleteProductConfirmation(this);">
											    <i class="fas fa-trash"></i>
											</a>                                           
                                            </td>
                                        </tr> 
                                        </c:forEach>
                            		
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
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
   
  <jsp:include page="../layouts/footer.jsp"></jsp:include>
		
		
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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.6/dist/sweetalert2.min.js"></script>
		
<!-- Page specific script -->
<jsp:include page="../layouts/script-index.jsp"></jsp:include>
<script>
function deleteProductConfirmation(element) {
    var url = element.getAttribute('href');
    
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to recover this record!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = url;
        }
    });
}
</script>