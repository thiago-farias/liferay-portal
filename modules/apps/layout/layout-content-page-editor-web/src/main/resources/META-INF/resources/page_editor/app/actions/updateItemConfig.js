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

import {UPDATE_ITEM_CONFIG as type} from './types';

const ACTION = {type};

/**
 * @param {object} options
 * @param {object} [options.config={}]
 * @param {string} options.itemId
 * @param {string} options.itemType
 * @return {object}
 */
export default function updateItem({config = {}, itemId, itemType}) {
	return {
		...ACTION,
		config,
		itemId,
		itemType
	};
}
