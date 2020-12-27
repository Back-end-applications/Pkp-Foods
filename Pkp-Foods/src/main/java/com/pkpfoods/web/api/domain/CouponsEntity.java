package com.pkpfoods.web.api.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "coupons")
@Data
public class CouponsEntity {

	@Id
	private String couponCode;

	private String description;

	private double discount;

	private String discountType;

	private Date validFrom;

	private Date validTo;

	public void setValidFrom(String date) {
		final String DATE_FORMAT = "yyyy-MM-dd";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			this.validFrom = sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("CouponsEntity - setValidFrom : Exception in date formatter");
			e.printStackTrace();
		}
	}

	public void setValidTo(String date) {
		final String DATE_FORMAT = "yyyy-MM-dd";
		try {
			this.validTo = new SimpleDateFormat(DATE_FORMAT).parse(date);
		} catch (ParseException e) {
			System.out.println("CouponsEntity - setValidTo : Exception in date formatter");
			e.printStackTrace();
		}
	}

}
