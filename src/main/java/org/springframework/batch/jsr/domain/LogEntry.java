package org.springframework.batch.jsr.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogEntry {

	private String ipAddress;
	private String requestedUrl;
	private String countryCode;
	private Date viewDate;

	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getViewDate() {
		return viewDate;
	}
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	public String getRequestedUrl() {
		return requestedUrl;
	}
	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		String date = null;
		if(viewDate != null)
			date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss Z", new Locale(Locale.ENGLISH.getLanguage())).format(viewDate);
		String baseString = ipAddress + "|" + requestedUrl + "|" + date;

		if(countryCode != null) {
			baseString = baseString + "|" + countryCode;
		}

		return baseString;
	}
}
