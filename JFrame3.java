package OnlineStore;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.*;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
public class JFrame3 extends JFrame{
/**
* 
*/
private static final long serialVersionUID = 1L;
private JTextField tf1;
private JTextField tf2;
private JTextField tf3;
private JTextField tf4;
public JFrame3() {
getContentPane().setLayout(null);
JPanel panel = new JPanel();
panel.setBackground(new Color(175, 238, 238));
panel.setBounds(0, 0, 1192, 650);
getContentPane().add(panel);
panel.setLayout(null);

JLabel lblNewLabel = new JLabel("Name:");
lblNewLabel.setBounds(228, 146, 95, 64);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblNewLabel);
JLabel lblPhoneNumber = new JLabel("Phone Number:");
lblPhoneNumber.setBounds(228, 238, 154, 64);
lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblPhoneNumber);
JLabel lblAddress = new JLabel("Delivery Address:");
lblAddress.setBounds(228, 349, 188, 64);
lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblAddress);
tf1 = new JTextField();
tf1.setBounds(426, 162, 266, 39);
panel.add(tf1);
tf1.setColumns(10);
tf2 = new JTextField();
tf2.setBounds(426, 254, 266, 39);
tf2.setColumns(10);
panel.add(tf2);

tf3 = new JTextField();
tf3.setBounds(426, 365, 266, 39);
tf3.setColumns(10);
panel.add(tf3);
JLabel lblNewLabel_1 = new JLabel("Confirmation Page");
lblNewLabel_1.setBounds(396, 25, 407, 79);
lblNewLabel_1.setFont(new Font("Zilap Sleep", Font.BOLD, 28));
panel.add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Items Cart:");
lblNewLabel_2.setBounds(818, 116, 136, 33);
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblNewLabel_2);
JButton btnNewButton = new JButton("Confirm Order");
btnNewButton.setBounds(530, 532, 182, 50);
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null, "Proceeding to purchase");
JOptionPane.showMessageDialog(null, "Order Confirmed!");
JOptionPane.showMessageDialog(null, "Thank You for shopping with us!");
dispose();

Onlinestore d=new Onlinestore();
d.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
panel.add(btnNewButton);
JLabel lblNewLabel_3 = new JLabel("Delete Any Item:");
lblNewLabel_3.setBounds(50, 455, 188, 33);
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblNewLabel_3);
JLabel lblNewLabel_4 = new JLabel("Item Name:");
lblNewLabel_4.setBounds(50, 519, 136, 22);
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(lblNewLabel_4);
tf4 = new JTextField();
tf4.setBounds(216, 514, 214, 39);
panel.add(tf4);
tf4.setColumns(10);
Onlinestore a=new Onlinestore();
tf1.setText(Onlinestore.name);

tf2.setText(Onlinestore.phn);
tf3.setText(Onlinestore.Address);
JButton btnNewButton_1 = new JButton("Show Items");
btnNewButton_1.setBounds(50, 579, 154, 33);
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
table_load("select * from cart");
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(btnNewButton_1);
JButton btnNewButton_1_1 = new JButton("Delete Item");
btnNewButton_1_1.setBounds(276, 579, 154, 33);
btnNewButton_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String bid;
bid = tf4.getText();
try {
pst = con.prepareStatement("delete from cart where item_name =?");
 pst.setString(1, bid);

 pst.executeUpdate();
 JOptionPane.showMessageDialog(null, "Item removed from cart");
 table_load("select * from cart");
 tf4.setText("");
 
}
 catch (SQLException e1) {
e1.printStackTrace();
}
}
});
btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(btnNewButton_1_1);
JButton btnNewButton_2 = new JButton("Cancel");
btnNewButton_2.setBounds(928, 601, 113, 38);
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null, "Orders have been cancelled");
JOptionPane.showMessageDialog(null, "Returning to Home Page");
dispose();
Onlinestore o=new Onlinestore();
o.setVisible(true);

}
});
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
panel.add(btnNewButton_2);
JPanel panel_1 = new JPanel();
panel_1.setBounds(768, 162, 414, 336);
panel.add(panel_1);
table = new JTable();
panel_1.add(table);
Connect();
}
Connection con;
PreparedStatement pst;
ResultSet r;
private JTable table;
public void Connect()
 {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Onlinestore?autoReconnect=true&useSSL=false","root","");
 }
 catch (ClassNotFoundException ex) 

 {
 ex.printStackTrace();
 }
 catch (SQLException ex) 
 {
 ex.printStackTrace();
 }
 }
public void table_load(String s_1)
 {
 try 
 {
 pst = con.prepareStatement(s_1);
 r = pst.executeQuery();
 table.setModel(DbUtils.resultSetToTableModel(r));
} 
 catch (SQLException e) 
 {
 e.printStackTrace();
 } 
 }
public static void Main(String[] args) {
JFrame f = new JFrame("A JFrame");
 f.setSize(1339, 771);
 f.setLocation(300,200);

 f.getContentPane().setLayout(null);
}
}
