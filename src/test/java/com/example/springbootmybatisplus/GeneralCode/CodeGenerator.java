package com.example.springbootmybatisplus.GeneralCode;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhan
 * @since 2020-03-30
 */
public class CodeGenerator {

    //输出路径
    private static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/main/java";

    //作者
    private static final String AUTHOR = "ZongjieWu";

    //数据源
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gm_springboot_layui?allowMultiQueries=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";

    //驱动名称
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    //账号
    private static final String USERNAME = "root";

    //密码
    private static final String PASSWORD = "123456";

    //根路径
    private static final String PARENT = "com.example.springbootmybatisplus";

    //controller
    private static final String CONTROLLER = "controller";

    //service
    private static final String SERVICE = "service";

    //service.impl
    private static final String SERVICE_IMPL = "service.impl";

    //model
    private static final String ENTITY = "model";

    //mapper
    private static final String MAPPER = "mapper";

    //xml
    private static final String TEMPLATE_PATH = "/templates/mapper.xml.vm";

    //表名称
    private static String getTableName() {
        return "s_saas_user_role_permission";
    }

    //模块名称
    private static String getModuleName() {
        return "";
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOutputDir(OUTPUT_DIR);
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(getModuleName());
        packageConfig.setParent(PARENT);
        packageConfig.setController(CONTROLLER);
        packageConfig.setService(SERVICE);
        packageConfig.setServiceImpl(SERVICE_IMPL);
        packageConfig.setEntity(ENTITY);
        packageConfig.setMapper(MAPPER);
        autoGenerator.setPackageInfo(packageConfig);

        //模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setInclude(getTableName());
        strategyConfig.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategyConfig);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        //自定义输出配置
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        fileOutConfigList.add(new FileOutConfig(TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" + packageConfig.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);
        autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
        autoGenerator.execute();
    }

}

