package demo.demoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongthomas on 2018/7/2.
 */
public class StringUtils {

    private static final String seperator ="£»";
    private static final String refer="\"";

    public static List<Long> getIdListFromString(String idString){
        List<Long> idList = new ArrayList<Long>();
        String[] ids = idString.split(",");
        if (ids.length <= 0) {
            return idList;
        }
        for (String id : ids) {
            idList.add(Long.parseLong(id));
        }
        return idList;
    }

    public static String getChineseFromOri(String nameString){
        String[] names = nameString.split(",");
        StringBuilder sb = new StringBuilder();
        for(String s:names){
            sb.append(s).append(seperator);
        }
        return sb.toString();
    }

    public static String getChineseFromOld(String nameString){
       String[] names = nameString.split(",");
       StringBuilder sb = new StringBuilder();
       for(String name:names){
           sb.append(refer+name+refer+seperator);
       }
       return sb.toString();
    }
}
