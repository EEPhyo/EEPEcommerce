<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

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

<style>
	.image{
		width:100px;
		border-radius:7px;
		vertical-align: middle;
    	border-style: none;
	}

</style>

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
                            <h3 class="card-title">Products List</h3>
                            <a href="/ClothingProj/addProduct" class="btn btn-primary" style="float: right;">Add New Product</a>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr class="align-middle">
                                        <th>Name</th>
                                        <th style="min-width: 100px !important;">Image</th>
                                        <th>Category</th>
                                        <th>Color</th>
                                         <th>Size</th>
                                         <th style="min-width: 200px !important;">Description</th>
                                          <th>Quantity</th>
                                          <th>Price</th>
                                          <th>Stock</th>
                                          <th style="min-width:120px;">Action</th>
                                                  
                                    </tr>
                                </thead>
                                
                                <tbody>
									 <c:forEach items="${products}" var="product">                                   
                                 	  <tr>                                                        
	                                       <td class="align-middle">${product.name}</td>         
	                                      <td class="align-middle" style="max-width: 100px;">
											    <div class="text-center">
											        <c:choose>
												        <c:when test="${not empty product.base64Image}">
												            <img class="image" src="data:image;base64,${product.base64Image}" alt="Product Image">
												        </c:when>
												        <c:otherwise>
												            <img class="image" src="${pageContext.request.contextPath}/resource/image/thumbnail-default.jpg" alt="Default Thumbnail">
												        </c:otherwise>
    												</c:choose>										
    							 				</div>
											</td>

										
                                       	<td class="align-middle">${product.category_name }</td>
                                       	<td class="align-middle">${product.color_name }</td>
                                       	<td class="align-middle">${product.size_value }</td>
                                        <td class="align-middle" style="max-width: 150px !important;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">${product.description}</td>
                                        <td class="align-middle">${product.quantity }</td>
                                        <td class="align-middle">${product.price }</td>
                                        <td class="align-middle">${product.is_stock }</td>
                                       
                                        
                                        <td class="align-middle">    
                                             <a href="/ClothingProj/editProduct/${product.id }"
                                                    class="btn btn-info btn-sm"><i class="fas fa-edit"></i></a>                                  
                                          
                                            <a href="/ClothingProj/deleteProduct/${product.id}"
                                             class="btn btn-danger btn-sm delete_btn"><i class="fas fa-trash"></i></a>                                
                                                                                   
                                                                                  
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

<jsp:include page="../layouts/script-index.jsp"></jsp:include>		
<!-- Page specific script -->
