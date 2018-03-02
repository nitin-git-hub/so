package org.openecomp.mso.requestsdb;

import java.io.Serializable;
import java.sql.Timestamp;

public class OperationalEnvDistributionStatus implements Serializable {

	/**
	 * Serialization id.
	 */
	private static final long serialVersionUID = 7398393659281364650L;

	private String distributionId;
	private String operationalEnvId;
	private String serviceModelVersionId;
	private String requestId;
	private String distributionIdStatus;
	private String distributionIdErrorReason;
	private Timestamp createTime;
	private Timestamp modifyTime;
	
	public String getDistributionId() {
		return distributionId;
	}
	
	public void setDistributionId(String distributionId) {
		this.distributionId = distributionId;
	}
	
	public String getOperationalEnvId() {
		return operationalEnvId;
	}
	
	public void setOperationalEnvId(String operationalEnvId) {
		this.operationalEnvId = operationalEnvId;
	}
	
	public String getServiceModelVersionId() {
		return serviceModelVersionId;
	}
	
	public void setServiceModelVersionId(String serviceModelVersionId) {
		this.serviceModelVersionId = serviceModelVersionId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	public String getDistributionIdStatus() {
		return distributionIdStatus;
	}
	
	public void setDistributionIdStatus(String distributionIdStatus) {
		this.distributionIdStatus = distributionIdStatus;
	}
	
	public String getDistributionIdErrorReason() {
		return distributionIdErrorReason;
	}

	public void setDistributionIdErrorReason(String distributionIdErrorReason) {
		this.distributionIdErrorReason = distributionIdErrorReason;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
