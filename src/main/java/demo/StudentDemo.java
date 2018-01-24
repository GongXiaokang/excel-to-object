package demo;

import util.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by gongthomas on 2018/1/24.
 */
public class StudentDemo {

    public static void main(String[] args){
        try{
            File file = new File("/Users/gongthomas/Desktop/student.xls");
            InputStream inputStream = new FileInputStream(file);
            List<Student> students = Excel.read(inputStream,Student.class);
            for(Student student:students){
                System.out.println(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
