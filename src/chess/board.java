package chess;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
public class board extends variable implements ActionListener{
	public JLabel label1;
	public JLabel label2;
    public Timer timer1;
	public Timer timer2;
	public JPanel frame = new JPanel();
	public JPanel frame2 = new JPanel();
	public boolean w = true;
	public boolean P = false;
    public JFrame all = new JFrame();
public board() {
    all.setLayout(new GridBagLayout());
    all.setVisible(true);
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx =1;
    c.weighty = 0.3;
    c.fill = GridBagConstraints.BOTH;
	secondleft1 = 6000;
	secondleft2 = 6000;
		label1 = new JLabel();
		label2 = new JLabel();
		timer1 = new javax.swing.Timer(100, this);
		timer2 = new javax.swing.Timer(100, this);
        timer1.setInitialDelay(0);
        updateLabel(label1,secondleft1);
		label1.setOpaque(true);
		label1.setBackground(Color.decode("#EFD4B1"));
		all.add(label1, c);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx =1;
		c.weighty = 0.3;
		timer2.setInitialDelay(0);
        updateLabel(label2,secondleft2);
		label2.setBackground(Color.decode("#EFD4B1"));
		label2.setOpaque(true);
		all.add(label2, c);
	c.gridx = 2;
	c.gridy = 0;
	c.gridwidth = 1;
	c.gridheight = 1;
	c.weightx = 0.3;
	c.weighty = 0.3;
	JButton b1Button = new JButton();
	b1Button.setBackground(Color.decode("#EFD4B1"));
	b1Button.setBorder(null);
	all.add(b1Button,c);
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth =1;
    c.gridheight = 1;
    c.weightx =0.2;
    c.weighty = 0.9;
    JButton b2Button = new JButton();
	b2Button.setBorder(null);
    b2Button.setBackground(Color.decode("#EFD4B1"));
	all.add(b2Button,c);
    c.gridx = 1;
    c.gridy = 1;
    c.gridwidth = 1;
    c.gridheight= 1;
    c.weightx =0.4;
    c.weighty = 0.8;
    all.setSize(1200, 700);
    
	frame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        all.add(frame, c);
		
        frame2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    c.gridx = 2;
    c.gridy = 1;
    c.gridwidth =1;
    c.gridheight = 1;
    c.weightx =0.05;
    c.weighty = 0.9;;
	JLabel util = new JLabel();
	JButton Return = new JButton();
	Return.setIcon(RETURN);
	Return.setBorder(null);
	Return.setBackground(Color.decode("#EFD4B1"));
	Return.setFocusPainted(false);
		Return.addActionListener(
				e -> {
					Return();}
			);
	util.setLayout(new GridLayout(3, 1, 0, 0));
	util.setBorder(null);
	all.add(util,c);
	util.add(Return);
	c.gridx = 3;
    c.gridy = 1;
    c.gridwidth = 1;
    c.gridheight= 1;
    c.weightx =0.4;
    c.weighty = 0.8;
	all.add(frame2, c);
	c.gridx = 4;
    c.gridy = 1;
    c.gridwidth =1;
    c.gridheight = 2;
    c.weightx =0.2;
    c.weighty = 0.9;
	JButton b5Button = new JButton();
	b5Button.setBackground(Color.decode("#EFD4B1"));
	b5Button.setBorder(null);
    all.add(b5Button, c);

	c.gridx = 0;
    c.gridy = 2;
    c.gridwidth = 5;
    c.gridheight = 1;
    c.weightx =0.8;
    c.weighty = 0.2;
    JButton b6Button = new JButton();
	b6Button.setBackground(Color.decode("#EFD4B1"));
	b6Button.setIcon(newGame);
	b6Button.setBorder(null);
	b6Button.addActionListener(
		e -> {
			h = 2;
            Return();
            luot="trang";
            secondleft1 = 6000;
            secondleft2 = 6000;}
	);
    all.add(b6Button, c);
all.setLocationRelativeTo(null);
all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Panel = new JPanel();
		Panel.setBounds(0, 0, 50, 50);

		
		frame2.setLayout(new GridLayout(8, 8, 0, 0));
		frame.setLayout(new GridLayout(8, 8, 0, 0));
		
		JButton Pause = new JButton();
		Pause.setIcon(board.Pause);
		Pause.setBorder(null);
		Pause.setBackground(Color.decode("#EFD4B1"));
		Pause.setFocusPainted(false);
		Pause.addActionListener(
			e -> {
				if(P){
					timer1.stop();
					timer2.stop();
					Pause.setIcon(board.Pause);
				}else{
					Pause.setIcon(Continue);
					if(luot == "trang"){
						timer1.start();
					}else{
						timer2.start();
					}
				}
				P=!P;
				}
		);
		util.add(Pause);
		JButton swap = new JButton();
		swap.setIcon(Swap);
		swap.setBorder(null);
		swap.setBackground(Color.decode("#EFD4B1"));
		swap.setFocusPainted(false);
		swap.addActionListener(
			e -> {
				all.remove(frame);
				all.remove(frame2);
				all.remove(label1);
				all.remove(label2);
					c.gridx = 1;
					c.gridy = 1;
					c.gridwidth = 1;
					c.gridheight= 1;
					c.weightx =0.4;
					c.weighty = 0.8;
				if(w){
				all.add(frame2,c);
				c.gridx = 3;
				all.add(frame,c);
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				c.gridheight = 1;
				c.weightx =1;
				c.weighty = 0.3;
				all.add(label2,c);
				c.gridx = 3;
				all.add(label1,c);
				}else{
				all.add(frame,c);
				c.gridx = 3;
				all.add(frame2,c);
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth = 2;
				c.gridheight = 1;
				c.weightx =1;
				c.weighty = 0.3;
				all.add(label1,c);
				c.gridx = 3;
				all.add(label2,c);
				}
				w = !w;
				}
		);
		util.add(swap);
		int a = 1;
			x[1][1]=5;
			x[1][2]=2;
			x[1][3]=3;
			x[1][4]=9;
			x[1][5]=10;
			x[1][6]=3;
			x[1][7]=2;
			x[1][8]=5;
			for(int i=1;i<=8;i++){
				x[2][i]=1;
			}
			for(int i=3;i<=6;i++){
				for(int j=1;j<=8;j++){
					x[i][j]=0;
				}
			}
			for(int i=1;i<=8;i++){
				x[7][i]=11;
			}
			x[8][1]=15;
			x[8][2]=12;
			x[8][3]=13;
			x[8][4]=19;
			x[8][5]=20;
			x[8][6]=13;
			x[8][7]=12;
			x[8][8]=15;
			for(int i=1;i<=8;i++){
				for(int j=1;j<=8;j++){
					history[1][i][j]=x[i][j];
					arr[i][j] = new JButton();
					arr1[i][j]= new JButton();
				}
			}

			// try {
			// 	FileInputStream fileIn = new FileInputStream("C:/Users/ADMIN/Downloads/LT-JAVA/src/chess/Save.txt");
			// 	ObjectInputStream in = new ObjectInputStream(fileIn);
			// 	int[][][] arr = (int[][][]) in.readObject();
			// 	history = arr;
			// 	h++;
			// 	in.close();
			// 	fileIn.close();
			//  } catch (IOException e) {
			// 	e.printStackTrace();
			//  } catch (ClassNotFoundException e) {
			// 	e.printStackTrace();
			//  }
			// Return();

		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
                int g = i;
                int h = j;
                arr[i][j].addActionListener(
                    e -> {
						Check.check(g, h);}
                );
				arr1[9-i][9-j].addActionListener(
                    e -> {
						Check.check(g, h);}
                );
				arr[i][j].setBorder(null);
				arr[i][j].setFocusPainted(false);
				arr[9-i][9-j].setFocusPainted(false);
				arr1[9-i][9-j].setBorder(null);
				frame.add(arr[i][j]);
				frame2.add(arr1[i][j]);

				if(a==1){
					if(j%2==0){
						arr[i][j].setBackground(Color.decode("#b16e41"));
						arr1[9-i][9-j].setBackground(Color.decode("#b16e41"));
					}else{
						arr[i][j].setBackground(Color.decode("#ffd599"));
						arr1[9-i][9-j].setBackground(Color.decode("#ffd599"));
					}
				}else{
					if(j%2==0){
						arr[i][j].setBackground(Color.decode("#ffd599"));
						arr1[9-i][9-j].setBackground(Color.decode("#ffd599"));
					}else{
						arr[i][j].setBackground(Color.decode("#b16e41"));
						arr1[9-i][9-j].setBackground(Color.decode("#b16e41"));
					}
				}
				if(x[i][j]==1){
					arr[i][j].setIcon(tot_den_icon);
					arr1[9-i][9-j].setIcon(tot_den_icon);
				}else if(x[i][j]==2){
					arr[i][j].setIcon(ma_den_icon);
					arr1[9-i][9-j].setIcon(ma_den_icon);
				}else if(x[i][j]==3){
					arr[i][j].setIcon(tuong_den_icon);
					arr1[9-i][9-j].setIcon(tuong_den_icon);
				}else if(x[i][j]==5){
					arr[i][j].setIcon(xe_den_icon);
					arr1[9-i][9-j].setIcon(xe_den_icon);
				}else if(x[i][j]==9){
					arr[i][j].setIcon(hau_den_icon);
					arr1[9-i][9-j].setIcon(hau_den_icon);
				}else if(x[i][j]==10){
					arr[i][j].setIcon(vua_den_icon);
					arr1[9-i][9-j].setIcon(vua_den_icon);
				}else if(x[i][j]==11){
					arr[i][j].setIcon(tot_trang_icon);
					arr1[9-i][9-j].setIcon(tot_trang_icon);
				}else if(x[i][j]==15){
					arr[i][j].setIcon(xe_trang_icon);
					arr1[9-i][9-j].setIcon(xe_trang_icon);
				}else if(x[i][j]==13){
					arr[i][j].setIcon(tuong_trang_icon);
					arr1[9-i][9-j].setIcon(tuong_trang_icon);
				}else if(x[i][j]==12){
					arr[i][j].setIcon(ma_trang_icon);
					arr1[9-i][9-j].setIcon(ma_trang_icon);
				}else if(x[i][j]==19){
					arr[i][j].setIcon(hau_trang_icon);
					arr1[9-i][9-j].setIcon(hau_trang_icon);
				}else if(x[i][j]==20){
					arr[i][j].setIcon(vua_trang_icon);
					arr1[9-i][9-j].setIcon(vua_trang_icon);
				}
			}
			a=-a;
		}
		
		
//    		Xuất điểm ra màn hình
		// try {
			
		// 	File file = new File("C:/Users/ADMIN/Downloads/LT-JAVA/src/chess/Save.txt");
		// 	BufferedReader br = new BufferedReader(new FileReader(file));
		// 	String line;
		// 	while ((line = br.readLine()) != null) { // Đọc từng dòng dữ liệu
		// 		System.out.println(line); // In ra màn hình
		// 	}
		// 	br.close();
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
		
		
}
public void updateLabel(JLabel label, int secondleft) {
	SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
	// Date date = new Date(secondleft * 1000);
	Date date = new Date();
	date.setTime(secondleft*100);
	label.setText(formatter.format(date));
	Font font = new Font("Serif", Font.BOLD, 30);
	label.setFont(font);
	label.setHorizontalAlignment(JLabel.CENTER);
}
public void actionPerformed(ActionEvent e) {
	
	if(luot=="trang"){
		timer1.start();
		secondleft1--;
		timer2.stop();
		frame.setBorder(BorderFactory.createLineBorder(Color.decode("#04FAD9"), 5));
		frame2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	}else{
		timer2.start();
		secondleft2--;
		timer1.stop();
		frame2.setBorder(BorderFactory.createLineBorder(Color.decode("#04FAD9"), 5));
		frame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	}
	if (secondleft1 == 0) {
		timer1.stop();
	}else if (secondleft2 == 0) {
		timer2.stop();
	}
	 else {
		updateLabel(label1,secondleft1);
		updateLabel(label2,secondleft2);
	}
	if(secondleft1==0){
		Check.Message("Đen Thắng!!!");
	}else if(secondleft2==0){
		Check.Message("Trắng Thắng!!!");
	}
}
	
}
