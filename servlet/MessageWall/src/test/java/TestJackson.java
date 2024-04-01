import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -02 -29
 * Time: 19:32
 */
class Student {
    public String classId;
    public String studentId;
}

public class TestJackson {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
       //readValue是吧json格式的字符串转成java对象
//       String s = "{ \"classId\":10, \"studentId\":20}";
//       //readValue第一个参数可以直接写一个String，也可以写个InputStream
//       Student student = objectMapper.readValue(s, Student.class);
//        System.out.println(student.classId);
//        System.out.println(student.studentId);

        //writeValue /writeValueAsString是把java对象转成json字符串
        Student student = new Student();
        student.classId = "10";
        student.studentId = "20";
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }
}
