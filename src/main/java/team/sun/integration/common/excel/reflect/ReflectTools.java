package team.sun.integration.common.excel.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import team.sun.integration.common.excel.annotation.ExcelColumnName;
import team.sun.integration.common.excel.annotation.Show;
import team.sun.integration.common.utils.FileExcel;


@SuppressWarnings({"unused", "unchecked"})
public class ReflectTools {

    public static List<ReflectModel> getModelFields(Object obj, boolean showValue) {
        Class classes = obj.getClass();
        List<ReflectModel> listModel = new ArrayList<ReflectModel>();
        ReflectModel reflect = null;
        String desc = "";
        boolean show = true;
        Field[] fields = classes.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            show = getAnnotation(field.getAnnotation(Show.class));
            desc = getAnnotation(field.getAnnotation(ExcelColumnName.class));
            if (FileExcel.isEmpty(desc)) {
                continue;
            }
            reflect = new ReflectModel();
            reflect.setField(field.getName());
            reflect.setDesc(desc);
            reflect.setType(getAnnotation(field.getType()));
            if (show) {
                reflect.setValue(String.valueOf(GetterFieldOfValue(obj, field.getName())));
            }
            listModel.add(reflect);
        }
        return listModel;
    }

    private static String getAnnotation(ExcelColumnName desc) {
        String key = "";
        if (desc != null) {
            return desc.value();
        }
        return key;
    }

    private static boolean getAnnotation(Show desc) {
        if (desc != null) {
            return desc.value();
        }
        return true;
    }

    private static String getAnnotation(Class desc) {
        if (desc.getTypeName() != null) {
            return desc.getTypeName();
        }
        return "";
    }

    private static Object GetterFieldOfValue(Object obj, String field) {
        Object value = "";
        Class classes = obj.getClass();
        Method[] methods = classes.getDeclaredMethods();

        char[] chars = field.toCharArray();
        chars[0] -= 32;
        for (Method method : methods) {
            if (("get" + new String(chars)).equals(method.getName())) {
                try {
                    value = method.invoke(obj);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;

    }

}
