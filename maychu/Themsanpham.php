<?php
include"connect.php";

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>SPORT WEAR</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#">Pages Admin</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/105997341_865490910608834_6151239131287146641_n.jpg?_nc_cat=105&_nc_sid=85a577&_nc_ohc=hlov5QMkLPUAX8acajI&_nc_ht=scontent.fsgn2-1.fna&oh=986b68e66bea8f1a470f3ec4a0eff2b8&oe=5F3E2E1D" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">Vạn Quý</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="Admin.php"><em class="fa fa-dashboard">&nbsp;</em>Danh Sách Đơn Hàng</a></li>
            <li ><a href="danhsachsanpham.php"><em class="fa fa-toggle-off">&nbsp;</em>Danh Sách Sản Phẩm</a></li>
			<li  class="active"><a href="Themsanpham.php"><em class="fa fa-calendar">&nbsp;</em>Thêm Sản Phẩm</a></li>
		    <li><a href="login.html"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Thêm Sản Phẩm</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thêm Sản Phẩm</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Forms</div>
					<div class="panel-body">
						<div class="col-md-6">

		
							<form action="Themsanpham.php" role="form" method="post">
								<div class="form-group">
									<label>Tên Sản Phẩm</label>
									<input name="tensanpham" type="text" class="form-control" >
								</div>
								<div class="form-group">
									<label>Giá Sản Phẩm</label>
									<input name="giasanpham" type="number" class="form-control">
								</div>
								<div class="form-group">
									<label>Link Hình Ảnh</label>
									<input name="hinhanh" type="text" class="form-control" >
								</div>
								<div class="form-group">
									<label>Mô Tả Sản Phẩm</label>
									<textarea name="mota" class="form-control" rows="3"></textarea>
								</div>
								<div class="form-group">
									<label>Loại Sản Phẩm</label>
									<input name="sanpham" type="number" placeholder="1"  min="1" max="2" class="form-control">
								</div>
								    <button type="submit" class="btn btn-primary">Thêm Sản Phẩm</button>
								</div>
							</form>

							<?php
                             if ($_SERVER["REQUEST_METHOD"] == "POST") {
                              $tensanpham  = $_POST['tensanpham']; 
                              $giasanpham  = $_POST['giasanpham'];
                              $hinhanh     = $_POST['hinhanh'];
                              $mota        = $_POST['mota']; 
                              $loaisanpham = $_POST['sanpham']; } 

                             

                           
                              if ( isset($tensanpham) && isset($giasanpham) && isset($hinhanh) && isset($mota) ) {
                              $query = "INSERT INTO sanpham(Id,tensanpham,giasanpham,hinhansanpham,motasanpham,Idsanpham) VALUES (null,'$tensanpham',' $giasanpham','$hinhanh','$mota','$loaisanpham')";
                              $dulieu = mysqli_query($conn,$query);
                              if ($dulieu) {
                               header("Location:https://www.facebook.com/Torrard98");

		          
	                          }else{
		                       echo "Không Thành Công";
	                          }
                              }
                              
		                    
		                      ?>
						
	                         
							
                             
						</div>
					</div>
				</div><!-- /.panel-->
			</div><!-- /.col-->
			<div class="col-sm-12">
				<p class="back-link">Lumino Theme by <a href="https://www.medialoot.com">Medialoot</a></p>
			</div>
		</div><!-- /.row -->
	</div><!--/.main-->
	
<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	
</body>
</html>