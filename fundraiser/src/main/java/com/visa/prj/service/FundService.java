package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.dao.DonationDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;

@Service
public class FundService {

	@Autowired
	private DonationDao donationDao;
	
	@Autowired
	private CampaignDao campaignDao;
	@Transactional
	public int addDonation(Donation d) {
		
//		System.out.println(d.getCampaign().getCid());
		
		Campaign c = campaignDao.findById(d.getCampaign().getCid()).get();
		System.out.println(d.getAmount());
		c.setDonated_amount(c.getDonated_amount()+d.getAmount());
		d.setCampaign(c);
		donationDao.save(d);
		return d.getDid();
		
	}
	
	public Campaign getCampaignByID(int id) {
		return campaignDao.findById(id).get();
	}
	
	public List<Donation> getDonations(){
		return donationDao.findAll();
	}

	@Transactional
	public int addCampaign(Campaign d) {
		campaignDao.save(d);
		return d.getCid();
		
	}

	public List<Campaign> getCampaigns(){
		return campaignDao.findAll();
	}
	
}
