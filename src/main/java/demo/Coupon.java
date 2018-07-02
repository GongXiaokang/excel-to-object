package demo;

import annotation.ExcelClz;
import annotation.ExcelField;

/**
 * Created by gongthomas on 2018/7/2.
 */
@ExcelClz(startRow = 1)
public class Coupon {

    @ExcelField(index = 0)
    private Long couponId;

    @ExcelField(index = 1)
    private String toAddValue;

    @ExcelField(index = 2)
    private String toAddChinese;

    @ExcelField(index = 6)
    private String value;

    @ExcelField(index = 4)
    private String chinese;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getToAddValue() {
        return toAddValue;
    }

    public void setToAddValue(String toAddValue) {
        this.toAddValue = toAddValue;
    }

    public String getToAddChinese() {
        return toAddChinese;
    }

    public void setToAddChinese(String toAddChinese) {
        this.toAddChinese = toAddChinese;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", toAddValue='" + toAddValue + '\'' +
                ", toAddChinese='" + toAddChinese + '\'' +
                ", value='" + value + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
