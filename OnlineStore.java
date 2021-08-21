package OnlineStore;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class Onlinestore extends JFrame{
/**
* 
*/
private static final long serialVersionUID = 1L;
public Onlinestore() {
}
private static JTextField t3;
private static JTextField t2;
private static JTextField t1;
public static String name;
public static String phn;
public static String Address;
static Connection con;
static PreparedStatement pst;
static ResultSet r;
public static void Connect()
 {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 con =DriverManager.getConnection("jdbc:mysql://localhost:3307/Onlinestore?autoReconnect=true&useSSL=false","root","");
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
 public static void main(String[] args) {
 
 JFrame f = new JFrame("A JFrame");
 f.setSize(1040, 691);
 f.setLocation(300,200);
 f.getContentPane().setLayout(null);
 
 JLabel lblNewLabel = new JLabel("WELCOME TO ONLINE STORE");
 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
 lblNewLabel.setBounds(335, 39, 356, 107);
 f.getContentPane().add(lblNewLabel);

 
 JLabel lblNewLabel_1 = new JLabel("USER ID:");
 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
 lblNewLabel_1.setBounds(335, 214, 96, 57);
 f.getContentPane().add(lblNewLabel_1);
 
 JLabel lblNewLabel_1_1 = new JLabel("Phone Number:");
 lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
 lblNewLabel_1_1.setBounds(335, 287, 169, 57);
 f.getContentPane().add(lblNewLabel_1_1);
 
 JLabel lblNewLabel_1_2 = new JLabel("Delivery Address:");
 lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
 lblNewLabel_1_2.setBounds(333, 375, 171, 57);
 f.getContentPane().add(lblNewLabel_1_2);
 
 t3 = new JTextField();
 t3.setBounds(536, 398, 330, 134);
 f.getContentPane().add(t3);
 t3.setColumns(10);
 
 t2 = new JTextField();
 t2.setBounds(536, 298, 330, 41);
 f.getContentPane().add(t2);
 t2.setColumns(10);
 
 t1 = new JTextField();
 t1.setBounds(536, 225, 330, 41);
 f.getContentPane().add(t1);
 t1.setColumns(10);
 
 JButton btnNewButton = new JButton("SAVE");
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 
 
 
 
 name=t1.getText();
 phn=t2.getText();
 Address=t3.getText();
 
 
 String a1="";
String a2="";
String a3="";
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
try {

pst = con.prepareStatement("insert into user(name,phn_num,del_address)values(?,?,?)");
pst.setString(1,a1);
pst.setString(2,a2);
pst.setString(3, a3);
pst.executeUpdate();
JOptionPane.showMessageDialog(null, "Info stored");
 t1.setText("");t2.setText("");
 t3.setText("");
t1.requestFocus();
JOptionPane.showMessageDialog(null, "Proceeding to items list");
JFrame2 jf=new JFrame2();
 f.dispose();
 jf.setVisible(true);
 }
catch (SQLException e1) 
 {
e1.printStackTrace();
 }
 finally {
 
 }
 
 }
 });

 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
 btnNewButton.setBounds(335, 578, 136, 41);
 f.getContentPane().add(btnNewButton);
 
 JButton btnClear = new JButton("CLEAR");
 btnClear.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 t1.setText("");
 t2.setText("");
 t3.setText("");
 }
 });
 btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
 btnClear.setBounds(536, 578, 136, 41);
 f.getContentPane().add(btnClear);
 
 JButton btnExit = new JButton("EXIT");
 btnExit.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 System.exit(0);
 }
 });
 btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
 btnExit.setBounds(730, 578, 136, 41);
 f.getContentPane().add(btnExit);

 
 JLabel lblNewLabel_2 = new JLabel("*click on save to continue to store*");
 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
 lblNewLabel_2.setBounds(35, 592, 315, 14);
 f.getContentPane().add(lblNewLabel_2);
 JTextArea txtrClear = new JTextArea(10, 40);
 txtrClear.setBounds(0, 0, 1026, 656);
 f.getContentPane().add(txtrClear);
 f.setVisible(true);
 
 Connect();
 
 }
}
