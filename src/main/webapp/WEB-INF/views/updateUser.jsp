<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div id="login-box">
			<h2>Fill the given information</h2>

			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name="loginForm" action="<c:url value="/updateUser"/> "
				method="post">
				<c:if test="${not empty error}">
					<div class="error" style="color: #ff0000;">${error}</div>
				</c:if>
				<div class="form-group">
					<label for="username">Use Name</label> <input type="text"
						id="username" name="userName" class="form-control" value="${user.userName}" required="required"/>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control" value="${user.password}" required="required"/>
				</div>

				<div>
					Select Role <select id="selectDropDown" class="div-toggle"
						name="roleId">
						<option tabrez="student" value="1">Student</option>
						<option tabrez="faculty" value="2">Faculty</option>
						
					</select>
				</div>

				<div class="form-group" id="studentForm">
					<label for="studentId">Student Id</label> <input type="text"
						id="studentId" name="studentId" class="form-control" value="${user.student.studentId}"/>
				</div>

				<div class="form-group" id="facultyForm">
					<label for="facultyId">Faculty Id</label> <input type="number"
						id="facultyId" name="facultyId" class="form-control"  <%-- value="${user.faculty.id } --%>"/>
				</div>
				<input type="submit" value="Update" class="btn btn-default" />

				<hr /><%-- 
				<div class="form-group ">
					<a type="submit" class="btn btn-info btn-lg btn-block login-button"
						href="<c:url value="/signup" />">Sign up!</a>
				</div> --%>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	var studentForm = $('#studentForm');
	var facultyForm = $('#facultyForm');
	facultyForm.hide();
	$("#selectDropDown").change(function(){
		var option = $('option:selected', this).attr('tabrez');
		if(option === "student"){
			facultyForm.val("");
			
			studentForm.show();
			facultyForm.hide();
			
		}else{
			studentForm.val("");
			facultyForm.show();
			studentForm.hide();
			
		}
	});
})
	
</script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>