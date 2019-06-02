package com.cheng.btlusermrg.pojo;
import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import com.cheng.beetl.annotation.Auditor;
import com.cheng.beetl.annotation.NowDefault;
import com.cheng.beetl.annotation.UpperCase;

/*
* 
* gen by jack.lin 2019-06-02
*/
public class AuthPermission extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = 3150829306714777420L;

	//PK
    private Long permId ;
        
    //创建者
    @UpdateIgnore
    @Auditor
    private String createBy ;
        
    //最后修改者
    @Auditor
    private String lastModifiedBy ;
        
    //HttpMethod ALL,GET,POST,PUT,DELETE
    private String method ;
        
    //许可编码
    @UpperCase
    private String permCode ;
        
    //许可描述
    private String permDescription ;
        
    //访问URI地址
    private String uri ;
        
    //版本号
    @Version
    private Long version ;
        
    //创建时间
    @UpdateIgnore
    @NowDefault
    private Date createDate ;
        
    //最后修改时间
    @NowDefault
    private Date lastModifiedDate ;
        
    /**
    * PK
    */
    public Long getPermId() {
	    return this.permId;
    }
	
    /**
    * PK
    */
    public void setPermId(Long permId) {
        this.permId = permId;
    }
    
    /**
    * 创建者
    */
    public String getCreateBy() {
	    return this.createBy;
    }
	
    /**
    * 创建者
    */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    /**
    * 最后修改者
    */
    public String getLastModifiedBy() {
	    return this.lastModifiedBy;
    }
	
    /**
    * 最后修改者
    */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    /**
    * HttpMethod ALL,GET,POST,PUT,DELETE
    */
    public String getMethod() {
	    return this.method;
    }
	
    /**
    * HttpMethod ALL,GET,POST,PUT,DELETE
    */
    public void setMethod(String method) {
        this.method = method;
    }
    
    /**
    * 许可编码
    */
    public String getPermCode() {
	    return this.permCode;
    }
	
    /**
    * 许可编码
    */
    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }
    
    /**
    * 许可描述
    */
    public String getPermDescription() {
	    return this.permDescription;
    }
	
    /**
    * 许可描述
    */
    public void setPermDescription(String permDescription) {
        this.permDescription = permDescription;
    }
    
    /**
    * 访问URI地址
    */
    public String getUri() {
	    return this.uri;
    }
	
    /**
    * 访问URI地址
    */
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    /**
    * 版本号
    */
    public Long getVersion() {
	    return this.version;
    }
	
    /**
    * 版本号
    */
    public void setVersion(Long version) {
        this.version = version;
    }
    
    /**
    * 创建时间
    */
    public Date getCreateDate() {
	    return this.createDate;
    }
	
    /**
    * 创建时间
    */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    /**
    * 最后修改时间
    */
    public Date getLastModifiedDate() {
	    return this.lastModifiedDate;
    }
	
    /**
    * 最后修改时间
    */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
}