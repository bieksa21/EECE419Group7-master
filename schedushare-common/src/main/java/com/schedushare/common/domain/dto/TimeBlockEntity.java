package com.schedushare.common.domain.dto;

import java.sql.Time;

import com.google.gson.annotations.SerializedName;

/**
 * Time block {@link RestEntity} passed between client and server as a JSON representation.
 * 
 * Simple user pojo that is structured to be serialized by JOOQ and automatically mapped.
 * Did not like the DTO generated by JOOQ so we chose to make our own.
 */
public class TimeBlockEntity extends RestEntity {

	public static final String TIME_BLOCK_ID = "time-block-id";
	public static final String START_TIME = "start-time";
	public static final String END_TIME = "end-time";
	public static final String DAY = "day";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String SCHEDULE_ID = "schedule-id";
	public static final String TIME_BLOCK_NAME = "time-block-name";
	public static final String TIME_BLOCK_TYPE  = "time-block-type";
	
	@SerializedName(TIME_BLOCK_ID)
	private final int timeBlockId;
	
	
	@SerializedName(START_TIME)
	private String startTime;
	
	
	@SerializedName(END_TIME)
	private String endTime;
	
	@SerializedName(DAY)
	private final String day;
	
	@SerializedName(LATITUDE)
	private final Double latitude;

	@SerializedName(LONGITUDE)
	private final Double longitude;
	
	@SerializedName(SCHEDULE_ID)
	private final int scheduleId;
	
	@SerializedName(TIME_BLOCK_NAME)
	private final String timeBlockName;
	
	@SerializedName(TIME_BLOCK_TYPE)
	private final String timeBlockType;
	
	private Time t_startTime;
	
	private Time t_endTime;
	
	/**
	 * SQL Constructor.
	 *
	 * @param ID the id
	 * @param START_TIME the start time
	 * @param END_TIME the end time
	 * @param DAY the day
	 * @param LATITUDE the latitude
	 * @param LONGITUDE the longitude
	 * @param SCHEDULE_ID the schedule id
	 * @param NAME the name
	 * @param TYPE the typegetStartTime
	 */
	public TimeBlockEntity(final int ID, final Time START_TIME, final Time END_TIME, final String DAY, final String NAME, final String TYPE, 
			final Double LATITUDE, final Double LONGITUDE, final int SCHEDULE_ID) {
		this.timeBlockId = ID;
		this.t_startTime = START_TIME;
		this.t_endTime = END_TIME;
		this.day = DAY;
		this.latitude = LATITUDE;
		this.longitude = LONGITUDE;
		this.scheduleId = SCHEDULE_ID;
		this.timeBlockName = NAME;
		this.timeBlockType = TYPE;
	}
	
	/**
	 * JSON Constructor.
	 *
	 * @param id the id
	 * @param STARTTIME the starttime
	 * @param endTime the end time
	 * @param day the day
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param SCHEDULE_ID the schedule id
	 * @param name the name
	 * @param type the type
	 */
	public TimeBlockEntity(final int id, final String startTime, final String endTime, final String day, 
			final String name, final String type, final Double latitude, final Double longitude, final int SCHEDULE_ID) {
		this.timeBlockId = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
		this.latitude = latitude;
		this.longitude = longitude;
		this.scheduleId = SCHEDULE_ID;
		this.timeBlockName = name;
		this.timeBlockType = type;
	}

	public String getStartTime() {
		if (t_startTime != null) {
			return t_startTime.toString();
		} 
		return startTime;
	}


	public String getEndTime() {
		if (t_endTime != null) {
			return t_endTime.toString();
		}
		return endTime;
	}


	public String getDay() {
		return day;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public int getTimeBlockId() {
		return timeBlockId;
	}

	public Time getT_startTime() {
		return t_startTime;
	}
	
	public Time getT_endTime() {
		return t_endTime;
	}
	
	public int getScheduleId() {
		return this.scheduleId;
	}
	
	public String getTimeBlockName() {
		return this.timeBlockName;
	}
	
	public String getTimeBlockType() {
		return this.timeBlockType;
	}
}
