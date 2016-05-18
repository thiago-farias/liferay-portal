<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/admin/common/init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
%>

<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, KBActionKeys.VIEW_KB_TEMPLATES) %>">

	<%
	List<String> names = new ArrayList<String>();
	List<String> urls = new ArrayList<String>();
	String value = null;

	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), KBActionKeys.VIEW)) {
		PortletURL kbArticlesURL = renderResponse.createRenderURL();

		kbArticlesURL.setParameter("mvcPath", "/admin/view.jsp");

		names.add("articles");
		urls.add(kbArticlesURL.toString());
		value = names.get(names.size() - 1);
	}

	if (AdminPermission.contains(permissionChecker, scopeGroupId, KBActionKeys.VIEW_SUGGESTIONS)) {
		PortletURL kbSuggestionsURL = renderResponse.createRenderURL();

		kbSuggestionsURL.setParameter("mvcPath", "/admin/view_suggestions.jsp");

		names.add("suggestions");
		urls.add(kbSuggestionsURL.toString());
		value = mvcPath.contains("suggestions") ? names.get(names.size() - 1) : value;
	}
	%>

	<liferay-ui:tabs
		names="<%= StringUtil.merge(names) %>"
		param="topTabs"
		url0="<%= (urls.size() > 0) ? urls.get(0) : null %>"
		url1="<%= (urls.size() > 1) ? urls.get(1) : null %>"
		value="<%= value %>"
	/>
</c:if>