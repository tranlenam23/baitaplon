package chess;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class variable {
    public static int m=1;
    public static int d;
    public static int f;
    public static int h =1;
    public static int x[][]= new int[9][9];
    public static JButton arr[][] = new JButton[10][9];
    public static JButton arr1[][] = new JButton[10][9];
    public static int history[][][] = new int[1000][9][9];
    public static int secondleft1;
    public static int secondleft2;
    
	public static void check2(int a, int b){
        arr[a][b].setBackground(Color.decode("#d4a354"));
        arr1[9-a][9-b].setBackground(Color.decode("#d4a354"));
    }
    public static void check3(int a, int b){
        arr[a][b].setBackground(Color.decode("#ad2c2c"));
        arr1[9-a][9-b].setBackground(Color.decode("#ad2c2c"));
    }
    public static void check4(int a,int b){
        arr[a][b].setBackground(Color.decode("#b4ad2c"));
        arr1[9-a][9-b].setBackground(Color.decode("#b4ad2c"));
    }
    
    public static void checked2(int a, int b){
        
        int c = 1;
        for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				if(c==1){
					if(j%2==0){
						if(a==i && b==j){
                            arr[i][j].setBackground(Color.decode("#b16e41"));
                            arr1[9-i][9-j].setBackground(Color.decode("#b16e41"));
                            return;
                        }
					}else{
                        if(a==i && b==j){
                            arr[i][j].setBackground(Color.decode("#ffd599"));
                            arr1[9-i][9-j].setBackground(Color.decode("#ffd599"));
                            return;
                        }
					}
				}else{
					if(j%2==0){
						if(a==i && b==j){
                            arr[i][j].setBackground(Color.decode("#ffd599"));
                            arr1[9-i][9-j].setBackground(Color.decode("#ffd599"));
                            return;
                        }
					}else{
						if(a==i && b==j){
                            arr[i][j].setBackground(Color.decode("#b16e41"));
                            arr1[9-i][9-j].setBackground(Color.decode("#b16e41"));
                            return;
                        }
					}
				}
			}
			c=-c;
		}
    }
    public static void Return(){
        if(h==1){
            return;
        }
        h--;
        if(luot=="den"){
            luot="trang";
        }else{
            luot="den";
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
                arr[i][j].setIcon(null);
                arr1[9-i][9-j].setIcon(null);
                x[i][j] = history[h][i][j];
                switch(x[i][j]){
                    case 1: arr[i][j].setIcon(tot_den_icon);
                            arr1[9-i][9-j].setIcon(tot_den_icon);   
                            continue;
                    case 5: arr[i][j].setIcon(xe_den_icon);
                            arr1[9-i][9-j].setIcon(xe_den_icon);
                            continue;
                    case 2: arr[i][j].setIcon(ma_den_icon);
                            arr1[9-i][9-j].setIcon(ma_den_icon);
                            continue;
                    case 3: arr[i][j].setIcon(tuong_den_icon);
                            arr1[9-i][9-j].setIcon(tuong_den_icon);
                            continue;
                    case 9: arr[i][j].setIcon(hau_den_icon);
                            arr1[9-i][9-j].setIcon(hau_den_icon);
                            continue;
                    case 10: arr[i][j].setIcon(vua_den_icon);
                             arr1[9-i][9-j].setIcon(vua_den_icon);
                            continue;
                    case 11: arr[i][j].setIcon(tot_trang_icon);
                             arr1[9-i][9-j].setIcon(tot_trang_icon);
                            continue;
                    case 15: arr[i][j].setIcon(xe_trang_icon);
                             arr1[9-i][9-j].setIcon(xe_trang_icon);
                            continue;
                    case 12: arr[i][j].setIcon(ma_trang_icon);
                             arr1[9-i][9-j].setIcon(ma_trang_icon);
                            continue;
                    case 13: arr[i][j].setIcon(tuong_trang_icon);
                             arr1[9-i][9-j].setIcon(tuong_trang_icon);
                            continue;
                    case 19: arr[i][j].setIcon(hau_trang_icon);
                             arr1[9-i][9-j].setIcon(hau_trang_icon);
                            continue;
                    case 20: arr[i][j].setIcon(vua_trang_icon);
                             arr1[9-i][9-j].setIcon(vua_trang_icon);
                            continue;
                }
            }
            p=-p;
        }
        m=1;
    
    }
    public static String luot= "trang";
    	static Icon hau_trang_icon = new ImageIcon("src/chess/Assets/hau_trang.png");
		static Icon vua_trang_icon = new ImageIcon("src/chess/Assets/vua_trang.png");
		static Icon tuong_trang_icon = new ImageIcon("src/chess/Assets/tuong_trang.png");
		static Icon ma_trang_icon = new ImageIcon("src/chess/Assets/ma_trang.png");
		static Icon xe_trang_icon = new ImageIcon("src/chess/Assets/xe_trang.png");
		static Icon tot_trang_icon = new ImageIcon("src/chess/Assets/tot_trang.png");
		static Icon hau_den_icon = new ImageIcon("src/chess/Assets/hau_den.png");
		static Icon vua_den_icon = new ImageIcon("src/chess/Assets/vua_den.png");
		static Icon tuong_den_icon = new ImageIcon("src/chess/Assets/tuong_den.png");
		static Icon ma_den_icon = new ImageIcon("src/chess/Assets/ma_den.png");
		static Icon xe_den_icon = new ImageIcon("src/chess/Assets/xe_den.png");
		static Icon tot_den_icon = new ImageIcon("src/chess/Assets/tot_den.png");
        static Icon RETURN = new ImageIcon("src/chess/Assets/RETURN.png");
        static Icon Pause = new ImageIcon("src/chess/Assets/pause.png");
        static Icon Continue = new ImageIcon("src/chess/Assets/continue.png");
        static Icon Swap = new ImageIcon("src/chess/Assets/swap.png");
        static Icon newGame = new ImageIcon("src/chess/Assets/newGame.png");
    }
