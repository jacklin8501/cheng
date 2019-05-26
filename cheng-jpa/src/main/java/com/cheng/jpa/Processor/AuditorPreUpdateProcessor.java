/**
 * 
 */
package com.cheng.jpa.Processor;

import com.cheng.jpa.AbstractAuditor;

/**
 * @author jack.lin
 * 修改前，审计程序
 */
public interface AuditorPreUpdateProcessor {

	public void proceeding(AbstractAuditor auditor);
}
