
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
	
		<div class="container">
			<h1>Your ToDos </h1>
			<table class="table	">
				<thead>
					<tr>
						
						<th>Username</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.username}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add ToDo</a>
		</div>
		<%@ include file="common/footer.jspf" %>