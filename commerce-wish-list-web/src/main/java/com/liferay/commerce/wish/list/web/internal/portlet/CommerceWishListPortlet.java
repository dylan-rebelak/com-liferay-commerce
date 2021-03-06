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

package com.liferay.commerce.wish.list.web.internal.portlet;

import com.liferay.commerce.price.CommerceProductPriceCalculation;
import com.liferay.commerce.product.util.CPDefinitionHelper;
import com.liferay.commerce.product.util.CPInstanceHelper;
import com.liferay.commerce.wish.list.constants.CommerceWishListConstants;
import com.liferay.commerce.wish.list.constants.CommerceWishListPortletKeys;
import com.liferay.commerce.wish.list.service.CommerceWishListItemService;
import com.liferay.commerce.wish.list.service.CommerceWishListService;
import com.liferay.commerce.wish.list.util.CommerceWishListHttpHelper;
import com.liferay.commerce.wish.list.web.internal.display.context.CommerceWishListDisplayContext;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 * @author Andrea Di Giorgi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-commerce-wish-list",
		"com.liferay.portlet.display-category=hidden",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=Wish Lists",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CommerceWishListPortletKeys.COMMERCE_WISH_LIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {CommerceWishListPortlet.class, Portlet.class}
)
public class CommerceWishListPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		HttpServletRequest httpServletRequest = portal.getHttpServletRequest(
			renderRequest);

		CommerceWishListDisplayContext commerceWishListDisplayContext =
			new CommerceWishListDisplayContext(
				commerceProductPriceCalculation, commerceWishListHttpHelper,
				commerceWishListItemService, commerceWishListService,
				cpDefinitionHelper, cpInstanceHelper, httpServletRequest,
				_portletResourcePermission);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, commerceWishListDisplayContext);

		super.render(renderRequest, renderResponse);
	}

	@Reference
	protected CommerceProductPriceCalculation commerceProductPriceCalculation;

	@Reference
	protected CommerceWishListHttpHelper commerceWishListHttpHelper;

	@Reference
	protected CommerceWishListItemService commerceWishListItemService;

	@Reference
	protected CommerceWishListService commerceWishListService;

	@Reference
	protected CPDefinitionHelper cpDefinitionHelper;

	@Reference
	protected CPInstanceHelper cpInstanceHelper;

	@Reference
	protected Portal portal;

	@Reference(
		target = "(resource.name=" + CommerceWishListConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

}