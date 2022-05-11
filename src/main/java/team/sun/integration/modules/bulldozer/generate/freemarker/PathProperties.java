package team.sun.integration.modules.bulldozer.generate.freemarker;

import java.io.File;
import java.util.regex.Matcher;

public class PathProperties {
    static final String packagePath = "team.sun.integration.modules.sys";
    static final String modelEntityFtlPath = "model.entity.java.ftl";
    static final String modelEntityOutPath = (packagePath+"model.entity").replaceAll("\\.", Matcher.quoteReplacement(File.separator));


    public static String getPackagePath() {
        return packagePath;
    }

    public static String getModelEntityFtlPath() {
        return modelEntityFtlPath;
    }

    public static String getModelEntityOutPath() {
        return modelEntityOutPath;
    }
}
