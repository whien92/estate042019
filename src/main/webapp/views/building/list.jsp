<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingURL" value="/admin-building" />
<c:url var="buildingAPI" value="/api-admin-building"/>
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
														<option value="">Chọn quận</option>
														<c:forEach var="district" items="${districts}">
															<option value="${district.key}" ${item.key == model.district ? "selected" : ""}>${district.value}</option>
														</c:forEach>
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
														<input type="text" class="form-control input-sm"
															name="buildingArea" value="${model.buildingArea}" />
													</div>
												</div>
												<div class="col-sm-3">
													<label>Số tầng hầm</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
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
															name="areaRentTo" value="${model.areaRentTo}" />
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
														<c:forEach var="buildingType" items="${buildingTypes}">
														<label class="form-check-label">${buildingType.value}</label>
														<input class="form-check-input" type="checkbox" name="buildingTypes" value="${buildingType.key}" 
																${fn:contains(fn:join(model.buildingTypes, ','), item.key) ? "checked" : ""}> 
															
														</c:forEach>
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
									<button type="button" id="btnDelete" onclick=""
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
							<thead class="thead-dark|thead-light">
								<tr>
									<th><input class="form-check-input" type="checkbox" name="" value="" id="checkAll"></th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Địa chỉ</th>
									<th scope="col">Giá thuê</th>
									<th scope="col">Diện tích thuê</th>
									<th scope="col">Diện tích sàn</th>
									<th scope="col">Số tầng hầm</th>
									<th scope="col">Loại tòa nhà</th>
									<th scope="col">Tên quản lý</th>
									<th scope="col">Số điện thoại</th>
									<th scope="col">Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.listResults}">
									<tr>
										<td><input class="form-check-input" type="checkbox" name="${item.id }" value="" id="checkbox_${item.id }"></td>
										<td>${item.name}</td>
										<td>${item.address}</td>
										<td>${item.costRent}</td>
										<td>${item.rentArea}</td>
										<td>${item.buildingArea}</td>
										<td>${item.numberOfBasement}</td>
										<td>${item.type}</td>
										<td>${item.managerName}</td>
										<td>${item.managerPhone}</td>
										<td>
											<a class="btn btn-xs btn-primary btn-edit" data-toggle="tooltip" title='Cập nhật tòa nhà' href='<c:url value="/admin-building?action=EDIT&id=${item.id }" />'> 
											 	<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- end row list result search -->
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
		$("#btnDelete").click(function() {
			 var dataArray = $('input[type=checkbox]:checked').map(function() {
				 return $(this).val();
			 }).get();
			 var data = {};
			 data['ids'] = dataArray;
			 deleteBuilding(dataArray);
		});
		
		function deleteBuilding(data) {
			$.ajax({
				url: '${buildingAPI}',
				data: JSON.stringify(data),
				type: 'DELETE',
				contentType: 'application/json',
				dataType: 'json',
				success: function(data) {
					window.location.href = "${buildingURL}?action=LIST&message=delete_success";
				},
				error: function() {
					window.location.href = "${buildingURL}?action=LIST&message=error_system";
				}
			});
		}
	</script>
</body>
</html>