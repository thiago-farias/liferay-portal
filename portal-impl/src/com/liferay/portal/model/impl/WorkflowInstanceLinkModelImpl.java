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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.model.WorkflowInstanceLinkModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the WorkflowInstanceLink service. Represents a row in the &quot;WorkflowInstanceLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>WorkflowInstanceLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkflowInstanceLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowInstanceLinkImpl
 * @generated
 */
public class WorkflowInstanceLinkModelImpl
	extends BaseModelImpl<WorkflowInstanceLink>
	implements WorkflowInstanceLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a workflow instance link model instance should use the <code>WorkflowInstanceLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "WorkflowInstanceLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"workflowInstanceLinkId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT}, {"workflowInstanceId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workflowInstanceLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workflowInstanceId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table WorkflowInstanceLink (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,workflowInstanceLinkId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,workflowInstanceId LONG,primary key (workflowInstanceLinkId, ctCollectionId))";

	public static final String TABLE_SQL_DROP =
		"drop table WorkflowInstanceLink";

	public static final String ORDER_BY_JPQL =
		" ORDER BY workflowInstanceLink.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY WorkflowInstanceLink.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.WorkflowInstanceLink"));

	public WorkflowInstanceLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workflowInstanceLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowInstanceLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowInstanceLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowInstanceLink.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowInstanceLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<WorkflowInstanceLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<WorkflowInstanceLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WorkflowInstanceLink, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((WorkflowInstanceLink)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<WorkflowInstanceLink, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<WorkflowInstanceLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(WorkflowInstanceLink)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<WorkflowInstanceLink, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<WorkflowInstanceLink, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, WorkflowInstanceLink>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			WorkflowInstanceLink.class.getClassLoader(),
			WorkflowInstanceLink.class, ModelWrapper.class);

		try {
			Constructor<WorkflowInstanceLink> constructor =
				(Constructor<WorkflowInstanceLink>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<WorkflowInstanceLink, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<WorkflowInstanceLink, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<WorkflowInstanceLink, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<WorkflowInstanceLink, Object>>();
		Map<String, BiConsumer<WorkflowInstanceLink, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<WorkflowInstanceLink, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", WorkflowInstanceLink::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", WorkflowInstanceLink::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setCtCollectionId);
		attributeGetterFunctions.put(
			"workflowInstanceLinkId",
			WorkflowInstanceLink::getWorkflowInstanceLinkId);
		attributeSetterBiConsumers.put(
			"workflowInstanceLinkId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setWorkflowInstanceLinkId);
		attributeGetterFunctions.put(
			"groupId", WorkflowInstanceLink::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setGroupId);
		attributeGetterFunctions.put(
			"companyId", WorkflowInstanceLink::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setCompanyId);
		attributeGetterFunctions.put("userId", WorkflowInstanceLink::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setUserId);
		attributeGetterFunctions.put(
			"userName", WorkflowInstanceLink::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<WorkflowInstanceLink, String>)
				WorkflowInstanceLink::setUserName);
		attributeGetterFunctions.put(
			"createDate", WorkflowInstanceLink::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<WorkflowInstanceLink, Date>)
				WorkflowInstanceLink::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", WorkflowInstanceLink::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<WorkflowInstanceLink, Date>)
				WorkflowInstanceLink::setModifiedDate);
		attributeGetterFunctions.put(
			"classNameId", WorkflowInstanceLink::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setClassNameId);
		attributeGetterFunctions.put(
			"classPK", WorkflowInstanceLink::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setClassPK);
		attributeGetterFunctions.put(
			"workflowInstanceId", WorkflowInstanceLink::getWorkflowInstanceId);
		attributeSetterBiConsumers.put(
			"workflowInstanceId",
			(BiConsumer<WorkflowInstanceLink, Long>)
				WorkflowInstanceLink::setWorkflowInstanceId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ctCollectionId = ctCollectionId;
	}

	@Override
	public long getWorkflowInstanceLinkId() {
		return _workflowInstanceLinkId;
	}

	@Override
	public void setWorkflowInstanceLinkId(long workflowInstanceLinkId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workflowInstanceLinkId = workflowInstanceLinkId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classNameId = classNameId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassNameId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("classNameId"));
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("classPK"));
	}

	@Override
	public long getWorkflowInstanceId() {
		return _workflowInstanceId;
	}

	@Override
	public void setWorkflowInstanceId(long workflowInstanceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workflowInstanceId = workflowInstanceId;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), WorkflowInstanceLink.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkflowInstanceLink toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, WorkflowInstanceLink>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkflowInstanceLinkImpl workflowInstanceLinkImpl =
			new WorkflowInstanceLinkImpl();

		workflowInstanceLinkImpl.setMvccVersion(getMvccVersion());
		workflowInstanceLinkImpl.setCtCollectionId(getCtCollectionId());
		workflowInstanceLinkImpl.setWorkflowInstanceLinkId(
			getWorkflowInstanceLinkId());
		workflowInstanceLinkImpl.setGroupId(getGroupId());
		workflowInstanceLinkImpl.setCompanyId(getCompanyId());
		workflowInstanceLinkImpl.setUserId(getUserId());
		workflowInstanceLinkImpl.setUserName(getUserName());
		workflowInstanceLinkImpl.setCreateDate(getCreateDate());
		workflowInstanceLinkImpl.setModifiedDate(getModifiedDate());
		workflowInstanceLinkImpl.setClassNameId(getClassNameId());
		workflowInstanceLinkImpl.setClassPK(getClassPK());
		workflowInstanceLinkImpl.setWorkflowInstanceId(getWorkflowInstanceId());

		workflowInstanceLinkImpl.resetOriginalValues();

		return workflowInstanceLinkImpl;
	}

	@Override
	public int compareTo(WorkflowInstanceLink workflowInstanceLink) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), workflowInstanceLink.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkflowInstanceLink)) {
			return false;
		}

		WorkflowInstanceLink workflowInstanceLink =
			(WorkflowInstanceLink)object;

		long primaryKey = workflowInstanceLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkflowInstanceLink> toCacheModel() {
		WorkflowInstanceLinkCacheModel workflowInstanceLinkCacheModel =
			new WorkflowInstanceLinkCacheModel();

		workflowInstanceLinkCacheModel.mvccVersion = getMvccVersion();

		workflowInstanceLinkCacheModel.ctCollectionId = getCtCollectionId();

		workflowInstanceLinkCacheModel.workflowInstanceLinkId =
			getWorkflowInstanceLinkId();

		workflowInstanceLinkCacheModel.groupId = getGroupId();

		workflowInstanceLinkCacheModel.companyId = getCompanyId();

		workflowInstanceLinkCacheModel.userId = getUserId();

		workflowInstanceLinkCacheModel.userName = getUserName();

		String userName = workflowInstanceLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			workflowInstanceLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			workflowInstanceLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			workflowInstanceLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			workflowInstanceLinkCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			workflowInstanceLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		workflowInstanceLinkCacheModel.classNameId = getClassNameId();

		workflowInstanceLinkCacheModel.classPK = getClassPK();

		workflowInstanceLinkCacheModel.workflowInstanceId =
			getWorkflowInstanceId();

		return workflowInstanceLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<WorkflowInstanceLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<WorkflowInstanceLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WorkflowInstanceLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((WorkflowInstanceLink)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<WorkflowInstanceLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<WorkflowInstanceLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WorkflowInstanceLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((WorkflowInstanceLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, WorkflowInstanceLink>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _workflowInstanceLinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _workflowInstanceId;

	public <T> T getColumnValue(String columnName) {
		Function<WorkflowInstanceLink, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((WorkflowInstanceLink)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("ctCollectionId", _ctCollectionId);
		_columnOriginalValues.put(
			"workflowInstanceLinkId", _workflowInstanceLinkId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("classNameId", _classNameId);
		_columnOriginalValues.put("classPK", _classPK);
		_columnOriginalValues.put("workflowInstanceId", _workflowInstanceId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("ctCollectionId", 2L);

		columnBitmasks.put("workflowInstanceLinkId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("classNameId", 512L);

		columnBitmasks.put("classPK", 1024L);

		columnBitmasks.put("workflowInstanceId", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private WorkflowInstanceLink _escapedModel;

}