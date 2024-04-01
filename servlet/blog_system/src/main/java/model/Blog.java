package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -03 -03
 * Time: 14:51
 */
public class Blog {
    private int blogId;
    private String title;
    private String content;
    private Timestamp updateTime;
    private int UserId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTime;
    }

    public String getUpdateTime() {
        //把时间戳转成格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(updateTime);
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}

