<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation">
		<a class="nav-link active" id="videoEditing-tab" data-toggle="tab" href="#videoEditing" role="tab" 
		aria-controls="videoEditing" aria-selected="true">
			Video Editing
		</a>
	</li>
	<li class="nav-item" role="presentation">
		<a class="nav-link" id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
		aria-controls="videoList" aria-selected="false">
			Video List
		</a>
	</li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="videoEditing" role="tabpanel" aria-labelledby="videoEditing-tab">
		<form action="" method="post" enctype="multipart/form-data">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-3">
							<div class="border p-3">
								<img id="posterImg"
									src="${video.poster !=null ? video.poster : '../images/cartoons/coco.jpg'}"
									alt="" class="img-fluid">
								<div class="input-group mb-3 mt-3">
									<div class="input-group-prepend">
										<span class="input-group-text">Upload</span>
									</div>
									<div class="custom-file">
										<input type="file" class="custom-file-input" 
										id="cover"name="cover" onchange="chooseFile(this)" 
										accept="image/gif, image/jpeg, image/png"/>
										<label for="cover">Choose file</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-9">
							<div class="form-group">
								<label for="youtubeId">Youtube ID</label> <input type="text"
									class="form-control" name="videoId" id="youtubeId"
									aria-labelledby="youtubeIdHid" placeholder="Youtube ID" value="${video.videoId}">
								<small id="youtubeIdHid" class="form-text text-muted">Youtube
									is required</small>
							</div>

							<div class="form-group">
								<label for="videoTitle">Video Title</label> <input type="text"
									class="form-control" name="title" id="videoTitle"
									aria-labelledby="videoTitle" placeholder="Video title" value="${video.title}">
								<small id="videoTitle" class="form-text text-muted">Video
									title is required</small>
							</div>
							
							<div class="form-group">
								<label for="videoCategory">Category</label> 
								<select name="category" id="videoCategory">
									<c:forEach var="item" items="${cats}">
										<option value="${item.categoryName}" 
										${item.categoryName == video.category ? 'selected' : '' }>
											${item.categoryName}
										</option>
									</c:forEach>
								</select>	
								<small id="category" class="form-text text-muted">Video
									category is required</small>
							</div>
							
							<div class="form-group">
								<label for="viewCount">Video URL</label> <input type="text"
									class="form-control" name="videoURL" id="videoURL"
									aria-labelledby="videoURL" placeholder="videoURL" value="${video.videoURL}">
								<small id="videoURL" class="form-text text-muted">Video
									URL is required</small>
							</div>

							<div class="form-group">
								<label for="viewCount">View Count</label> <input type="text"
									class="form-control" name="views" id="viewCount"
									aria-labelledby="viewCountHid" placeholder="viewCountHid" value="${video.views}">
								<small id="viewCountHid" class="form-text text-muted">Video
									count is required</small>
							</div>

							<div class="form-check form-check-inline">
								<label class="active-btn"> <input type="radio"
									class="form-check-input" value="true" name="active" id="status" 
									${video.active? 'checked' : ''}> Active
								</label> <label class="inactive-btn"> <input type="radio"
									class="form-check-input" value="false" name="active"
									id="status" ${!video.active? 'checked' : ''}> Inactive
								</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="description">Description</label>
							<textarea name="description" id="description" cols="30" rows="4"
								class="form-control" value="${video.description}">${video.description}</textarea>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					<c:if test="${isCreateBtn}">
						<button class="btn btn-primary" formaction="videoManagement/create">Create</button>
					</c:if>
					
					<c:if test="${isUpdateBtn}">
						<button class="btn btn-warning" formaction="videoManagement/update">Update</button>
					</c:if>
<!-- 					<button class="btn btn-danger" formaction="videoManagement/delete">Delete</button> -->
					<button class="btn btn-info" formaction="videoManagement/reset">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="videoList" role="tabpanel"
		aria-labelledby="videoList-tab">
		<table class="table table-stripe">
			<tr>
				<td>Youtube ID</td>
				<td>Video title</td>
				<td>Category</td>
				<td>Video URL</td>
				<td>View count</td>
				<td>Status</td>
				<td>&nbsp;</td>
			</tr>
			<c:forEach var="item" items="${videos}">
				<tr>
					<td>${item.videoId }</td>
					<td>${item.title }</td>
					<td>${item.category}</td>
					<td>${item.videoURL}</td>
					<td>${item.views }</td>
					<td>${item.active? 'Active' : 'Deactive'}</td>
					<td>
						<a href="videoManagement/edit?videoId=${item.videoId }"	> 
							<i class="fa fa-edit" aria-hidden="true"></i>Edit
						</a> 
						
						<a href="videoManagement/delete?videoId=${item.videoId }"> 
							<i class="fa fa-trash" aria-hidden="true"></i>Delete
						</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</div>
