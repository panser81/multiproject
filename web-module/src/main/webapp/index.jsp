<%@ page import="com.gmail.spanteleyko.multiproject.web.services.FileService" %>
<%@ page import="com.gmail.spanteleyko.multiproject.web.services.impl.FileServiceImpl" %>
<%@ page import="com.gmail.spanteleyko.multiproject.web.repositories.PropertyRepository" %>
<%@ page import="com.gmail.spanteleyko.multiproject.web.repositories.impl.PropertyRepositoryImpl" %>
<%@ page import="com.gmail.spanteleyko.multiproject.web.constants.PropertyConstants" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    FileService fileService = FileServiceImpl.getInstance();
    PropertyRepository propertyRepository = PropertyRepositoryImpl.getInstance();
    String fileName = propertyRepository.get(PropertyConstants.FILE_NAME);
    int total = fileService.calculateTotal(fileName);

%>
<p>
    <%=total%>
</p>
</body>
</html>
