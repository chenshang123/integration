package team.sun.integration.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import team.sun.integration.common.exception.BusinessException;
import team.sun.integration.common.excel.reflect.ReflectModel;
import team.sun.integration.common.excel.reflect.ReflectTools;
import org.apache.commons.lang3.StringUtils;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FileExcel<T> {

    protected T entityClass;

    public static boolean isEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public T getEntityClass() {
        return entityClass;
    }

    public void writeExcel(List<T> data, String sheetName, OutputStream os) throws Exception {
        try {
            WorkbookSettings ws = new WorkbookSettings();
            WritableWorkbook workbook = Workbook.createWorkbook(os, ws);
            writeExcel(workbook, data, sheetName);
            if (os != null) {
                os.flush();
            }
        } catch (IOException e1) {
            throw new BusinessException("导出失败");
        }
    }

    public void writeExcel(List<T> data, String sheetName, File file) throws Exception {
        try {
            WorkbookSettings ws = new WorkbookSettings();
            WritableWorkbook workbook = Workbook.createWorkbook(file, ws);
            writeExcel(workbook, data, sheetName);
        } catch (IOException e1) {
            throw new BusinessException("导出失败");
        }
    }

    public WritableCellFormat getWritableCellFormat() {
        WritableFont font1 = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);

        WritableCellFormat cellFormat1 = new WritableCellFormat(font1);
        try {
            //设置背景色
            cellFormat1.setBackground(Colour.GRAY_25);
            //设置边框,dashed虚线，dash_dot实线，dotted虚线,double双实线
            cellFormat1.setBorder(Border.ALL, BorderLineStyle.DASH_DOT);
            //设置边框颜色
            cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            //设置自换行
            cellFormat1.setWrap(true);
            //设置文字居中对齐方式
            cellFormat1.setAlignment(Alignment.CENTRE);
            //设置垂直居中
            cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellFormat1;
    }

    private void writeExcel(WritableWorkbook workbook, List<T> data, String sheetName) throws Exception {
        if (data == null || data.size() < 1) {
            throw new BusinessException("导出数据不能为空");
        }
        WritableSheet s1 = workbook.createSheet(sheetName, 0);
        s1.getSettings().setDefaultColumnWidth(18);
        ReflectModel reflectModel = null;
        WritableCell text = null;
        Number number = null;
        List<ReflectModel> reflectModels = new ArrayList<ReflectModel>();

        reflectModels = ReflectTools.getModelFields(data.get(0), false);
        WritableCellFormat format = getWritableCellFormat();
        SimpleDateFormat formatDateUs = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < reflectModels.size(); i++) {
            reflectModel = reflectModels.get(i);
            s1.addCell(new Label(i, 0, reflectModel.getDesc(), format));
        }
        String dataString = "";
        for (int j = 1; j <= data.size(); j++) {
            reflectModels = ReflectTools.getModelFields(data.get(j - 1), true);
            for (int i = 0; i < reflectModels.size(); i++) {
                reflectModel = reflectModels.get(i);
                if (reflectModel.getType().equals("java.lang.String")) {
                    if (!reflectModel.getValue().equals("null")) {
                        text = new Label(i, j, String.valueOf(reflectModel.getValue()));
                    } else {
                        text = new Label(i, j, "");
                    }
                    s1.addCell(text);
                } else if (reflectModel.getType().equals("java.util.Date")) {
                    dataString = String.valueOf(reflectModel.getValue());
                    if (StringUtils.isNotBlank(dataString) && !dataString.equals("null")) {
                        text = new Label(i, j, formatDate.format(formatDateUs.parse(dataString)));
                    } else {
                        text = new Label(i, j, "");
                    }
                    s1.addCell(text);
                } else {
                    try {
                        number = new Number(i, j, Double.parseDouble(String.valueOf(reflectModel.getValue())));
                        s1.addCell(number);
                    } catch (Exception e) {
                        text = new Label(i, j, String.valueOf(reflectModel.getValue()));
                        s1.addCell(text);
                    }
                }
            }
        }
        workbook.write();
        workbook.close();
    }

    public boolean isChinese(String key) {
        if (isEmpty(key)) {
            return true;
        }
        Matcher zhongwen = Pattern.compile("[\u4e00-\u9fa5]").matcher(key);
        return zhongwen.find();
    }
}

