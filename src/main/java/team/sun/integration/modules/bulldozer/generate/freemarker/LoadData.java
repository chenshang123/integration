package team.sun.integration.modules.bulldozer.generate.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import team.sun.integration.common.base.exception.BusinessException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <p>
 * 生成代码-加载数据
 * </p>
 *
 * @author chens
 * @since 2021-12-17
 */
public class LoadData {

    // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
    Configuration configurationDefault = new Configuration(Configuration.getVersion());

    public LoadData() throws IOException {
        configurationDefault.setDirectoryForTemplateLoading(
                new File(PathProperties.directory + File.separator + "templates"));
        configurationDefault.setDefaultEncoding("utf-8");
    }

    private void ToJavaFtl(Configuration configuration, String fltName, String saveFilename, Object dataModel) {
        Template template;
        Writer out = null;
        try {
            template = configuration.getTemplate(fltName);
            new File(saveFilename).createNewFile();
            out = new FileWriter(saveFilename);
            template.process(dataModel, out);
        } catch (IOException | TemplateException e) {
            throw new BusinessException(e.getMessage());
        } finally {
            try {
                if(out != null)
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ToJavaFtl(String fltName, String saveFilename, Object dataModel) {
        ToJavaFtl(configurationDefault, fltName, saveFilename, dataModel);
    }

    public void ToJavaFtl(String fltName, String saveFilename, Object dataModel, String templateDirectory) {
        Configuration configuration = new Configuration(Configuration.getVersion());
        try {
            configuration.setDirectoryForTemplateLoading(
                    new File(templateDirectory));
        } catch (IOException e) {
            throw new BusinessException(e.getMessage());
        }
        configuration.setDefaultEncoding("utf-8");
        ToJavaFtl(configuration, fltName, saveFilename, dataModel);
    }

}
