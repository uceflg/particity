/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.particity.scheduler;

import java.util.List;

import javax.inject.Inject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_OrganizationController;
import de.particity.model.listener.ModelNotificationRepository;

/**
 * Scheduler for weekly tasks
 */
public class WeeklyScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(WeeklyScheduler.class);

	private static final long	WEEK	 = 1000 * 60 * 60 * 24 * 7;

	@Inject
	private I_OrganizationController orgCtrl;
	
	@Inject
	private I_OfferController offerCtrl;
	
	private void notifyInactiveOrganisations() {
		try {
			final long now = CustomServiceUtils.timeMillis();
			final long minLastUpdate = now - WEEK;
			final long orgSize = orgCtrl.count();
			if (orgSize > 0) {
				List<I_OrganizationModel> orgs;
				I_OfferModel offer;
				for (int i = 0; i < orgSize; i += 5) {
					orgs = orgCtrl.get(i, i + 5);
					for (final I_OrganizationModel org : orgs) {
						offer = offerCtrl
						        .getLastForOrg(org.getId());
						if (offer != null) {
							long updated =CustomServiceUtils.localDateTimeToMillis(offer.getUpdated());
							if (updated < minLastUpdate) {
								ModelNotificationRepository.getInstance()
								        .notifyOutdated(org,
								                now - updated);
							}
						}
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for inactive organisations failed due to "
			                + t.getMessage(), t);
		}
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(final Message message) throws MessageListenerException {
		try {

			this.notifyInactiveOrganisations();

			m_objLog.info("Weekly scheduler update done.");
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Could not exec daily schedule due to: " + t.getMessage(),
			        t);
		}
	}

}