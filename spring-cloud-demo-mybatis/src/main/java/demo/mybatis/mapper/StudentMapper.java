package demo.mybatis.mapper;

import demo.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int insertStudent(Student student);

    Student getStudent(String studentNum);
}
