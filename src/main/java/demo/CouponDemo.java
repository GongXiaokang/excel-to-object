package demo;

import demo.demoUtil.StringUtils;
import util.Excel;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

/**
 * Created by gongthomas on 2018/7/2.
 */
public class CouponDemo {

    public static void main(String[] args){
        try{
            File file = new File("/Users/gongthomas/Desktop/toProcess.xls");
            InputStream inputStream = new FileInputStream(file);
            List<Coupon> couponList = Excel.read(inputStream,Coupon.class);

            File fileName = new File("/Users/gongthomas/Desktop/Process.txt");
            fileName.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for(Coupon coupon:couponList){
                String newCode = getNewCode(coupon);
                String newChinese = getNewChinese(coupon);
                out.write(coupon.getCouponId().toString());
                out.write("#");
                out.write(newCode);
                out.write("#");
                out.write(newChinese);
                out.write("\r\n");
                out.flush();
                System.out.println(newCode);
                System.out.println(newChinese);
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private static String getNewCode(Coupon coupon) {
        String ruleCode = coupon.getValue();
        int index = ruleCode.indexOf("itemBrandIn(");
        String newCode = new String();
        if (index > 0) {
            newCode = ruleCode.substring(0, index);
        }
        newCode = newCode + ruleCode.substring(index, "itemBrandIn(".length()) + coupon.getToAddValue() + "," + ruleCode.substring(index + "itemBrandIn(".length());
        return newCode;
    }

    private static String getNewChinese(Coupon coupon){
        String chinese = coupon.getChinese();
        String newChinese = new String();
        if(isNew(coupon)){
            int index = chinese.indexOf("商品包含品牌 ：");
            if(index>0){
                newChinese = chinese.substring(0,index);
            }
            newChinese = newChinese + chinese.substring(index,"商品包含品牌 ：".length())+ StringUtils.getChineseFromOri(coupon.getToAddChinese())+chinese.substring(index+"商品包含品牌 ：".length());
            return newChinese;
        }else{
            int index = chinese.indexOf("brand");
            newChinese = chinese.substring(0,index);
            newChinese = newChinese+chinese.substring(index,index+8)+StringUtils.getChineseFromOld(coupon.getToAddChinese())+chinese.substring(index+8);
            return newChinese;
        }
    }

    private static boolean isNew(Coupon coupon){
        String ruleString = coupon.getChinese();
        if (ruleString.length() <= 0) {
            return false;
        }
        return ruleString.contains("商品包含品牌 ：");
    }
}
