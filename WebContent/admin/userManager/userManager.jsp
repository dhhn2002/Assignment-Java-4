<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item" role="presentation">
		<a class="nav-link active" id="userEditing-tab" data-toggle="tab" href="#userEditing" role="tab" 
		aria-controls="userEditing" aria-selected="true">
			User Editing
		</a>
	</li>
	<li class="nav-item" role="presentation">
		<a class="nav-link" id="userList-tab" data-toggle="tab" href="#userList" role="tab"
		aria-controls="userList" aria-selected="false">
			User List
		</a>
	</li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="userEditing" role="tabpanel" aria-labelledby="userEditing-tab">
		<form action="" method="post">
			<div class="card">
				<div class="card-body">
					<div class="row">
<!-- 						<div class="col-3"> -->
<!-- 							<div class="border p-3"> -->
								
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="col-9">
<!-- 							<div class="form-group"> -->
<!-- 								<label for="userId">User ID</label> <input type="text" -->
<!-- 									class="form-control" name="userId" id="userId" -->
<%-- 									aria-labelledby="userId" placeholder="userId" value="${user.userId}"> --%>
<!-- 								<small id="userId" class="form-text text-muted">User ID -->
<!-- 									is required</small> -->
<!-- 							</div> -->
						
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									class="form-control" name="username" id="username"
									aria-labelledby="username" placeholder="Username" value="${user.username}">
								<small id="username" class="form-text text-muted">Username
									is required</small>
							</div>

							<div class="form-group">
								<label for="password">Password</label> <input type="text"
									class="form-control" name="password" id="password"
									aria-labelledby="password" placeholder="Password" value="${user.password}">
								<small id="password" class="form-text text-muted">Password is required</small>
							</div>
							
							<div class="form-group">
								<label for="fullname">Fullname</label> <input type="text"
									class="form-control" name="fullname" id="fullname"
									aria-labelledby="fullname" placeholder="Fullname" value="${user.fullname}">
								<small id="fullname" class="form-text text-muted">Fullname is required</small>
							</div>

							<div class="form-group">
								<label for="email">Email</label> <input type="text"
									class="form-control" name="email" id="email"
									aria-labelledby="email" placeholder="Email" value="${user.email}">
								<small id="email" class="form-text text-muted">Email is required</small>
							</div>

							<div class="form-check form-check-inline">
								<label class="active-btn"> <input type="radio"
									class="form-check-input" value="true" name="admin" id="status" 
									${user.admin? 'checked' : ''}> Admin
								</label> <label class="inactive-btn"> <input type="radio"
									class="form-check-input" value="false" name="admin"
									id="status" ${!user.admin? 'checked' : ''}> User
								</label>
							</div>
						</div>
					</div>
					
				</div>
				<div class="card-footer text-muted">
					<button class="btn btn-primary" formaction="userManagement/create">Create</button>
					<button class="btn btn-warning" formaction="userManagement/update">Update</button>
					<button class="btn btn-danger" formaction="userManagement/delete">Delete</button>
					<button class="btn btn-info" formaction="userManagement/reset">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="userList" role="tabpanel"
		aria-labelledby="userList-tab">
		<table class="table table-stripe">
			<tr>
				<td>User ID</td>
				<td>Username</td>
				<td>Password</td>
				<td>Fullname</td>
				<td>Email</td>
				<td>Admin</td>
				<td>&nbsp;</td>
			</tr>
			<c:forEach var="item" items="${users}">
				<tr>
					<td>${item.userId }</td>
					<td>${item.username }</td>
					<td>${item.password}</td>
					<td>${item.fullname }</td>
					<td>${item.email}</td>
					<td>${item.admin? 'Admin' : 'User'}</td>
					<td>
						<a href="userManagement/edit?userId=${item.userId }"	> 
							<i class="fa fa-edit" aria-hidden="true"></i>Edit
						</a> 
						
						<a href="userManagement/delete?userId=${item.userId }"> 
							<i class="fa fa-trash" aria-hidden="true"></i>Delete
						</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</div>
