package com.RealProject.frame;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.RealProject.dao.CCourseDao;
import com.RealProject.dao.CourseDao;
import com.RealProject.model.CourseModel;



public class CCourseMarkStatistic extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel3 = null;
	private JComboBox jComboBox_course = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel_course_max = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel_course_min = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel_course_avg = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel_course_good = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel_course_ok = null;
	private JLabel jLabel_course_counts = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;

	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton jButton_export = null;

	private List<CourseModel> course_lists; 
	
	private List<String> course_threeMark;  
	private List<String> course_goodRadio;
	
	
	private void initialize() {
		this.setSize(477, 189);
		
		this.setTitle("�ɼ�ͳ��");
		this.setModal(true);
		this.setLocationRelativeTo(null);
		
		

		jLabel11 = new JLabel();
		jLabel11.setText("");
		jLabel11.setBounds(new Rectangle(191, 89, 45, 25));
		jLabel10 = new JLabel();
		jLabel10.setText("");
		jLabel10.setBounds(new Rectangle(192, 60, 45, 25));
		jLabel_course_counts = new JLabel();
		jLabel_course_counts.setText("JLabel");
		jLabel_course_counts.setBounds(new Rectangle(224, 23, 55, 25));
		jLabel_course_ok = new JLabel();
		jLabel_course_ok.setText("");
		jLabel_course_ok.setBounds(new Rectangle(148, 92, 40, 21));
		jLabel8 = new JLabel();
		jLabel8.setText("������(60������):");
		jLabel8.setBounds(new Rectangle(10, 89, 145, 24));
		jLabel_course_good = new JLabel();
		jLabel_course_good.setText("");
		jLabel_course_good.setBounds(new Rectangle(147, 58, 44, 26));
		jLabel7 = new JLabel();
		jLabel7.setText("������(90������):");
		jLabel7.setBounds(new Rectangle(10, 57, 145, 25));
		jLabel_course_avg = new JLabel();
		jLabel_course_avg.setText("");
		jLabel_course_avg.setBounds(new Rectangle(66, 89, 107, 25));
		jLabel6 = new JLabel();
		jLabel6.setText("ƽ���֣�");
		jLabel6.setBounds(new Rectangle(4, 89, 65, 27));
		jLabel_course_min = new JLabel();
		jLabel_course_min.setText("");
		jLabel_course_min.setBounds(new Rectangle(68, 58, 103, 26));
		jLabel5 = new JLabel();
		jLabel5.setText("��ͷ֣�");
		jLabel5.setBounds(new Rectangle(3, 55, 65, 29));
		jLabel_course_max = new JLabel();
		jLabel_course_max.setText("");
		jLabel_course_max.setBounds(new Rectangle(65, 28, 105, 23));
		jLabel4 = new JLabel();
		jLabel4.setText("��߷֣�");
		jLabel4.setBounds(new Rectangle(3, 29, 65, 18));
		jLabel3 = new JLabel();
		jLabel3.setText("�γ�ѡ��");
		jLabel3.setBounds(new Rectangle(12, 25, 75, 21));
		jLabel = new JLabel();
		jLabel.setText("��ͬ�༶�꼶��ѧ������ѡ��ͬһ�ſγ̣�ֻ�ܰ��γ�ͳ�ơ�");
		jLabel.setBounds(new Rectangle(8, 8, 450, 22));
		


		
		jComboBox_course = new JComboBox();
		jComboBox_course.setBounds(new Rectangle(85, 24, 137, 24));
		
		CourseDao cd = new CourseDao();
		course_lists = cd.getLists(false, -1);
		for(int i=0;i<course_lists.size();i++){
			
			jComboBox_course.addItem(course_lists.get(i).getCourse_name());
		}	
		
		
		
		jButton_export = new JButton();
		jButton_export.setText("����ͳ��");
		jButton_export.setBounds(new Rectangle(376, 8, 91, 22));
		
		jPanel = new JPanel();
		jPanel.setLayout(null);
		jPanel.setBounds(new Rectangle(293, 32, 177, 120));
		jPanel.add(jLabel4, null);
		jPanel.add(jLabel_course_max, null);
		jPanel.add(jLabel5, null);
		jPanel.add(jLabel_course_min, null);
		jPanel.add(jLabel6, null);
		jPanel.add(jLabel_course_avg, null);
		jPanel.setBorder(BorderFactory.createTitledBorder("�ߵͷ�ͳ��"));

		jPanel1 = new JPanel();
		jPanel1.setLayout(null);
		jPanel1.setBounds(new Rectangle(-2, 29, 296, 124));
		jPanel1.setBorder(BorderFactory.createTitledBorder("�γ�ѡ��"));
		jPanel1.add(jLabel7, null);
		jPanel1.add(jLabel_course_good, null);
		jPanel1.add(jLabel10, null);
		jPanel1.add(jLabel11, null);
		jPanel1.add(jLabel_course_ok, null);
		jPanel1.add(jLabel8, null);
		jPanel1.add(jLabel_course_counts, null);
		jPanel1.add(jComboBox_course, null);
		jPanel1.add(jLabel3, null);
		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		jContentPane.add(jLabel, null);
		jContentPane.add(jPanel, null);
		jContentPane.add(jPanel1, null);

		//jContentPane.add(jButton_export, null);
		this.setContentPane(jContentPane);
	}
	
	

	public void flashData(){
		
		
		if(jComboBox_course.getSelectedIndex()==-1)
			return;
		
		int index = jComboBox_course.getSelectedIndex();
		int course_id = course_lists.get(index).getCourse_id();
		
		jLabel_course_counts.setText("��ţ�"+Integer.toString(course_id));
		
		CCourseDao ccd = new CCourseDao();
		course_threeMark = ccd.getThreeMark(course_id);
		jLabel_course_max.setText(course_threeMark.get(0));
		jLabel_course_min.setText(course_threeMark.get(1));
		jLabel_course_avg.setText(course_threeMark.get(2));
		
		course_goodRadio = ccd.getGoodRadio(course_id);

		
		int totalCounts = Integer.parseInt(course_goodRadio.get(0));
		if(totalCounts==0)
			return;
		jLabel_course_good.setText(Integer.parseInt(course_goodRadio.get(1))*100/totalCounts+"%");
		jLabel_course_ok.setText(Integer.parseInt(course_goodRadio.get(2))*100/totalCounts+"%");
		

		
	}
	
	public CCourseMarkStatistic() {
		super();
		initialize();
		flashData();
		jComboBox_course.addItemListener(new itemListener_course());
	}
	
	
	public class itemListener_course implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				flashData();
				}
			}

		}

	

} 
