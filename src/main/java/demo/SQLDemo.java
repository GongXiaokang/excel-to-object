package demo;

import util.Excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongthomas on 2018/7/2.
 */
public class SQLDemo {

    public static void main(String[] args) {
        try
        {
            File file = new File("/Users/gongthomas/Desktop/toProcess.xls");
            InputStream inputStream = new FileInputStream(file);
            List<Coupon> couponList = Excel.read(inputStream, Coupon.class);
            List<String> sql = new ArrayList<String>();
            for(Coupon coupon:couponList){
                StringBuilder sb = new StringBuilder();
                sb.append("update t_biz_rule tbr left join t_coupon tc on tbr.rule_code = tc.use_rule_code set tbr.rule_value=\"");
                sb.append(coupon.getValue());
                sb.append("\" , tbr.rule_show_value='");
                sb.append(coupon.getChinese());
                sb.append("' where tc.id=");
                sb.append(coupon.getCouponId());
                sb.append(";");
                sql.add(sb.toString());
            }
            File fileName = new File("/Users/gongthomas/Desktop/sqlhahaha.txt");
            fileName.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for(String sq:sql){
                out.write(sq);
                out.write("\r\n");
                out.flush();
            }
            out.close();
        }catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }

}
