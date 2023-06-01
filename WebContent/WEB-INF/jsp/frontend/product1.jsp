<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="zxx">
<head>
	<!-- Meta Tag -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name='copyright' content=''>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Title Tag  -->
	<title>Ecommerce Shop</title>
	<!-- Favicon -->
	<link rel="icon" type="image/png" href="${Pagecontext.Request.contextpath }/resource/frontedn_ui/product/images/logo.jpg" width="30%">
	<!-- Web Font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">
	
	<!-- StyleSheet -->
	
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/frontedn_ui/product/css/slicknav.min.css" type="text/css">
	
	<!-- Eshop StyleSheet -->
	
	<link rel="stylesheet" href="${Pagecontext.Request.contextpath }/resource/frontedn_ui/product/css/reset.css">
	<link rel="stylesheet" href="${Pagecontext.Request.contextpath }/resource/frontedn_ui/product/style.css">
	<link rel="stylesheet" href="${Pagecontext.Request.contextpath }/resource/frontedn_ui/product/css/responsive.css">
	
	
	
</head>
<body class="js">
	
	<!-- Preloader -->
	<div class="preloader">
		<div class="preloader-inner">
			<div class="preloader-icon">
				<span></span>
				<span></span>
			</div>
		</div>
	</div>
	<!-- End Preloader -->
	
	<jsp:include page="header.jsp"></jsp:include>
	
	
      <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Product</h4>
                        <div class="breadcrumb__links">
                            <a href="home.jsp">Home</a>
                            <span>Products</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        <div class="shop__sidebar__search">
                            <form action="#">
                                <input type="text" placeholder="Search...">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                                               
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne"><b>Categories</b></a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                      <c:forEach items="${categories }" var="category">
                                                      		<li>${category.name }</li>
                                                      
                                                      </c:forEach>							
                                              
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                                             
                               
                                <div class="card">
                                     <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseTwo"><b>Colors</b></a>
                                    </div>
                                    <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__color">
                                                <ul class="nice-scroll">
                                                        <c:forEach items="${colors}" var="color">
                                                      		<li>${color.name }</li>
                                                      
                                                      </c:forEach>			
                                                 
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>										
								
										
								<div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseThree"><b>Size</b></a>
                                    </div>
                                    <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__size">
                                                <ul class="nice-scroll">
                                                        <c:forEach items="${sizes}" var="size">
                                                      		<li>${size.value}</li>
                                                      
                                                      </c:forEach>                                               
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>                                       
                                                          
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="shop__product__option">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__left">
                                    <p>Showing results</p>
                                </div>
                            </div>
                           
                        </div>
                    </div>
                   <div class="row">
    				<c:forEach items="${products}" var="product">  
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                           
                            <div class="product__item__pic set-bg">
                                                      
                               	<img class="image" src="${pageContext.request.contextPath}/image/${product.image}" alt="Product Image">
								    <ul class="product__hover">
								        <li><a href="#"><img src="${Pagecontext.Request.contextPath}/resource/frontedn_ui/product/images/img/icon/search.png" alt=""></a></li>
								    </ul>
								</div>
							

                                <div class="product__item__text">
                                      <a href="cart.jsp" class="add-cart">+ Add To Cart</a>
                                    
                                    <h5>${product.price }MMK</h5>
                                    
                                </div>
                            </div>
                          
                        </div>
                         </c:forEach>
                    </div>    
                    
			          <div class="row">
                        <div class="col-lg-12">
                            <div class="product__pagination">
                                <a class="active" href="/ClothingProj/getProductByPage/1">1</a>
                                <a href="/ClothingProj/getProductByPage/2">2</a>
                                <a href="/ClothingProj/getProductByPage/3">3</a>
                                <span>...</span>
                                <a href="#">21</a>
                            </div>
                        </div>
                    </div>
				
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Section End -->

   
            

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->
		
		
        <jsp:include page="footer.jsp"></jsp:include>

		<jsp:include page="js.jsp"></jsp:include>

            <!-- Js Plugins -->
        
        
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/jquery.nice-select.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/jquery.nicescroll.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/jquery.magnific-popup.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/jquery.countdown.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/jquery.slicknav.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/mixitup.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/owl.carousel.min.js"></script>
        <script src="${Pagecontext. Request. contextpath }/resource/frontedn_ui/product/js/main.js"></script>
	</body> 
	</html>