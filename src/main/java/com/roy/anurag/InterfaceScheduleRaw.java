package com.roy.anurag;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InterfaceScheduleRaw {
	
	@JsonProperty("task_id")
	private String taskId;
	@JsonProperty("task_name")
	private String taskName;
	@JsonProperty("trigger_type")
	private String triggerType;
	@JsonProperty("enabled")
	private String enabled;
	@JsonProperty("interfaceID")
	private String interfaceId;
	@JsonProperty("pipe_snode_id")
	private String pipeSnodeId;
	@JsonProperty("task_folder")
	private String taskFolder;
	@JsonProperty("schedule")
	private Schedule schedule;
	@JsonProperty("pipeline_name")
	private String pipelineName;
	@JsonProperty("pipeline_folder")
	private String pipelineFolder;
	
	public class Schedule {
		
		@JsonProperty("start_time")
		private String startTime;
		@JsonProperty("repeat")
		private Repeat repeat;
		@JsonProperty("time_zone")
		private String timeZone;
		@JsonProperty("start_date")
		private String startDate;
		
		public class Repeat {
			
			private On on;
			private Ends ends;
			@JsonProperty("blackout_dates")
			private List<String> blackoutDates;
			private String by;
			private int every;
			private Cron cron;
			
			public class On {
				
				private List<String> day;

				public List<String> getDay() {
					return day;
				}

				public void setDay(List<String> day) {
					this.day = day;
				}

				@Override
				public String toString() {
					return "On [day=" + day + "]";
				}
			}
			
			public class Ends {
				
				private String when;
				private String occurrences;
				
				public String getWhen() {
					return when;
				}
				public void setWhen(String when) {
					this.when = when;
				}
				public String getOccurrences() {
					return occurrences;
				}
				public void setOccurrences(String occurrences) {
					this.occurrences = occurrences;
				}
				@Override
				public String toString() {
					return "Ends [when=" + when + ", occurrences=" + occurrences + "]";
				}
			}
			
			public class Cron {
				
				private String hour;
				private String day;
				private String minute;
				@JsonProperty("day_of_week")
				private String dayOfWeek;
				private String month;
				
				public String getHour() {
					return hour;
				}
				public void setHour(String hour) {
					this.hour = hour;
				}
				public String getDay() {
					return day;
				}
				public void setDay(String day) {
					this.day = day;
				}
				public String getMinute() {
					return minute;
				}
				public void setMinute(String minute) {
					this.minute = minute;
				}
				public String getDayOfWeek() {
					return dayOfWeek;
				}
				public void setDayOfWeek(String dayOfWeek) {
					this.dayOfWeek = dayOfWeek;
				}
				public String getMonth() {
					return month;
				}
				public void setMonth(String month) {
					this.month = month;
				}
				@Override
				public String toString() {
					return "Cron [hour=" + hour + ", day=" + day + ", minute=" + minute + ", dayOfWeek=" + dayOfWeek
							+ ", month=" + month + "]";
				}
				
			}

			public String getBy() {
				return by;
			}

			public void setBy(String by) {
				this.by = by;
			}

			public int getEvery() {
				return every;
			}

			public void setEvery(int every) {
				this.every = every;
			}

			public Cron getCron() {
				return cron;
			}

			public void setCron(Cron cron) {
				this.cron = cron;
			}

			public List<String> getBlackoutDates() {
				return blackoutDates;
			}

			public void setBlackoutDates(List<String> blackoutDates) {
				this.blackoutDates = blackoutDates;
			}

			public On getOn() {
				return on;
			}

			public void setOn(On on) {
				this.on = on;
			}

			public Ends getEnds() {
				return ends;
			}

			public void setEnds(Ends ends) {
				this.ends = ends;
			}

			@Override
			public String toString() {
				return "Repeat [on=" + on + ", ends=" + ends + ", blackoutDates=" + blackoutDates + ", by=" + by
						+ ", every=" + every + ", cron=" + cron + "]";
			}

			
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public Repeat getRepeat() {
			return repeat;
		}

		public void setRepeat(Repeat repeat) {
			this.repeat = repeat;
		}

		public String getTimeZone() {
			return timeZone;
		}

		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		@Override
		public String toString() {
			return "Schedule [startTime=" + startTime + ", repeat=" + repeat + ", timeZone=" + timeZone + ", startDate="
					+ startDate + "]";
		}
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getPipeSnodeId() {
		return pipeSnodeId;
	}

	public void setPipeSnodeId(String pipeSnodeId) {
		this.pipeSnodeId = pipeSnodeId;
	}

	public String getTaskFolder() {
		return taskFolder;
	}

	public void setTaskFolder(String taskFolder) {
		this.taskFolder = taskFolder;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getPipelineName() {
		return pipelineName;
	}

	public void setPipelineName(String pipelineName) {
		this.pipelineName = pipelineName;
	}

	public String getPipelineFolder() {
		return pipelineFolder;
	}

	public void setPipelineFolder(String pipelineFolder) {
		this.pipelineFolder = pipelineFolder;
	}

	@Override
	public String toString() {
		return "InterfaceScheduleRaw [taskId=" + taskId + ", taskName=" + taskName + ", triggerType=" + triggerType
				+ ", enabled=" + enabled + ", interfaceId=" + interfaceId + ", pipeSnodeId=" + pipeSnodeId
				+ ", taskFolder=" + taskFolder + ", schedule=" + schedule + ", pipelineName=" + pipelineName
				+ ", pipelineFolder=" + pipelineFolder + "]";
	}
}
