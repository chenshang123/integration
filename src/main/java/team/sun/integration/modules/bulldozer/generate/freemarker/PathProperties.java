package team.sun.integration.modules.bulldozer.generate.freemarker;

import freemarker.template.Configuration;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;

public class PathProperties {

    public static final String directory = Objects.requireNonNull(
            GetResource.class.getClassLoader().getResource("generates")).getPath();
    public static final String generatedDirectory = directory + File.separator + "generated";
    // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。

     String packagePath = "team.sun.integration.modules";
     String modelEntityFtlPath = "model.entity.java.ftl";

    public PathProperties(String module){
        packagePath += "."+module;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public String getModelEntityFtlPath() {
        return modelEntityFtlPath;
    }

    public String getOutPath(String fltPath, String className) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generatedDirectory).append(".").append(packagePath).append(".");
        String[] fltPaths =  fltPath.split("\\.");
        String suffix = (fltPaths.length>2) ? fltPaths[fltPaths.length-2] : null;

        if(StringUtils.hasLength(suffix)){
            stringBuilder.append(fltPath.split(suffix)[0]);
            String catalogue = stringBuilder.toString().replaceAll("\\.", Matcher.quoteReplacement(File.separator));
            new File(catalogue).mkdirs();
            stringBuilder = new StringBuilder(catalogue);
            stringBuilder.append(className);
            stringBuilder.append(".");
            stringBuilder.append(suffix);
           return stringBuilder.toString();
        }
        return null;
    }


}
