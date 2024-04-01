package com.blog.community.model;

import lombok.Data;


/**
 *封装分页相关信息
 */
@Data
public class Page {
    private Integer currentPage = 1;//当前页码
    private Integer limit = 10;//每页显示数量
    private Integer rows; //数据总数（用户计算总页数）
    private String path; //查询路径（用于复用分页链接）

    public void setLimit(Integer limit) {
        if (limit >= 1 || limit <= 100) {
            this.limit = limit;
        }
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage >= 1) {
            this.currentPage = currentPage;
        }
    }

    public String getPath() {
        return "/index";
    }

//    public Integer getTotal() {
//        return;
//    }
}
