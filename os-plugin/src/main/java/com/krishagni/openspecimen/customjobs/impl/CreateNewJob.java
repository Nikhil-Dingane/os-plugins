package com.krishagni.openspecimen.customjobs.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.krishagni.catissueplus.core.administrative.domain.ScheduledJobRun;
import com.krishagni.catissueplus.core.administrative.events.SiteDetail;
import com.krishagni.catissueplus.core.administrative.services.ScheduledTask;
import com.krishagni.catissueplus.core.administrative.services.impl.SiteServiceImpl;
import com.krishagni.catissueplus.core.common.events.RequestEvent;

@Configurable
public class CreateNewJob implements ScheduledTask{
	
	@Autowired
	private SiteServiceImpl siteService ;
	
	public SiteServiceImpl getSiteService() {
		return siteService;
	}
	public void setSiteService(SiteServiceImpl siteService) {
		this.siteService = siteService;
	}
	
	private static final Logger logger = Logger.getLogger(CreateNewJob.class);
	@Override	
	public void doJob(ScheduledJobRun arg0) throws Exception {
		logger.info("Your first job run successfully");
		SiteDetail site = new SiteDetail();
		RequestEvent<SiteDetail> siteEvent = new RequestEvent<SiteDetail>();
		
		site.setName("Plugin Testing Site");
		site.setInstituteName("Biobank Institute");
		site.setCode("PTS");
		site.setType("Not Specified");
		site.setCpCount(0);
		site.setAddress("Pune");
		site.setActivityStatus("Active");
		
		siteEvent.setPayload((SiteDetail)site);
		siteService.createSite(siteEvent);
	}
	
}
