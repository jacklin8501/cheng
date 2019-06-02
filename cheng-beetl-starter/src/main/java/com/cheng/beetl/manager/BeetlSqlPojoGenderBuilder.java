/**
 * 
 */
package com.cheng.beetl.manager;

import java.util.function.Supplier;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.NameConversion;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;

/**
 * @author jack.lin
 * beetl sql Pojo生成器
 */
public class BeetlSqlPojoGenderBuilder {

	private BeetlSqlPojoGenderBuilder() {}
	
	public static BeetlSqlGenderConfig create() {
		return new BeetlSqlGenderConfig();
	}
	
	public static class BeetlSqlGenderConfig {
		private BeetlSqlGenderConfig() {}
		private String driver;
		private String url;
		private String username;
		private String password;
		
		private DBStyle dbStyle;
		private NameConversion nameConversion = new UnderlinedNameConversion();
		private String sqlPath = "/sql";
		
		private String daoPath;
		private String pojoPath;
		
		public BeetlSqlGenderConfig dataSource(String driver, String url, String username, String password, Supplier<DBStyle> dbStyle) {
			this.driver = driver;
			this.url = url;
			this.username = username;
			this.password = password;
			this.dbStyle = dbStyle.get();
			return this;
		}
		
		public BeetlSqlGenderConfig nameConversion(Supplier<NameConversion> supplier) {
			this.nameConversion = supplier.get();
			return this;
		}
		
		public BeetlSqlGenderConfig sqlPath(String sqlPath) {
			this.sqlPath = sqlPath;
			return this;
		}
		
		public BeetlSqlGenderConfig daoPath(String daoPath) {
			this.daoPath = daoPath;
			return this;
		}
		
		public BeetlSqlGenderConfig pojoPath(String pojoPath) {
			this.pojoPath = pojoPath;
			return this;
		}
		
		public BeetlSqlPojoGender build() {
			BeetlSqlPojoGender gender = new BeetlSqlPojoGender();
			ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, username, password);
			// sql语句放在classpagth的/sql 目录下
			SQLLoader loader = new ClasspathLoader(sqlPath);
			SQLManager sqlManager = new SQLManager(dbStyle,loader,source,nameConversion);
			gender.setSqlManager(sqlManager);
			gender.setDaoPath(daoPath);
			gender.setPojoPath(pojoPath);
			return gender;
		}
	}
	
	public static class BeetlSqlPojoGender {
		private String pojoPath;
		private SQLManager sqlManager;
		private GenConfig config;
		private BeetlSqlPojoGender() {
			config = new GenConfig();
			config.setTemplate(config.getTemplate("btpojo-tpl.btl"));
			config.setBaseClass("org.beetl.sql.core.TailBean");
		}
		
		public void setSqlManager(SQLManager sqlManager) {
			this.sqlManager = sqlManager;
		}
		public void setDaoPath(String daoPath) {
			config.codeGens.add(new MapperCodeGen(daoPath));
		}
		public void setPojoPath(String pojoPath) {
			this.pojoPath = pojoPath;
		}
		
		public void gen(String tablename) throws Exception {
			sqlManager.genPojoCode(tablename, pojoPath, config);
			sqlManager.genSQLFile(tablename, config);
		}
		
		public void genPojoCodeToConsole(String tablename) throws Exception {
			sqlManager.genPojoCodeToConsole(tablename, config);
		}
	}
}
