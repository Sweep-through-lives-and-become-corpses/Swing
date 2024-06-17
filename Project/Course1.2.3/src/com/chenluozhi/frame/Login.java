/**
 * ѡ�޿γ̹���ϵͳ �㶫ʯ�ͻ���ѧԺ �����07-1��
 *
 *
 * @version 1.2.3
 * @data 03/24/2010
 * @last update 06/02/2011
 *
 * <p>
 * ����         �� ����
 * �����ߩ��������ߩ�
 * ������������������
 * ������������������
 * �����ש������ס���
 * ������������������
 * ���������ߡ�������
 * ������������������
 * ������������������
 * ��������������
 * ��������������
 * ����������������������
 * ���������������������ǩ�
 * ������������������������
 * ���������������ש�����
 * ���������ϩϡ����ϩ�
 * ���������ߩ������ߩ�
 * ������������κ������ɷ����޸ġ��������뱣����ע�ӣ�лл��
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
    static int storeUserId;// ��¼�û���
    public static String storeUserName = null;// ��¼�û���
    public static String storeUserPassword = null;// ��¼����
    static boolean RELOAD = true;// ���µ�½���
    static int login_user_type;//0��ʾ����Ա��1��ʾ��ʦ��2��ʾѧ��
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
        jLabel_welcome.setText("��ӭ��½");
        Font font6 = new Font("����", Font.PLAIN, 60);
        jLabel_welcome.setFont(font6);

        jLabel_title = new JLabel();
        jLabel_title.setBounds(new Rectangle(45, 130, 415, 36));
        jLabel_title.setText("ѧ���ɼ�����ϵͳ");
        Font font5 = new Font("����", Font.PLAIN, 40);
        jLabel_title.setFont(font5);

        jLabel_tips = new JLabel();
        jLabel_tips.setBounds(new Rectangle(40, 300, 415, 36));
        jLabel_tips.setText("����Աʹ���˺ŵ�½���ǹ���Ա��ʹ��ID��½");
        Font font3 = new Font("����", Font.PLAIN, 18);
        jLabel_tips.setFont(font3);

        this.setSize(444, 534);
        this.setTitle("��ӭ��½");

        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// ʹ��windows���
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jButton21 = new JButton();
        jButton21.setBounds(new Rectangle(60, 400, 117, 39));
		


        jButton21.setText("��¼");
        getRootPane().setDefaultButton(jButton21);// �س���¼

        jButton22 = new JButton();
        jButton22.setBounds(new Rectangle(240, 400, 117, 39));
        jButton22.setText("�˳�");

        jTextField = new JTextField(30);
        jTextField.setBounds(new Rectangle(180, 220, 186, 35));

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(new Rectangle(180, 260, 186, 35));

        jLabel = new JLabel();
        jLabel.setText("");
        jLabel.setBounds(new Rectangle(0, -2, 436, 213));

        jLabel_password = new JLabel();
        jLabel_password.setBounds(new Rectangle(90, 260, 159, 42));
        jLabel_password.setText("��  �룺");
        // ����һ��������������������ơ���ʽ�ʹ�С
        Font font = new Font("����", Font.PLAIN, 24); // �������ƣ���ʽ����С
        jLabel_password.setFont(font);

        jLabel_userName = new JLabel();
        jLabel_userName.setBounds(new Rectangle(90, 220, 106, 29));
        jLabel_userName.setText("�û�����");
        Font font2 = new Font("����", Font.PLAIN, 24);
        jLabel_userName.setFont(font2);
        jLabel_User = new JLabel();
        jLabel_User.setBounds(new Rectangle(15, 220, 412, 147));


        jLabel_privilege = new JLabel();
        jLabel_privilege.setBounds(new Rectangle(50, 340, 406, 28));
        jLabel_privilege.setText("��½���ͣ�");
        Font font4 = new Font("����", Font.PLAIN, 20);
        jLabel_privilege.setFont(font4);

        jComboBox = new JComboBox();
        jComboBox.setBounds(new Rectangle(163, 340, 184, 34));
        jComboBox.addItem("�����½");
        jComboBox.addItem("��ʦ��¼");
        jComboBox.addItem("ѧ����½");



        jContentPane = new JPanel();// �½�jPanel���
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
     * @������
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
                    JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
                    return;
                }
                if ("".equals(password)) {
                    JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dt = sdf.format(new java.util.Date());

                //����ǹ���Ա������ֱ��ʹ���˻���¼
                if (login_user_type == 0) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {

                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "��ӭ " + user + "��½��", "����ѡ�޿γ̹���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
                        storeUserId = ud.getUserIdByUserName(storeUserName);
                        String log_operate = "[" + storeUserName + "]" + "����Ա��½ϵͳ";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");
                    } else {
                        JOptionPane.showMessageDialog(null, "��¼ʧ��");
                        return;
                    }
                    //��ʦ��¼
                } else if (login_user_type == 1) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {

                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "��ӭ " + storeUserName + "�Ž�ʦ��½��", "����ѡ�޿γ̹���ϵͳ", JOptionPane.INFORMATION_MESSAGE);

                        String log_operate = "[" + storeUserName + "]�Ž�ʦ" + "�û���½ϵͳ";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");

                    } else {
                        JOptionPane.showMessageDialog(null, "��¼ʧ��");
                        return;
                    }
                } else if (login_user_type == 2) {

                    if (ud.userLogin(login_user_type, storeUserName, storeUserPassword)) {
                        dispose();
                        MainFrame mf = new MainFrame();
                        mf.setVisible(true);
                        JOptionPane.showMessageDialog(null, "��ӭ " + user + "��ѧ����½��", "����ѡ�޿γ̹���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
                        String log_operate = "[" + storeUserName + "]" + "��ѧ����½ϵͳ";
                        DBConnection.update("insert into c_log(login_user,log_operate,log_time) values('" + storeUserName + "','" + log_operate + "','" + dt + "')");
                    } else {
                        JOptionPane.showMessageDialog(null, "��¼ʧ��");
                        return;
                    }
                }
            } else if (e.getSource() == jButton22) {
                System.exit(0);
            }
        }
    }


    /**
     * @������
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
        //new MusicDemo();// ��������
    }
}  //  @jve:decl-index=0:visual-constraint="10,10" 
