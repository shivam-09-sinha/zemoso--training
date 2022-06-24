<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Team</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
<body>

	<div class="container my-2">
	<h1>All Team List</h1>

	<a th:href = "@{/showNewEmployeeForm}" class="btn btn-primary btn-sm mb-3"> Add Teams </a>

		<table border="1" class = "table table-striped table-responsive-md">
			<thead>
				<tr>
					<th>
							Team Name
					</th>
					<th>

							Captain Name
					</th>
					<th>

							Employee Email
					</th>
					<th> Actions </th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="Teams : ${listTeams}">
					<td th:text="${Teams.teamName}"></td>
					<td th:text="${Teams.captain_Name}"></td>
					<td th:text="${Teams.owned_By}"></td>

				</tr>
			</tbody>

</body>
</html>