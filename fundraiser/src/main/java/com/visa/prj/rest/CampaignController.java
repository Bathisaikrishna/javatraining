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

import com.visa.prj.entity.Campaign;
import com.visa.prj.service.FundService;

@RestController
public class CampaignController {

	@Autowired
	private FundService fs;
	
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign d)
	{
		fs.addCampaign(d);
		return new ResponseEntity<Campaign>(d, HttpStatus.CREATED);
	}
	
	@GetMapping("campaigns")
	public @ResponseBody List<Campaign> getCampaigns()
	{
		return fs.getCampaigns();
	}
}
