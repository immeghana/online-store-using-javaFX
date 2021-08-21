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
import javax.swing.JFormattedTextField;
public class JFrame2 extends JFrame {
/**
* 
*/
private static final long serialVersionUID = 1L;
private JTextField tf1;
private JTextField tf2;
private JTextField tf3;
private JTextField tf4;
private JTextField tf5;

private JTextField tf6;
private JTextField tf7;
private JTextField tf8;
private int totalcost;
public JFrame2(){
getContentPane().setLayout(null);
JPanel panel = new JPanel();
panel.setBackground(Color.PINK);
panel.setBounds(0, 0, 469, 225);
getContentPane().add(panel);
panel.setLayout(null);
JLabel lblNewLabel_2 = new JLabel(" VEGETABLES:");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_2.setBounds(10, 11, 145, 38);
panel.add(lblNewLabel_2);
JLabel lblNewLabel_2_4 = new JLabel("Item Name:");
lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2_4.setBounds(20, 60, 145, 38);
panel.add(lblNewLabel_2_4);
JLabel lblNewLabel_2_4_1 = new JLabel("Item Price:");
lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));

lblNewLabel_2_4_1.setBounds(20, 120, 145, 38);
panel.add(lblNewLabel_2_4_1);
tf1 = new JTextField();
tf1.setBounds(126, 60, 256, 31);
panel.add(tf1);
tf1.setColumns(10);
tf2 = new JTextField();
tf2.setColumns(10);
tf2.setBounds(126, 127, 256, 31);
panel.add(tf2);
Onlinestore a=new Onlinestore();
JButton btnNewButton = new JButton("Buy item");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";
String b1="";
String b2="";
a1=tf1.getText();
a2=tf2.getText();
try {

 pst = con.prepareStatement("select * from vegetables where item_name= 
?"); 
 pst.setString(1, a1);
 ResultSet r = pst.executeQuery();
 if(r.next()==true)
 {
 tf1.setText(r.getString(1));
 tf2.setText(r.getString(2));
 
 JOptionPane.showMessageDialog(null, "Vegetables added to the cart");
 table_load("select * from cart");
 
 } 
 else
 {
 JOptionPane.showMessageDialog(null, "No Item Found"); 
 }
 
 
 tf7.setText(Onlinestore.name);
totalcost=totalcost+Integer.parseInt(r.getString(2));
tf8.setText(Integer.toString(totalcost));
b1=tf1.getText();
b2=tf2.getText();

 pst = con.prepareStatement("insert into 
cart(item_name,item_price)values(?,?)");
pst.setString(1,b1);
pst.setString(2,b2);
pst.executeUpdate();
table_load("select * from cart");
 tf1.setText("");tf2.setText("");
tf1.requestFocus();
 
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(20, 191, 135, 23);
panel.add(btnNewButton);
JButton btnAddItem = new JButton("Add item");

btnAddItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";
a1=tf1.getText();
a2=tf2.getText();
try {
pst = con.prepareStatement("insert into 
vegetables(item_name,item_price)values(?,?)");
pst.setString(1,a1);
pst.setString(2,a2);
pst.executeUpdate();
JOptionPane.showMessageDialog(null, "Vegetable added to the Store");
table_load("select * from vegetables");
 tf1.setText("");tf2.setText("");
tf1.requestFocus();
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
}
});
btnAddItem.setFont(new Font("Tahoma", Font.BOLD, 16));
btnAddItem.setBounds(169, 191, 135, 23);
panel.add(btnAddItem);

JButton btnShowItem = new JButton("Show items");
btnShowItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
table_load("select * from vegetables");
}
});
btnShowItem.setFont(new Font("Tahoma", Font.BOLD, 16));
btnShowItem.setBounds(324, 193, 135, 23);
panel.add(btnShowItem);
JPanel panel_1 = new JPanel();
panel_1.setBackground(Color.PINK);
panel_1.setBounds(0, 236, 469, 225);
getContentPane().add(panel_1);
panel_1.setLayout(null);
JLabel lblNewLabel_2_1 = new JLabel("FRUITS:");
lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_2_1.setBounds(10, 11, 145, 38);
panel_1.add(lblNewLabel_2_1);

JLabel lblNewLabel_2_4_2 = new JLabel("Item Name:");
lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2_4_2.setBounds(10, 60, 145, 38);
panel_1.add(lblNewLabel_2_4_2);
JLabel lblNewLabel_2_4_3 = new JLabel("Item Price:");
lblNewLabel_2_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2_4_3.setBounds(10, 120, 145, 38);
panel_1.add(lblNewLabel_2_4_3);
tf3 = new JTextField();
tf3.setColumns(10);
tf3.setBounds(123, 60, 256, 31);
panel_1.add(tf3);
tf4 = new JTextField();
tf4.setColumns(10);
tf4.setBounds(123, 126, 256, 31);
panel_1.add(tf4);
JButton btnNewButton_1 = new JButton("Buy item");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";

a1=tf3.getText();
a2=tf4.getText();
try {
 pst = con.prepareStatement("select * from fruits where item_name= ?"); 
 pst.setString(1, a1);
 pst.executeUpdate();
 ResultSet r = pst.executeQuery();
 if(r.next()==true)
 {
 tf3.setText(r.getString(1));
 tf4.setText(r.getString(2));
 
 JOptionPane.showMessageDialog(null, "Fruit added to the cart");
 
 table_load("select * from cart");
 tf3.setText("");tf4.setText("");
tf3.requestFocus();
 
 } 
 else
 {
 tf3.setText("");tf4.setText("");
 JOptionPane.showMessageDialog(null, "No Item Found"); 

 }
 tf7.setText(Onlinestore.name);
totalcost=totalcost+Integer.parseInt(r.getString(2));
tf8.setText(Integer.toString(totalcost));
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_1.setBounds(20, 191, 135, 23);
panel_1.add(btnNewButton_1);
JButton btnAddItem_1 = new JButton("Add item");
btnAddItem_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";
a1=tf3.getText();
a2=tf4.getText();
try {
pst = con.prepareStatement("insert into fruits(item_name,item_price)values(?,?)");

pst.setString(1,a1);
pst.setString(2,a2);
pst.executeUpdate();
JOptionPane.showMessageDialog(null, "Fruit added to the Store");
table_load("select * from fruits");
 tf3.setText("");tf4.setText("");
tf3.requestFocus();
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
}
});
btnAddItem_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnAddItem_1.setBounds(165, 191, 135, 23);
panel_1.add(btnAddItem_1);
JButton btnShowItem_1 = new JButton("Show items");
btnShowItem_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
table_load("select * from fruits");
}
});
btnShowItem_1.setFont(new Font("Tahoma", Font.BOLD, 16));

btnShowItem_1.setBounds(324, 193, 135, 23);
panel_1.add(btnShowItem_1);
JPanel panel_2 = new JPanel();
panel_2.setBackground(Color.PINK);
panel_2.setBounds(0, 475, 469, 225);
getContentPane().add(panel_2);
panel_2.setLayout(null);
JLabel lblNewLabel_2_3 = new JLabel("STATIONARY:");
lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_2_3.setBounds(10, 11, 145, 38);
panel_2.add(lblNewLabel_2_3);
JLabel lblNewLabel_2_4_2_1 = new JLabel("Item Name:");
lblNewLabel_2_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2_4_2_1.setBounds(10, 61, 145, 38);
panel_2.add(lblNewLabel_2_4_2_1);
JLabel lblNewLabel_2_4_2_2 = new JLabel("Item Price:");
lblNewLabel_2_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2_4_2_2.setBounds(10, 120, 145, 38);
panel_2.add(lblNewLabel_2_4_2_2);
tf5 = new JTextField();

tf5.setColumns(10);
tf5.setBounds(123, 68, 256, 31);
panel_2.add(tf5);
tf6 = new JTextField();
tf6.setColumns(10);
tf6.setBounds(123, 127, 256, 31);
panel_2.add(tf6);
JButton btnNewButton_1_1 = new JButton("Buy item");
btnNewButton_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";
a1=tf5.getText();
a2=tf6.getText();
try {
 pst = con.prepareStatement("select * from stationary where item_name= 
?"); 
 pst.setString(1, a1);
 pst.executeUpdate();
 ResultSet r = pst.executeQuery();
 if(r.next()==true)
 {

 tf5.setText(r.getString(1));
 tf6.setText(r.getString(2));
 
 JOptionPane.showMessageDialog(null, "Stationary added to the cart");
 table_load("select * from cart");
 tf5.setText("");tf6.setText("");
tf5.requestFocus();
 
 } 
 else
 {
 tf5.setText("");tf6.setText("");
 JOptionPane.showMessageDialog(null, "No Item Found"); 
 }
 
 tf7.setText(Onlinestore.name);
 
totalcost=totalcost+Integer.parseInt(r.getString(2));
tf8.setText(Integer.toString(totalcost));
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
}

});
btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_1_1.setBounds(20, 191, 135, 23);
panel_2.add(btnNewButton_1_1);
JButton btnAddItem_1_1 = new JButton("Add item");
btnAddItem_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String a1="";
String a2="";
a1=tf5.getText();
a2=tf6.getText();
try {
pst = con.prepareStatement("insert into 
stationary(item_name,item_price)values(?,?)");
pst.setString(1,a1);
pst.setString(2,a2);
pst.executeUpdate();
JOptionPane.showMessageDialog(null, "Stationary added to the Store");
table_load("select * from stationary");
 tf5.setText("");tf6.setText("");
tf5.requestFocus();
 }
catch (SQLException e1) 
 {
e1.printStackTrace();

 }
}
});
btnAddItem_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnAddItem_1_1.setBounds(165, 191, 135, 23);
panel_2.add(btnAddItem_1_1);
JButton btnShowItem_1_1 = new JButton("Show items");
btnShowItem_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
table_load("select * from stationary");
}
});
btnShowItem_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnShowItem_1_1.setBounds(324, 191, 135, 23);
panel_2.add(btnShowItem_1_1);
JLabel lblNewLabel_2_2 = new JLabel("");
lblNewLabel_2_2.setBackground(Color.PINK);
lblNewLabel_2_2.setBounds(0, 475, 469, 225);
getContentPane().add(lblNewLabel_2_2);
JPanel panel_4 = new JPanel();
panel_4.setBackground(Color.PINK);
panel_4.setBounds(479, 475, 794, 225);

getContentPane().add(panel_4);
panel_4.setLayout(null);
JLabel lblNewLabel_2_3_1 = new JLabel("CART:");
lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_2_3_1.setBounds(10, 11, 145, 38);
panel_4.add(lblNewLabel_2_3_1);
JLabel lblNewLabel_3 = new JLabel("Purchaser");
lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel_3.setBounds(20, 67, 94, 14);
panel_4.add(lblNewLabel_3);
tf7 = new JTextField();
tf7.setColumns(10);
tf7.setBounds(158, 62, 256, 31);
panel_4.add(tf7);
JLabel lblNewLabel_3_1 = new JLabel("total bill");
lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel_3_1.setBounds(20, 139, 94, 14);
panel_4.add(lblNewLabel_3_1);
tf8 = new JTextField();
tf8.setColumns(10);

tf8.setBounds(158, 139, 256, 31);
panel_4.add(tf8);
JButton btnNewButton_2 = new JButton("BUY");
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null, "Proceeding to Check Out");
dispose();
JFrame3 j=new JFrame3();
j.setVisible(true);
}
});
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_2.setBounds(586, 63, 89, 23);
panel_4.add(btnNewButton_2);
JButton btnNewButton_2_1 = new JButton("CANCEL");
btnNewButton_2_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null, "Orders have been cancelled");
JOptionPane.showMessageDialog(null, "Returning to Home Page");
dispose();
Onlinestore o=new Onlinestore();
o.setVisible(true);

}
});
btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_2_1.setBounds(575, 102, 120, 23);
panel_4.add(btnNewButton_2_1);
JButton btnNewButton_2_2 = new JButton("EXIT");
btnNewButton_2_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
System.exit(0);
}
});
btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_2_2.setBounds(586, 140, 89, 23);
panel_4.add(btnNewButton_2_2);
JPanel panel_3 = new JPanel();
panel_3.setBackground(Color.PINK);
panel_3.setBounds(479, 0, 794, 461);
getContentPane().add(panel_3);
panel_3.setLayout(null);
JScrollPane scrollPane_1 = new JScrollPane();
scrollPane_1.setBounds(10, 79, 774, 371);

panel_3.add(scrollPane_1);
table = new JTable();
scrollPane_1.setColumnHeaderView(table);
JLabel lblNewLabel_2_5 = new JLabel("Displayer:");
lblNewLabel_2_5.setBounds(10, 25, 145, 38);
lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 18));
panel_3.add(lblNewLabel_2_5);
JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setBackground(Color.PINK);
lblNewLabel_1.setBounds(0, 0, 1283, 700);
getContentPane().add(lblNewLabel_1);
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
 con = 
DriverManager.getConnection("jdbc:mysql://localhost:3307/Onlinestore?autoReco
nnect=true&useSSL=false","root","");
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
public static void main(String[] args) {
JFrame f = new JFrame("A JFrame");
 f.setSize(1339, 771);
 f.setLocation(300,200);
 f.getContentPane().setLayout(null);
 
}
}