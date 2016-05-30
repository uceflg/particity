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

package de.fraunhofer.fokus.oefit.particity.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHAddrPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHConfigPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHContactPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHSubscriptionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the a h org local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHOrgLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHOrgLocalServiceImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AHOrgLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AHOrgLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil} to access the a h org local service.
	 */

	/**
	 * Adds the a h org to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ahOrg the a h org
	 * @return the a h org that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AHOrg addAHOrg(AHOrg ahOrg) {
		ahOrg.setNew(true);

		return ahOrgPersistence.update(ahOrg);
	}

	/**
	 * Creates a new a h org with the primary key. Does not add the a h org to the database.
	 *
	 * @param orgId the primary key for the new a h org
	 * @return the new a h org
	 */
	@Override
	public AHOrg createAHOrg(long orgId) {
		return ahOrgPersistence.create(orgId);
	}

	/**
	 * Deletes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgId the primary key of the a h org
	 * @return the a h org that was removed
	 * @throws PortalException if a a h org with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AHOrg deleteAHOrg(long orgId) throws PortalException {
		return ahOrgPersistence.remove(orgId);
	}

	/**
	 * Deletes the a h org from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ahOrg the a h org
	 * @return the a h org that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AHOrg deleteAHOrg(AHOrg ahOrg) {
		return ahOrgPersistence.remove(ahOrg);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AHOrg.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ahOrgPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return ahOrgPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return ahOrgPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ahOrgPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return ahOrgPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public AHOrg fetchAHOrg(long orgId) {
		return ahOrgPersistence.fetchByPrimaryKey(orgId);
	}

	/**
	 * Returns the a h org with the primary key.
	 *
	 * @param orgId the primary key of the a h org
	 * @return the a h org
	 * @throws PortalException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg getAHOrg(long orgId) throws PortalException {
		return ahOrgPersistence.findByPrimaryKey(orgId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ahOrgLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AHOrg.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("orgId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(ahOrgLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AHOrg.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("orgId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(ahOrgLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AHOrg.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("orgId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return ahOrgLocalService.deleteAHOrg((AHOrg)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return ahOrgPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the a h orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @return the range of a h orgs
	 */
	@Override
	public List<AHOrg> getAHOrgs(int start, int end) {
		return ahOrgPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of a h orgs.
	 *
	 * @return the number of a h orgs
	 */
	@Override
	public int getAHOrgsCount() {
		return ahOrgPersistence.countAll();
	}

	/**
	 * Updates the a h org in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ahOrg the a h org
	 * @return the a h org that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AHOrg updateAHOrg(AHOrg ahOrg) {
		return ahOrgPersistence.update(ahOrg);
	}

	/**
	 * Returns the a h addr local service.
	 *
	 * @return the a h addr local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService getAHAddrLocalService() {
		return ahAddrLocalService;
	}

	/**
	 * Sets the a h addr local service.
	 *
	 * @param ahAddrLocalService the a h addr local service
	 */
	public void setAHAddrLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService ahAddrLocalService) {
		this.ahAddrLocalService = ahAddrLocalService;
	}

	/**
	 * Returns the a h addr persistence.
	 *
	 * @return the a h addr persistence
	 */
	public AHAddrPersistence getAHAddrPersistence() {
		return ahAddrPersistence;
	}

	/**
	 * Sets the a h addr persistence.
	 *
	 * @param ahAddrPersistence the a h addr persistence
	 */
	public void setAHAddrPersistence(AHAddrPersistence ahAddrPersistence) {
		this.ahAddrPersistence = ahAddrPersistence;
	}

	/**
	 * Returns the a h categories local service.
	 *
	 * @return the a h categories local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService getAHCategoriesLocalService() {
		return ahCategoriesLocalService;
	}

	/**
	 * Sets the a h categories local service.
	 *
	 * @param ahCategoriesLocalService the a h categories local service
	 */
	public void setAHCategoriesLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService ahCategoriesLocalService) {
		this.ahCategoriesLocalService = ahCategoriesLocalService;
	}

	/**
	 * Returns the a h categories persistence.
	 *
	 * @return the a h categories persistence
	 */
	public AHCategoriesPersistence getAHCategoriesPersistence() {
		return ahCategoriesPersistence;
	}

	/**
	 * Sets the a h categories persistence.
	 *
	 * @param ahCategoriesPersistence the a h categories persistence
	 */
	public void setAHCategoriesPersistence(
		AHCategoriesPersistence ahCategoriesPersistence) {
		this.ahCategoriesPersistence = ahCategoriesPersistence;
	}

	/**
	 * Returns the a h categories finder.
	 *
	 * @return the a h categories finder
	 */
	public AHCategoriesFinder getAHCategoriesFinder() {
		return ahCategoriesFinder;
	}

	/**
	 * Sets the a h categories finder.
	 *
	 * @param ahCategoriesFinder the a h categories finder
	 */
	public void setAHCategoriesFinder(AHCategoriesFinder ahCategoriesFinder) {
		this.ahCategoriesFinder = ahCategoriesFinder;
	}

	/**
	 * Returns the a h cat entries local service.
	 *
	 * @return the a h cat entries local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService getAHCatEntriesLocalService() {
		return ahCatEntriesLocalService;
	}

	/**
	 * Sets the a h cat entries local service.
	 *
	 * @param ahCatEntriesLocalService the a h cat entries local service
	 */
	public void setAHCatEntriesLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService ahCatEntriesLocalService) {
		this.ahCatEntriesLocalService = ahCatEntriesLocalService;
	}

	/**
	 * Returns the a h cat entries persistence.
	 *
	 * @return the a h cat entries persistence
	 */
	public AHCatEntriesPersistence getAHCatEntriesPersistence() {
		return ahCatEntriesPersistence;
	}

	/**
	 * Sets the a h cat entries persistence.
	 *
	 * @param ahCatEntriesPersistence the a h cat entries persistence
	 */
	public void setAHCatEntriesPersistence(
		AHCatEntriesPersistence ahCatEntriesPersistence) {
		this.ahCatEntriesPersistence = ahCatEntriesPersistence;
	}

	/**
	 * Returns the a h cat entries finder.
	 *
	 * @return the a h cat entries finder
	 */
	public AHCatEntriesFinder getAHCatEntriesFinder() {
		return ahCatEntriesFinder;
	}

	/**
	 * Sets the a h cat entries finder.
	 *
	 * @param ahCatEntriesFinder the a h cat entries finder
	 */
	public void setAHCatEntriesFinder(AHCatEntriesFinder ahCatEntriesFinder) {
		this.ahCatEntriesFinder = ahCatEntriesFinder;
	}

	/**
	 * Returns the a h config local service.
	 *
	 * @return the a h config local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService getAHConfigLocalService() {
		return ahConfigLocalService;
	}

	/**
	 * Sets the a h config local service.
	 *
	 * @param ahConfigLocalService the a h config local service
	 */
	public void setAHConfigLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService ahConfigLocalService) {
		this.ahConfigLocalService = ahConfigLocalService;
	}

	/**
	 * Returns the a h config persistence.
	 *
	 * @return the a h config persistence
	 */
	public AHConfigPersistence getAHConfigPersistence() {
		return ahConfigPersistence;
	}

	/**
	 * Sets the a h config persistence.
	 *
	 * @param ahConfigPersistence the a h config persistence
	 */
	public void setAHConfigPersistence(AHConfigPersistence ahConfigPersistence) {
		this.ahConfigPersistence = ahConfigPersistence;
	}

	/**
	 * Returns the a h contact local service.
	 *
	 * @return the a h contact local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService getAHContactLocalService() {
		return ahContactLocalService;
	}

	/**
	 * Sets the a h contact local service.
	 *
	 * @param ahContactLocalService the a h contact local service
	 */
	public void setAHContactLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService ahContactLocalService) {
		this.ahContactLocalService = ahContactLocalService;
	}

	/**
	 * Returns the a h contact persistence.
	 *
	 * @return the a h contact persistence
	 */
	public AHContactPersistence getAHContactPersistence() {
		return ahContactPersistence;
	}

	/**
	 * Sets the a h contact persistence.
	 *
	 * @param ahContactPersistence the a h contact persistence
	 */
	public void setAHContactPersistence(
		AHContactPersistence ahContactPersistence) {
		this.ahContactPersistence = ahContactPersistence;
	}

	/**
	 * Returns the a h offer local service.
	 *
	 * @return the a h offer local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService getAHOfferLocalService() {
		return ahOfferLocalService;
	}

	/**
	 * Sets the a h offer local service.
	 *
	 * @param ahOfferLocalService the a h offer local service
	 */
	public void setAHOfferLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService ahOfferLocalService) {
		this.ahOfferLocalService = ahOfferLocalService;
	}

	/**
	 * Returns the a h offer persistence.
	 *
	 * @return the a h offer persistence
	 */
	public AHOfferPersistence getAHOfferPersistence() {
		return ahOfferPersistence;
	}

	/**
	 * Sets the a h offer persistence.
	 *
	 * @param ahOfferPersistence the a h offer persistence
	 */
	public void setAHOfferPersistence(AHOfferPersistence ahOfferPersistence) {
		this.ahOfferPersistence = ahOfferPersistence;
	}

	/**
	 * Returns the a h offer finder.
	 *
	 * @return the a h offer finder
	 */
	public AHOfferFinder getAHOfferFinder() {
		return ahOfferFinder;
	}

	/**
	 * Sets the a h offer finder.
	 *
	 * @param ahOfferFinder the a h offer finder
	 */
	public void setAHOfferFinder(AHOfferFinder ahOfferFinder) {
		this.ahOfferFinder = ahOfferFinder;
	}

	/**
	 * Returns the a h org local service.
	 *
	 * @return the a h org local service
	 */
	public AHOrgLocalService getAHOrgLocalService() {
		return ahOrgLocalService;
	}

	/**
	 * Sets the a h org local service.
	 *
	 * @param ahOrgLocalService the a h org local service
	 */
	public void setAHOrgLocalService(AHOrgLocalService ahOrgLocalService) {
		this.ahOrgLocalService = ahOrgLocalService;
	}

	/**
	 * Returns the a h org persistence.
	 *
	 * @return the a h org persistence
	 */
	public AHOrgPersistence getAHOrgPersistence() {
		return ahOrgPersistence;
	}

	/**
	 * Sets the a h org persistence.
	 *
	 * @param ahOrgPersistence the a h org persistence
	 */
	public void setAHOrgPersistence(AHOrgPersistence ahOrgPersistence) {
		this.ahOrgPersistence = ahOrgPersistence;
	}

	/**
	 * Returns the a h org finder.
	 *
	 * @return the a h org finder
	 */
	public AHOrgFinder getAHOrgFinder() {
		return ahOrgFinder;
	}

	/**
	 * Sets the a h org finder.
	 *
	 * @param ahOrgFinder the a h org finder
	 */
	public void setAHOrgFinder(AHOrgFinder ahOrgFinder) {
		this.ahOrgFinder = ahOrgFinder;
	}

	/**
	 * Returns the a h region local service.
	 *
	 * @return the a h region local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService getAHRegionLocalService() {
		return ahRegionLocalService;
	}

	/**
	 * Sets the a h region local service.
	 *
	 * @param ahRegionLocalService the a h region local service
	 */
	public void setAHRegionLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService ahRegionLocalService) {
		this.ahRegionLocalService = ahRegionLocalService;
	}

	/**
	 * Returns the a h region persistence.
	 *
	 * @return the a h region persistence
	 */
	public AHRegionPersistence getAHRegionPersistence() {
		return ahRegionPersistence;
	}

	/**
	 * Sets the a h region persistence.
	 *
	 * @param ahRegionPersistence the a h region persistence
	 */
	public void setAHRegionPersistence(AHRegionPersistence ahRegionPersistence) {
		this.ahRegionPersistence = ahRegionPersistence;
	}

	/**
	 * Returns the a h subscription local service.
	 *
	 * @return the a h subscription local service
	 */
	public de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService getAHSubscriptionLocalService() {
		return ahSubscriptionLocalService;
	}

	/**
	 * Sets the a h subscription local service.
	 *
	 * @param ahSubscriptionLocalService the a h subscription local service
	 */
	public void setAHSubscriptionLocalService(
		de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService ahSubscriptionLocalService) {
		this.ahSubscriptionLocalService = ahSubscriptionLocalService;
	}

	/**
	 * Returns the a h subscription persistence.
	 *
	 * @return the a h subscription persistence
	 */
	public AHSubscriptionPersistence getAHSubscriptionPersistence() {
		return ahSubscriptionPersistence;
	}

	/**
	 * Sets the a h subscription persistence.
	 *
	 * @param ahSubscriptionPersistence the a h subscription persistence
	 */
	public void setAHSubscriptionPersistence(
		AHSubscriptionPersistence ahSubscriptionPersistence) {
		this.ahSubscriptionPersistence = ahSubscriptionPersistence;
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("de.fraunhofer.fokus.oefit.particity.model.AHOrg",
			ahOrgLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"de.fraunhofer.fokus.oefit.particity.model.AHOrg");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AHOrgLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AHOrg.class;
	}

	protected String getModelClassName() {
		return AHOrg.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ahOrgPersistence.getDataSource();

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

	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService ahAddrLocalService;
	@BeanReference(type = AHAddrPersistence.class)
	protected AHAddrPersistence ahAddrPersistence;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService ahCategoriesLocalService;
	@BeanReference(type = AHCategoriesPersistence.class)
	protected AHCategoriesPersistence ahCategoriesPersistence;
	@BeanReference(type = AHCategoriesFinder.class)
	protected AHCategoriesFinder ahCategoriesFinder;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService ahCatEntriesLocalService;
	@BeanReference(type = AHCatEntriesPersistence.class)
	protected AHCatEntriesPersistence ahCatEntriesPersistence;
	@BeanReference(type = AHCatEntriesFinder.class)
	protected AHCatEntriesFinder ahCatEntriesFinder;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService ahConfigLocalService;
	@BeanReference(type = AHConfigPersistence.class)
	protected AHConfigPersistence ahConfigPersistence;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService ahContactLocalService;
	@BeanReference(type = AHContactPersistence.class)
	protected AHContactPersistence ahContactPersistence;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService ahOfferLocalService;
	@BeanReference(type = AHOfferPersistence.class)
	protected AHOfferPersistence ahOfferPersistence;
	@BeanReference(type = AHOfferFinder.class)
	protected AHOfferFinder ahOfferFinder;
	@BeanReference(type = AHOrgLocalService.class)
	protected AHOrgLocalService ahOrgLocalService;
	@BeanReference(type = AHOrgPersistence.class)
	protected AHOrgPersistence ahOrgPersistence;
	@BeanReference(type = AHOrgFinder.class)
	protected AHOrgFinder ahOrgFinder;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService ahRegionLocalService;
	@BeanReference(type = AHRegionPersistence.class)
	protected AHRegionPersistence ahRegionPersistence;
	@BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService.class)
	protected de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService ahSubscriptionLocalService;
	@BeanReference(type = AHSubscriptionPersistence.class)
	protected AHSubscriptionPersistence ahSubscriptionPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}