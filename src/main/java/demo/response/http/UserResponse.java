package demo.response.http;

import demo.enums.CheckState;
import demo.pojo.Classroom;
import demo.pojo.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse implements Serializable {
    private String name;
    private Integer age;

    private LocalDate birthDay;

    private LocalDateTime createTime;

    private Classroom classroom;

    private List<Teacher> teachers;

    private CheckState checkState;
}
