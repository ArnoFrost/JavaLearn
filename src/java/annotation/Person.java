package java.annotation;

import java.annotation.notnull.NotNull;

/**
 * 测试
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2019-06-17 14:02
 */
public class Person {

    @NotNull(fileName = "编号")
    private String id;
    @NotNull(fileName = "姓名")
    private String name;
    @NotNull(fileName = "年龄")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}