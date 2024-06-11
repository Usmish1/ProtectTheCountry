public class Money {
    int gameCred;

    public void currency(){
        gameCred = 5000000;
        String printMoney = "$" + gameCred;
    }

    public static void main(String[] args) {
        new Money();
    }

}
