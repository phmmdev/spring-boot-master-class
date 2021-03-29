<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form method="POST">
        <font color="red">${errorMessage}</font>
        <br>
        Name: <input type="text" name="name" value=""/>
        Password: <input type="password" name="password" value=""/>
        <input type="submit">
    </form>
</div>

<%@ include file="common/footer.jspf" %>