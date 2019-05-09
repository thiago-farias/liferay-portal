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

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

UserGroup userGroup = (UserGroup)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, siteMembershipsDisplayContext.getGroup(), ActionKeys.ASSIGN_USER_ROLES) %>">
		<portlet:renderURL var="assignURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value="/user_groups_roles.jsp" />
			<portlet:param name="userGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(siteMembershipsDisplayContext.getGroupId()) %>" />
		</portlet:renderURL>

		<%
		Map<String, Object> assignData = new HashMap<>();

		assignData.put("href", assignURL.toString());
		assignData.put("usergroupid", userGroup.getUserGroupId());
		%>

		<liferay-ui:icon
			cssClass="assign-site-roles"
			data="<%= assignData %>"
			id='<%= row.getRowId() + "assignSiteRoles" %>'
			message="assign-site-roles"
			url="javascript:;"
		/>

		<portlet:renderURL var="unAssignURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="mvcPath" value="/user_groups_roles.jsp" />
			<portlet:param name="userGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(siteMembershipsDisplayContext.getGroupId()) %>" />
			<portlet:param name="assignRoles" value="<%= Boolean.FALSE.toString() %>" />
		</portlet:renderURL>

		<%
		Map<String, Object> unAssignData = new HashMap<>();

		unAssignData.put("href", unAssignURL.toString());
		unAssignData.put("usergroupid", userGroup.getUserGroupId());
		%>

		<liferay-ui:icon
			cssClass="unassign-site-roles"
			data="<%= unAssignData %>"
			id='<%= row.getRowId() + "unAssignSiteRoles" %>'
			message="unassign-site-roles"
			url="javascript:;"
		/>
	</c:if>

	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, siteMembershipsDisplayContext.getGroup(), ActionKeys.ASSIGN_MEMBERS) %>">
		<portlet:actionURL name="deleteGroupUserGroups" var="deleteGroupUserGroupsURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(siteMembershipsDisplayContext.getGroupId()) %>" />
			<portlet:param name="removeUserGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			message="remove-membership"
			url="<%= deleteGroupUserGroupsURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>

<aui:script use="liferay-item-selector-dialog">
	$('#<portlet:namespace /><%= row.getRowId() %>assignSiteRoles').on(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = $(event.currentTarget);

			var addUserGroupGroupRoleFm = $(document.<portlet:namespace />addUserGroupGroupRoleFm);

			addUserGroupGroupRoleFm.fm('userGroupId').val(currentTarget.data('usergroupid'));

			var itemSelectorDialog = new A.LiferayItemSelectorDialog(
				{
					eventName: '<portlet:namespace />selectUserGroupsRoles',
					on: {
						selectedItemChange: function(event) {
							var selectedItem = event.newVal;

							if (selectedItem) {
								addUserGroupGroupRoleFm.append(selectedItem);

								submitForm(addUserGroupGroupRoleFm);
							}
						}
					},
					'strings.add': '<liferay-ui:message key="done" />',
					title: '<liferay-ui:message key="assign-site-roles" />',
					url: currentTarget.data('href')
				}
			);

			itemSelectorDialog.open();
		}
	);

	$('#<portlet:namespace /><%= row.getRowId() %>unAssignSiteRoles').on(
		'click',
		function(event) {
			event.preventDefault();

			var currentTarget = $(event.currentTarget);

			var unAssignUserGroupGroupRoleFm = $(document.<portlet:namespace />unAssignUserGroupGroupRoleFm);

			unAssignUserGroupGroupRoleFm.fm('userGroupId').val(currentTarget.data('usergroupid'));

			var itemSelectorDialog = new A.LiferayItemSelectorDialog(
				{
					eventName: '<portlet:namespace />selectUserGroupsRoles',
					on: {
						selectedItemChange: function(event) {
							var selectedItem = event.newVal;

							if (selectedItem) {
								unAssignUserGroupGroupRoleFm.append(selectedItem);

								submitForm(unAssignUserGroupGroupRoleFm);
							}
						}
					},
					'strings.add': '<liferay-ui:message key="done" />',
					title: '<liferay-ui:message key="unassign-site-roles" />',
					url: currentTarget.data('href')
				}
			);

			itemSelectorDialog.open();
		}
	);
</aui:script>