package com.project.springboot;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author dkz
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 * @date 2018年1月25日 下午2:55:14
 */
public class CodeGeneration {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("E:\\code");
        gc.setAuthor("jobob");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/db2?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//	        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.baomidou.ant");
        mpg.setPackageInfo(pc);

        // 自定义配置\kichun
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
//	        List<FileOutConfig> focList = new ArrayList<>();
//	        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//	            @Override
//	            public String outputFile(TableInfo tableInfo) {
//	                // 自定义输入文件名称
//	                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//	                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//	            }
//	        });
//	        cfg.setFileOutConfigList(focList);
//	        mpg.setCfg(cfg);
//	        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
//	        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude("biz_user");
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
//	        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}