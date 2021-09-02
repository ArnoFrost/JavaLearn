package java.orm;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 11:44
 * @Version 1.0
 */
@MyTable(tableName = "user_info")
public class User {

    @MyColumn(columnValue = "id")
    private Integer id;
    @MyColumn(columnValue = "userName")
    private String userName;
    @MyColumn(columnValue = "age")
    private Integer age;
    @MyColumn(columnValue = "address")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
