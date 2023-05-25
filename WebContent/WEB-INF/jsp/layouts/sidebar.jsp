<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
        <img src="$ {Pagecontext. Request. contextpath }/../resource/dist/img/logo.jpg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
            style="opacity: .8">
       <span class="brand-text font-weight-light">Ecommerce</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="$ {Pagecontext. Request. contextpath }/../resource/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">Admin</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
                        <a href="/ClothingProj/list" class="nav-link">
                            <i class="nav-icon fas fa-users"></i>
                            <p>
                                User List
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/ClothingProj/list" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>User List</p>
                                </a>
                            </li>
                           
                        </ul>
                  </li>          
                  
                 <li class="nav-item">
                        <a href="/ClothingProj/category" class="nav-link">
                            <i class="nav-icon fas fa-cog"></i>
                            <p>
                                Categories List
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/ClothingProj/category" class="nav-link">
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
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>