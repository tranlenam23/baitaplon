package chess;

public class xe extends variable{
    public static void xe_trang_active(int a,int b){
        check2(a,b);
        for(int i=a-1;i>=1;i--){
            if(x[i][b]==0){
                check2(i,b);
                continue;
            }else if(x[i][b]<=10){
                check3(i,b);
            }
            break;
        }
        for(int i=a+1;i<=8;i++){
            if(x[i][b]==0){
                check2(i,b);
                continue;
            }else if(x[i][b]<=10){
                check3(i,b);
            }
            break;
        }
        for(int i=b-1;i>=1;i--){
            if(x[a][i]==0){
                check2(a,i);
                continue;
            }else if(x[a][i]<=10){
                check3(a,i);
            }
            break;
        }
        for(int i=b+1;i<=8;i++){
            if(x[a][i]==0){
                check2(a,i);
                continue;
            }else if(x[a][i]<=10){
                check3(a,i);
            }
            break;
        }
        m=-m;
        d=a;
        f=b;
    }
    public static void xe_trang_off(int a,int b){
        checked2(a,b);
        for(int i=a-1;i>=1;i--){
            if(x[i][b]==0){
                checked2(i,b);
                continue;
            }else if(x[i][b]<=10){
                checked2(i,b);
            }
            break;
        }
        for(int i=a+1;i<=8;i++){
            if(x[i][b]==0){
                checked2(i,b);
                continue;
            }else if(x[i][b]<=10){
                checked2(i,b);
            }
            break;
        }
        for(int i=b-1;i>=1;i--){
            if(x[a][i]==0){
                checked2(a,i);
                continue;
            }else if(x[a][i]<=10){
                checked2(a,i);
            }
            break;
        }
        for(int i=b+1;i<=8;i++){
            if(x[a][i]==0){
                checked2(a,i);
                continue;
            }else if(x[a][i]<=10){
                checked2(a,i);
            }
            break;
        }
        m=-m;
    }
    public static void xe_trang_run(int a,int b){
        String xe[] = new String[50];
        int p = 1;
        int o = 0;
        for(int i=d-1;i>=1;i--){
            if(x[i][f]==0){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
                continue;
            }else if(x[i][f]<=10){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
            }
            break;
        }
        for(int i=d+1;i<=8;i++){
            if(x[i][f]==0){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
                continue;
            }else if(x[i][f]<=10){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
            }
            break;
        }
        for(int i=f-1;i>=1;i--){
            if(x[d][i]==0){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
                continue;
            }else if(x[d][i]<=10){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
            }
            break;
        }
        for(int i=f+1;i<=8;i++){
            if(x[d][i]==0){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
                continue;
            }else if(x[d][i]<=10){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
            }
            break;
        }
        for(int i=1;i<=xe.length;i++){
            if(xe[i].equals(String.valueOf(a)+String.valueOf(b))){
                xe_trang_an(a,b);
                o=1;
                luot = "den";
                break;
            }
        }
        if(o==0){
                xe_trang_off(d,f);
        }
        
    }
    public static void xe_trang_an(int a,int b){
        arr[a][b].setIcon(xe_trang_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(xe_trang_icon);
        arr1[9-d][9-f].setIcon(null);
        xe_trang_off(d,f);
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

    public static void xe_den_active(int a,int b){
        check2(a,b);
        for(int i=a-1;i>=1;i--){
            if(x[i][b]==0){
                check2(i,b);
                continue;
            }else if(x[i][b]>10){
                check3(i,b);
            }
            break;
        }
        for(int i=a+1;i<=8;i++){
            if(x[i][b]==0){
                check2(i,b);
                continue;
            }else if(x[i][b]>10){
                check3(i,b);
            }
            break;
        }
        for(int i=b-1;i>=1;i--){
            if(x[a][i]==0){
                check2(a,i);
                continue;
            }else if(x[a][i]>10){
                check3(a,i);
            }
            break;
        }
        for(int i=b+1;i<=8;i++){
            if(x[a][i]==0){
                check2(a,i);
                continue;
            }else if(x[a][i]>10){
                check3(a,i);
            }
            break;
        }
        m=-m;
        d=a;
        f=b;
    }
    public static void xe_den_off(int a, int b){
        checked2(a,b);
        for(int i=a-1;i>=1;i--){
            if(x[i][b]==0){
                checked2(i,b);
                continue;
            }else if(x[i][b]>10){
                checked2(i,b);
            }
            break;
        }
        for(int i=a+1;i<=8;i++){
            if(x[i][b]==0){
                checked2(i,b);
                continue;
            }else if(x[i][b]>10){
                checked2(i,b);
            }
            break;
        }
        for(int i=b-1;i>=1;i--){
            if(x[a][i]==0){
                checked2(a,i);
                continue;
            }else if(x[a][i]>10){
                checked2(a,i);
            }
            break;
        }
        for(int i=b+1;i<=8;i++){
            if(x[a][i]==0){
                checked2(a,i);
                continue;
            }else if(x[a][i]>10){
                checked2(a,i);
            }
            break;
        }
        m=-m;
    }
    public static void xe_den_run(int a,int b){
        String xe[] = new String[50];
        int p = 1;
        int o = 0;
        for(int i=d-1;i>=1;i--){
            if(x[i][f]==0){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
                continue;
            }else if(x[i][f]>10){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
            }
            break;
        }
        for(int i=d+1;i<=8;i++){
            if(x[i][f]==0){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
                continue;
            }else if(x[i][f]>10){
                xe[p]=String.valueOf(i)+String.valueOf(f);
                p++;
            }
            break;
        }
        for(int i=f-1;i>=1;i--){
            if(x[d][i]==0){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
                continue;
            }else if(x[d][i]>10){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
            }
            break;
        }
        for(int i=f+1;i<=8;i++){
            if(x[d][i]==0){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
                continue;
            }else if(x[d][i]>10){
                xe[p]=String.valueOf(d)+String.valueOf(i);
                p++;
            }
            break;
        }
        for(int i=1;i<=xe.length;i++){
            if(xe[i].equals(String.valueOf(a)+String.valueOf(b))){
                xe_den_an(a,b);
                o=1;
                luot="trang";
                break;
            }
        }
        if(o==0){
                xe_den_off(d,f);
        }
        
    }
    public static void xe_den_an(int a,int b){
        arr[a][b].setIcon(xe_den_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(xe_den_icon);
        arr1[9-d][9-f].setIcon(null);
        xe_den_off(d,f);
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
