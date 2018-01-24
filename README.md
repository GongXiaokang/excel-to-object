# excel-to-object
Project to read Object info from Excel. Info from rows to Objects in a single line of code.

For Example, if you have Student class which has three fields: firstName, secondName and age. And the corresponding column in Excel is column0, column1 and column2, and the first row of excel is the head.

Just put the annotation "ExcelClz" ahead the Student with indication of the start row of the excel. 

@ExcelClz(startRow =1)
public class Student{
}

And put the annotation "ExcelField" ahead the field witg indication of the column location.

@ExcelField(index =4)
private String firstName;

index=4 means firstName locates in the 5th the row.


在将excel中的信息读取到对象中时，只需要两个注解：ExcelClz和ExcelField
在ExcelClz中指定信息开始的行，为的是忽略表头；ExcelField中指定属性在excel中所在的列。

例子：
excel表如下
|firstName|secondName|age|
|gong|xiaokang|26|
|zheng|junwei|30|

@ExcelClz(startRow=1)
public class Student{

@ExcelField(index=0)
private String firstName;

@ExcelField(index=1)
private String secondName;

@ExcelField(index=2)
private Integer age;
}

使用：
List<Student> students = Excel.read(inputStream,Student.class)
