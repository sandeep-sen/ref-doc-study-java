package com.azure.refdoc.study.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Volcano {
    @JsonProperty("Volcano Name")
	private String volcanoName;
    @JsonProperty("Country")
	private String country;
    @JsonProperty("Region")
	private String region;
    @JsonProperty("Location")
	private Location location;
    @JsonProperty("Elevation")
	private Long elevation;
    @JsonProperty("Type")
	private String type;
    @JsonProperty("Status")
	private String status;
    @JsonProperty("Last Known Eruption")
	private String lastKnownEruption;
	private String id;
    @JsonProperty("_rid")
	private String rid;
    @JsonProperty("_self")
	private String self;
    @JsonProperty("_etag")
	private String etag;
    @JsonProperty("_attachments")
	private String attachments;
    @JsonProperty("_ts")
	private Long ts;

	public Volcano(String volcanoName, String country, String region, Location location, Long elevation, String type, String status, String lastKnownEruption, String id, String rid, String self, String etag, String attachments, Long ts) {
		this.volcanoName = volcanoName;
		this.country = country;
		this.region = region;
		this.location = location;
		this.elevation = elevation;
		this.type = type;
		this.status = status;
		this.lastKnownEruption = lastKnownEruption;
		this.id = id;
		this.rid = rid;
		this.self = self;
		this.etag = etag;
		this.attachments = attachments;
		this.ts = ts;
	}

	public String getVolcanoName() {
		return this.volcanoName;
	}

	public String getCountry() {
		return this.country;
	}

	public String getRegion() {
		return this.region;
	}

	public Location getLocation() {
		return this.location;
	}

	public Long getElevation() {
		return this.elevation;
	}

	public String getType() {
		return this.type;
	}

	public String getStatus() {
		return this.status;
	}

	public String getLastKnownEruption() {
		return this.lastKnownEruption;
	}

	public String getId() {
		return this.id;
	}

	public String getRid() {
		return this.rid;
	}

	public String getSelf() {
		return this.self;
	}

	public String getEtag() {
		return this.etag;
	}

	public String getAttachments() {
		return this.attachments;
	}

	public Long getTs() {
		return this.ts;
	}

	public void setVolcanoName(String volcanoName) {
		this.volcanoName = volcanoName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setElevation(Long elevation) {
		this.elevation = elevation;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLastKnownEruption(String lastKnownEruption) {
		this.lastKnownEruption = lastKnownEruption;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
}

