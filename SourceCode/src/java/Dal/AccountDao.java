/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;


import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author ADMIN
 */
public class AccountDao extends DBContext {
    public User GetAccount(String gmail, String pass) {

        String sql = "select * from [dbo].[User] where gmail=? and password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gmail);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User a = new User();
                a.setId(rs.getInt("id"));
                a.setGmail(rs.getString("gmail"));
                a.setPassWord(rs.getString("passWord"));
                a.setFullName(rs.getString("fullName"));
                a.setPhone(rs.getInt("phone"));
                a.setAddress(rs.getString("address"));
                a.setRole(rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        String gmail = "hai@gmail.com";
        String pass = "123";
        AccountDao ad = new AccountDao();
//        ad.SingUp(user, pass);
        User a = ad.GetAccount(gmail, pass);
        System.out.println(a.getFullName());
    }
}
