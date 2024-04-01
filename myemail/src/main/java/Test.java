/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -18
 * Time: 11:29
 */

public class Test {
    public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        email.setSslSmtpPort("465");
        email.setHostName("smtp.qq.com");
        email.setAuthentication("1611793075@qq.com", "uxnaoewaoneudfjf");
        email.setCharset("UTF-8");
        try{
            email.addTo("1611793075@qq.com");
            email.setFrom("1611793075@qq.com");
            email.setSubject("哈哈哈哈哈哈");
            email.setMsg("hello, 这里有一封邮件请查收");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
