package com.adarsh.entity;

public class ApiInputesEntity {
	
	private String region;
	private String lang;
	private Boolean includePrePost;
	private String interval;
	private Boolean useYfid;
	private String range;
	private String corsDomain;
	private String tsrc;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Boolean getIncludePrePost() {
		return includePrePost;
	}
	public void setIncludePrePost(Boolean includePrePost) {
		this.includePrePost = includePrePost;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public Boolean getUseYfid() {
		return useYfid;
	}
	public void setUseYfid(Boolean useYfid) {
		this.useYfid = useYfid;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getCorsDomain() {
		return corsDomain;
	}
	public void setCorsDomain(String corsDomain) {
		this.corsDomain = corsDomain;
	}
	public String getTsrc() {
		return tsrc;
	}
	public void setTsrc(String tsrc) {
		this.tsrc = tsrc;
	}
	
}
