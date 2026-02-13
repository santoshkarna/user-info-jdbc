package com.diyo.uij.dao;

import com.diyo.uij.model.User;
import com.diyo.uij.util.DBConnectionUtil;
import com.diyo.uij.util.QueryUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public int insertUser(User user) {
        int saved = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(QueryUtil.INSERT_USER)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getMobileNo());
            ps.setDate(6, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setDouble(7, user.getSalary());
            saved = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return saved;
    }

    @Override
    public int updateUser(User user) {
        int updated = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(QueryUtil.UPDATE_USER)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getMobileNo());
            ps.setDate(6, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setDouble(7, user.getSalary());
            ps.setInt(8, user.getId());
            updated = ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    @Override
    public int deleteUser(int id) {
        int deleted = 0;
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(QueryUtil.DELETE_USER)
        ) {
            ps.setInt(1, id);
            deleted = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    @Override
    public User findUserById(int id) {
        User user = new User();
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(QueryUtil.GET_USER_BY_ID)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setDateOfBirth(new java.sql.Date(rs.getDate("date_of_birth").getTime()));
                user.setSalary(rs.getDouble("salary"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try (
                PreparedStatement ps = DBConnectionUtil.getConnection().prepareStatement(QueryUtil.GET_ALL_USER)
        ) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setDateOfBirth(new java.sql.Date(rs.getDate("date_of_birth").getTime()));
                user.setSalary(rs.getDouble("salary"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
