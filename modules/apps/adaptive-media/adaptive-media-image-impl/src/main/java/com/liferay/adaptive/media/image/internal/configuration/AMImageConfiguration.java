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

package com.liferay.adaptive.media.image.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "collaboration")
@Meta.OCD(
	id = "com.liferay.adaptive.media.image.internal.configuration.AMImageConfiguration",
	localization = "content/Language",
	name = "adaptive-media-image-configuration-name"
)
public interface AMImageConfiguration {

	/**
	 * Sets the supported mime types that generate adaptive media images.
	 */
	@Meta.AD(
		deflt = "image/bmp|image/gif|image/jpeg|image/pjpeg|image/png|image/tiff|image/x-citrix-jpeg|image/x-citrix-png|image/x-ms-bmp|image/x-png|image/x-tiff",
		description = "supported-mime-types-key-description",
		name = "supported-mime-type", required = false
	)
	public String[] supportedMimeTypes();

}