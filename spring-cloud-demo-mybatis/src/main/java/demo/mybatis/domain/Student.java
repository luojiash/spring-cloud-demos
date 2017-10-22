package demo.mybatis.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private String studentNum;
    private String name;
    private int age;
    private String interest;
    private Date createTime;
}
