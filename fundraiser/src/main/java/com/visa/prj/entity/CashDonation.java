package com.visa.prj.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cash")
public class CashDonation extends Donation {

}
