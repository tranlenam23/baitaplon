package chess;

public class vua extends variable{
    public static void vua_trang_active(int a,int b){
        check2(a,b);
        int u[][] = chieutuong_trang();
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0 && u[i][j]!=1){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        check2(i,j);
                    }
                }else if(x[i][j]<=10 && x[i][j]>0 && u[i][j]!=1){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        check3(i,j);
                    }
                }
            }
        }
        if(a==8 && b==5 && x[8][1]==15 && x[8][2]==0 && x[8][3]==0 && x[8][4]==0){
            check3(8,1);
        }
        if(a==8 && b==5 && x[8][8]==15 && x[8][6]==0 && x[8][7]==0){
            check3(8,8);
        }
        m=-1;
        d=a;
        f=b;
    }
    public static void vua_trang_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        checked2(i,j);
                    }
                }else if(x[i][j]<=10){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        checked2(i,j);
                    }
                }
            }
        }
        if(a==8 && b==5 && x[8][1]==15 && x[8][2]==0 && x[8][3]==0 && x[8][4]==0){
            checked2(8,1);
        }
        if(a==8 && b==5 && x[8][8]==15 && x[8][6]==0 && x[8][7]==0){
            checked2(8,8);
        }
        m=-m;
    }
    public static void vua_trang_run(int a,int b){
        int u[][]= chieutuong_trang();
        String vua[] = new String[10];
        int p = 1;
        int o = 0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if((x[i][j]==0 || x[i][j]<=10) && u[i][j]!=1){
                    if((i==d-1 && j==f-1)||(i==d && j==f-1)||(i==d+1 && j==f-1)||(i==d+1 && j==f)||(i==d+1 && j==f+1)||(i==d && j==f+1)||(i==d-1 && j==f+1)||(i==d-1 && j==f)){
                        vua[p]=String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }
            }
        }
        for(int i=1;i<=vua.length;i++){
            try{
                if(vua[i].equals(String.valueOf(a)+String.valueOf(b))){
                    vua_trang_an(a,b);
                    o=1;
                    luot = "den";
                    break;
                }
            }catch(Exception e){
            }
            
        }
        if(o==0){
            vua_trang_off(d,f);
        }
    }
    public static void vua_trang_an(int a,int b){
        arr[a][b].setIcon(vua_trang_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(vua_trang_icon);
        arr1[9-d][9-f].setIcon(null);
        vua_trang_off(d,f);
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
    public static int[][] chieutuong_trang(){
        int u[][] = new int[10][10];
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==1){
                    u[i+1][j-1]=1;
                    u[i+1][j+1]=1;
                }else if(x[i][j]==5){
                    for(int k=i-1;k>=1;k--){
                        if(x[k][j]==0 || x[k][j]==20){
                            u[k][j]=1;
                            continue;
                        }else if(x[k][j]<10){
                            u[k][j]=1;
                        }
                        break;
                    }
                    for(int k=i+1;k<=8;k++){
                        if(x[k][j]==0|| x[k][j]==20){
                            u[k][j]=1;
                            continue;
                        }else if(x[k][j]<10){
                            u[k][j]=1;
                        }
                        break;
                    }
                    for(int k=j-1;k>=1;k--){
                        if(x[i][k]==0|| x[i][k]==20){
                            u[i][k]=1;
                            continue;
                        }else if(x[i][k]<10){
                            u[i][k]=1;
                        }
                        break;
                    }
                    for(int k=j+1;k<=8;k++){
                        if(x[i][k]==0 || x[i][k]==20){
                            u[i][k]=1;
                            continue;
                        }else if(x[i][k]<10){
                            u[i][k]=1;
                        }
                        break;
                    }
                }else if(x[i][j]==2){
                    for(int k=1;k<=8;k++){
                        for(int l=1;l<=8;l++){
                            if(x[k][l]==0 || x[k][l]==20 || x[k][l]<10){
                                if((k==i-1 && l==j-2)||(k==i+1 && l==j-2)||(k==i+2 && l==j-1)||(k==i+2 && l==j+1)||(k==i+1 && l==j+2)||(k==i-1 && l==j+2)||(k==i-2 && l==j+1)||(k==i-2 && l==j-1)){
                                    u[k][l]=1;
                                }
                            }
                        }
                    }
                }else if(x[i][j]==3){
                    for(int k=1;k<=8;k++){
                        if(i-k>0 && j-k>0){
                            if(x[i-k][j-k]==0 || x[i-k][j-k]==20){
                                u[i-k][j-k]=1;
                                continue;
                            }else if(x[i-k][j-k]<10){
                                u[i-k][j-k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i+k<=8 && j+k<=8){
                            if(x[i+k][j+k]==0 || x[i+k][j+k]==20){
                                u[i+k][j+k]=1;
                                continue;
                            }else if(x[i+k][j+k]<10){
                                u[i+k][j+k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i-k>0 && j+k<=8){
                            if(x[i-k][j+k]==0|| x[i-k][j+k]==20){
                                u[i-k][j+k]=1;
                                continue;
                            }else if(x[i-k][j+k] <10 ){
                                u[i-k][j+k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i+k<=8 && j-k>0){
                            if(x[i+k][j-k]==0|| x[i+k][j-k]==20){
                                u[i+k][j-k]=1;
                                continue;
                            }else if(x[i+k][j-k]<10 ){
                                u[i+k][j-k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if(x[i][j]==9){
                    for(int k=i-1;k>=1;k--){
                        if(x[k][j]==0 || x[k][j]==20 ){
                            u[k][j]=1;
                            continue;
                        }else if(x[k][j]<10 ){
                            u[k][j]=1;
                        }
                        break;
                    }
                    for(int k=i+1;k<=8;k++){
                        if(x[k][j]==0 || x[k][j]==20){
                            u[k][j]=1;
                            continue;
                        }else if(x[k][j]<10 ){
                            u[k][j]=1;
                        }
                        break;
                    }
                    for(int k=j-1;k>=1;k--){
                        if(x[i][k]==0|| x[i][k]==20){
                            u[i][k]=1;
                            continue;
                        }else if(x[i][k]<10 ){
                            u[i][k]=1;
                        }
                        break;
                    }
                    for(int k=j+1;k<=8;k++){
                        if(x[i][k]==0 || x[i][k]==20){
                            u[i][k]=1;
                            continue;
                        }else if(x[i][k]<10){
                            u[i][k]=1;
                        }
                        break;
                    }
                    // tuong
                    for(int k=1;k<=8;k++){
                        if(i-k>0 && j-k>0){
                            if(x[i-k][j-k]==0|| x[i-k][j-k]==20){
                                u[i-k][j-k]=1;
                                continue;
                            }else if(x[i-k][j-k]<10 ){
                                u[i-k][j-k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i+k<=8 && j+k<=8){
                            if(x[i+k][j+k]==0 || x[i+k][j+k]==20){
                                u[i+k][j+k]=1;
                                continue;
                            }else if(x[i+k][j+k]<10){
                                u[i+k][j+k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i-k>0 && j+k<=8){
                            if(x[i-k][j+k]==0 || x[i-k][j+k]==20){
                                u[i-k][j+k]=1;
                                continue;
                            }else if(x[i-k][j+k]<10){
                                u[i-k][j+k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int k=1;k<=8;k++){
                        if(i+k<=8 && j-k>0){
                            if(x[i+k][j-k]==0 || x[i+k][j-k]==20){
                                u[i+k][j-k]=1;
                                continue;
                            }else if(x[i+k][j-k]<10 ){
                                u[i+k][j-k]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if(x[i][j]==10){
                    for(int k=1;k<=8;k++){
                        for(int l=1;l<=8;l++){
                            if(x[k][l]==0  || x[k][l]==20 || x[k][l]<10){
                                if((k==i-1 && l==j-1)||(k==i && l==j-1)||(k==i+1 && l==j-1)||(k==i+1 && l==j)||(k==i+1 && l==j+1)||(k==i && l==j+1)||(k==i-1 && l==j+1)||(k==i-1 && l==j)){
                                    u[k][l]=1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return u;
    }

    public static int chieuhet_trang(){
        int u[][] = new int[10][10];
        int e=1;
        int r=1;
        for(int a=1;a<=8;a++){
            for(int b=1;b<=8;b++){
                if(x[a][b]==11){
                    if(a==7){
                        if(x[a-1][b]==0){
                            u[a-1][b]=3;
                            if(x[a-2][b]==0){
                                u[a-2][b]=3;
                            }
                        }
                        
                    }else{
                        if(x[a-1][b]==0){
                            u[a-1][b]=3;
                        }
                    }
                    if(u[a-1][b-1]!=3){
                        u[a-1][b-1]=2;
                    }
                    if(u[a-1][b+1]!=3){
                        u[a-1][b+1]=2;
                    }
                }else if(x[a][b]==15){
                    for(int i=a-1;i>=1;i--){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else{
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=a+1;i<=8;i++){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else{
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=b-1;i>=1;i--){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else{
                            u[a][i]=1;
                        }
                        break;
                    }
                    for(int i=b+1;i<=8;i++){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else{
                            u[a][i]=1;
                        }
                        break;
                    }
                }else if(x[a][b]==12){
                    for(int i=1;i<=8;i++){
                        for(int j=1;j<=8;j++){
                                if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                                    u[i][j]=1;
                                }
                        }
                    }
                }else if(x[a][b]==13){
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b-i>0){
                            if(x[a-i][b-i]==0 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                                continue;
                            }else{
                                u[a-i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b+i<=8){
                            if(x[a+i][b+i]==0 || x[a+i][b+i]==10){
                                u[a+1][b+i]=1;
                                continue;
                            }else{
                                u[a+1][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b+i<=8){
                            if(x[a-i][b+i]==0 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                                continue;
                            }else{
                                u[a-i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b-i>0){
                            if(x[a+i][b-i]==0 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                                continue;
                            }else{
                                u[a+i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if(x[a][b]==19){
                    for(int i=a-1;i>=1;i--){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else{
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=a+1;i<=8;i++){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else{
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=b-1;i>=1;i--){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else{
                            u[a][i]=1;
                        }
                        break;
                    }
                    for(int i=b+1;i<=8;i++){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else{
                            u[a][i]=1;
                        }
                        break;
                    }
                    // tuong
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b-i>0){
                            if(x[a-i][b-i]==0 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                                continue;
                            }else{
                                u[a-i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b+i<=8){
                            if(x[a+i][b+i]==0 || x[a+i][b+i]==10){
                                u[a+i][b+i]=1;
                                continue;
                            }else{
                                u[a+i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b+i<=8){
                            if(x[a-i][b+i]==0 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                                continue;
                            }else{
                                u[a-i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b-i>0){
                            if(x[a+i][b-i]==0 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                                continue;
                            }else{
                                u[a+i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }
                if(x[a][b]==20){
                    e= a;
                    r=b;
                }
            }
        }
        int b[][] = vua.chieutuong_trang();
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if((u[i][j]==1 && (x[i][j]==0 || x[i][j]<10))||(u[i][j]==2 && x[i][j]<10 && x[i][j]!=0)||(u[i][j]==3 && x[i][j]==0)){
                    int w = x[i][j];
                    x[i][j]=14;
                    int v[][] = vua.chieutuong_trang();
                    x[i][j]=w;
                    if(v[e][r]!=1){
                        return 1;
                    }
                }
                if((x[i][j]==0 || x[i][j]<=10) && b[i][j]!=1){
                    if((i==e-1 && j==r-1)||(i==e && j==r-1)||(i==e+1 && j==r-1)||(i==e+1 && j==r)||(i==e+1 && j==r+1)||(i==e && j==r+1)||(i==e-1 && j==r+1)||(i==e-1 && j==r)){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void vua_den_active(int a,int b){
        int u[][]= chieutuong_den();
        check2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0 && u[i][j]!=1){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        check2(i,j);
                    }
                }else if(x[i][j]>10 && u[i][j]!=1){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        check3(i,j);
                    }
                }
            }
        }
        if(a==1 && b==5 && x[1][1]==5 && x[1][2]==0 && x[1][3]==0 && x[1][4]==0){
            check3(1,1);
        }
        if(a==1 && b==5 && x[1][8]==5 && x[1][6]==0 && x[1][7]==0){
            check3(1,8);
        }
        m=-1;
        d=a;
        f=b;
    }
    public static void vua_den_off(int a,int b){
        checked2(a,b);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(x[i][j]==0){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        checked2(i,j);
                    }
                }else if(x[i][j]>10){
                    if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                        checked2(i,j);
                    }
                }
            }
        }
        if(a==1 && b==5 && x[1][1]==5 && x[1][2]==0 && x[1][3]==0 && x[1][4]==0){
            checked2(1,1);
        }
        if(a==1 && b==5 && x[1][8]==5 && x[1][6]==0 && x[1][7]==0){
            checked2(1,8);
        }
        m=-m;
    }
    public static void vua_den_run(int a,int b){
        int u[][]= chieutuong_den();
        String vua[] = new String[10];
        int p = 1;
        int o = 0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if((x[i][j]==0 || x[i][j]>10) && u[i][j]!=1){
                    if((i==d-1 && j==f-1)||(i==d && j==f-1)||(i==d+1 && j==f-1)||(i==d+1 && j==f)||(i==d+1 && j==f+1)||(i==d && j==f+1)||(i==d-1 && j==f+1)||(i==d-1 && j==f)){
                        vua[p]=String.valueOf(i)+String.valueOf(j);
                        p++;
                    }
                }
            }
        }
        for(int i=1;i<=vua.length;i++){
            try{
                if(vua[i].equals(String.valueOf(a)+String.valueOf(b))){
                    vua_den_an(a,b);
                    o=1;
                    luot="trang";
                    break;
                }
            }catch(Exception e){
                
            }
        }
        if(o==0){
            vua_den_off(d,f);
        }
    }
    public static void vua_den_an(int a,int b){
        arr[a][b].setIcon(vua_den_icon);
        arr[d][f].setIcon(null);
        arr1[9-a][9-b].setIcon(vua_den_icon);
        arr1[9-d][9-f].setIcon(null);
        vua_den_off(d,f);
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
    public static int[][] chieutuong_den(){
        int u[][] = new int[10][10];
        for(int a=1;a<=8;a++){
            for(int b=1;b<=8;b++){
                if(x[a][b]==11){
                    u[a-1][b-1]=1;
                    u[a-1][b+1]=1;
                }else if(x[a][b]==15){
                    for(int i=a-1;i>=1;i--){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else if(x[i][b]>10 || x[i][b]==10){
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=a+1;i<=8;i++){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else if(x[i][b]>10 || x[i][b]==10){
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=b-1;i>=1;i--){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else if(x[a][i]>10 || x[a][i]==10){
                            u[a][i]=1;
                        }
                        break;
                    }
                    for(int i=b+1;i<=8;i++){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else if(x[a][i]>10 || x[a][i]==10){
                            u[a][i]=1;
                        }
                        break;
                    }
                }else if(x[a][b]==12){
                    for(int i=1;i<=8;i++){
                        for(int j=1;j<=8;j++){
                            if(x[i][j]==0 || x[i][j]==10 || x[i][j]>10){
                                if((i==a-1 && j==b-2)||(i==a+1 && j==b-2)||(i==a+2 && j==b-1)||(i==a+2 && j==b+1)||(i==a+1 && j==b+2)||(i==a-1 && j==b+2)||(i==a-2 && j==b+1)||(i==a-2 && j==b-1)){
                                    u[i][j]=1;
                                }
                            }
                        }
                    }
                }else if(x[a][b]==13){
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b-i>0){
                            if(x[a-i][b-i]==0 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                                continue;
                            }else if(x[a-i][b-i]>10 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b+i<=8){
                            if(x[a+i][b+i]==0 || x[a+i][b+i]==10){
                                u[a+1][b+i]=1;
                                continue;
                            }else if(x[a+i][b+i]>10 || x[a+i][b+i]==10){
                                u[a+1][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b+i<=8){
                            if(x[a-i][b+i]==0 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                                continue;
                            }else if(x[a-i][b+i]>10 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b-i>0){
                            if(x[a+i][b-i]==0 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                                continue;
                            }else if(x[a+i][b-i]>10 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if(x[a][b]==19){
                    for(int i=a-1;i>=1;i--){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else if(x[i][b]>10 || x[i][b]==10){
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=a+1;i<=8;i++){
                        if(x[i][b]==0 || x[i][b]==10){
                            u[i][b]=1;
                            continue;
                        }else if(x[i][b]>10 || x[i][b]==10){
                            u[i][b]=1;
                        }
                        break;
                    }
                    for(int i=b-1;i>=1;i--){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else if(x[a][i]>10 || x[a][i]==10){
                            u[a][i]=1;
                        }
                        break;
                    }
                    for(int i=b+1;i<=8;i++){
                        if(x[a][i]==0 || x[a][i]==10){
                            u[a][i]=1;
                            continue;
                        }else if(x[a][i]>10 || x[a][i]==10){
                            u[a][i]=1;
                        }
                        break;
                    }
                    // tuong
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b-i>0){
                            if(x[a-i][b-i]==0 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                                continue;
                            }else if(x[a-i][b-i]>10 || x[a-i][b-i]==10){
                                u[a-i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b+i<=8){
                            if(x[a+i][b+i]==0 || x[a+i][b+i]==10){
                                u[a+i][b+i]=1;
                                continue;
                            }else if(x[a+i][b+i]>10 || x[a+i][b+i]==10){
                                u[a+i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a-i>0 && b+i<=8){
                            if(x[a-i][b+i]==0 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                                continue;
                            }else if(x[a-i][b+i]>10 || x[a-i][b+i]==10){
                                u[a-i][b+i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                    for(int i=1;i<=8;i++){
                        if(a+i<=8 && b-i>0){
                            if(x[a+i][b-i]==0 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                                continue;
                            }else if(x[a+i][b-i]>10 || x[a+i][b-i]==10){
                                u[a+i][b-i]=1;
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if(x[a][b]==20){
                    for(int i=1;i<=8;i++){
                        for(int j=1;j<=8;j++){
                            if(x[i][j]==0){
                                if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                                    u[i][j]=1;
                                }
                            }else if(x[i][j]<=10){
                                if((i==a-1 && j==b-1)||(i==a && j==b-1)||(i==a+1 && j==b-1)||(i==a+1 && j==b)||(i==a+1 && j==b+1)||(i==a && j==b+1)||(i==a-1 && j==b+1)||(i==a-1 && j==b)){
                                    u[i][j]=1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return u;
    }
    public static int chieuhet_den(){
        int u[][] = new int[10][10];
            int e=1;
            int r=1;
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(x[i][j]==1){
                        if(i==2){
                            if(x[i+1][j]==0){
                                u[i+1][j]=3;
                                if(x[i+2][j]==0){
                                    u[i+2][j]=3;
                                }
                            }
                        }else{
                            if(x[i+1][j]==0){
                                u[i+1][j]=3;
                            }
                        }
                        if(u[i+1][j-1]!=3){
                            u[i+1][j-1]=2;
                        }
                        if(u[i+1][j+1]!=3){
                            u[i+1][j+1]=2;
                        }
                    }else if(x[i][j]==5){
                        for(int k=i-1;k>=1;k--){
                            if(x[k][j]==0 || x[k][j]==20){
                                u[k][j]=1;
                                continue;
                            }else{
                                u[k][j]=1;
                            }
                            break;
                        }
                        for(int k=i+1;k<=8;k++){
                            if(x[k][j]==0  || x[k][j]==20){
                                u[k][j]=1;
                                continue;
                            }else{
                                u[k][j]=1;
                            }
                            break;
                        }
                        for(int k=j-1;k>=1;k--){
                            if(x[i][k]==0 || x[i][k]==20){
                                u[i][k]=1;
                                continue;
                            }else{
                                u[i][k]=1;
                            }
                            break;
                        }
                        for(int k=j+1;k<=8;k++){
                            if(x[i][k]==0 || x[i][k]==20){
                                u[i][k]=1;
                                continue;
                            }else{
                                u[i][k]=1;
                            }
                            break;
                        }
                    }else if(x[i][j]==2){
                        for(int k=1;k<=8;k++){
                            for(int l=1;l<=8;l++){
                                if(x[k][l]==0 || x[k][l]==20 || x[k][l]<10 || x[k][l]>10){
                                    if((k==i-1 && l==j-2)||(k==i+1 && l==j-2)||(k==i+2 && l==j-1)||(k==i+2 && l==j+1)||(k==i+1 && l==j+2)||(k==i-1 && l==j+2)||(k==i-2 && l==j+1)||(k==i-2 && l==j-1)){
                                        u[k][l]=1;
                                    }
                                }
                            }
                        }
                    }else if(x[i][j]==3){
                        for(int k=1;k<=8;k++){
                            if(i-k>0 && j-k>0){
                                if(x[i-k][j-k]==0 || x[i-k][j-k]==20){
                                    u[i-k][j-k]=1;
                                    continue;
                                }else{
                                    u[i-k][j-k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i+k<=8 && j+k<=8){
                                if(x[i+k][j+k]==0 || x[i+k][j+k]==20){
                                    u[i+k][j+k]=1;
                                    continue;
                                }else{
                                    u[i+k][j+k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i-k>0 && j+k<=8){
                                if(x[i-k][j+k]==0 || x[i-k][j+k]==20){
                                    u[i-k][j+k]=1;
                                    continue;
                                }else{
                                    u[i-k][j+k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i+k<=8 && j-k>0){
                                if(x[i+k][j-k]==0 || x[i+k][j-k]==20){
                                    u[i+k][j-k]=1;
                                    continue;
                                }else{
                                    u[i+k][j-k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                    }else if(x[i][j]==9){
                        for(int k=i-1;k>=1;k--){
                            if(x[k][j]==0 || x[k][j]==20){
                                u[k][j]=1;
                                continue;
                            }else{
                                u[k][j]=1;
                            }
                            break;
                        }
                        for(int k=i+1;k<=8;k++){
                            if(x[k][j]==0 || x[k][j]==20){
                                u[k][j]=1;
                                continue;
                            }else{
                                u[k][j]=1;
                            }
                            break;
                        }
                        for(int k=j-1;k>=1;k--){
                            if(x[i][k]==0 || x[i][k]==20){
                                u[i][k]=1;
                                continue;
                            }else{
                                u[i][k]=1;
                            }
                            break;
                        }
                        for(int k=j+1;k<=8;k++){
                            if(x[i][k]==0 || x[i][k]==20){
                                u[i][k]=1;
                                continue;
                            }else{
                                u[i][k]=1;
                            }
                            break;
                        }
                        // tuong
                        for(int k=1;k<=8;k++){
                            if(i-k>0 && j-k>0){
                                if(x[i-k][j-k]==0 || x[i-k][j-k]==20){
                                    u[i-k][j-k]=1;
                                    continue;
                                }else{
                                    u[i-k][j-k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i+k<=8 && j+k<=8){
                                if(x[i+k][j+k]==0 || x[i+k][j+k]==20){
                                    u[i+k][j+k]=1;
                                    continue;
                                }else{
                                    u[i+k][j+k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i-k>0 && j+k<=8){
                                if(x[i-k][j+k]==0 || x[i-k][j+k]==20){
                                    u[i-k][j+k]=1;
                                    continue;
                                }else{
                                    u[i-k][j+k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                        for(int k=1;k<=8;k++){
                            if(i+k<=8 && j-k>0){
                                if(x[i+k][j-k]==0 || x[i+k][j-k]==20){
                                    u[i+k][j-k]=1;
                                    continue;
                                }else{
                                    u[i+k][j-k]=1;
                                }
                                break;
                            }else{
                                break;
                            }
                        }
                    }
                    if(x[i][j]==10){
                        e= i;
                        r=j;
                    }
                }
            }
            int b[][] = vua.chieutuong_den();
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if((u[i][j]==1 && (x[i][j]==0 || x[i][j]>10))||(u[i][j]==2 && x[i][j]>10)||(u[i][j]==3 && x[i][j]==0)){
                        int w = x[i][j];
                        x[i][j]=4;
                        int v[][] = vua.chieutuong_den();
                        x[i][j]=w;
                        if(v[e][r]!=1){
                            return 1;
                        }
                    }
                    if((x[i][j]==0 || x[i][j]>10) && b[i][j]!=1){
                        if((i==e-1 && j==r-1)||(i==e && j==r-1)||(i==e+1 && j==r-1)||(i==e+1 && j==r)||(i==e+1 && j==r+1)||(i==e && j==r+1)||(i==e-1 && j==r+1)||(i==e-1 && j==r)){
                            return 1;
                        }
                    }
                }
            }
            return 0;
        
        }
    
}
