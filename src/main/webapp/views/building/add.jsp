<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a></li>
						<li class="active">Thêm sản phẩm</li>
					</ul>	
				</div> <!-- /.breadcrumbs -->
				<div class="page-content f-addsp">
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Tên sản phẩm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Người quản lý sản phẩm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Quận</span></div>
						<div class="col-sm-9">
							<select class="spInput custom-select" id="quan">
							  <option selected>--Chọn quận--</option>
							  <option value="1">Quận 12</option>
							  <option value="2">Quận Gò Vấp</option>
							  <option value="3">Quận Tân Bình</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Phường</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Đường</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Kết cấu</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Số tầng hầm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Diện tích sàn</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Hướng</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Hạng</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Diện tích thuê</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Upload ảnh sản phẩm</span></div>
						<div class="col-sm-9">
							<div class="custom-file">
							    <input type="file" class="custom-file-input" id="customFile">
						  </div>
						</div>
					</div>
					<div class="row text-center btn-addsp">
						<button class="btn btn-light">Hủy bỏ</button>
						<button class="btn btn-success">Thêm sản phẩm</button>
					</div>
						
				</div> <!-- page-content -->
			</div> <!-- "main-content-inner -->
		</div><!-- /.main-content -->				
	</body>
</html>