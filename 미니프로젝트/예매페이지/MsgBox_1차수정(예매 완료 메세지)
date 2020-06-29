package com.kh.project.movie.view;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MsgBox extends Panel implements ActionListener{
	
	boolean id = false;
	Button ok,can;
	JFrame parent,frame;
	String moviename,movieday,movietime,seats,msg;
	
	public MsgBox(JFrame jFrame, String moviename, String movieday, String msg, String movietime, String seats, String price, boolean okcan, String ticketnum) 
	{
		frame.setTitle("예약확인");
		frame.setSize(500,400);
		this.parent = parent;
		
		Container panel = frame.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		if(moviename!= null) panel.add(new Label(moviename));
		if(movieday!= null) panel.add(new Label(movieday));
		if(movietime!=null) panel.add(new Label(movietime));
		if(seats!= null) panel.add(new Label(seats));
		panel.add(new Label(msg));
		add(panel);
		addOKCancelPanel(okcan);
		creatFrame();
		setVisible(true);
		
	
		
		
	}

	private void addOKCancelPanel(boolean okcan) {
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		createOKButton(p);
		if (okcan == true)
			createCancelButton(p);
		add("South",p);
	}

	private void createCancelButton(Panel p) {
		p.add(ok = new Button("완료"));
		ok.addActionListener(this);
	}

	private void createOKButton(Panel p) {
		p.add(can = new Button("취소"));
		can.addActionListener(this);
		
	}

	private void creatFrame() {
		Dimension d = getToolkit().getScreenSize();
		setLocation(d.width/3,d.height/3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok)
		{
			id = true;
			if(parent!=null) parent.dispose();
//			new MainFrame().show();                // 마이페이지로 이동
			setVisible(false);
		}
		else if (e.getSource() == can)
		{
			setVisible(false);
		}
	}
	
}


