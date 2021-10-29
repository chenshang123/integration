package team.sun.integration.protocol.hex.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析配置文件
 *  Map转换成List
 * @author chens
 */
@Component
public class ProfileConvert {

    /**
     * 字段对应字节长度
     * @return
     * profile index0 报文总长度
     * 格式如下：521（单位：字节）
     * profile index1 字段名称字符串，中间逗号隔开
     * 格式如下：字段1，字段2，...
     * profile index2 字段长度字符串，中间逗号隔开
     * 格式如下：长度1，长度2，...
     * profile index3 下标大于等于3的字符串，为需要出的对象集合，中间逗号隔开；
     * 格式如下： 字段1，字段2，...，处理类型，对象名称
     */
    @NotNull
    public static List<String> getFieldAndLength(List<String> profile) {
        List<String> forField = new ArrayList<>();
        List<String> result = new ArrayList<>();

        StringBuilder bytes = new StringBuilder();
        StringBuilder names = new StringBuilder();
        StringBuilder forBytePara = new StringBuilder();
        StringBuilder forNamePara = new StringBuilder();
        int count = 0;
        int forcount = 0;

        if (null != profile && profile.size() > 0) {
            for (String s : profile) {
                if (null != s) {
                    String[] data = s.split("_");

                    if (s.contains("for")) {
                        forBytePara.append(",").append(data[0]);
                        forNamePara.append(",").append(data[1]).append(1);
                        forcount += Integer.parseInt(data[0]);
                    } else if (data.length == 2) {
                        count += Integer.parseInt(data[0]);
                        bytes.append(",").append(data[0]);
                        names.append(",").append(data[1]);
                    }

                    if (s.contains("for_end")) {
                        String nameStr = forNamePara.toString();
                        forField.add(nameStr
                                .replaceFirst(",", "")
                                .replaceAll("1", "")
                                + ",for_" + data[4] + "," + data[5]);
                        for (int j = 1; j < Integer.parseInt(data[4]) + 1; j++) {
                            names.append(nameStr.replaceAll("1", "" + j));
                            bytes.append(forBytePara);
                            count += forcount;
                        }
                        forBytePara = new StringBuilder();
                        forNamePara = new StringBuilder();
                        forcount = 0;
                    }
                }
            }
        }
        result.add(String.valueOf(count));
        result.add(names.toString().replaceFirst(",", ""));
        result.add(bytes.toString().replaceFirst(",", ""));
        if(forField.size()>0)result.addAll(forField);
        return result;
    }


}
