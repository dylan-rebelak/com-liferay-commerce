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

package com.liferay.commerce.account.service.base;

import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountService;
import com.liferay.commerce.account.service.persistence.CommerceAccountFinder;
import com.liferay.commerce.account.service.persistence.CommerceAccountOrganizationRelPersistence;
import com.liferay.commerce.account.service.persistence.CommerceAccountPersistence;
import com.liferay.commerce.account.service.persistence.CommerceAccountUserRelPersistence;

import com.liferay.expando.kernel.service.persistence.ExpandoRowPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce account remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.account.service.impl.CommerceAccountServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.account.service.impl.CommerceAccountServiceImpl
 * @see com.liferay.commerce.account.service.CommerceAccountServiceUtil
 * @generated
 */
public abstract class CommerceAccountServiceBaseImpl extends BaseServiceImpl
	implements CommerceAccountService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.commerce.account.service.CommerceAccountServiceUtil} to access the commerce account remote service.
	 */

	/**
	 * Returns the commerce account local service.
	 *
	 * @return the commerce account local service
	 */
	public com.liferay.commerce.account.service.CommerceAccountLocalService getCommerceAccountLocalService() {
		return commerceAccountLocalService;
	}

	/**
	 * Sets the commerce account local service.
	 *
	 * @param commerceAccountLocalService the commerce account local service
	 */
	public void setCommerceAccountLocalService(
		com.liferay.commerce.account.service.CommerceAccountLocalService commerceAccountLocalService) {
		this.commerceAccountLocalService = commerceAccountLocalService;
	}

	/**
	 * Returns the commerce account remote service.
	 *
	 * @return the commerce account remote service
	 */
	public CommerceAccountService getCommerceAccountService() {
		return commerceAccountService;
	}

	/**
	 * Sets the commerce account remote service.
	 *
	 * @param commerceAccountService the commerce account remote service
	 */
	public void setCommerceAccountService(
		CommerceAccountService commerceAccountService) {
		this.commerceAccountService = commerceAccountService;
	}

	/**
	 * Returns the commerce account persistence.
	 *
	 * @return the commerce account persistence
	 */
	public CommerceAccountPersistence getCommerceAccountPersistence() {
		return commerceAccountPersistence;
	}

	/**
	 * Sets the commerce account persistence.
	 *
	 * @param commerceAccountPersistence the commerce account persistence
	 */
	public void setCommerceAccountPersistence(
		CommerceAccountPersistence commerceAccountPersistence) {
		this.commerceAccountPersistence = commerceAccountPersistence;
	}

	/**
	 * Returns the commerce account finder.
	 *
	 * @return the commerce account finder
	 */
	public CommerceAccountFinder getCommerceAccountFinder() {
		return commerceAccountFinder;
	}

	/**
	 * Sets the commerce account finder.
	 *
	 * @param commerceAccountFinder the commerce account finder
	 */
	public void setCommerceAccountFinder(
		CommerceAccountFinder commerceAccountFinder) {
		this.commerceAccountFinder = commerceAccountFinder;
	}

	/**
	 * Returns the commerce account organization rel local service.
	 *
	 * @return the commerce account organization rel local service
	 */
	public com.liferay.commerce.account.service.CommerceAccountOrganizationRelLocalService getCommerceAccountOrganizationRelLocalService() {
		return commerceAccountOrganizationRelLocalService;
	}

	/**
	 * Sets the commerce account organization rel local service.
	 *
	 * @param commerceAccountOrganizationRelLocalService the commerce account organization rel local service
	 */
	public void setCommerceAccountOrganizationRelLocalService(
		com.liferay.commerce.account.service.CommerceAccountOrganizationRelLocalService commerceAccountOrganizationRelLocalService) {
		this.commerceAccountOrganizationRelLocalService = commerceAccountOrganizationRelLocalService;
	}

	/**
	 * Returns the commerce account organization rel remote service.
	 *
	 * @return the commerce account organization rel remote service
	 */
	public com.liferay.commerce.account.service.CommerceAccountOrganizationRelService getCommerceAccountOrganizationRelService() {
		return commerceAccountOrganizationRelService;
	}

	/**
	 * Sets the commerce account organization rel remote service.
	 *
	 * @param commerceAccountOrganizationRelService the commerce account organization rel remote service
	 */
	public void setCommerceAccountOrganizationRelService(
		com.liferay.commerce.account.service.CommerceAccountOrganizationRelService commerceAccountOrganizationRelService) {
		this.commerceAccountOrganizationRelService = commerceAccountOrganizationRelService;
	}

	/**
	 * Returns the commerce account organization rel persistence.
	 *
	 * @return the commerce account organization rel persistence
	 */
	public CommerceAccountOrganizationRelPersistence getCommerceAccountOrganizationRelPersistence() {
		return commerceAccountOrganizationRelPersistence;
	}

	/**
	 * Sets the commerce account organization rel persistence.
	 *
	 * @param commerceAccountOrganizationRelPersistence the commerce account organization rel persistence
	 */
	public void setCommerceAccountOrganizationRelPersistence(
		CommerceAccountOrganizationRelPersistence commerceAccountOrganizationRelPersistence) {
		this.commerceAccountOrganizationRelPersistence = commerceAccountOrganizationRelPersistence;
	}

	/**
	 * Returns the commerce account user rel local service.
	 *
	 * @return the commerce account user rel local service
	 */
	public com.liferay.commerce.account.service.CommerceAccountUserRelLocalService getCommerceAccountUserRelLocalService() {
		return commerceAccountUserRelLocalService;
	}

	/**
	 * Sets the commerce account user rel local service.
	 *
	 * @param commerceAccountUserRelLocalService the commerce account user rel local service
	 */
	public void setCommerceAccountUserRelLocalService(
		com.liferay.commerce.account.service.CommerceAccountUserRelLocalService commerceAccountUserRelLocalService) {
		this.commerceAccountUserRelLocalService = commerceAccountUserRelLocalService;
	}

	/**
	 * Returns the commerce account user rel remote service.
	 *
	 * @return the commerce account user rel remote service
	 */
	public com.liferay.commerce.account.service.CommerceAccountUserRelService getCommerceAccountUserRelService() {
		return commerceAccountUserRelService;
	}

	/**
	 * Sets the commerce account user rel remote service.
	 *
	 * @param commerceAccountUserRelService the commerce account user rel remote service
	 */
	public void setCommerceAccountUserRelService(
		com.liferay.commerce.account.service.CommerceAccountUserRelService commerceAccountUserRelService) {
		this.commerceAccountUserRelService = commerceAccountUserRelService;
	}

	/**
	 * Returns the commerce account user rel persistence.
	 *
	 * @return the commerce account user rel persistence
	 */
	public CommerceAccountUserRelPersistence getCommerceAccountUserRelPersistence() {
		return commerceAccountUserRelPersistence;
	}

	/**
	 * Sets the commerce account user rel persistence.
	 *
	 * @param commerceAccountUserRelPersistence the commerce account user rel persistence
	 */
	public void setCommerceAccountUserRelPersistence(
		CommerceAccountUserRelPersistence commerceAccountUserRelPersistence) {
		this.commerceAccountUserRelPersistence = commerceAccountUserRelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.kernel.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.kernel.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.kernel.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.kernel.service.GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the expando row local service.
	 *
	 * @return the expando row local service
	 */
	public com.liferay.expando.kernel.service.ExpandoRowLocalService getExpandoRowLocalService() {
		return expandoRowLocalService;
	}

	/**
	 * Sets the expando row local service.
	 *
	 * @param expandoRowLocalService the expando row local service
	 */
	public void setExpandoRowLocalService(
		com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService) {
		this.expandoRowLocalService = expandoRowLocalService;
	}

	/**
	 * Returns the expando row persistence.
	 *
	 * @return the expando row persistence
	 */
	public ExpandoRowPersistence getExpandoRowPersistence() {
		return expandoRowPersistence;
	}

	/**
	 * Sets the expando row persistence.
	 *
	 * @param expandoRowPersistence the expando row persistence
	 */
	public void setExpandoRowPersistence(
		ExpandoRowPersistence expandoRowPersistence) {
		this.expandoRowPersistence = expandoRowPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceAccountService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceAccount.class;
	}

	protected String getModelClassName() {
		return CommerceAccount.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceAccountPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.commerce.account.service.CommerceAccountLocalService.class)
	protected com.liferay.commerce.account.service.CommerceAccountLocalService commerceAccountLocalService;
	@BeanReference(type = CommerceAccountService.class)
	protected CommerceAccountService commerceAccountService;
	@BeanReference(type = CommerceAccountPersistence.class)
	protected CommerceAccountPersistence commerceAccountPersistence;
	@BeanReference(type = CommerceAccountFinder.class)
	protected CommerceAccountFinder commerceAccountFinder;
	@BeanReference(type = com.liferay.commerce.account.service.CommerceAccountOrganizationRelLocalService.class)
	protected com.liferay.commerce.account.service.CommerceAccountOrganizationRelLocalService commerceAccountOrganizationRelLocalService;
	@BeanReference(type = com.liferay.commerce.account.service.CommerceAccountOrganizationRelService.class)
	protected com.liferay.commerce.account.service.CommerceAccountOrganizationRelService commerceAccountOrganizationRelService;
	@BeanReference(type = CommerceAccountOrganizationRelPersistence.class)
	protected CommerceAccountOrganizationRelPersistence commerceAccountOrganizationRelPersistence;
	@BeanReference(type = com.liferay.commerce.account.service.CommerceAccountUserRelLocalService.class)
	protected com.liferay.commerce.account.service.CommerceAccountUserRelLocalService commerceAccountUserRelLocalService;
	@BeanReference(type = com.liferay.commerce.account.service.CommerceAccountUserRelService.class)
	protected com.liferay.commerce.account.service.CommerceAccountUserRelService commerceAccountUserRelService;
	@BeanReference(type = CommerceAccountUserRelPersistence.class)
	protected CommerceAccountUserRelPersistence commerceAccountUserRelPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.GroupLocalService.class)
	protected com.liferay.portal.kernel.service.GroupLocalService groupLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.GroupService.class)
	protected com.liferay.portal.kernel.service.GroupService groupService;
	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.expando.kernel.service.ExpandoRowLocalService.class)
	protected com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService;
	@ServiceReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;
}