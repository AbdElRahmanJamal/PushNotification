<?php 

	if (isset($_POST["Token"])) {
		
		   $_uv_Token=$_POST["Token"];

		   $conn =mysqli_connect("localhost","id5266469_psycho","123456789","id5266469_psychodb") or die("Error connecting");

		   $q="INSERT INTO testFCM (TOKEN) VALUES ( '$_uv_Token') "
              ." ON DUPLICATE KEY UPDATE TOKEN = '$_uv_Token';";
              
      mysqli_query($conn,$q) or die(mysqli_error($conn));

      mysqli_close($conn);

	}


 ?>
