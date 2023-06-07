package com.revature.daos;

import com.revature.models.Classroom;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassroomDAO implements ClassroomDAOInterface {

    @Override
    public ArrayList<Classroom> getAllClassrooms() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            ArrayList<Classroom> classrooms = new ArrayList<>();
            String sql = "SELECT * FROM classrooms";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classroom classroom = new Classroom(
                        rs.getInt("class_id"),
                        rs.getString("class_name"),
                        rs.getString("description")
                );
                classrooms.add(classroom);
            }
            return classrooms;

        } catch (SQLException e) {
            System.out.println("Failed to retrieve Classrooms");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Classroom getClassroomById(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM classrooms WHERE class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Classroom(
                        rs.getInt("class_id"),
                        rs.getString("class_name"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve Classrooms");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateClassName(String name, int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE classrooms SET class_name = ? WHERE class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to update Classrooms");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int deleteClassroom(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM classrooms WHERE class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to delete from Classrooms");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertClassroom(Classroom c) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO classrooms (class_name, description) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getClassName());
            ps.setString(2, c.getDescription());
            return ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Failed to insert into Classrooms");
            e.printStackTrace();
        }
        return 0;
    }
}
