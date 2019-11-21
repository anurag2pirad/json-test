package com.roy.anurag;

public class InterfaceScheduleFlattened {

	private String taskId;
	private String taskName;
	private String pipelineName;
	private String pipelineFolder;
	private String module;
	private long scheduledTime;
	
	public InterfaceScheduleFlattened(String taskId, String taskName, String pipelineName, String pipelineFolder,
			String module, long scheduledTime) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.pipelineName = pipelineName;
		this.pipelineFolder = pipelineFolder;
		this.module = module;
		this.scheduledTime = scheduledTime;
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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public long getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(long scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	@Override
	public String toString() {
		return "InterfaceScheduleFlattened [taskId=" + taskId + ", taskName=" + taskName + ", pipelineName="
				+ pipelineName + ", pipelineFolder=" + pipelineFolder + ", module=" + module + ", scheduledTime="
				+ scheduledTime + "]";
	}
	
}
