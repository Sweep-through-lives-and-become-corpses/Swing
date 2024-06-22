package com.RealProject.frame;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.util.List;

import com.RealProject.dao.CCourseDao;
import com.RealProject.dao.CourseDao;
import com.RealProject.model.CCourseModel;
import com.RealProject.model.CourseModel;
import com.RealProject.model.TeacherModel;

import javax.swing.JCheckBox;

public class CCourseManage extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JScrollPane jScrollPane = null;
    private JTable jTable = null;
    private JButton jButton_ccourse_open = null;
    private JButton jButton_ccourse_print = null;
    private JLabel jLabel_course_counts = null;
    public int total;
    private JLabel jLabel = null;
    private JLabel jLabel3 = null;
    private JComboBox jComboBox_query_condition = null;
    private JTextField jTextField_query_word = null;
    private JButton jButton_course_query = null;
    private JLabel jLabel4 = null;
    private JComboBox jComboBox_course_condition = null;
    private JButton jButton_course_delete = null;
    private JPanel jPanel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel5 = null;
    private JComboBox jComboBox_course_name = null;
    private JButton jButton_course_modify = null;

    private JLabel jLabel_student_name = null;
    private JLabel jLabel6 = null;
    private JComboBox jComboBox_course_counts = null;

    private List<CourseModel> course_lists;
    private List<TeacherModel> teach_lists;
    private List<CCourseModel> ccourse_lists;


    DefaultTableModel model = new DefaultTableModel();

    private boolean isFirstModify = true;
    //	private int counts = 0;//��¼��
    private JCheckBox jCheckBox_teach_filter = null;
    private JCheckBox jCheckBox_fuzzy_query = null;

    /**
     * This is the default constructor
     */
    public CCourseManage() {
        super();

        initialize();

        jComboBox_course_condition.addItemListener(new itemListener_course());
        jComboBox_course_counts.addItemListener(new itemListener_course());
        jButton_course_query.addActionListener(new btnListener());
        jButton_ccourse_open.addActionListener(new btnListener());
        jButton_course_query.addActionListener(new btnListener());
        jButton_course_delete.addActionListener(new btnListener());
        jButton_course_modify.addActionListener(new btnListener());

        jCheckBox_teach_filter.addItemListener(new checkListener());
        jCheckBox_fuzzy_query.addItemListener(new checkListener());
        jTable.getSelectionModel()
                .addListSelectionListener(new tableListener());// jTableѡ�м�����

    }

    private void initialize() {
        this.setSize(750, 568);
        this.setContentPane(getJContentPane());
        this.setTitle("ѡ�ι���");
        this.setLocationRelativeTo(null);
        //	this.setModal(true);
        this.setLocationRelativeTo(null);

        initTableDataByCombo();
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel6 = new JLabel();
            jLabel6.setBounds(new Rectangle(306, 24, 110, 24));
            jLabel6.setText("ѧ��ѡ��������");
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(553, 22, 65, 26));
            jLabel1.setText("��¼����");
            jLabel4 = new JLabel();
            jLabel4.setBounds(new Rectangle(19, 25, 120, 24));
            jLabel4.setText("���γ������о�:");
            jLabel3 = new JLabel();
            jLabel3.setBounds(new Rectangle(19, 63, 75, 18));
            jLabel3.setText("��ѯ��ʽ:");
            jLabel = new JLabel();
            jLabel.setText("ѧ��������");
            jLabel.setBounds(new Rectangle(13, 21, 75, 25));


            jComboBox_query_condition = new JComboBox();
            jComboBox_query_condition.addItem("��ID");
            jComboBox_query_condition.addItem("������");
            jComboBox_query_condition.addItem("���ɼ�");

            jComboBox_query_condition.setBounds(new Rectangle(105, 56, 159, 27));


            jComboBox_course_name = new JComboBox();
            jComboBox_course_name.setBounds(new Rectangle(299, 19, 167, 30));
            jComboBox_course_name.setEnabled(false);


            jButton_course_modify = new JButton();
            jButton_course_modify.setBounds(new Rectangle(169, 58, 144, 27));
            jButton_course_modify.setText("�޸�ѡ��");


            jComboBox_course_counts = new JComboBox();
            jComboBox_course_counts.setBounds(new Rectangle(413, 24, 122, 23));
            jComboBox_course_counts.setEnabled(false);
            jComboBox_course_counts.addItem("��ûѡ��ѧ��");
            jComboBox_course_counts.addItem("ѡһ�ſγ�");
            jComboBox_course_counts.addItem("ѡ���Ż�����");


            jComboBox_course_condition = new JComboBox();
            jComboBox_course_condition.setBounds(new Rectangle(130, 24, 134, 26));


            //��ʼ������������
            CourseDao cd = new CourseDao();
            course_lists = cd.getLists(false, -1);
            for (int i = 0; i < course_lists.size(); i++) {
                jComboBox_course_condition.addItem(course_lists.get(i).getCourse_name());
            }

            for (int i = 0; i < course_lists.size(); i++) {
                jComboBox_course_name.addItem(course_lists.get(i).getCourse_name());
            }



            jTextField_query_word = new JTextField();
            jTextField_query_word.setBounds(new Rectangle(274, 56, 139, 28));

            jButton_course_query = new JButton();
            jButton_course_query.setBounds(new Rectangle(539, 56, 105, 28));
            jButton_course_query.setText("��ѯ");


            jButton_course_delete = new JButton();
            jButton_course_delete.setText("ɾ��ѡ��");
            jButton_course_delete.setBounds(new Rectangle(372, 58, 92, 27));

            if (Login.login_user_type == 2) {

            }


            jTable = new JTable();

            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(jTable);
            jScrollPane.setBounds(new Rectangle(20, 90, 620, 300));


            String heads[] = {"�γ�ID", "�γ�����", "ѧ��ID", "ѧ������", "��ʦID", "��ʦ����", "�γ̳ɼ�"};
            model = new DefaultTableModel(null, heads);


            jLabel_student_name = new JLabel();
            jLabel_student_name.setBounds(new Rectangle(97, 19, 90, 25));
            jLabel_student_name.setText("");
            jLabel5 = new JLabel();
            jLabel5.setBounds(new Rectangle(209, 20, 80, 26));
            jLabel5.setText("��ѡ�γ̣�");
            jPanel = new JPanel();
            jPanel.setLayout(null);
            jPanel.setBounds(new Rectangle(17, 403, 619, 105));
            jPanel.setBorder(BorderFactory.createTitledBorder("�������"));
            //jPanel.add(getjButton_ccourse_print(), null);
            jPanel.add(jLabel, null);
            jPanel.add(getJButton_ccourse_open(), null);
            jPanel.add(jButton_course_delete, null);
            jPanel.add(jLabel5, null);
            jPanel.add(jComboBox_course_name, null);
            jPanel.add(jButton_course_modify, null);

            jPanel.add(jLabel_student_name, null);


            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.setBorder(BorderFactory.createTitledBorder("ѡ����Ϣһ����"));
            jContentPane.add(jScrollPane, null);
            jContentPane.add(jLabel3, null);
            jContentPane.add(jComboBox_query_condition, null);
            jContentPane.add(jTextField_query_word, null);
            jContentPane.add(jButton_course_query, null);
            jContentPane.add(jLabel4, null);
            jContentPane.add(jComboBox_course_condition, null);
            jContentPane.add(jPanel, null);
            jContentPane.add(getJLabel_course_counts(), null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(jLabel6, null);
            jContentPane.add(jComboBox_course_counts, null);
            jContentPane.add(getJCheckBox_teach_filter(), null);
            jContentPane.add(getJCheckBox_fuzzy_query(), null);
        }
        return jContentPane;
    }

    /**
     * @ͨ�����������ˢ��table����
     */

    public void initTableDataByCombo() {
        int course_index = jComboBox_course_condition.getSelectedIndex();
        if (course_index == -1) {
            return;
        }
        int course_id = course_lists.get(course_index).getCourse_id();
        CCourseDao ccd = new CCourseDao();
        ccourse_lists = ccd.getCCourseSpecificList(course_id, -1);
        flashTableData();
    }

    /**
     * @ͨ���ı�ccourse_lists ���� ˢ��table
     */
    public void flashTableData() {
        model.setRowCount(ccourse_lists.size());// ��������
        for (int i = 0; i < ccourse_lists.size(); i++) {

            model.setValueAt(ccourse_lists.get(i).getCourse_id(), i, 0);
            model.setValueAt(ccourse_lists.get(i).getCourse_name(), i, 1);
            model.setValueAt(ccourse_lists.get(i).getStu_id(), i, 2);
            model.setValueAt(ccourse_lists.get(i).getStu_name(), i, 3);
            model.setValueAt(ccourse_lists.get(i).getTeach_id(), i, 4);
            model.setValueAt(ccourse_lists.get(i).getTeach_name(), i, 5);
            model.setValueAt(ccourse_lists.get(i).getCcourse_mark(), i, 6);
        }
        jLabel_course_counts.setText(Integer.toString(ccourse_lists.size()));
        jTable.setModel(model);
        jTable.setRowHeight(22);
    }


    private JButton getJButton_ccourse_open() {
        if (jButton_ccourse_open == null) {
            jButton_ccourse_open = new JButton();
            jButton_ccourse_open.setText("��ѡ�ι������");
            jButton_ccourse_open.setBounds(new Rectangle(5, 57, 160, 26));
        }
        return jButton_ccourse_open;
    }

    private JButton getjButton_ccourse_print() {
        if (jButton_ccourse_print == null) {
            jButton_ccourse_print = new JButton();
            jButton_ccourse_print.setText("��ӡ��");
            jButton_ccourse_print.setBounds(new Rectangle(510, 58, 98, 25));
        }
        return jButton_ccourse_print;
    }

    private JLabel getJLabel_course_counts() {
        if (jLabel_course_counts == null) {
            jLabel_course_counts = new JLabel();
            jLabel_course_counts.setBounds(new Rectangle(608, 22, 27, 26));
        }
        return jLabel_course_counts;
    }


    //�γ����������
    public class itemListener_course implements ItemListener {
        public void itemStateChanged(ItemEvent e) {

            if (e.getSource() == jComboBox_course_condition) {

                int course_index = jComboBox_course_condition.getSelectedIndex();
                int course_id = course_lists.get(course_index).getCourse_id();
                CCourseDao ccd = new CCourseDao();
                ccourse_lists = ccd.getCCourseSpecificList(course_id, -1);


                //flashDataByCombo();
                flashTableData();

            } else if (e.getSource() == jComboBox_course_counts) {

//				int course_index = jComboBox_course_condition.getSelectedIndex();
//				int course_id = course_lists.get(course_index).getCourse_id();

                int course_counts_index = jComboBox_course_counts.getSelectedIndex();

                CCourseDao ccd = new CCourseDao();
                ccourse_lists = ccd.getCCourseSpecificList(-1, course_counts_index);
                flashTableData();

            }

        }

    }

    /**
     * @author Administrator
     * @��ť����
     */
    public class btnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            CCourseDao ccd = new CCourseDao();
            if (e.getSource() == jButton_course_delete) {
                if (jTable.getSelectedRow() != -1) {
                    int stu_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 2).toString());
                    int course_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());

                    if (Login.login_user_type == 2) {
                        if (!Login.storeUserName.equals(stu_id + "")) {
                            JOptionPane.showMessageDialog(null, "ֻ��ѡ��ɾ���Լ��Ŀγ̣�");
                            return;
                        }
                    }
                    ccd.deleteCCourse(stu_id, course_id);

                    model.removeRow(jTable.getSelectedRow());
                    //	counts--;
                    //flashDataByCombo();
                    flashTableData();

                } else {
                    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
                }
            } else if (e.getSource() == jButton_ccourse_open) {
                CCourseAdd cca = new CCourseAdd();
                cca.setVisible(true);

            }
//
            else if (e.getSource() == jButton_ccourse_print) {

                JOptionPane.showMessageDialog(null, "����������...");

            } else if (e.getSource() == jButton_course_modify) {
                int stu_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 2).toString());
                if (Login.login_user_type == 2) {
                    if (!Login.storeUserName.equals(stu_id + "")) {
                        JOptionPane.showMessageDialog(null, "ֻ��ѡ���޸��Լ��Ŀγ̣�");
                        return;
                    }
                }
                //����
                if (isFirstModify) {

                    isFirstModify = !isFirstModify;
                    jButton_course_modify.setText("ȷ���޸ģ����ã�");
                    jComboBox_course_name.setEnabled(true);
                } else {
                    //д�����ݿ�
                    isFirstModify = !isFirstModify;
                    jComboBox_course_name.setEnabled(false);

                    int old_course_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());

                    int new_course_id = course_lists.get(jComboBox_course_name.getSelectedIndex()).getCourse_id();
                    if (!ccd.modifyCCourse(stu_id, old_course_id, new_course_id)) {
                        JOptionPane.showMessageDialog(null, "����ʧ�ܣ���ȷ����ѧ��δ��ѡ�޹����ſγ�");
                        return;
                    }
                    flashTableData();
                    JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
                }
            } else if (e.getSource() == jButton_course_query) {

                int type = jComboBox_query_condition.getSelectedIndex();
                String query_word = jTextField_query_word.getText();
                if (jCheckBox_fuzzy_query.isSelected()) {
                    ccourse_lists = ccd.queryCCourseSpecificList(type, query_word, true);
                } else
                    ccourse_lists = ccd.queryCCourseSpecificList(type, query_word, false);


                flashTableData();
            }

        }
    }

    /**
     * �ڲ��������ģ�����jTable�Ƿ�ѡ�У�
     */

    public class tableListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (jTable.getSelectedRow() != -1) {
                int rows = jTable.getSelectedRow();
                jLabel_student_name.setText(jTable.getValueAt(rows, 3).toString());
                //ƥ��������
                int course_id = Integer.parseInt(jTable.getValueAt(rows, 0).toString());


                for (int i = 0; i < jComboBox_course_name.getItemCount(); i++) {
                    if (course_id == course_lists.get(i).getCourse_id()) {
                        jComboBox_course_name.setSelectedIndex(i);
                        break;
                    } else {
                        jComboBox_course_name.setSelectedIndex(0);
                    }
                }


            }
        }
    }

    public class checkListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {

            if (e.getSource() == jCheckBox_teach_filter) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jComboBox_course_counts.setEnabled(true);
                    jComboBox_course_condition.setEnabled(false);

                } else {
                    jComboBox_course_counts.setEnabled(false);
                    jComboBox_course_condition.setEnabled(true);
                }

            } else if (e.getSource() == jCheckBox_fuzzy_query) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    jComboBox_query_condition.setEnabled(false);
                    //	jTextField_query_word.setEnabled(false);
                } else {
                    jComboBox_query_condition.setEnabled(true);
                    //	jTextField_query_word.setEnabled(true);
                }

            }


        }


    }

    /**
     * This method initializes jCheckBox_teach_filter
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox_teach_filter() {
        if (jCheckBox_teach_filter == null) {
            jCheckBox_teach_filter = new JCheckBox();
            jCheckBox_teach_filter.setBounds(new Rectangle(265, 22, 23, 22));
        }
        return jCheckBox_teach_filter;
    }

    /**
     * This method initializes jCheckBox_fuzzy_query
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox_fuzzy_query() {
        if (jCheckBox_fuzzy_query == null) {
            jCheckBox_fuzzy_query = new JCheckBox();
            jCheckBox_fuzzy_query.setBounds(new Rectangle(424, 59, 120, 22));
            jCheckBox_fuzzy_query.setText("�Ƿ�ȫ��ģ��");
        }
        return jCheckBox_fuzzy_query;
    }

//	public static void main(String args[]){
//		CCourseManage cc = new CCourseManage();
//		cc.setVisible(true);
//		
//	}

}
