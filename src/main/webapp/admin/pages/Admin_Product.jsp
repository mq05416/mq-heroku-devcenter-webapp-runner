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
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Danh sách sản phẩm</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">DataTables Advanced Tables</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tên sản phẩm</th>
										<th>Mô tả</th>
										<th>Hình ảnh</th>
										<th>Giá bán</th>
										<th>Thể loại</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>




									<s:iterator value="products">
										<tr class="odd gradeX">
											<td><s:property value="productID" /></td>
											<td><s:property value="productName" /></td>
											<td><s:property value="productDesc" /></td>
											<!-- <td><img src=<s:property value="productImg" /> /></td> -->
											<td><img src='uploads?productIdImage=<s:property value="productID" />'
												style="display: block;" width="30%" height="30%" /></td>
											<td><s:property value="productPrice" /></td>
											<td><s:property value="category.categoryName" /></td>
											<td class="center"><a
												href="edit_product_view?productID=<s:property value="productID" />">Edit</a></td>
											<td class="center"><a
												href="delete_product?productID=<s:property value="productID" />">Delete</a></td>
										</tr>

									</s:iterator>

								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
						<div class="well">
							<h4>DataTables Usage Information</h4>
							<p>
								DataTables is a very flexible, advanced tables plugin for
								jQuery. In SB Admin, we are using a specialized version of
								DataTables built for Bootstrap 3. We have also customized the
								table headings to use Font Awesome icons in place of images. For
								complete documentation on DataTables, visit their website at <a
									target="_blank" href="https://datatables.net/">https://datatables.net/</a>.
							</p>
							<a class="btn btn-default btn-lg btn-block" target="_blank"
								href="https://datatables.net/">View DataTables Documentation</a>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->





		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Basic Form Elements</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form role="form" action="add_product"
									enctype="multipart/form-data" method="post">
									<div class="form-group">
										<label>Mã sản phẩm</label> <input class="form-control"
											name="productID"
											value=<s:property value="product.productID" />>

									</div>
									<div class="form-group">
										<label>Tên sản phẩm</label> <input class="form-control"
											name="productName"
											value=<s:property value="product.productName" />>
										<p class="help-block">Example block-level help text here.</p>
									</div>






									<div class="form-group">

										<label>Tên thể loại</label> <select name="categoryName_ID"
											class="form-control">
											<s:iterator value="categories">
												<option><s:property value="categoryName" /></option>
											</s:iterator>
										</select>

									</div>


									<div class="form-group">
										<label>Mô tả</label>
										<textarea class="form-control" rows="3" name="productDesc"><s:property
												value="product.productDesc" /></textarea>
									</div>

									<div class="form-group">
										<label>Hình ảnh</label>
										<s:file name="productImg" label="Product Image" />

									</div>


									<div class="form-group">
										<label>Giá cả</label>
										<textarea class="form-control" rows="3" name="productPrice"><s:property
												value="product.productPrice" /></textarea>
									</div>

									<!-- <div class="form-group">
										<label>Thể loại</label>
										<textarea class="form-control" rows="3" name="categoryId"></textarea>
									</div> -->



									<button type="submit" class="btn btn-default">Submit</button>
									<button type="reset" class="btn btn-default">Reset</button>
								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->


						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>





		<!-- /.row -->

		<!-- /.row -->

		<!-- /.row -->
	</div>
</body>
</html>