<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">

			<h2>User Details Information</h2>
			<form action="<c:url value="#"/>" method="get">
				<div>

					Search User (Type Name): <input type="text" name="userName" id="userName"
						placeholder="Search..">
					<button type="submit" value="">search</button>


				</div>
			</form>
			<form action="/createUser" method="get">
				<div>
					<button type="submit" class="btn btn-primary">Create User</button>
				</div>
			</form>

			<table class="table table-striped table-hover" border="1">

				<thead>
					<tr class="bg-success">
						<th>UserName(ID)</th>
						<th>password</th>
						<th>Role</th>
						<th>Student Id</th>
						<th>Faculty Id</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>

				<c:forEach items="${userList}" var="user">

					<tr>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td>${user.role.id}</td>
						<td>${user.student.studentId}</td>
						<td>${user.faculty.id}</td>
						

						<td><a
							href="<spring:url value="/userInfo/edit/${user.userName}"/>"> <span
								class="glyphicon glyphicon-pencil"></span>
						</a></td>
						<td><a
							href="<spring:url value="/userInfo/delete/${user.userName}" />">
								<span class="glyphicon glyphicon-remove"></span>
						</a></td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>