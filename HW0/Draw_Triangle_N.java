public class Draw_Triangle_N {
    public static void main(String[] args){
        drawTriangle(10);
    }
    public static void drawTriangle(int tall){
        for(int i=1;i<=tall;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.print('\n');
        }
    }
}
