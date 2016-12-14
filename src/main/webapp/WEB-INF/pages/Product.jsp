<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:iterator value="products">

		<div class="col-md-4">
			<div class="single-products">
				<div class="productinfo text-center">
					<img src='uploads?productIdImage=<s:property value="productID" />' />
					<h2>
						<s:property value="productPrice" />
					</h2>
					<p>
						<s:property value="productName" />
					</p>
					<a href="product_detail?productID=<s:property value="productID" />"
						class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i>Details</a>
				</div>
				<div class="product-overlay">
					<div class="overlay-content">
						<h2>
							<s:property value="productPrice" />
						</h2>
						<p>
							<s:property value="productName" />
						</p>
						<a
							href="product_detail?productID=<s:property value="productID" />"
							class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Details</a>
					</div>
				</div>
			</div>


		</div>

	</s:iterator>
</body>
</html>