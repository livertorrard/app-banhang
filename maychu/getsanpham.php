<?php
	include "connect.php";
	$idsp = $_POST['idsanpham'];
    $mangsanpham = array();
	$query = "SELECT * FROM sanpham WHERE Idsanpham=$idsp";
	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)){
		array_push($mangsanpham,new Sanpham(
			$row['Id'],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhansanpham'],
			$row['motasanpham'],
			$row['Idsanpham']));
	}
	echo json_encode($mangsanpham);
	class Sanpham{
		function Sanpham($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
			$this->id = $id;
			$this ->tensp = $tensp;
			$this->giasp=$giasp;
			$this->hinhanhsp=$hinhanhsp;
			$this->motasp=$motasp;
			$this->idsanpham=$idsanpham;
		}
	}

?>
