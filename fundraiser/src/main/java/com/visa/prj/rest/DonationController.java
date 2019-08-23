package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.CashDonation;
import com.visa.prj.entity.Donation;
import com.visa.prj.entity.OnlineDonation;
import com.visa.prj.service.FundService;

@RestController
public class DonationController {

	@Autowired
	private FundService fs;
	
	@PostMapping("donations")
	public ResponseEntity<Donation> addDonation(@RequestBody String s)
	{
		
		System.out.println(s);
		String type = JsonPath.parse(s).read("$.ccCode");
		System.out.println(type);
		if(type != null)
		{
			OnlineDonation d = new OnlineDonation();
			ObjectMapper om = new ObjectMapper();
			Campaign c = new Campaign();
			c.setCid(JsonPath.parse(s).read("$.campaign.cid"));
			d.setCampaign(c);
			d.setAmount(JsonPath.parse(s).read("$.amount"));
			d.setCcCode(JsonPath.parse(s).read("$.ccCode"));
			d.setEmail(JsonPath.parse(s).read("$.email"));
			fs.addDonation(d);
			return new ResponseEntity<Donation>(d, HttpStatus.CREATED);
		}
		
		CashDonation d = new CashDonation();
		return new ResponseEntity<Donation>(d, HttpStatus.CREATED);
	}
	
	@GetMapping("donations")
	public @ResponseBody List<Donation> getDonations()
	{
		return fs.getDonations();
	}
}
