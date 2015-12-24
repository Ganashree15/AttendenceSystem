<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery.js"></script>
	<title>Login</title>
</head>
<style>
        #wrapper {
        	width: 1000px;
        	margin: 0 auto;
        }
        #container {
        	width: 300px;
        	border:1px solid #30dabf;
        	background: #d0e2f3;
        	margin-left: 40%;
        }
        #container form{
        	position: relative;
        }
        #container form p {
        	margin: 20px;
        }
        #container form label {
        	color: #e74c67;

        }
        #container form label[for="password"] {
        	padding-right: 7px;
        }
          #container form input {
          	width: 165px;
          	border: 1px solid #30dabf;
          	padding: 5px;
          } 
          #container form input[type="submit"] {
          	width: 80px;
          	color: green;
          	margin-left: 80px;
          }
          #loading{
          	position: absolute;
          }
          
      </style>
<body>
	
	<div id="wrapper">
		
		<div id="container">
			<form action="" method="POST">
				<div id="loading"> </div>
				<p>
					<label for="username">UserName: </label>
					<input type="text" name="username" id="username">
				</p>
				<p>
					<label for="password">Password: </label>
					<input type="password" name="password" id="password">
				</p>
				<p>
					<input type="submit" value="Login" id="login">
				</p>
			</form>
		</div>
	</div>
</body>
</html>


