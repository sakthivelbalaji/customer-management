<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Read Contacts</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="customerdto" items="${customerdtos}">
            <tr>
                <td>${customerdto.id}</td>
                <td>${customerdto.name}</td>
                <td>${customerdto.email}</td>
                <td>${customerdto.country}</td>
                <td><a href="/update-contact/${customerdto.id}">Update</a></td>
                <td><a href="/delete-contact/${customerdto.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/create-contact">Create Contact</a>