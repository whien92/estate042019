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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
						chủ</a></li>
						<li class="active">Danh sách sản phẩm</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="widget-header">
									<h4 class="widget-title">Tìm kiếm</h4>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-horizontal dssanpham">
											<div class="form-group">
												<div class="col-sm-12">
													<label>Tên Sản phẩm</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													<label>Quận hiện có</label>
													<div class="fg-line">
														<select class="custom-select" id="quan">
														  <option selected>--Chọn quận--</option>
														  <option value="1">Quận 12</option>
														  <option value="2">Quận Gò Vấp</option>
														  <option value="3">Quận Tân Bình</option>
														</select>
													</div>
												</div>
												<div class="col-sm-4">
													<label>Phường</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-4">
													<label>Đường</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">
													<label>Diện tích sàn</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Số tầng hầm</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Hướng</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Hạng</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">
													<label>Diện tích từ</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Diện tích đến</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Giá thuê từ</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-3">
													<label>Giá thuê đến</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													<label>Tên Quản lý</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-4">
													<label>Điện thoại quản lý</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"/>
													</div>
												</div>
												<div class="col-sm-4">
													<label>Nhân viên phụ trách</label>
													<div class="fg-line">
														<select class="custom-select" id="nhanvienpt">
														  <option selected>--Chọn nhân viên phụ trách--</option>
														  <option value="1">Nhân viên A</option>
														  <option value="2">Nhân viên B</option>
														  <option value="3">Nhân viên C</option>
														</select>
													</div>
												</div>
											</div> 
											<div class="form-group">
												<div class="col-sm-12">
													<label>Loại tòa nhà</label>
													<div class="fg-line">
														<div class="form-check">
														  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
														  <label class="form-check-label" for="defaultCheck1">
														    Tầng trệt
														  </label>
														</div>
														<div class="form-check">
														  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
														  <label class="form-check-label" for="defaultCheck2">
														    Nhà nguyên căn
														  </label>
														</div>
														<div class="form-check">
														  <input class="form-check-input" type="checkbox" value="" id="defaultCheck3">
														  <label class="form-check-label" for="defaultCheck3">
														    Nội thất
														  </label>
														</div>
													</div>
												</div>
											</div> 

											<div class="btn btn-success">Tìm kiếm <i class="fa fa-arrow-right"></i></div>	
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-horizontal buttons text-right">
							<a href="http://localhost:8081/jdbc042019/admin-building-add"><i class="fa fa-building bg-primary"></i></a>
							<a href="http://localhost:8081/jdbc042019/admin-building-edit"><i class="fa fa-store-alt bg-danger"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.main-content -->
	</body>
</html>