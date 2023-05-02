package chess;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
public class Check extends variable{
    
    
    public static void nhapthanh(int a,int b){
        if(d==1 && f==5 && a==1 && b==1){
            arr[a][b].setIcon(null);
            arr[d][f].setIcon(null);
            arr[1][2].setIcon(vua_den_icon);
            arr[1][3].setIcon(xe_den_icon);

            arr1[9-a][9-b].setIcon(null);
            arr1[9-d][9-f].setIcon(null);
            arr1[9-1][9-2].setIcon(vua_den_icon);
            arr1[9-1][9-3].setIcon(xe_den_icon);
                    vua.vua_den_off(d,f);
                    x[1][2]=10;
                    x[1][3]=5;
                    x[1][1]=0;
                    x[1][5]=0;
                    luot="trang";
        }else if(d==1 && f==5 && a==1 && b==8){
            arr[a][b].setIcon(null);
            arr[d][f].setIcon(null);
            arr[1][7].setIcon(vua_den_icon);
            arr[1][6].setIcon(xe_den_icon);

            arr1[9-a][9-b].setIcon(null);
            arr1[9-d][9-f].setIcon(null);
            arr1[9-1][9-7].setIcon(vua_den_icon);
            arr1[9-1][9-6].setIcon(xe_den_icon);
                    vua.vua_den_off(d,f);
                    x[1][7]=10;
                    x[1][6]=5;
                    x[1][5]=0;
                    x[1][8]=0;
                    luot="trang";
        }
        else if(d==8 && f==5 && a==8 && b==8){
            arr[a][b].setIcon(null);
            arr[d][f].setIcon(null);
            arr[8][7].setIcon(vua_trang_icon);
            arr[8][6].setIcon(xe_trang_icon);

            arr1[9-a][9-b].setIcon(null);
            arr1[9-d][9-f].setIcon(null);
            arr1[9-8][9-7].setIcon(vua_trang_icon);
            arr1[9-8][9-6].setIcon(xe_trang_icon);
                    vua.vua_trang_off(d,f);
                    x[8][7]=20;
                    x[8][6]=15;
                    x[8][5]=0;
                    x[8][8]=0;
                     luot="den";
        }else if(d==8 && f==5 && a==8 && b==1){
            arr[a][b].setIcon(null);
            arr[d][f].setIcon(null);
            arr[8][2].setIcon(vua_trang_icon);
            arr[8][3].setIcon(xe_trang_icon);

            arr1[9-a][9-b].setIcon(null);
            arr1[9-d][9-f].setIcon(null);
            arr1[9-8][9-2].setIcon(vua_trang_icon);
            arr1[9-8][9-3].setIcon(xe_trang_icon);
                    vua.vua_trang_off(d,f);
                    x[8][2]=20;
                    x[8][3]=15;
                    x[8][1]=0;
                    x[8][5]=0;
                     luot="den";
        }
        check4(d,f);
        check4(a,b);
        d=0;
        f=0;
    }
    
    public static void check(int a,int b){
        if(luot=="trang"){
            if(m==1 && (x[a][b]==0 || x[a][b]<=10)){
                return;
            }
            int p=1;
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(p==1){
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
                }
                p=-p;
            }
            if(m==-1 && x[a][b]>10 && x[d][f]>10){
                if(a==d && b==f){
                    switch(x[a][b]){
                        case 11: tot.tot_trang_off(a,b);
                        return;
                        case 12: ma.ma_trang_off(a,b);
                        return;
                        case 13: tuong.tuong_trang_off(a,b);
                        return;
                        case 15: xe.xe_trang_off(a,b);
                        return;
                        case 19: hau.hau_trang_off(a,b);
                        return;
                        case 20: vua.vua_trang_off(a,b);
                        return;
                    }
                }else{
                    switch(x[a][b]){
                        case 11: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                            case 20: vua.vua_trang_off(d,f);
                            tot.tot_trang_active(a,b);
                                    break;
                        }
                        break;
                        case 12: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                            case 20: vua.vua_trang_off(d,f);
                                    ma.ma_trang_active(a,b);
                                    break;
                        }
                        break;
                        case 13: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                            case 20: vua.vua_trang_off(d,f);
                                    tuong.tuong_trang_active(a,b);
                                    break;
                        }
                        break;
                        case 15: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                                    xe.xe_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                                    xe.xe_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                                    xe.xe_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                                    xe.xe_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                                    xe.xe_trang_active(a,b);
                                    break;
                            case 20: if((x[8][2]==0 && x[8][3]==0 && x[8][4]==0 && b==1 && a==8) || (x[8][6]==0 && x[8][7]==0 && a==8 && b==8)){
                                        nhapthanh(a,b);
                                    }else{
                                        vua.vua_trang_off(d,f);
                                        xe.xe_trang_active(a,b);
                                    }
                                    break;
                        }
                        break;
                        case 19: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                            case 20: vua.vua_trang_off(d,f);
                                    hau.hau_trang_active(a,b);
                                    break;
                        }
                        break;
                        case 20: switch(x[d][f]){
                            case 11: tot.tot_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                            case 12: ma.ma_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                            case 13: tuong.tuong_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                            case 15: xe.xe_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                            case 19: hau.hau_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                            case 20: vua.vua_trang_off(d,f);
                                    vua.vua_trang_active(a,b);
                                    break;
                        }
                        break;
                    }
                }
                
            }
            if(x[a][b]==11){
                if(m==1){
                    tot.tot_trang_active(a,b);
                }
            }
            else if(x[a][b]==0 || x[a][b]<=10){
                if(m==-1 && x[d][f]==11){
                    tot.tot_trang_run(a,b);
                }else if(m==-1 && x[d][f]==15){
                    xe.xe_trang_run(a,b);
                }else if(m==-1 && x[d][f]==12){
                    ma.ma_trang_run(a,b);
                }else if(m==-1 && x[d][f]==13){
                    tuong.tuong_trang_run(a,b);
                }else if(m==-1 && x[d][f]==19){
                    hau.hau_trang_run(a,b);
                }else if(m==-1 && x[d][f]==20){
                    vua.vua_trang_run(a,b);
                    return;
                }
                int t[][]=vua.chieutuong_trang();
                for(int i=1;i<=8;i++){
                    for(int j=1;j<=8;j++){
                        if((t[i][j]==1 && x[i][j]==20)){
                            Return();
                        }
                    }
                }
                playSound();
            }else if(x[a][b]==15){
                if(m==1){
                    xe.xe_trang_active(a,b);
                }
            }else if(x[a][b]==12){
                if(m==1){
                    ma.ma_trang_active(a,b);
                }
            }else if(x[a][b]==13){
                if(m==1){
                    tuong.tuong_trang_active(a,b);
                }
            }else if(x[a][b]==19){
                if(m==1){
                    hau.hau_trang_active(a,b);
                }
            }else if(x[a][b]==20){
                if(m==1){
                    vua.vua_trang_active(a,b);
                }
            }
            
            for(int i=1;i<=8;i++){
                if(x[1][i]==11){
                    arr[1][i].setIcon(hau_trang_icon);
                    arr1[9-1][9-i].setIcon(hau_trang_icon);
                    x[1][i]=19;
                }
            }
            int t[][]=vua.chieutuong_den();
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if((t[i][j]==1 && x[i][j]==10)){
                        check3(i,j);
                        if(vua.chieuhet_den()==0){
                            Message("Trắng Thắng!!!");
                        }
                    }
                }
            }
        }else if(luot == "den") {
            if(m==1 && (x[a][b]==0 || x[a][b]>10)){
                return;
            }
            int p=1;
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(p==1){
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
                }
                p=-p;
            }
            if(m==-1 && x[a][b]>0 && x[a][b]<=10 && x[d][f]>0 && x[d][f]<=10){
                if(a==d && b==f){
                    switch(x[a][b]){
                        case 1: tot.tot_den_off(a,b);
                        return;
                        case 2: ma.ma_den_off(a,b);
                        return;
                        case 3: tuong.tuong_den_off(a,b);
                        return;
                        case 5: xe.xe_den_off(a,b);
                        return;
                        case 9: hau.hau_den_off(a,b);
                        return;
                        case 10: vua.vua_den_off(a,b);
                        return;
                    }
                }else{
                    switch(x[a][b]){
                        case 1: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                            case 10: vua.vua_den_off(d,f);
                                    tot.tot_den_active(a,b);
                                    break;
                        }
                        break;
                        case 2: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                            case 10: vua.vua_den_off(d,f);
                                    ma.ma_den_active(a,b);
                                    break;
                        }
                        break;
                        case 3: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                            case 10: vua.vua_den_off(d,f);
                                    tuong.tuong_den_active(a,b);
                                    break;
                        }
                        break;
                        case 5: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    xe.xe_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    xe.xe_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    xe.xe_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    xe.xe_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    xe.xe_den_active(a,b);
                                    break;
                            case 10: if((x[1][2]==0 && x[1][3]==0 && x[1][4]==0 && b==1 && a==1) || (x[1][6]==0 && x[1][7]==0 && a==1 && b==8)){
                                        nhapthanh(a,b);
                                    }else{
                                        vua.vua_den_off(d,f);
                                        xe.xe_den_active(a,b);
                                    }
                                    break;
                        }
                        break;
                        case 9: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                            case 10: vua.vua_den_off(d,f);
                                    hau.hau_den_active(a,b);
                                    break;
                        }
                        break;
                        case 10: switch(x[d][f]){
                            case 1: tot.tot_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                            case 2: ma.ma_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                            case 3: tuong.tuong_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                            case 5: xe.xe_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                            case 9: hau.hau_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                            case 10: vua.vua_den_off(d,f);
                                    vua.vua_den_active(a,b);
                                    break;
                        }
                        break;
                    }
                }
                
            }
            if(x[a][b]==1){
                if(m==1){
                    tot.tot_den_active(a,b);
                }
            }
            else if(x[a][b]==0 || x[a][b]>10){
                if(m==-1 && x[d][f]==1){
                    tot.tot_den_run(a,b);
                }else if(m==-1 && x[d][f]==5){
                    xe.xe_den_run(a,b);
                }else if(m==-1 && x[d][f]==2){
                    ma.ma_den_run(a,b);
                }else if(m==-1 && x[d][f]==3){
                    tuong.tuong_den_run(a,b);
                }else if(m==-1 && x[d][f]==9){
                    hau.hau_den_run(a,b);
                }else if(m==-1 && x[d][f]==10){
                    vua.vua_den_run(a,b);
                    return;
                }
                int t[][]=vua.chieutuong_den();
                for(int i=1;i<=8;i++){
                    for(int j=1;j<=8;j++){
                        if((t[i][j]==1 && x[i][j]==10)){
                            Return();
                        }
                    }
                }
                playSound();
            }else if(x[a][b]==5){
                if(m==1){
                    xe.xe_den_active(a,b);
                }
            }else if(x[a][b]==2){
                if(m==1){
                    ma.ma_den_active(a,b);
                }
            }else if(x[a][b]==3){
                if(m==1){
                    tuong.tuong_den_active(a,b);
                }
            }else if(x[a][b]==9){
                if(m==1){
                    hau.hau_den_active(a,b);
                }
            }else if(x[a][b]==10){
                if(m==1){
                    vua.vua_den_active(a,b);
                }
            }
            
            for(int i=1;i<=8;i++){
                if(x[8][i]==1){
                    arr[8][i].setIcon(hau_den_icon);
                    arr1[9-8][9-i].setIcon(hau_den_icon);
                    x[8][i]=9;
                }
            }
        }
        int v[][]=vua.chieutuong_trang();
    for(int i=1;i<=8;i++){
        for(int j=1;j<=8;j++){
            if(v[i][j]==1 && x[i][j]==20){
                check3(i,j);
                if(vua.chieuhet_trang()==0){
                    // JOptionPane.showMessageDialog(null, "Đen Thắng!!!");
                    Message("Đen Thắng!!!");
                }
            }
        }
    }
    }
public static void Message(String string){
            JOptionPane optionPane = new JOptionPane(string + "  Chơi Lại?", JOptionPane.INFORMATION_MESSAGE);

            // Thêm nút YES và gắn hàm vào nút đó
            optionPane.setOptionType(JOptionPane.OK_OPTION);
            optionPane.addPropertyChangeListener(e -> {
            String prop = e.getPropertyName();
            if (e.getSource() == optionPane && prop.equals(JOptionPane.VALUE_PROPERTY)) {
            if (e.getNewValue() instanceof Integer && (Integer) e.getNewValue() == JOptionPane.OK_OPTION) {
            // Gọi hàm khi người dùng click vào nút YES
                h = 2;
                Return();
                luot="trang";
                secondleft1 = 6000;
                secondleft2 = 6000;
            }
            if (e.getNewValue() instanceof Integer && (Integer) e.getNewValue() == JOptionPane.NO_OPTION) {
                // Gọi hàm khi người dùng click vào nút NO
                    
                }
            }
            });
            optionPane.createDialog(null, "Kết Thúc Ván Đấu").setVisible(true);
}
    public static void playSound(){
        try {
            File audioFile = new File("src/chess/Assets/sound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public static void WriteFIle(){
    //     // try {
            
	// 	// 	FileWriter writer = new FileWriter("src/chess/Save.txt");

	// 	// 	for(int k=1;k<=h;k++){
				
	// 	// 		for(int i=1;i<=8;i++){
	// 	// 			for(int j=1;j<=8;j++){
	// 	// 				writer.write(String.valueOf(history[k][i][j])+" ");
	// 	// 			}
	// 	// 		}
	// 	// 		writer.write("\n");

	// 	// 	}
	// 	// 	// writer.write("Point: "+getDiem() + System.getProperty("line.separator")); // Ghi dữ liệu vào file
	// 	// 	// writer.write("Date: " + inNgayGio+System.getProperty("line.separator")+System.getProperty("line.separator"));
	// 	// 	writer.close();
	// 	// } catch (IOException e) {
	// 	// 	e.printStackTrace();
	// 	// }
    //     try {
    //         // Lưu mảng vào tệp tin
            
    //         FileOutputStream fileOut = new FileOutputStream("src/chess/Save.txt");
    //         ObjectOutputStream out = new ObjectOutputStream(fileOut);
    //         out.writeObject(history);
    //         out.close();
    //         fileOut.close();
    //      } catch (IOException e) {
    //         e.printStackTrace();
    //      }

    // }
}
