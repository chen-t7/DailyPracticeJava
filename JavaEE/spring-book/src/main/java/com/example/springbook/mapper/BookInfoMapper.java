package com.example.springbook.mapper;

import com.example.springbook.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("select * from book_info where status!=0 " +
            " order by id limit #{offset},#{pageSize}")
    List<BookInfo> selectBookInfoByLimit(@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);

    @Select("select count(1) from book_info where status!= 0")
    Integer count();

    @Insert("insert into book_info (book_name, author, book_count, publishing_home, price, status) " +
            "values (#{bookName}, #{author}, #{bookCount}, #{publishingHome}, #{price}, #{status})")
    Integer insertBookInfo(BookInfo bookInfo);

    Integer updateBookInfo(BookInfo bookInfo);

    @Select("select * from book_info where id = #{bookId}")
    BookInfo queryBookInfoById(Integer bookId);

    Integer batchDelete(@Param("ids")List<Integer> ids);
}
