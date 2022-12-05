<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

			h1{
				text-align: center;
			}
			
			table {
				position: absolute;
				left:44%;
			}
			
</style>

</head>


<body>




					<h1>TABLA DEL 1 AL 10</h1>
				
				
	
					<table border="1">
	
							<%for(int i=1;i<=10;i++){ %>
								<tr>
									<%for(int k=1;k<=10;k++){ %>
										<td><%=i*k %></td>
									<% } %>
								</tr>
							<% } %>
					</table>
	



</body>
</html>