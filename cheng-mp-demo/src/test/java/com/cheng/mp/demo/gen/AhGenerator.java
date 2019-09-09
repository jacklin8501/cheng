package com.cheng.mp.demo.gen;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.cheng.mp.demo.AbstractMvcTest;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * AhGenerator
 */
@Slf4j
public class AhGenerator extends AbstractMvcTest {

    @Test
    public void whenGenOk() {
        final String PROJECT_PATH = System.getProperty("user.dir");
        final String SUB_PROJECT = PROJECT_PATH + "/cheng-mp-demo";
        log.info(":: SUB_PROJECT = {}", SUB_PROJECT);
        final String PARENT_PACKAGE = "com.cheng.mp.demo.model";
        final String MODULE_NAME = "admin";
        final String[] TABLES = new String[] {"AH_USER", "AH_ROLE", "AH_PERM"};
        final String SUPER_ENTITY = "com.cheng.mp.demo.model.commons";
        final String[] SUPER_COLUMNS = new String[] {"create_by", "create_date", "last_modified_by", "last_modified_date"};
        final String ENTITY_TEMPLATE = "tpl/entity.java";

        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new BeetlTemplateEngine());

        GlobalConfig gc = new GlobalConfig();
        gc.setBaseResultMap(true);
        gc.setOutputDir(SUB_PROJECT + "/src/main/java");
        gc.setAuthor("jack.lin");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:h2:mem:test");
        // dsc.setSchemaName("public");
        dsc.setDriverName("org.h2.Driver");
        dsc.setUsername("sa");
        // dsc.setPassword("Nn123456!");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setParent(PARENT_PACKAGE);
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        final String templatePath = "/templates/mapper.xml.btl";
        //自定义输出
        List<FileOutConfig> focList = new ArrayList<>();

        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SUB_PROJECT + "/src/main/resources/mapper/" + pc.getModuleName()
                + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        StrategyConfig strategy = new StrategyConfig();
        
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass(SUPER_ENTITY);
        // strategy.setSuperEntityColumns(SUPER_COLUMNS);
        strategy.setEntityLombokModel(true);

        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.demo.common.BaseController");

        strategy.setInclude(TABLES);
        strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        TemplateConfig templateConfig = new TemplateConfig().setEntity(ENTITY_TEMPLATE);
        templateConfig.setXml(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        mpg.execute();
    }    
}