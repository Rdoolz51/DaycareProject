package com.revature.daos;

import com.revature.models.Child;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ChildDAO implements ChildDAOInterface {

    @Override
    public ArrayList<Child> getAllChildren() {
        ClassroomDAO cDao = new ClassroomDAO();
        try (Connection conn = ConnectionUtil.getConnection()) {
            ArrayList<Child> children = new ArrayList<>();
            String sql = "SELECT * FROM children";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Child child = new Child(
                        rs.getInt("child_id"),
                        rs.getString("child_fn"),
                        rs.getString("child_ln"),
                        rs.getDate("child_dob"),
                        cDao.getClassroomById(rs.getInt("class_id")));

                children.add(child);
            }
            return children;

        } catch (SQLException e) {
            System.out.println("Failed to retrieve Children");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Child getChildById(int id) {
        ClassroomDAO cDao = new ClassroomDAO();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM children WHERE child_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Child(
                        rs.getInt("child_id"),
                        rs.getString("child_fn"),
                        rs.getString("child_ln"),
                        rs.getDate("child_dob"),
                        cDao.getClassroomById(rs.getInt("class_id")));
            }

        } catch (SQLException e) {
            System.out.println("Failed to retrieve Child");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertChild(Child c) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO children (child_fn, child_ln, child_dob, class_id) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getChildFn());
            ps.setString(2, c.getChildLn());
            ps.setDate(3, c.getChildDob());
            ps.setInt(4, c.getClass_id_fk());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to insert Child");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteChild(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM children WHERE child_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to delete Child");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateChild(String firstName, String lastName, Date childDob, int class_id_fk, int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE children SET child_fn = ?, child_ln = ?, child_dob = ?, class_id = ? WHERE child_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDate(3, childDob);
            ps.setInt(4, class_id_fk);
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to update Child");
            e.printStackTrace();
        }
        return false;
    }
}
