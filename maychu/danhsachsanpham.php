
<?php
	include "connect.php";
	$query = "SELECT * FROM sanpham ORDER BY Id DESC";
	$data = mysqli_query($conn,$query);

	
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>SPORT WEAR</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
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
            <li  class="active"><a href="danhsachsanpham.php"><em class="fa fa-toggle-off">&nbsp;</em>Danh Sách Sản Phẩm</a></li>
			<li><a href="Themsanpham.php"><em class="fa fa-calendar">&nbsp;</em>Thêm Sản Phẩm</a></li>
		    <li><a href="login.html"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Danh Sách Sản Phẩm</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Danh Sách Sản Phẩm</h1>
			</div>
		</div><!--/.row-->
	
<div class="container">
		  <table style="width:90%" class="table table-bordered">
            <thead>
               <tr>
                 <th style="text-align: center";>ID </th>
                 <th style="text-align: center";>Tên Sản Phẩm</th> 
                 <th style="text-align: center";>Giá Sản Phẩm</th>
                 <th style="text-align: center";>Hình Ảnh</th>
                 <th style="text-align: center";>Mô Tả</th>
               </tr>
            </thead>
           
            	<?php 
if (mysqli_num_rows($data) > 0) {
    // hiển thị dữ liệu trên trang
    while($row = mysqli_fetch_assoc($data)) {
?>
  <tr>
    <td><?php echo $row["Id"]; ?></td>
    <td><?php echo $row["tensanpham"]; ?></td>
    <td><?php echo $row["giasanpham"]; ?></td>
    <td><img src="<?php echo $row["hinhansanpham"]; ?>" height="100" width="100"></td>
    <td><?php echo $row["motasanpham"]; ?></td>
   </tr>
<?php
}
}else {
    echo "0 results";
} 
?>
               
          
         </table>
      </div>
  </div>
<!-- <div class="panel panel-container"> -->
<!-- </div> -->	
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script>
		window.onload = function () {
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
	responsive: true,
	scaleLineColor: "rgba(0,0,0,.2)",
	scaleGridLineColor: "rgba(0,0,0,.05)",
	scaleFontColor: "#c5c7cc"
	});
};
	</script>
		
</body>
</html>