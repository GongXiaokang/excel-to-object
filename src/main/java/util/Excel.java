package util;

import annotation.ExcelClz;
import annotation.ExcelField;
import util.ExcelUtil;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gongthomas on 2018/1/23.
 */
public class Excel {

    public static List read(InputStream inputStream,Class clazz) throws Exception{
        String[][] stringContent = ExcelUtil.readExcelToArray(inputStream);
        if(stringContent==null||stringContent.length<1){
            return Collections.emptyList();
        }
        if(!clazz.isAnnotationPresent(ExcelClz.class)){
            return Collections.emptyList();
        }
        ExcelClz excelClz = (ExcelClz) clazz.getAnnotation(ExcelClz.class);
        int startRow = excelClz.startRow();
        if(stringContent.length<startRow){
            return Collections.emptyList();
        }
        List list = new ArrayList();
        for(int i=startRow;i<stringContent.length;i++){
            Object obj = clazz.newInstance();
            String[] row = stringContent[i];
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                field.setAccessible(true);
                if(field.isAnnotationPresent(ExcelField.class)){
                    int index = field.getAnnotation(ExcelField.class).index();
                    if(field.getType().getSimpleName().equals("String")){
                        field.set(obj,row[index]);
                    }else if(field.getType().getSimpleName().equals("Integer")){
                        field.set(obj,Integer.parseInt(row[index]));
                    }else if(field.getType().getSimpleName().equals("Long")){
                        field.set(obj,Long.parseLong(row[index]));
                    }else if(field.getType().getSimpleName().equals("Double")){
                        field.set(obj,Double.parseDouble(row[index]));
                    }else if(field.getType().getSimpleName().equals("Boolean")){
                        field.set(obj,Boolean.parseBoolean(row[index]));
                    }else if(field.getType().getSimpleName().equals("Date")){
                        field.set(obj, Date.valueOf(row[index]));
                    }else{
                        field.set(obj,row[index]);
                    }

                }
            }
            list.add(obj);
        }
        return list;
    }

    //以上的方法，clazz的所有属性都是字符串型，需要进一步修改
}
