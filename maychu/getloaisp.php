<?php
	include "connect.php";
	$query = "SELECT * FROM loaisanpham";
	$data = mysqli_query($conn,$query);
	$mangloaisp = array();
	while($row = mysqli_fetch_assoc($data)){
		array_push($mangloaisp,new Loaisp(
			$row['Id'],
			$row['tenloaisanpham'],
			$row['hinhanhsanpham']));
	}
	echo json_encode($mangloaisp);
	class Loaisp{
		function Loaisp($id,$tenloaisp,$hinhanhloaisp){
			$this->id = $id;
			$this->tenloaisp = $tenloaisp;
			$this->hinhanhloaisp = $hinhanhloaisp;
		}
	}
?>