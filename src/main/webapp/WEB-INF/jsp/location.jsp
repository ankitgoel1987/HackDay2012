<jsp:include page="header.jsp" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">


<!-- Map -->
<style type="text/css">

      html { height: 100% }

      body { height: 100%; margin: 2px; padding: 2px }

      #map_canvas { height: 30% }

    </style>


<div class="container well" id="map_canvas">

</div>
<jsp:include page="footer.jsp" />