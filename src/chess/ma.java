package chess;

public class ma extends variable{
    public static void ma_trang_active(int a,int b){
        check2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        check2(i,j);
                    }
                }else if(x[i][j]<=10){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        check3(i,j);
                    }
                }
            }
        }
        m=-1;
        d=a;
        f=b;
    }
    public static void ma_trang_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        checked2(i,j);
                    }
                }else if(x[i][j]<=10){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        checked2(i,j);
                    }
                }
            }
        }
        m=-m;
    }
    public static void ma_trang_run(int a,int b){
        String ma[] = new String[50];
        int p = 1;
        int o = 0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0 || x[i][j]<=10){
                    if((i==d-1 && j==f-2)||(i==d+1 && j==f-2)||(i==d+2 && j==f-1)||(i==d+2 && j==f+1)||(i==d+1 && j==f+2)||(i==d-1 && j==f+2)||(i==d-2 && j==f+1)||(i==d-2 && j==f-1)){
                        ma[p] = String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }
            }
        }
        for(int i=1;i<=ma.length;i++){
            if(ma[i].equals(String.valueOf(a)+String.valueOf(b))){
                ma_trang_an(a,b);
                o=1;
                luot = "den";
                break;
            }
        }
        if(o==0){
            ma_trang_off(d,f);
        }
        
    }
    public static void ma_trang_an(int a,int b){
        arr[a][b].setIcon(ma_trang_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(ma_trang_icon);
        arr1[9-d][9-f].setIcon(null);
        ma_trang_off(d,f);
        x[a][b]=x[d][f];
        x[d][f]=0;
        check4(d,f);
        check4(a,b);
        d=0;
        f=0;
        h++;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                history[h][i][j]=x[i][j];
            }
        }
    }
    public static void ma_den_active(int a,int b){
        check2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        check2(i,j);
                    }
                }else if(x[i][j]>10){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        check3(i,j);
                    }
                }
            }
        }
        m=-1;
        d=a;
        f=b;
    }
    public static void ma_den_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        checked2(i,j);
                    }
                }else if(x[i][j]>10){
                    if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                        checked2(i,j);
                    }
                }
            }
        }
        m=-m;
    }
    public static void ma_den_run(int a,int b){
        String ma[] = new String[50];
        int p = 1;
        int o = 0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0 || x[i][j]>10){
                    if((i==d-1 && j==f-2)||(i==d+1 && j==f-2)||(i==d+2 && j==f-1)||(i==d+2 && j==f+1)||(i==d+1 && j==f+2)||(i==d-1 && j==f+2)||(i==d-2 && j==f+1)||(i==d-2 && j==f-1)){
                        ma[p] = String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }
            }
        }
        for(int i=1;i<=ma.length;i++){
            if(ma[i].equals(String.valueOf(a)+String.valueOf(b))){
                ma_den_an(a,b);
                o=1;
                luot="trang";
                break;
            }
        }
        if(o==0){
            ma_den_off(d,f);
        }
        
    }
    public static void ma_den_an(int a,int b){
        arr[a][b].setIcon(ma_den_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(ma_den_icon);
        arr1[9-d][9-f].setIcon(null);
        ma_den_off(d,f);
        x[a][b]=x[d][f];
        x[d][f]=0;
        check4(d,f);
        check4(a,b);
        d=0;
        f=0;h++;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                history[h][i][j]=x[i][j];
            }
        }
    }
    
}
