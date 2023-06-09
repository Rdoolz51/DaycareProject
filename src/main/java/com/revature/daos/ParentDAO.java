//package com.revature.daos;
//
//import com.revature.models.Parent;
//import com.revature.utils.ConnectionUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class ParentDAO implements ParentDAOInterface {
//    @Override
//    public ArrayList<Parent> getAllParents() {
//        ChildDAO cDao = new ChildDAO();
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            ArrayList<Parent> parents = new ArrayList<>();
//            String sql = "SELECT * FROM parents";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Parent parent = new Parent(
//                        rs.getInt("parent_id"),
//                        rs.getString("parent_fn"),
//                        rs.getString("parent_ln"),
//                        rs.getInt("parent_monthly_dues"),
//                        cDao.getChildById(rs.getInt("child_id")));
//
//                parents.add(parent);
//            }
//            return parents;
//        } catch (SQLException e) {
//            System.out.println("Failed to retrieve Parents");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Parent getParentByChildId(int id) {
//        ChildDAO cDao = new ChildDAO();
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "SELECT * FROM parents WHERE child_id = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                return new Parent(
//                        rs.getInt("parent_id"),
//                        rs.getString("parent_fn"),
//                        rs.getString("parent_ln"),
//                        rs.getInt("parent_monthly_dues"),
//                        cDao.getChildById(rs.getInt("child_id")));
//
//            }
//        } catch (SQLException e) {
//            System.out.println("Failed to retrieve Parent");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public int insertParent(Parent p) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "INSERT INTO parents (parent_fn, parent_ln, parent_credit_card_num, parent_monthly_dues, child_id) VALUES(?,?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, p.getParentFn());
//            ps.setString(2, p.getParentLn());
//            ps.setString(3, p.getDebitCardNum());
//            ps.setFloat(4, p.getMonthlyDues());
//            ps.setInt(5, p.getChild_id_fk());
//            return ps.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("Failed to create Parent");
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean updateParent(String firstName, String lastName, int child_id_fk, int id) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "UPDATE parents SET parent_fn = ?, parent_ln = ?, child_id = ? WHERE parent_id = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, firstName);
//            ps.setString(2, lastName);
//            ps.setInt(3, child_id_fk);
//            ps.setInt(4, id);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Failed to update Parent");
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateParentPayment(int id, String debitCardNum) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "UPDATE parents SET parent_credit_card_num = ? WHERE parent_id = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, debitCardNum);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Failed to update Parent payment info");
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public int deleteChild(int id) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "DELETE FROM parents WHERE parent_id = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            return ps.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("Failed to delete Parent");
//            e.printStackTrace();
//        }
//        return 0;
//    }
//}
