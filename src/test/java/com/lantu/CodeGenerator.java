package com.lantu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///x_db";
        String username = "root";
        String password = "1234";
        String moduleName = "codesim";//模块名 可进行修改
        String mapperLocation = "C:\\x-admin-project-master\\x-admin-project-master\\x-admin\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "x_code_feature"; //要生成代码的数据库中的表名
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("jianghao") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\x-admin-project-master\\x-admin-project-master\\x-admin\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lantu") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("x_"); // 设置过滤表前缀 可以过滤掉表的前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
