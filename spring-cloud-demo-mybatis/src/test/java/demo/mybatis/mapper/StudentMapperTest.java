package demo.mybatis.mapper;

import demo.mybatis.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = NONE)
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    @Rollback
    public void test() {
        Student student = new Student();
        student.setStudentNum("1723");
        student.setName("Li Ming");
        student.setAge(16);
        studentMapper.insertStudent(student);

        Student student1 = studentMapper.getStudent(student.getStudentNum());
        Assert.assertEquals(student.getStudentNum(), student1.getStudentNum());
        Assert.assertEquals(student.getName(), student1.getName());
        Assert.assertEquals(student.getAge(), student1.getAge());
    }
}
