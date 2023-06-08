<?php 
$dm='http://localhost/logistic/';
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<base href="<?php echo $dm; ?>"/>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
	<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

	<link rel="stylesheet" type="text/css" href="css/style.css?version=<?php echo time(); ?>" />
	 <link
	    rel="stylesheet"
	    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
	  />
	<script src="public/js/jquery.js"></script>
	<script src="owlcarousel/owl.carousel.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/d87d54734a.js" crossorigin="anonymous"></script>
	
	<title>Document</title>
</head>
<body>
	<div class="container-fluid">
		<?php 
		if(@$_GET['p']){
			
			$p=$_GET['p'];
			if($p!="dangnhap" || $p!="dangky"){
				require "page/header.php";
				require "page/".$p.".php";
				require "page/footer.php";
			}else{
				require "page/".$p.".php";
			}
		} else{

			require "page/header.php";
			require "page/trangchu.php";
			require "page/footer.php";
		}
		?>
	</div>

	
</html>