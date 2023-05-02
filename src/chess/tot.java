package chess;

public class tot extends variable{
    public static void tot_trang_active(int a,int b){
        check2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if(a==7 && ((i==a-1 && j==b) || (i==a-2 && j==b))){
                        check2(i,j);
                    }else if(a!=7 && i==a-1 && j==b){
                        check2(i,j);
                    }
                }else if(x[i][j]<=10){
                    if((i==a-1 && j==b-1)||(i==a-1 && j==b+1)){
                        check3(i,j);
                    }
                }
            }
        }
        m=-1;
        d=a;
        f=b;
    }
        public static void tot_trang_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if(a==7 && ((i==a-1 && j==b) || (i==a-2 && j==b))){
                        checked2(i,j);
                    }else if(a!=7 && i==a-1 && j==b){
                        checked2(i,j);
                    }
                }else if(x[i][j]<=10){
                    if((i==a-1 && j==b-1)||(i==a-1 && j==b+1)){
                        checked2(i,j);
                    }
                }
            }
        }
        m=-m;
    }
        public static void tot_trang_run(int a,int b){
            String tot[] = new String[50];
            int p=1;
            int o=0;
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(x[i][j]==0){
                        if(d==7 && ((i==d-1 && j==f) || (i==d-2 && j==f))){
                            tot[p] = String.valueOf(i)+String.valueOf(j);
                            p++;
                        }else if(d!=7 && i==d-1 && j==f){
                            tot[p] = String.valueOf(i)+String.valueOf(j);
                            p++;
                        }
                    }else if(x[i][j]<=10){
                        if((i==d-1 && j==f-1)||(i==d-1 && j==f+1)){
                            tot[p] = String.valueOf(i)+String.valueOf(j);
                            p++;
                        }
                    }
                }
            }
            for(int i=1;i<=tot.length;i++){
                if(tot[i].equals(String.valueOf(a)+String.valueOf(b))){
                    tot_trang_an(a,b);
                    o=1;
                    luot = "den";
                    break;
                }
            }
                if(o==0){
                    tot_trang_off(d,f);
                }
                
        }
        public static void tot_trang_an(int a,int b){
            arr[a][b].setIcon(tot_trang_icon);
            arr[d][f].setIcon(null);
            arr1[9-a][9-b].setIcon(tot_trang_icon);
            arr1[9-d][9-f].setIcon(null);
            tot_trang_off(d,f);
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

    public static void tot_den_active(int a, int b){
        check2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if(a==2 && ((i==a+1 && j==b) || (i==a+2 && j==b))){
                        check2(i,j);
                    }else if(a!=2 && i==a+1 && j==b){
                        check2(i,j);
                    }
                }else if(x[i][j]>10){
                    if((i==a+1 && j==b-1)||(i==a+1 && j==b+1)){
                        check3(i,j);
                    }
                }
            }
        }
        m=-1;
        d=a;
        f=b;
    }
    public static void tot_den_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if(a==2 && ((i==a+1 && j==b) || (i==a+2 && j==b))){
                        checked2(i,j);
                    }else if(a!=2 && i==a+1 && j==b){
                        checked2(i,j);
                    }
                }else if(x[i][j]>10){
                    if((i==a+1 && j==b-1)||(i==a+1 && j==b+1)){
                        checked2(i,j);
                    }
                }
            }
        }
            m=-m;
    }
    public static void tot_den_run(int a, int b){
        String tot[] = new String[50];
        int p=1;
        int o=0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if(d==2 && ((i==d+1 && j==f) || (i==d+2 && j==f))){
                        tot[p] = String.valueOf(i)+String.valueOf(j);
                        p++;
                    }else if(d!=2 && i==d+1 && j==f){
                        tot[p] = String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }else if(x[i][j]>10){
                    if((i==d+1 && j==f-1)||(i==d+1 && j==f+1)){
                        tot[p] = String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }
            }
        }
        for(int i=1;i<=tot.length;i++){
            if(tot[i].equals(String.valueOf(a)+String.valueOf(b))){
                tot_den_an(a,b);
                luot="trang";
                o=1;
                break;
            }
        }
        if(o==0){
            tot_den_off(d,f);
        }
        
    }
    public static void tot_den_an(int a,int b){
        arr[a][b].setIcon(tot_den_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(tot_den_icon);
        arr1[9-d][9-f].setIcon(null);
        tot_den_off(d,f);
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
   
}
