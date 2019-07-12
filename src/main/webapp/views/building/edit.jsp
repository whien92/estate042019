<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api-admin-building"/>
<c:url var="buildingURL" value="/admin-building" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Update building</title>
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
					<!--  FORMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM -->
					<form id="fEdit" >
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Tên sản phẩm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="name" value="${model.name}"/></div>
 					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Người quản lý sản phẩm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Quận</span></div>
						<div class="col-sm-9">
							<select class="custom-select" id="quan" name="district">
							<option value="">Chọn quận</option>
							<c:forEach var="district" items="${districts}">
								<option value="${district.key}" ${item.key == model.district ? "selected" : ""}>${district.value}</option>
							</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Phườnggggg</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="ward" value="${model.ward}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Đường</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="street" value="${model.street}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Kết cấu</span></div>
						<div class="col-sm-9"><input type="text" class="spInput"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Số tầng hầm</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="numberOfBasement" value="${model.numberOfBasement}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Diện tích sàn</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="buildingArea" value="${model.buildingArea}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Hướng</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="direction" value="${model.direction}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Hạng</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="level" value="${model.level}"/></div>
					</div>	
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Diện tích thuê</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="rentArea" value="${model.rentArea}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Giá thuê</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="costRent" value="${model.costRent}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Tên quản lý</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="managerName" value="${model.managerName}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Số điên thoại quản lý</span></div>
						<div class="col-sm-9"><input type="text" class="spInput" name="managerPhone" value="${model.managerPhone}"/></div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Loại tòa nhà</span></div>
						<div class="col-sm-9">
							<c:forEach var="buildingType" items="${buildingTypes}">
							<label class="form-check-label">${buildingType.value}</label>
							<input class="form-check-input" type="checkbox" name="buildingTypes" value="${buildingType.key}" 
									${fn:contains(fn:join(model.buildingTypes, ','), item.key) ? "checked" : ""}> 
								
							</c:forEach>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3"><span class="splabel">Upload ảnh sản phẩm</span></div>
						<div class="col-sm-9">
							<div class="custom-file">
							    <input type="file" class="custom-file-input" id="customFile">
						  </div>
						</div>
					</div>
					<input type="hidden" id="buildingId" name="id" value="${model.id}">
					</form>
					<div class="row text-center btn-addsp">
						<button class="btn btn-light">Hủy bỏ</button>
						<c:if test = "${empty model.id }">
							<button class="btn btn-success" id="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
						</c:if>
						<c:if test = "${not empty model.id }">
							<button class="btn btn-success" id="btnAddOrUpdateBuilding">Cập nhật tòa nhà</button>
						</c:if>
					</div>
						
				</div> <!-- page-content -->
			</div> <!-- "main-content-inner -->
		</div><!-- /.main-content -->			
	<script type="text/javascript">
		$("#btnAddOrUpdateBuilding").click(function() {
			addOrUpdateBuilding();
		});
		function addOrUpdateBuilding() {
			var buildingId = $("#buildingId").val();
			var formData = $("#fEdit").serializeArray();
			var data = {};
			var buildingTypes = [];
			$.each(formData, function(index, v) {
				if(v.name == 'buildingTypes') {
					buildingTypes.push(v.value);
				} else {
					data["" + v.name + ""] = v.value;
				}
			});
			data['buildingTypes'] = buildingTypes;
			if(buildingId == '') {
				addBuilding(data);
			}
			else {
				editBuilding(data, buildingId);
			}
		}

		function addBuilding(data) {
			$.ajax({
				url: '${buildingAPI}',
				data: JSON.stringify(data),
				type: 'POST',
				contentType: 'application/json',
				dataType: 'json',
				success: function(data) {
					window.location.href = "${buildingURL}?action=EDIT&id=" + data.id + "&message=insert_success";
				},
				error: function() {
					window.location.href = "${buildingURL}?action=LIST&message=error_system";
				}
			});
		}

		function editBuilding(data, id) {
			$.ajax({
				url: '${buildingAPI}',
				data: JSON.stringify(data),
				type: 'PUT',
				contentType: 'application/json',
				//dataType: 'json',
				success: function(data) {
					window.location.href = "${buildingURL}?action=EDIT&id=" +  id + "&message=update_success";
				},
				error: function() {
					window.location.href = "${buildingURL}?action=LIST&message=error_system";
				}
			});
		}
	</script>	
	</body>
</html>