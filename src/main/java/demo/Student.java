package demo;

import annotation.ExcelClz;
import annotation.ExcelField;

/**
 * Created by gongthomas on 2018/1/24.
 */
@ExcelClz(startRow = 1)
public class Student {

    @ExcelField(index = 0)
    private String firstName;

    @ExcelField(index = 1)
    private String secondName;

    @ExcelField(index = 2)
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
