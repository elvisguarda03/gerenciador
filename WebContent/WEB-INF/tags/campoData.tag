<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="id"  required="true" %>
<%@ attribute name="nome" required="true" %>

<script type="text/javascript">
	$(document).ready(function () {
		$('#${id}').datePicker({ dateFormat: 'dd/mm/yy' });
	});
</script>

<input id="${ id }" name="${ name }" type="text" />