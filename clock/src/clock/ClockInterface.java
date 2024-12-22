package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockInterface extends JFrame{
	
	ImageIcon icon=new ImageIcon("letter.png");
	
	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel tlabel;
	JLabel dLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	ClockInterface() {
		this.setSize(350,200);
		this.setTitle("Clock⌚");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		
		timeFormat=new SimpleDateFormat("hh:mm:ss a");
		dayFormat=new SimpleDateFormat("EEEE");
		dateFormat=new SimpleDateFormat("MMMMM dd, yyyy");
		
		tlabel=new JLabel();
		dLabel=new JLabel();
		dateLabel=new JLabel();
		
		tlabel.setFont(new Font("Verdana",Font.BOLD,45));
		tlabel.setForeground(new Color(81, 197, 224));
		tlabel.setBackground(Color.black);
		tlabel.setOpaque(true);
		
		dLabel.setFont(new Font("Ink free",Font.BOLD,30));
		dLabel.setForeground(new Color(255, 28, 170));
		dLabel.setOpaque(true);
		
		dateLabel.setFont(new Font("Ink free",Font.BOLD,30));
		dateLabel.setForeground(new Color(255, 28, 170));
		dateLabel.setOpaque(true);
		
		this.add(tlabel);
		this.add(dLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	public void setTime() {
		while(true) {
			time=timeFormat.format(Calendar.getInstance().getTime());
			tlabel.setText(time);
			
			day=dayFormat.format(Calendar.getInstance().getTime());
			dLabel.setText(day);
			
			date=dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
