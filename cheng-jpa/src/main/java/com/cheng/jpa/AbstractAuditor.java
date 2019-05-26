/**
 * 
 */
package com.cheng.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.jpa.Processor.AuditorPrePesistProcessor;
import com.cheng.jpa.Processor.AuditorPreUpdateProcessor;

/**
 * @author jack.lin
 *
 */
@MappedSuperclass
public abstract class AbstractAuditor {

	public static final String UNKOWN = "UNKOWN";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VERSION", nullable=false)
	private Long version;
	
	@CreatedBy
	@Column(name="CREATE_BY", length=255, nullable=false)
	private String createBy = UNKOWN;
	
	@CreatedBy
	@Column(name="CREATE_BY_CLIENT", length=255, nullable=false)
	private String createByClient = UNKOWN;
	
	@CreatedDate
	@Column(name="CREATE_DATE", nullable=false)
	private Date createDate;
	
	@LastModifiedBy
	@Column(name="LAST_MODIFIED_BY", length=255, nullable=false)
	private String lastModifiedBy = UNKOWN;
	
	@LastModifiedBy
	@Column(name="LAST_MODIFIED_BY_Client", length=255, nullable=false)
	private String lastModifiedByClient = UNKOWN;
	
	@LastModifiedDate
	@Column(name="LAST_MODIFIED_DATE", nullable=false)
	private Date lastModifiedDate;
	
	@PrePersist
	public void prePersist() {
		AuditorPrePesistProcessor processor = SpringContextHolder.getBean(AuditorPrePesistProcessor.class);
		if (null != processor) {
			processor.proceeding(this);
		}
	}
	
	@PreUpdate
	public void preUpdate() {
		AuditorPreUpdateProcessor processor = SpringContextHolder.getBean(AuditorPreUpdateProcessor.class);
		if (null != processor) {
			processor.proceeding(this);
		}
	}
	
	public String[] ignoreProperties(String ... properties) {
		int len = 6;
		
		if (null != properties && properties.length > 0) {
			len += properties.length;
		}
		
		String[] ignoreProperties = new String[len];
		ignoreProperties[0] = "createBy";
		ignoreProperties[1] = "createDate";
		ignoreProperties[2] = "lastModifiedBy";
		ignoreProperties[3] = "lastModifiedDate";
		ignoreProperties[4] = "createByClient";
		ignoreProperties[5] = "lastModifiedByClient";
		
		if (null != properties && properties.length > 0) {
			for (int i = 6; i < len; i++) {
				ignoreProperties[i] = properties[i - 6];
			}
		}
		return ignoreProperties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateByClient() {
		return createByClient;
	}

	public void setCreateByClient(String createByClient) {
		this.createByClient = createByClient;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedByClient() {
		return lastModifiedByClient;
	}

	public void setLastModifiedByClient(String lastModifiedByClient) {
		this.lastModifiedByClient = lastModifiedByClient;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
