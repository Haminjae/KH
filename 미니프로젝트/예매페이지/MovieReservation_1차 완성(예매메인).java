package com.kh.project.movie.view;

import java.awt.Choice;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieReservation extends JFrame{
	
	Choice moviename;
	Choice movietime;
	Choice movieday;
	Choice adultnum;
	Choice childnum;
	JPanel panel;
	JLabel name, day, time, adult, child, people, image1, image2, image3, image4, image5, image6, image7, image8;
	JButton next, cancle;
	ImageIcon batman, innocence, live, onward;
	int ticketnum, choicetime;
	JFrame frame;
	
	public MovieReservation() {
		setSize(500,400);
		setTitle("영화 예매");		
		panel = new JPanel(null);
		name = new JLabel("영화 선택 : ");
		day = new JLabel("상영 날짜 : ");
		time = new JLabel("상영 시간 : ");
		people = new JLabel("인원 수를 선택해주세요.");
		adult = new JLabel("성인 : ");
		child = new JLabel("청소년 : ");
		
		ticketnum = (int)(Math.random()*999999999);
		
		
		 
		
		next = new JButton("좌석 조회하기");
		cancle = new JButton("창 닫기");
		
		moviename = new Choice();   // 초이스 객체 생성
		movietime = new Choice();
		movieday = new Choice();
		
		movietime.add("원하시는 시간을 선택해주세요.");
		movietime.add("1관 : 09:00 ~ 10:50");
		movietime.add("1관 : 11:40 ~ 13:30");
		movietime.add("2관 : 14:00 ~ 15:50");
		movietime.add("1관 : 18:00 ~ 19:50");
		
		movieday.add("원하시는 날짜를 선택해주세요.");
		movieday.add("2020-06-30");
		movieday.add("2020-07-01");
		movieday.add("2020-07-02");
		movieday.add("2020-07-03");
		
		
		moviename.add("결백");
		moviename.add("#살아있다.");
		moviename.add("배트맨 비긴즈");
		moviename.add("온워드:단 하루의 기적");
		
		adultnum = new Choice();
		childnum = new Choice();
		
		for(int i = 0; i < 6; i++) {
			adultnum.add(String.valueOf(i));
			childnum.add(String.valueOf(i));
		}
		
		ImageIcon imageIcon1 = new ImageIcon("movie/batman.JPG");
		Image image1 = imageIcon1.getImage();
		Image icon1 = image1.getScaledInstance(100, 150, 150);
		
		image2 = new JLabel(new ImageIcon(icon1));
		image2.setBounds(10, 5, 100, 150);
		add(image2);
		
		ImageIcon imageIcon2 = new ImageIcon("movie/innocence.JPG");
		Image image3 = imageIcon2.getImage();
		Image icon2 = image3.getScaledInstance(100, 150, 150);
		
		image4 = new JLabel(new ImageIcon(icon2));
		image4.setBounds(120, 5, 100, 150);
		add(image4);
		
		ImageIcon imageIcon3 = new ImageIcon("movie/live.JPG");
		Image image5 = imageIcon3.getImage();
		Image icon3 = image5.getScaledInstance(100, 150, 150);
		
		image6 = new JLabel(new ImageIcon(icon3));
		image6.setBounds(230, 5, 100, 150);
		add(image6);
		
		ImageIcon imageIcon4 = new ImageIcon("movie/onward.JPG");
		Image image7 = imageIcon4.getImage();
		Image icon4 = image7.getScaledInstance(100, 150, 150);
		
		image8 = new JLabel(new ImageIcon(icon4));
		image8.setBounds(340, 5, 100, 150);
		add(image8);
		
		MovieReservation mr = new MovieReservation();
		
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.remove(mr);
				frame.setTitle("좌석 선택");
				frame.add(next);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		cancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.remove(next);
				frame.setTitle("영화 예매");
				frame.add(mr);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		
		
		
		name.setBounds(20, 160, 70, 30);
		moviename.setBounds(100, 160, 200, 30);
		day.setBounds(20, 190, 70, 30);
		movieday.setBounds(100, 190, 200, 30);
		time.setBounds(20, 220, 70, 30);
		movietime.setBounds(100, 220, 200, 30);
		people.setBounds(320, 160, 200, 30);
		child.setBounds(320, 190, 50, 30);
		childnum.setBounds(370, 190, 50, 30);
		adult.setBounds(320, 220, 50, 30);
		adultnum.setBounds(370, 220, 50, 30);
		next.setBounds(80, 300, 120, 50);
		cancle.setBounds(260, 300, 120, 50);
		
			
			
		panel.add(name);
		panel.add(day);
		panel.add(adult);
		panel.add(child);
		panel.add(people);
		add(next);
		panel.add(movieday);
		panel.add(moviename);
		panel.add(movietime);
		add(cancle);
		panel.add(adultnum);
		panel.add(childnum);
		panel.add(time);
		add(panel);
		
		
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}		
	
}
