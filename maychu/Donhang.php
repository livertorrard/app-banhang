<?php
	include "connect.php";
	$query = "SELECT * FROM donhang  ORDER BY id DESC";
	$data = mysqli_query($conn,$query);

	
?>

<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2 style="text-align: center;"><img  height="250" width="1000" src="https://metro.co.uk/wp-content/uploads/2019/12/yeezy-trainers-b4f6.gif"></h2>
<h2 style="text-align: center;">Danh Sách Các Đơn Hàng</h2>

<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Tên Khách Hàng</th> 
    <th>Số Điện Thoại</th>
    <th>Email</th>
    <th colspan="4">Sản Phẩm Cần Mua</th>
  </tr>
<?php 
if (mysqli_num_rows($data) > 0) {
    // hiển thị dữ liệu trên trang
    while($row = mysqli_fetch_assoc($data)) {
?>
  <tr>
    <td><?php echo $row["id"]; ?></td>
    <td><?php echo $row["tenkhachhang"]; ?></td>
    <td><?php echo $row["sodienthoai"]; ?></td>
    <td><?php echo $row["email"]; ?></td>
    <td><?php  
    $chitietdh1 = "SELECT tensanpham FROM chitietdonhang WHERE madonhang = '".$row["id"]."'";
    $result =  mysqli_query($conn,$chitietdh1);
    while($row1 = mysqli_fetch_assoc($result)) {
      echo "Tên sản phẩm : ". $row1 ["tensanpham"];
      echo "<br>";
        } ?></td>
    <td><?php  
    $chitietdh1 = "SELECT soluongsanpham FROM chitietdonhang WHERE madonhang = '".$row["id"]."'";
    $result =  mysqli_query($conn,$chitietdh1);
    while($row3 = mysqli_fetch_assoc($result)) {
      echo "Số lượng : ". $row3 ["soluongsanpham"];
      echo "<br>";
        } ?></td>    
    <td>   
    <?php 
    $chitietdh1 = "SELECT giasanpham FROM chitietdonhang WHERE madonhang = '".$row["id"]."' ";
    $result =  mysqli_query($conn,$chitietdh1);
    while ($row2 = mysqli_fetch_assoc($result)) 
      {
           echo "Đơn giá :" .number_format($row2["giasanpham"])." Đ";
           echo "<br>";
       } ?> 
    </td>
     <td>   
    <?php 
    $chitietdh1 = "SELECT SUM(giasanpham) AS value_sum FROM chitietdonhang WHERE madonhang = '".$row["id"]."' ";
    $result =  mysqli_query($conn,$chitietdh1);
    $row2   = mysqli_fetch_assoc($result)  ;
    echo "Thanh Toán :".number_format($row2["value_sum"])." Đ";
    ?> 
    </td>
   </tr>
<?php
}
}else {
    echo "0 results";
} 
?>
</table>
</body>
</html>
