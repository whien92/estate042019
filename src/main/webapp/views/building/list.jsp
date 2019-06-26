<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingURL" value="/admin-building" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách tò nhà</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a></li>
					<li class="active">Danh sách sản phẩm</li>
				</ul>	
			</div> <!-- /.breadcrumb -->
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form action="${buildingURL}" method="get">
							<div class="widget-box table-filter">
								<div class="widget-header">
									<h4 class="widget-title">Tìm kiếm</h4>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div> <!-- widget-toolbar -->
								</div> <!-- widget-header -->
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-horizontal dssanpham">
											<div class="form-group">
												<div class="col-sm-12">
													<label>Tên Sản phẩm</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="name" value="${model.name}" />
													</div>
												</div>
											</div> <!-- form-group -->
											<div class="form-group">
												<div class="col-sm-4">
													<label>Quận hiện có</label>
													<div class="fg-line">
														<select class="custom-select" id="quan" name="district">
															<option>--Chọn quận--</option>
															<option value="QUAN_1">Quận 12</option>
															<option value="QUAN_2">Quận Gò Vấp</option>
															<option value="QUAN_3">Quận Tân Bình</option>
														</select>
													</div>
												</div>
												<div class="col-sm-4">
													<label>Phường</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="ward" value="${model.ward}" />
													</div>
												</div>
												<div class="col-sm-4">
													<label>Đường</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="ward" value="${model.street}" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">
													<label>Diện tích sàn</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"
															name="buildingArea" value="${model.buildingArea}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Số tầng hầm</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"
															name="numberOfBasement" value="${model.numberOfBasement}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Hướng</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="direction" value="${model.direction}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Hạng</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="level" value="${model.level}" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">
													<label>Diện tích từ</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="areaRentFrom" value="${model.areaRentFrom}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Diện tích đến</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="areaRenTo" value="${model.areaRentTo}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Giá thuê từ</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="costRentFrom" value="${model.costRentFrom}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Giá thuê đến</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="costRentTo" value="${model.costRentTo}" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													<label>Tên Quản lý</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="managerName" value="${model.managerName}" />
													</div>
												</div>
												<div class="col-sm-4">
													<label>Điện thoại quản lý</label>
													<div class="fg-line">
														<input type="number" class="form-control input-sm"
															name="managerPhone" value="${model.managerPhone}" />
													</div>
												</div>
												<div class="col-sm-4">
													<!-- <label>Nhân viên phụ trách</label>
														<div class="fg-line">
																<select class="custom-select" id="nhanvienpt">
																		<option selected>--Chọn nhân viên phụ trách--</option>
																		<option value="1">Nhân viên A</option>
																		<option value="2">Nhân viên B</option>
																		<option value="3">Nhân viên C</option>
																</select>
														</div> -->
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<label>Loại tòa nhà</label>
													<div class="fg-line">
														<input class="form-check-input" type="checkbox"
															name="buildingTypes" value="TANG_TRET"> <label
															class="form-check-label">Tầng trệt</label> <input
															class="form-check-input" type="checkbox"
															name="buildingTypes" value="NGUYEN_CAN"> <label
															class="form-check-label"> Nguyên căn </label> <input
															class="form-check-input" type="checkbox"
															name="buildingTypes" value="NOI_THAT"> <label
															class="form-check-label"> Nội thất </label>

													</div>
												</div>
											</div>
											<input type="hidden" name="action" value="LIST" />
											<div class="form-group">
												<div class="col-sm-12">
													<button type="submit" class="btn btn-success">
														Tìm kiếm <i class="fa fa-arrow-right"></i>
													</button>
												</div>
											</div>
										</div> <!-- form-horizontal dssanpham -->
									</div><!--  widget-main -->
								</div><!-- widget-body -->
							</div>
							<!-- end widget-box table-filter -->
						</form>
					</div>
				</div>
				<!-- end row search -->
				<div class="row">
					<div class="col-xs-12">
						<!-- button add, delete -->
						<div class="table-btn-controls">
							<div class="pull-right tableTools-container">
								<div class="dt-buttons btn-overlap btn-group">
									<a flag="info"
										class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
										data-toggle="tooltip" title='Thêm tòa nhà'
										href='<c:url value="/admin-building?action=EDIT"/>'> <span><i
										class="fa fa-plus-circle bigger-110 purple"></i></span>
									</a>
									<button type="button"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Xóa tòa nhà'>
									<span><i class="fa fa-trash-o bigger-110 pink"></i></span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end row 2 buttons edit/delete -->
				<div class="row">
					<div class="col-xs-12">
						<table class="table table-striped">
							<caption>List of users</caption>
							<thead class="thead-dark|thead-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">Ngày</th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Tên quản lý</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">DT sàn</th>
									<th scope="col">DT trống</th>
									<th scope="col">Giá thuê</th>
									<th scope="col">Phí dịch vụ</th>
									<th scope="col">Phí môi giới</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
								</tr>
								<tr>
									<th scope="row">1</th>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>Mark</td>
									<td>Otto</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- end row list result search -->
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>
</html>