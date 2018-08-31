<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />



<portlet:defineObjects />

<portlet:actionURL var="add" name="AddEmployee">
</portlet:actionURL>

<aui:form action="${add}" method="post">
	<aui:input name="name" value="" />
	<aui:input name="address" value="" />
	<aui:button type="submit" value="Submit" />
</aui:form>


