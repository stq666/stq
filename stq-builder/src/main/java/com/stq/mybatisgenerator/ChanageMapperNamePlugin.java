package com.stq.mybatisgenerator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by newroc on 13-11-24.
 */
public class ChanageMapperNamePlugin extends PluginAdapter {
    private Log log = LogFactory.getLog(ChanageMapperNamePlugin.class);

    @Override
    public void initialized(IntrospectedTable table) {
        super.initialized(table);
        File testfile = new File(".");
        System.out.print("==========当前路径" + testfile.getAbsoluteFile() + "=============");
        String javaMapperType = table.getMyBatis3JavaMapperType();
        String packagename = javaMapperType.substring(0, javaMapperType.lastIndexOf('.'));
        String javaClassName = javaMapperType.substring(javaMapperType.lastIndexOf('.') + 1, javaMapperType.length());
        String genPackagename = packagename + "gen";
        String genJavaClassName = javaClassName + "Gen";
        String genJavaMapperType = genPackagename + "." + genJavaClassName;
        //修改xml 配置信息中的namespace
        table.setMyBatis3FallbackSqlMapNamespace(javaMapperType);
        //讲默认生成的dao修改为带gen字样的包和类
        table.setMyBatis3JavaMapperType(genJavaMapperType);
          /* 创建数据模型 */
        Map root = new HashMap();
        root.put("genJavaMapperType", genJavaMapperType);
        root.put("genJavaClassName", genJavaClassName);
        root.put("packagename", packagename);
        root.put("javaClassName", javaClassName);
        try {
            genDao(table, root);
        } catch (IOException e) {
            log.error(e, e);

        } catch (TemplateException e) {
            log.error(e, e);

        }


    }

    private void genDao(IntrospectedTable introspectedTable, Map root) throws IOException, TemplateException {
        String targetPackage = this.getContext().getJavaClientGeneratorConfiguration().getTargetPackage();
        String targetProject = this.getContext().getJavaClientGeneratorConfiguration().getTargetProject();
        String filePath = targetProject + "/" + targetPackage.replaceAll("\\.", "/") + "/" + root.get("javaClassName") + ".java";
        File file = new File(filePath);
        if (file.exists()) {
            log.warn(file.getAbsoluteFile() + "已经存在,跳过.");
            return;
        }


        /* 在整个应用的生命周期中,这个工作你应该只做一次。 */
        /* 创建和调整配置。 */
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/daoftl");
        cfg.setObjectWrapper(new DefaultObjectWrapper());

          /* 在整个应用的生命周期中,这个工作你可以执行多次 */
         /* 获取或创建模板*/
        Template temp = cfg.getTemplate("dao.ftl");


        FileUtils.touch(file);
        /* 将模板和数据模型合并 */
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        temp.process(root, out);
        out.flush();
        log.info("生成" + file.getAbsoluteFile());
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {

        return super.contextGenerateAdditionalJavaFiles(introspectedTable);
    }
    public boolean validate(List<String> warnings) {
        return true;
    }
}
