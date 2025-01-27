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

package com.liferay.sync.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sync.model.SyncDLFileVersionDiff;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sync dl file version diff service. This utility wraps <code>com.liferay.sync.service.persistence.impl.SyncDLFileVersionDiffPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SyncDLFileVersionDiffPersistence
 * @generated
 */
public class SyncDLFileVersionDiffUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SyncDLFileVersionDiff syncDLFileVersionDiff) {
		getPersistence().clearCache(syncDLFileVersionDiff);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SyncDLFileVersionDiff> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SyncDLFileVersionDiff> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SyncDLFileVersionDiff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SyncDLFileVersionDiff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SyncDLFileVersionDiff update(
		SyncDLFileVersionDiff syncDLFileVersionDiff) {

		return getPersistence().update(syncDLFileVersionDiff);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SyncDLFileVersionDiff update(
		SyncDLFileVersionDiff syncDLFileVersionDiff,
		ServiceContext serviceContext) {

		return getPersistence().update(syncDLFileVersionDiff, serviceContext);
	}

	/**
	 * Returns all the sync dl file version diffs where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByFileEntryId(
		long fileEntryId) {

		return getPersistence().findByFileEntryId(fileEntryId);
	}

	/**
	 * Returns a range of all the sync dl file version diffs where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @return the range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByFileEntryId(
		long fileEntryId, int start, int end) {

		return getPersistence().findByFileEntryId(fileEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sync dl file version diff in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff findByFileEntryId_First(
			long fileEntryId,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the first sync dl file version diff in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByFileEntryId_First(
		long fileEntryId,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().fetchByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last sync dl file version diff in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff findByFileEntryId_Last(
			long fileEntryId,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last sync dl file version diff in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByFileEntryId_Last(
		long fileEntryId,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().fetchByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the sync dl file version diffs before and after the current sync dl file version diff in the ordered set where fileEntryId = &#63;.
	 *
	 * @param syncDLFileVersionDiffId the primary key of the current sync dl file version diff
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a sync dl file version diff with the primary key could not be found
	 */
	public static SyncDLFileVersionDiff[] findByFileEntryId_PrevAndNext(
			long syncDLFileVersionDiffId, long fileEntryId,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByFileEntryId_PrevAndNext(
			syncDLFileVersionDiffId, fileEntryId, orderByComparator);
	}

	/**
	 * Removes all the sync dl file version diffs where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	public static void removeByFileEntryId(long fileEntryId) {
		getPersistence().removeByFileEntryId(fileEntryId);
	}

	/**
	 * Returns the number of sync dl file version diffs where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching sync dl file version diffs
	 */
	public static int countByFileEntryId(long fileEntryId) {
		return getPersistence().countByFileEntryId(fileEntryId);
	}

	/**
	 * Returns all the sync dl file version diffs where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @return the matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByLtExpirationDate(
		Date expirationDate) {

		return getPersistence().findByLtExpirationDate(expirationDate);
	}

	/**
	 * Returns a range of all the sync dl file version diffs where expirationDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @return the range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByLtExpirationDate(
		Date expirationDate, int start, int end) {

		return getPersistence().findByLtExpirationDate(
			expirationDate, start, end);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs where expirationDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByLtExpirationDate(
		Date expirationDate, int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().findByLtExpirationDate(
			expirationDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs where expirationDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findByLtExpirationDate(
		Date expirationDate, int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLtExpirationDate(
			expirationDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sync dl file version diff in the ordered set where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff findByLtExpirationDate_First(
			Date expirationDate,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByLtExpirationDate_First(
			expirationDate, orderByComparator);
	}

	/**
	 * Returns the first sync dl file version diff in the ordered set where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByLtExpirationDate_First(
		Date expirationDate,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().fetchByLtExpirationDate_First(
			expirationDate, orderByComparator);
	}

	/**
	 * Returns the last sync dl file version diff in the ordered set where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff findByLtExpirationDate_Last(
			Date expirationDate,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByLtExpirationDate_Last(
			expirationDate, orderByComparator);
	}

	/**
	 * Returns the last sync dl file version diff in the ordered set where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByLtExpirationDate_Last(
		Date expirationDate,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().fetchByLtExpirationDate_Last(
			expirationDate, orderByComparator);
	}

	/**
	 * Returns the sync dl file version diffs before and after the current sync dl file version diff in the ordered set where expirationDate &lt; &#63;.
	 *
	 * @param syncDLFileVersionDiffId the primary key of the current sync dl file version diff
	 * @param expirationDate the expiration date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a sync dl file version diff with the primary key could not be found
	 */
	public static SyncDLFileVersionDiff[] findByLtExpirationDate_PrevAndNext(
			long syncDLFileVersionDiffId, Date expirationDate,
			OrderByComparator<SyncDLFileVersionDiff> orderByComparator)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByLtExpirationDate_PrevAndNext(
			syncDLFileVersionDiffId, expirationDate, orderByComparator);
	}

	/**
	 * Removes all the sync dl file version diffs where expirationDate &lt; &#63; from the database.
	 *
	 * @param expirationDate the expiration date
	 */
	public static void removeByLtExpirationDate(Date expirationDate) {
		getPersistence().removeByLtExpirationDate(expirationDate);
	}

	/**
	 * Returns the number of sync dl file version diffs where expirationDate &lt; &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @return the number of matching sync dl file version diffs
	 */
	public static int countByLtExpirationDate(Date expirationDate) {
		return getPersistence().countByLtExpirationDate(expirationDate);
	}

	/**
	 * Returns the sync dl file version diff where fileEntryId = &#63; and sourceFileVersionId = &#63; and targetFileVersionId = &#63; or throws a <code>NoSuchDLFileVersionDiffException</code> if it could not be found.
	 *
	 * @param fileEntryId the file entry ID
	 * @param sourceFileVersionId the source file version ID
	 * @param targetFileVersionId the target file version ID
	 * @return the matching sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff findByF_S_T(
			long fileEntryId, long sourceFileVersionId,
			long targetFileVersionId)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByF_S_T(
			fileEntryId, sourceFileVersionId, targetFileVersionId);
	}

	/**
	 * Returns the sync dl file version diff where fileEntryId = &#63; and sourceFileVersionId = &#63; and targetFileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileEntryId the file entry ID
	 * @param sourceFileVersionId the source file version ID
	 * @param targetFileVersionId the target file version ID
	 * @return the matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByF_S_T(
		long fileEntryId, long sourceFileVersionId, long targetFileVersionId) {

		return getPersistence().fetchByF_S_T(
			fileEntryId, sourceFileVersionId, targetFileVersionId);
	}

	/**
	 * Returns the sync dl file version diff where fileEntryId = &#63; and sourceFileVersionId = &#63; and targetFileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileEntryId the file entry ID
	 * @param sourceFileVersionId the source file version ID
	 * @param targetFileVersionId the target file version ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sync dl file version diff, or <code>null</code> if a matching sync dl file version diff could not be found
	 */
	public static SyncDLFileVersionDiff fetchByF_S_T(
		long fileEntryId, long sourceFileVersionId, long targetFileVersionId,
		boolean useFinderCache) {

		return getPersistence().fetchByF_S_T(
			fileEntryId, sourceFileVersionId, targetFileVersionId,
			useFinderCache);
	}

	/**
	 * Removes the sync dl file version diff where fileEntryId = &#63; and sourceFileVersionId = &#63; and targetFileVersionId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @param sourceFileVersionId the source file version ID
	 * @param targetFileVersionId the target file version ID
	 * @return the sync dl file version diff that was removed
	 */
	public static SyncDLFileVersionDiff removeByF_S_T(
			long fileEntryId, long sourceFileVersionId,
			long targetFileVersionId)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().removeByF_S_T(
			fileEntryId, sourceFileVersionId, targetFileVersionId);
	}

	/**
	 * Returns the number of sync dl file version diffs where fileEntryId = &#63; and sourceFileVersionId = &#63; and targetFileVersionId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param sourceFileVersionId the source file version ID
	 * @param targetFileVersionId the target file version ID
	 * @return the number of matching sync dl file version diffs
	 */
	public static int countByF_S_T(
		long fileEntryId, long sourceFileVersionId, long targetFileVersionId) {

		return getPersistence().countByF_S_T(
			fileEntryId, sourceFileVersionId, targetFileVersionId);
	}

	/**
	 * Caches the sync dl file version diff in the entity cache if it is enabled.
	 *
	 * @param syncDLFileVersionDiff the sync dl file version diff
	 */
	public static void cacheResult(
		SyncDLFileVersionDiff syncDLFileVersionDiff) {

		getPersistence().cacheResult(syncDLFileVersionDiff);
	}

	/**
	 * Caches the sync dl file version diffs in the entity cache if it is enabled.
	 *
	 * @param syncDLFileVersionDiffs the sync dl file version diffs
	 */
	public static void cacheResult(
		List<SyncDLFileVersionDiff> syncDLFileVersionDiffs) {

		getPersistence().cacheResult(syncDLFileVersionDiffs);
	}

	/**
	 * Creates a new sync dl file version diff with the primary key. Does not add the sync dl file version diff to the database.
	 *
	 * @param syncDLFileVersionDiffId the primary key for the new sync dl file version diff
	 * @return the new sync dl file version diff
	 */
	public static SyncDLFileVersionDiff create(long syncDLFileVersionDiffId) {
		return getPersistence().create(syncDLFileVersionDiffId);
	}

	/**
	 * Removes the sync dl file version diff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syncDLFileVersionDiffId the primary key of the sync dl file version diff
	 * @return the sync dl file version diff that was removed
	 * @throws NoSuchDLFileVersionDiffException if a sync dl file version diff with the primary key could not be found
	 */
	public static SyncDLFileVersionDiff remove(long syncDLFileVersionDiffId)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().remove(syncDLFileVersionDiffId);
	}

	public static SyncDLFileVersionDiff updateImpl(
		SyncDLFileVersionDiff syncDLFileVersionDiff) {

		return getPersistence().updateImpl(syncDLFileVersionDiff);
	}

	/**
	 * Returns the sync dl file version diff with the primary key or throws a <code>NoSuchDLFileVersionDiffException</code> if it could not be found.
	 *
	 * @param syncDLFileVersionDiffId the primary key of the sync dl file version diff
	 * @return the sync dl file version diff
	 * @throws NoSuchDLFileVersionDiffException if a sync dl file version diff with the primary key could not be found
	 */
	public static SyncDLFileVersionDiff findByPrimaryKey(
			long syncDLFileVersionDiffId)
		throws com.liferay.sync.exception.NoSuchDLFileVersionDiffException {

		return getPersistence().findByPrimaryKey(syncDLFileVersionDiffId);
	}

	/**
	 * Returns the sync dl file version diff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param syncDLFileVersionDiffId the primary key of the sync dl file version diff
	 * @return the sync dl file version diff, or <code>null</code> if a sync dl file version diff with the primary key could not be found
	 */
	public static SyncDLFileVersionDiff fetchByPrimaryKey(
		long syncDLFileVersionDiffId) {

		return getPersistence().fetchByPrimaryKey(syncDLFileVersionDiffId);
	}

	/**
	 * Returns all the sync dl file version diffs.
	 *
	 * @return the sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sync dl file version diffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @return the range of sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findAll(
		int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sync dl file version diffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SyncDLFileVersionDiffModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sync dl file version diffs
	 * @param end the upper bound of the range of sync dl file version diffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sync dl file version diffs
	 */
	public static List<SyncDLFileVersionDiff> findAll(
		int start, int end,
		OrderByComparator<SyncDLFileVersionDiff> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sync dl file version diffs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sync dl file version diffs.
	 *
	 * @return the number of sync dl file version diffs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SyncDLFileVersionDiffPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SyncDLFileVersionDiffPersistence, SyncDLFileVersionDiffPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SyncDLFileVersionDiffPersistence.class);

		ServiceTracker
			<SyncDLFileVersionDiffPersistence, SyncDLFileVersionDiffPersistence>
				serviceTracker =
					new ServiceTracker
						<SyncDLFileVersionDiffPersistence,
						 SyncDLFileVersionDiffPersistence>(
							 bundle.getBundleContext(),
							 SyncDLFileVersionDiffPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}