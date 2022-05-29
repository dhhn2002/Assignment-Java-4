<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation"><a
		class="nav-link active" id="videoCategoryEditing-tab"
		data-toggle="tab" href="#videoCategoryEditing" role="tab"
		aria-controls="videoCategoryEditing" aria-selected="true"> Video
			Category Editing </a></li>
	<li class="nav-item" role="presentation"><a class="nav-link"
		id="videoCategoryList-tab" data-toggle="tab" href="#videoCategoryList"
		role="tab" aria-controls="videoCategoryList" aria-selected="false">
			Video Category List </a></li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="videoCategoryEditing"
		role="tabpanel" aria-labelledby="videoCategoryEditing-tab">
		<form action="" method="post">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-9">
							<c:if test="${isShowIdField}">
								<div class="form-group">
									<label for="categoryId">Category ID</label> <input
										type="text" class="form-control" name="categoryId"
										id="categoryId" aria-labelledby="categoryId"
										placeholder="Category ID"
										value="${videoCategory.categoryId}" readonly> <small
										id="categoryName" class="form-text text-muted">CategoryID is required</small>
								</div>
							</c:if>
							
							
							<div class="form-group">
								<label for="categoryName">Category Name</label> <input
									type="text" class="form-control" name="categoryName"
									id="categoryName" aria-labelledby="categoryName"
									placeholder="Category Name"
									value="${videoCategory.categoryName}"> <small
									id="categoryName" class="form-text text-muted">Category
									Name is required</small>
							</div>
						</div>

					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary"
							formaction="videoCategoryManagement/create">Create</button>
						<button class="btn btn-warning"
							formaction="videoCategoryManagement/update">Update</button>
						<button class="btn btn-danger"
							formaction="videoCategoryManagement/delete">Delete</button>
						<button class="btn btn-info"
							formaction="videoCategoryManagement/reset">Reset</button>
					</div>
				</div>
			</div>	
		</form>
	</div>
	<div class="tab-pane fade" id="videoCategoryList" role="tabpanel"
		aria-labelledby="videoCategoryList-tab">
		<table class="table table-stripe">
			<tr>
				<td>Category ID</td>
				<td>Category Name</td>
				<td>&nbsp;</td>
			</tr>
			<c:forEach var="item" items="${cats}">
				<tr>
					<td>${item.categoryId }</td>
					<td>${item.categoryName }</td>
					<td><a
						href="videoCategoryManagement/edit?categoryId=${item.categoryId }">
							<i class="fa fa-edit" aria-hidden="true"></i>Edit
					</a> <a
						href="videoCategoryManagement/delete?categoryId=${item.categoryId }">
							<i class="fa fa-trash" aria-hidden="true"></i>Delete
					</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</div>
