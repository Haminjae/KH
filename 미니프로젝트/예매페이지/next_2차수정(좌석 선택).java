package com.kh.project.movie.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class next extends JFrame{
		int member;
		JLabel screan,seats[],peopleLabel,priceLabel;
		JButton cancle,next;
		ArrayList<String> ticket;
		boolean[] select;
		JPanel panel,seat;
		
				
	public next(final String moviename,String movieday,final int price,final int ticketnum,final String movietime,int people,final JFrame parent) {
		panel = new JPanel(null);
		setSize(500, 400);
		setTitle("좌석 선택");
		
		peopleLabel = new JLabel();
		member = people;
		
		JLabel screen = new JLabel("스크린");
		screen.setBackground(Color.black);
		screen.setForeground(Color.white);
		screen.setOpaque(true);
			
		cancle = new JButton("돌아가기");
		next = new JButton("완료");
		ArrayList<String> ticket = new ArrayList<String>();
		
		JPanel seat = new JPanel(new GridLayout(8,8));
		JLabel seats1[] = new JLabel[65];
		boolean[] select = new boolean[65];
		
		seat.setBackground(Color.gray);
		seat.setOpaque(true);
		
		for(int i=0; i<8;i++)
			for(int j=0;j<8;j++) {
				final int k = i*8+1;
				seats1[k] = new JLabel(Integer.toString(k+1));
				seats1[k].setHorizontalAlignment(JLabel.CENTER);
				seats1[k].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(seats1[k].getBackground()==Color.MAGENTA) {
							seats1[k].setBackground(Color.gray);
							select[k] = false;
							member++;
						} else if (member > 0 && seats1[k].getBackground()!=Color.pink) {
							seats1[k].setBackground(Color.MAGENTA);
							select[k] = true;
							member--;
						}
						seats1[k].setOpaque(true);
					}
				});
				seat.add(seats1[k]);
			}
		
	try {
		FileReader fr = new FileReader("ticket.txt");
		BufferedReader br = new BufferedReader(fr);
		String str;
		while((str = br.readLine()) != null) {
			ticket.add(str);
			StringTokenizer st = new StringTokenizer(str);
			String str2 = st.nextToken("/t");
			String moviename1 = st.nextToken("\t"); // 영화 정보
			String movieday1 = st.nextToken("\t"); // 날짜 정보
			String movietime1 = st.nextToken("\t"); // 시간 정보;
			String seats2 = st.nextToken("\t"); // 좌석 정보
			String price1 = st.nextToken("\t"); // 가격 정보
			StringTokenizer st2 = new StringTokenizer(",");
			System.out.println(seats);
			if(moviename.equals(moviename1) && movietime1.equals(movietime1)) {
				while(st2.hasMoreTokens()) {
					str2 = st2.nextToken();
					int k = Integer.parseInt(str2);
					this.seats[k].setBackground(Color.GREEN);
					this.seats[k].setOpaque(true);
					
				}
			}
		}
		br.close();
		fr.close();
	}catch (Exception e2) {
		e2.printStackTrace();
	}
	
	cancle.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.setVisible(true);
			next.this.dispose();
		}
	});
	
	next.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(member > 0)
				new MsgBox(new JFrame(""),null,null,"좌석을 전부 선택해주세요",null,null,null, false,null);
			else {
				String msg = moviename + "\t" + ticketnum + "\t" + price;
				String seats = "\t";
				String etc = "시간 : " + movietime + "가격 : " + price;
			}
		}
	});
	
	
}

}
