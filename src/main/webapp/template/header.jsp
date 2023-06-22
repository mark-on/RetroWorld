<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style_header.css">
<link href='https://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet'>
<link href="https://fonts.cdnfonts.com/css/futura-pt" rel="stylesheet">
<link href='https://fonts.google.com/specimen/Roboto?query=roboto'
	rel='stylesheet'>
</head>
<body>
	<header>
		<div class="utility-bar">
			<div class="container">
				<p class="utility-bar__text">FREE SHIPPING SU ORDINI SUPERIORI A
					59$</p>
				<div class="utility-bar__login">
					<a href="#" class="login">ACCEDI</a> <span class="separator">|</span>
					<a href="#" class="login">REGISTRATI</a>
				</div>
			</div>
		</div>

		<div class="header-box">

			<div class="left">
				<img class="logo" src="image/logo.svg">
			</div>

			<div class="center">
				<nav>
					<ul>
						<li class="dropdown"><a href="/shop" class="shop">Shop</a>
							<ul class="dropdown-menu">
								<li><a href="/shop?tipo=console">Consoles</a></li>
								<li><a href="/shop?tipo=game">Games</a></li>
								<li><a href="/shop?tipo=game">Accessori</a></li>
							</ul></li>
						<li class="dropdown"><a href="/shop?brand=nintendo">Nintendo</a>
							<ul class="dropdown-menu">
								<li><a href="/shop?brand=nintendo&console=">NES</a></li>
								<li><a href="/shop?brand=nintendo&console=">SNES Lite</a></li>
								<li><a href="/shop?brand=nintendo&console=">N64</a></li>
								<li><a href="/shop?brand=nintendo&console=">GAMECUBE</a></li>
								<li><a href="/shop?brand=nintendo&console=">GAMEBOY</a></li>
							</ul></li>
						<li class="dropdown"><a href="/shop?brand=sony">Sony</a>
							<ul class="dropdown-menu">
								<li><a href="/shop?brand=sony&console=">PlayStation 1</a></li>
								<li><a href="/shop?brand=sony&console=">PlayStation 2</a></li>
								<li><a href="/shop?brand=sony&console=">PSP</a></li>
							</ul></li>
						<li class="dropdown"><a href="/shop?brand=microsoft">Microsoft</a>
							<ul class="dropdown-menu">
								<li><a href="/shop?brand=microsoft&console=">Xbox</a></li>
								<li><a href="/shop?brand=microsoft&console=">Xbox360</a></li>
							</ul></li>
						<li class="dropdown"><a href="/shop?brand=microsoft">Sega</a>
							<ul class="dropdown-menu">
								<li><a href="/shop?brand=microsoft&console=">Dreamcast</a></li>
								<li><a href="/shop?brand=microsoft&console=">Megadrive</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>

			<div class="right">
				<input type="text" placeholder="Cerca..."> <img src="image\cart.png" alt="cart">
			</div>

		</div>
	</header>
</body>
</html>