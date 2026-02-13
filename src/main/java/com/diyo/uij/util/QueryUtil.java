package com.diyo.uij.util;

public class QueryUtil {

    public static final String INSERT_USER = """
             insert into user_tbl(name, user_name, password, email, mobile_no, date_of_birth, salary) 
             values (?, ?, ?, ?, ? , ? , ?)
            """;

    public static final String UPDATE_USER = """
            update user_tbl set name=?, user_name=?, password=?, email=?, mobile_no=?, 
            date_of_birth=?, salary=? where id = ?
            """;

    public static final String DELETE_USER = """
            delete from user_tbl where id = ?
            """;

    public static final String GET_USER_BY_ID = """
            select * from user_tbl where id = ?
            """;

    public static final String GET_ALL_USER = """
            select * from user_tbl
            """;

}
