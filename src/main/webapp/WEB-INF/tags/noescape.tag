<%@ tag import="net.physalis.javaviews.web.jsp.EscapeHtmlElResolver" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<% request.setAttribute(EscapeHtmlElResolver.NO_ESCAPE_KEY, true); %>
<jsp:doBody/>
<% request.removeAttribute(EscapeHtmlElResolver.NO_ESCAPE_KEY); %>
