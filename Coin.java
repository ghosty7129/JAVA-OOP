public class Coin {

    private double two_euro;
    private double one_euro;
    private double fifty_cent;
    private double twenty_cent;
    private double ten_cent;
    private double five_cent;

    public Coin() {
        this.two_euro = 20.0;
        this.one_euro = 10.0;
        this.fifty_cent = 10.0;
        this.twenty_cent = 10.0;
        this.ten_cent = 4.0;
        this.five_cent = 5.0;
    }

    public void returnChange(double change) {
        double[] coinValues = { 2.0, 1.0, 0.5, 0.2, 0.1, 0.05 };
        double[] coinAmounts = { two_euro, one_euro, fifty_cent, twenty_cent, ten_cent, five_cent };
        
        change = Math.round(change * 100.0) / 100.0;

        for (int i = 0; i < coinValues.length; i++) {
            while (change >= coinValues[i] - 0.001 && coinAmounts[i] >= coinValues[i] - 0.001) {
                change -= coinValues[i];
                change = Math.round(change * 100.0) / 100.0;
                
                switch (i) {
                    case 0:
                        two_euro -= 2.0;
                        coinAmounts[0] = two_euro;
                        System.out.println("2 euro");
                        break;
                    case 1:
                        one_euro -= 1.0;
                        coinAmounts[1] = one_euro;
                        System.out.println("1 euro");
                        break;
                    case 2:
                        fifty_cent -= 0.5;
                        coinAmounts[2] = fifty_cent;
                        System.out.println("50 cent");
                        break;
                    case 3:
                        twenty_cent -= 0.2;
                        coinAmounts[3] = twenty_cent;
                        System.out.println("20 cent");
                        break;
                    case 4:
                        ten_cent -= 0.1;
                        coinAmounts[4] = ten_cent;
                        System.out.println("10 cent");
                        break;
                    case 5:
                        five_cent -= 0.05;
                        coinAmounts[5] = five_cent;
                        System.out.println("5 cent");
                        break;
                }
            }
        }
    }

    public void printCoinsStatus() {
        System.out.println("2 euro: " + String.format("%.2f", two_euro) + " euros (" + (int)(two_euro / 2.0) + " coins)");
        System.out.println("1 euro: " + String.format("%.2f", one_euro) + " euros (" + (int)(one_euro / 1.0) + " coins)");
        System.out.println("50 cent: " + String.format("%.2f", fifty_cent) + " euros (" + (int)(fifty_cent / 0.5) + " coins)");
        System.out.println("20 cent: " + String.format("%.2f", twenty_cent) + " euros (" + (int)(twenty_cent / 0.2) + " coins)");
        System.out.println("10 cent: " + String.format("%.2f", ten_cent) + " euros (" + (int)(ten_cent / 0.1) + " coins)");
        System.out.println("5 cent: " + String.format("%.2f", five_cent) + " euros (" + (int)(five_cent / 0.05) + " coins)");
    }
}
