/**
 * 
 */
package com.cheng.core.properties.admin;

/**
 * @author jack.lin
 *
 */
public class ChengAdminProperties {

	private ChengAdminDataSourceProperties dataSource = new ChengAdminDataSourceProperties();

	public ChengAdminDataSourceProperties getDataSource() {
		return dataSource;
	}

	public void setDataSource(ChengAdminDataSourceProperties dataSource) {
		this.dataSource = dataSource;
	}
}
