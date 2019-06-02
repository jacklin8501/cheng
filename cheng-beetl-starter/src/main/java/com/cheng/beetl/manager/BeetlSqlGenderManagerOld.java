/**
 * 
 */
package com.cheng.beetl.manager;

import javax.sql.DataSource;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;

import com.cheng.beetl.gender.BeetlSqlGender;
import com.cheng.core.holder.SpringContextHolder;

/**
 * @author jack.lin
 * 代码sql管理器，用于生成
 */
public class BeetlSqlGenderManagerOld {

	private String tablename;
	private String daoPackage;
	private String pojoPackage;
	private SQLManager sqlManager = SpringContextHolder.getBean(SQLManager.class);
	
	private BeetlSqlGenderManagerOld(){}
	
	/**
	 * @param tablename 表明
	 * @return
	 */
	public BeetlSqlGenderManagerOld table(String tablename) {
		this.tablename = tablename;
		return this;
	}
	
	/**
	 * @param daoPackage dao 包名
	 * @return
	 */
	public BeetlSqlGenderManagerOld daoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
		return this;
	}
	
	/**
	 * @param pojoPackage pojo包名
	 * @return
	 */
	public BeetlSqlGenderManagerOld pojoPackage(String pojoPackage) {
		this.pojoPackage = pojoPackage;
		return this;
	}
	
	/**
	 * 执行代码,md文件生成
	 * @throws Exception
	 */
	public void genPojoCodeSqlFile() throws Exception {
		BeetlSqlGender gender = () -> {
			GenConfig config = new GenConfig();
			config.codeGens.add(new MapperCodeGen(daoPackage));
			sqlManager.genPojoCode(tablename, pojoPackage, config);
			sqlManager.genSQLFile(tablename, config);
		};
		gender.gen();
	}
	
	/**
	 * 生成Pojo文件
	 * @throws Exception
	 */
	public void genPojoCode() throws Exception {
		BeetlSqlGender gender = () -> {
			sqlManager.genPojoCode(tablename, pojoPackage);
		};
		gender.gen();
	}
	
	/**
	 * 生成md文件
	 * @throws Exception
	 */
	public void genSqlFile() throws Exception {
		BeetlSqlGender gender = () -> {
			sqlManager.genSQLFile(tablename, new GenConfig());
		};
		gender.gen();
	}
	
	/**
	 * 显示pojo到控制台
	 * @throws Exception
	 */
	public void genPojoCodeToConsole() throws Exception {
		BeetlSqlGender gender = () -> {
			sqlManager.genPojoCodeToConsole(tablename);
		};
		gender.gen();
	}
	
	/**
	 * 显示md文件到控制台
	 * @throws Exception
	 */
	public void genSqlFileToConsole() throws Exception {
		BeetlSqlGender gender = () -> {
			sqlManager.genSQLTemplateToConsole(tablename);
		};
		gender.gen();
	}
	
	/**
	 * 创建一个BeetlSqlGenderManager
	 * @return
	 */
	public static BeetlSqlGenderManagerOld create() {
		return new BeetlSqlGenderManagerOld();
	}
}
