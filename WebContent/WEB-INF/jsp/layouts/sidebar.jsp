<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
        <img src="${pageContext.request.contextPath}/resource/dist/img/logo.jpg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
            style="opacity: .8">
       <span class="brand-text font-weight-light">Ecommerce</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="${pageContext.request.contextPath}/resource/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image" >
            </div>	
                  <div class="info">
               		 <a href="#"class="d-block">Admin  </a>
        		 </div>
           
        </div>

        <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          
         			 <li class="nav-item">
                        <a href="<c:url value='/list' />" class="nav-link">
                            <i class="nav-icon fas fa-users"></i>
                            <p>
                                User List
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<c:url value='/list' />" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>User List</p>
                                </a>
                            </li>
                           
                        </ul>
                  </li>          
                  
                 <li class="nav-item">
                        <a href="<c:url value='/category' />" class="nav-link">
                            <i class="nav-icon fas fa-cog"></i>
                            <p>
                                Categories List
                                <i class="right fas fa-angle-left"></i>
                            </p>
                       	 </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<c:url value='/category' />" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Categories List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/ClothingProj/setupaddCategory" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Add New Category</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    
                     <li class="nav-item">
                        <a href="<c:url value='/productList' />" class="nav-link">
                           <i class="fas fa-tshirt"></i>
                            <p>Products List
                            	<i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<c:url value='/productList' />" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Products List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/ClothingProj/addProduct" class="nav-link">                                	
                                    	<i class="far fa-circle nav-icon"></i>
                                    	<p>Add New Product</p>
                                   	
                                </a>
                            </li>
                        </ul>
                        
                        <li class="nav-item">
                        <a href="<c:url value='/logout' />" class="nav-link">
                            <i class="nav-icon fas fa-sign-out-alt"></i>
                            <p>
                                Logout
                            </p>
                        </a>
                    </li>
                    </li>
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>