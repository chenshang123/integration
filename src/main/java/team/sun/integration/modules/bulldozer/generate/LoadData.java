package team.sun.integration.modules.bulldozer.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import team.sun.integration.common.base.exception.BusinessException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 生成代码-加载数据
 * </p>
 *
 * @author chens
 * @since 2021-12-17
 */
public class LoadData {

    private final String directory = Objects.requireNonNull(
            GetResource.class.getClassLoader().getResource("generates")).getPath();
    private final String generatedDirectory = directory + File.separator + "generated";
    // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
    Configuration configurationDefault = new Configuration(Configuration.getVersion());

    public LoadData() throws IOException {
        configurationDefault.setDirectoryForTemplateLoading(
                new File(directory + File.separator + "templates"));
        configurationDefault.setDefaultEncoding("utf-8");
    }

    private void ToJavaFtl(Configuration configuration, String fltName, String saveFilename, Map<String, Objects> dataModel, String generatedDirectory) {
        Template template;
        Writer out = null;
        try {
            template = configuration.getTemplate(fltName);
            out = new FileWriter(generatedDirectory + File.separator + saveFilename);
            template.process(dataModel, out);
        } catch (IOException | TemplateException e) {
            throw new BusinessException(e.getMessage());
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void ToJavaFtl(String fltName, String saveFilename, Map<String, Objects> dataModel) {
        ToJavaFtl(configurationDefault, fltName, saveFilename, dataModel, generatedDirectory);
    }

    public void ToJavaFtl(String fltName, String saveFilename, Map<String, Objects> dataModel, String templateDirectory, String generatedDirectory) {
        Configuration configuration = new Configuration(Configuration.getVersion());
        try {
            configuration.setDirectoryForTemplateLoading(
                    new File(templateDirectory));
        } catch (IOException e) {
            throw new BusinessException(e.getMessage());
        }
        configuration.setDefaultEncoding("utf-8");
        ToJavaFtl(configuration, fltName, saveFilename, dataModel, generatedDirectory);
    }

    public static void main(String[] args) {

    }
}
