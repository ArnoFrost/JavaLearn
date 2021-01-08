package orm;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 11:46
 * @Version 1.0
 */
public class OrmTest {
    public static void main(String[] args) {
        String querySql = queryUser(getUser());
        System.out.println(querySql);
    }

    public static User getUser() {
        Random random = new Random();
        User user = new User();
        user.setId(random.nextInt());
        user.setAddress("asdjlasdaskl");
        user.setUserName("Arno");
        user.setAge(random.nextInt());

        return user;
    }

    public static String queryUser(@NotNull User user) {
        String SQL_MODEL = "select %s from %s where %s";

        Class c = user.getClass();

        //是否有MyTable注解
        boolean b = c.isAnnotationPresent(MyTable.class);
        if (!b) {
            return "没有表名";
        }

        //获取表名
        MyTable mytable = (MyTable) c.getAnnotation(MyTable.class);
        String tableName = mytable.tableName();
        System.out.println("table Name = " + tableName);

        //获取所有字段
        StringBuilder sbField = new StringBuilder();
        StringBuilder sbWhere = new StringBuilder();

        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            boolean has = field.isAnnotationPresent(MyColumn.class);
            if (!has) {
                return "成员没有生命字段名";
            }
            //拼接字段
            MyColumn myColumn = field.getAnnotation(MyColumn.class);
            String columnName = myColumn.columnValue();
            sbField.append(columnName).append(",");

            String getMethodName = "get" + field.getName().substring(0, 1)
                    .toUpperCase() + field.getName().substring(1);

            try {
                Method getMethod = c.getMethod(getMethodName);
                Object getValue = getMethod.invoke(user);
                System.out.println("columnName = " + columnName + ",value = " + getValue);

                //排出Int
                if (getValue == null || (getValue instanceof Integer && (Integer) getValue == 0)) {
                    continue;
                }

                //第一个不需要and
                if (i == 0) {
                    sbWhere.append(columnName);
                } else {
                    sbWhere.append(" and ").append(columnName);
                }

                if (getValue instanceof String) {
                    //in 查询
                    if (((String) getValue).contains(",")) {
                        String[] strings = ((String) getValue).split(",");
                        sbWhere.append(" in(");
                        for (String str : strings) {
                            sbWhere.append("'").append(str).append("',");
                        }
                        //删除最后一个逗号
                        sbWhere.deleteCharAt(sbWhere.length() - 1);
                        sbWhere.append(")");
                    } else {
                        //普通查询
                        sbWhere.append("=").append("'").append(getValue).append("'");
                    }
                } else if (getValue instanceof Integer) {
                    sbWhere.append("=").append(getValue);
                }


            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        //拼接完整sql输出
        String sql = String.format(SQL_MODEL, sbField.deleteCharAt(sbField.length() - 1),
                tableName, sbWhere);
        return sql;

    }


}
