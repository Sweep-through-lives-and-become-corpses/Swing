/**
 * 选修课程管理系统 广东石油化工学院 计算机07-1班
 *
 *
 * @version 1.2.3
 * @data 03/24/2010
 * @last update 06/02/2011
 *
 * <p>
 * ┏┓         　 ┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃
 * 　　┃　　　┃
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * 本程序可以由任何人自由发表、修改、传播，请保留此注视，谢谢！
 */
package com.chenluozhi.frame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import com.chenluozhi.dao.UserDao;
import com.chenluozhi.util.DBConnection;


import javax.swing.JComboBox;


public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JButton jButton21 = null;
    private JButton jButton22 = null;
    private JTextField jTextField = null;
    private JPasswordField jPasswordField = null;
    private JLabel jLabel = null;
    static int storeUserId;// 登录用户名
    public static String storeUserName = null;// 登录用户名
    public static String storeUserPassword = null;// 登录密码
    static boolean RELOAD = true;// 重新登陆标记
    static int login_user_type;//0表示管理员，1表示老师，2表示学生
    private JLabel jLabel_User = null;
    private JLabel jLabel_userName = null;
    private JLabel jLabel_password = null;
    private JLabel jLabel_privilege = null;
//    private URL imgURL = null;


    private BtnListener btl = null;
    private JComboBox jComboBox = null;
    private JLabel jLabel_tips = null;
    private JLabel jLabel_title = null;
    private JLabel jLabel_welcome = null;

    private void initialize() {

        jLabel_welcome = new JLabel();
        jLabel_welcome.setBounds(new Rectangle(90, 30, 415, 70));
        jLabel_welcome.setText("欢迎登陆");
        Font font6 = new Font("宋体", Font.PLAIN, 60);
        jLabel_welcome.setFont(font6);

        jLabel_title = new JLabel();
        jLabel_title.setBounds(new Rectangle(45, 130, 415, 36));
        jLabel_title.setText("学生成绩管理系统");
        Font font5 = new Font("宋体", Font.PLAIN, 40);
        jLabel_title.setFont(font5);

        jLabel_tips = new JLabel();
        jLabel_tips.setBounds(new Rectangle(40, 300, 415, 36));
        jLabel_tips.setText("管理员使用账号登陆，非管理员请使用ID登陆");
        Font font3 = new Font("宋体", Font.PLAIN, 18);
        jLabel_tips.setFont(font3);

        this.setSize(444, 534);
        this.setTitle("欢迎登陆");

        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 使用windows外观
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jButton21 = new JButton();
        jButton21.setBounds(new Rectangle(60, 400, 117, 39));
		


        jButton21.setText("登录");
        getRootPane().setDefaultButton(jButton21);// 回车登录

        jButton22 = new JButton();
        jButton22.setBounds(new Rectangle(240, 400, 117, 39));
        jButton22.setText("退出");

        jTextField = new JTextField(30);
        jTextField.setBounds(new Rectangle(180, 220, 186, 35));

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(new Rectangle(180, 260, 186, 35));

        jLabel = new JLabel();
        jLabel.setText("");
        jLabel.setBounds(new Rectangle(0, -2, 436, 213));

        jLabel_password = new JLabel();
        jLabel_password.setBounds(new Rectangle(90, 260, 159, 42));
        jLabel_password.setText("密  码：");
        // 创建一个字体对象，设置字体名称、样式和大小
        Font font = new Font("宋体", Font.PLAIN, 24); // 字体名称，样式，大小
        jLabel_password.setFont(font);

        jLabel_userName = new JLabel();
        jLabel_userName.setBounds(new Rectangle(90, 220, 106, 29));
        jLabel_userName.setText("用户名：");
        Font font2 = new Font("宋体", Font.PLAIN, 24);
        jLabel_userName.setFont(font2);
        jLabel_User = new JLabel();
        jLabel_User.setBounds(new Rectangle(15, 220, 412, 147));


        jLabel_privilege = new JLabel();
        jLabel_privilege.setBounds(new Rectangle(50, 340, 406, 28));
        jLabel_privilege.setText("登陆类型：");
        Font font4 = new Font("宋体", Font.PLAIN, 20);
        jLabel_privilege.setFont(font4);

        jComboBox = new JComboBox();
        jComboBox.setBounds(new Rectangle(163, 340, 184, 34));
        jComboBox.addItem("管理登陆");
        jComboBox.addItem("老师登录");
        jComboBox.addItem("学生登陆");



        jContentPane = new JPanel();// 新建jPanel面板
        jContentPane.setLayout(null);
        jContentPane.setBackground(new Color(255, 255, 255));
        jContentPane.add(jLabel_userName, null);
        jContentPane.add(jLabel_password, null);
        jContentPane.add(jButton21, null);
        jContentPane.add(jButton22, null);
        jContentPane.add(jTextField, null);
        jContentPane.add(jPasswordField, null);
        jContentPane.add(jLabel, null);
        jContentPane.add(jLabel_User, null);

        jContentPane.add(jComboBox, null);
        jContentPane.add(jLabel_privilege, null);
        jContentPane.add(jLabel_tips, null);
        jContentPane.add(jLabel_title, null);
        jContentPane.add(jLabel_welcome, null);
        setContentPane(jContentPane);

        btl = new BtnListener();
        jButton21.addActionListener(btl);
        jButton22.addActionListener(btl);

    }

    /**
     * @监听类
     * @author Administrator
     */
    public class BtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton21) {
                UserDao ud = new UserDao();
                String user = jTextField.getText().trim();
                String password = new String(jPasswordField.getPassword()).trim();//char to String

                storeUserName = user;
                storeUserPassword = password;
                login_user_type = jComboBox.getSelectedIndex();

                if ("".equals(user)) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空");
                    return;
                }
                if ("".equals(password)) {
                    JOptionPane.showMessageDialog(null, "密码不能为空");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dt = sdf.format(new java.util.Date());

                //如果是管理员，可以直接使用账户登录
                if (login_user_type == 0) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {

                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "欢迎 " + user + "登陆！", "关于选修课程管理系统", JOptionPane.INFORMATION_MESSAGE);
                        storeUserId = ud.getUserIdByUserName(storeUserName);
                        String log_operate = "[" + storeUserName + "]" + "管理员登陆系统";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");
                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败");
                        return;
                    }
                    //教师登录
                } else if (login_user_type == 1) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {

                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "欢迎 " + storeUserName + "号教师登陆！", "关于选修课程管理系统", JOptionPane.INFORMATION_MESSAGE);

                        String log_operate = "[" + storeUserName + "]号教师" + "用户登陆系统";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");

                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败");
                        return;
                    }
                } else if (login_user_type == 2) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {
                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "欢迎 " + user + "号学生登陆！", "关于选修课程管理系统", JOptionPane.INFORMATION_MESSAGE);
                        String log_operate = "[" + storeUserName + "]" + "号学生登陆系统";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");
                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败");
                        return;
                    }
                }
            } else if (e.getSource() == jButton22) {
                System.exit(0);
            }
        }
    }


    /**
     * @主函数
     * @param args
     */
    public static void main(String[] args) {
        Login login = new Login(RELOAD);
        login.setVisible(true);
    }

    public Login() {
        super();
        initialize();
    }

    public Login(boolean reload) {
        super();
        initialize();
        //new MusicDemo();// 背景音乐
    }
}  //  @jve:decl-index=0:visual-constraint="10,10" 
