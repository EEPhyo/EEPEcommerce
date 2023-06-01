<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<jsp:include page="../layouts/header.jsp"></jsp:include>
		<jsp:include page="../layouts/sidebar.jsp"></jsp:include>

     <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Update Product</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="<c:url value='/productList' />">Products List</a></li>
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
                <div class="col-md-12">             
                                       
                    
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Update Product Form</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->                                                         
                          <div class="card-body">
                            	
                            <div style="color: red;">${error}</div>
                            
                                 <p style="color:red">All star(*) fields are required</p>
                                
                             <form:form method="POST" action="/ClothingProj/updateProduct" modelAttribute="bean" enctype="multipart/form-data" >
                                
                                <div class="row">  
                                
                                  <form:input type="hidden" name="id" path="id" value="${product.id}" />
                                  
                                  <div class="col-sm-6">
                                	 <div class="form-group">
                                            <form:label for="name" path="name">Name<span style="color:red">*</span></form:label>
                                            <form:input type="text" class="form-control" path="name" id="name" name="name" />
                                             <form:errors path="name" cssClass="error" />
                                      </div>
                                   </div>
                                      
                                                                         
                                  <div class="col-sm-6">    
                                    <div class="form-group">
                                        <form:label for="category_id" path="category_id">Category<span style="color:red">*</span></form:label>
                                        <form:select class="form-control" id="category_id" name="category_id" path="category_id">
                           					<option value="" selected disabled>Choose Category<option>                                            
                                                 <c:forEach items="${categories}" var="category">											        								        
											      <option value="${category.category_id}" <c:if test="${category.category_id == category.category_id}">selected</c:if>>${category.name}</option>	
											    </c:forEach>
											</form:select>
											 <form:errors path="category_id" cssClass="error" />
                                    </div>
                                   </div>
                                   
                                   <div class="col-sm-6">                                      
                                     <div class="form-group">
                                        <form:label for="color_id" path="color_id">Color<span style="color:red">*</span></form:label>
                                        <form:select class="form-control" id="color_id" name="color_id" path="color_id">
                           				     <option value="" selected disabled>Choose Color<option>                            				                              
                                                 <c:forEach items="${colors}" var="color">
											          <option value="${color.color_id}" <c:if test="${color.color_id == color.color_id}">selected</c:if>>${color.name}</option>	
											    </c:forEach>
											 
											</form:select>
											 <form:errors path="color_id" cssClass="error" />
                                    	</div>
                                    </div>
                                      
                                     <div class="col-sm-6">
                                       <div class="form-group">
                                        <form:label for="size_id" path="size_id">Size<span style="color:red">*</span></form:label>
                                        <form:select class="form-control" id="size_id" name="size_id" path="size_id">
                           					<option value="" selected disabled>Choose Size<option>                                            
                                                 <c:forEach items="${sizes}" var="size">
											          <option value="${size.size_id}" <c:if test="${size.size_id == size.size_id}">selected</c:if>>${size.value}</option>	
											    </c:forEach>
											</form:select>
											 <form:errors path="size_id" cssClass="error" />
                                    	</div>
                                    </div>
                                   <div class="col-sm-6">
									    <div class="form-group">
									        <form:label for="image" path="image">Image<span style="color:red">*</span></form:label>
									        <form:input type="file" class="form-control imageSelector" path="image" id="image" name="image" accept="image/*"  />
									 		<form:errors path="image" cssClass="error" />
									    </div>
									</div>

                                     
                                     
                                     <div class="col-sm-6">
                                       <div class="form-group">
                                            <form:label for="quantity" path="quantity">Quantity<span style="color:red">*</span></form:label>
                                            <form:input type="text" class="form-control" path="quantity" id="quantity" name="quantity" maxLength="10"/>
                                             <form:errors path="quantity" cssClass="error" />
                                      	</div>
                                      </div>
                                      
                                     <div class="col-sm-6">
                                       <div class="form-group">
                                            <form:label for="price" path="price">Price<span style="color:red">*</span></form:label>
                                            <form:input type="text" class="form-control" path="price" id="price" name="price" />
                                             <form:errors path="price" cssClass="error" />
                                      	</div>
                                     </div>
                                     
                                     
                                     <div class="col-sm-6">
                                       <div class="form-group">
                                            <form:label for="is_stock" path="is_stock">Stock<span style="color:red">*</span></form:label>
                                            <form:input type="text" class="form-control" path="is_stock" id="is_stock" name="is_stock" />
                                             <form:errors path="price" cssClass="error" />
                                      	</div>
                                     </div>
                                     
                                     
                                         
                                     <div class="col-sm-12">                         
                              			<div class="form-group">
                                            <form:label for="description" path="description">Description<span style="color:red">*</span></form:label><br><br>
                                           	<form:textarea path = "description" rows = "5" cols = "150" />
                                            
                                      	</div>
                                     </div>   
                              	
                                
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Update</button>
                                     <a href="<c:url value='/productList' />" class="btn btn-default" style="float: right; margin-left:1000px">Cancel</a>
                                </div>
                              </div>
                          </form:form>
                       
                     </div>   
                        
                    </div>
                  </div>
                    
                </div>
            </div>
        </section>
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
		
</body>
</html>
       