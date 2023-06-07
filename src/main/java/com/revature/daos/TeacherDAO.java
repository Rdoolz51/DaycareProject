package com.revature.daos;

import com.revature.models.Teacher;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO implements TeacherDAOInterface {

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ClassroomDAO cDao = new ClassroomDAO();
        try (Connection conn = ConnectionUtil.getConnection()) {
            ArrayList<Teacher> teachers = new ArrayList<>();
            String sql = "SELECT * FROM teachers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt("teacher_id"),
                        rs.getString("teacher_fn"),
                        rs.getString("teacher_ln"),
                        cDao.getClassroomById(rs.getInt("class_id")));

                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            System.out.println("Failed to retrieve Teachers");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher getTeacherById(int id) {
        ClassroomDAO cDao = new ClassroomDAO();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM teachers WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Teacher(
                        rs.getInt("teacher_id"),
                        rs.getString("teacher_fn"),
                        rs.getString("teacher_ln"),
                        cDao.getClassroomById(rs.getInt("class_id")));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve Teacher");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertTeacher(Teacher t) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO teachers (teacher_fn, teacher_ln, class_id) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTeacherFn());
            ps.setString(2, t.getTeacherLn());
            ps.setInt(3, t.getClass_id_fk());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to insert Teachers");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteTeacher(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM teachers WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to retrieve Teachers");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateTeacher(String firstName, String lastName, int class_id_fk, int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE teachers SET teacher_fn = ?, teacher_ln = ?, class_id = ? WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, class_id_fk);
            ps.setInt(4, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to retrieve Teachers");
            e.printStackTrace();
        }
        return false;
    }
}
