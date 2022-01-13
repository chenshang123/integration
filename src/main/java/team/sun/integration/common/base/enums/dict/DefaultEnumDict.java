package team.sun.integration.common.base.enums.dict;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * xiaojunnuo
 * 2018/8/21 0021$
 */

public class DefaultEnumDict implements EnumDict {


    private String name;
    private Integer value;
    private String label;
    private String color;

    public DefaultEnumDict(String name, Integer value, String label) {
        this.name = name;
        this.value = value;
        this.label = label;

        this.color = randomColor(this.name);
    }

    public DefaultEnumDict(EnumDict enumDict) {
        this.name = enumDict.getName();
        this.value = enumDict.getValue();
        this.color = enumDict.getColor();
        this.label = enumDict.getLabel();
    }

    public static List<EnumDict> create(Class clazz) {
        final Logger log = LoggerFactory.getLogger(DefaultEnumDict.class);
        if (!clazz.isEnum()) {
            return null;
        }
        try {
            Method method = clazz.getMethod("values");
            EnumDict[] enums = (EnumDict[]) method.invoke(null);
            List<EnumDict> list = new ArrayList<>(enums.length);
            for (EnumDict item : enums) {
                list.add(new DefaultEnumDict(item));
            }
            return list;
        } catch (Exception e) {
            log.error("枚举类型转化失败:{},{}", e.getMessage(), clazz.getName(), e);
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
