/**
 * 
 */
package com.cheng.jpa.Processor;

import com.cheng.jpa.AbstractAuditor;

/**
 * @author jack.lin
 * 新增前，审计程序
 */
public interface AuditorPrePesistProcessor {

	public void proceeding(AbstractAuditor auditor);
	
}
