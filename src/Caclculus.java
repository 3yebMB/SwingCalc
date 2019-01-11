public class Caclculus {
    private String result = "0";
    double tmp;

    public int getFact(int x){
        int res = 1;
        if (x==0)
            return 1;
        else {
            return getFact(x-1)*x;
        }
    }
    // принимать на вход int
    public String getDegree (String x, String y){
        double tmp = Double.parseDouble(x);
        int exp = Integer.parseInt(y);
        for (int i=1; i<exp; i++)
            tmp += tmp;
        return Double.toString(tmp);
    }
    // принимать на вход int
    public String getResult(String x, String y, String o) {
        switch (o){
            case "/" :
                try{
                    tmp = Double.parseDouble(x)/Double.parseDouble(y);
                }
                catch (ArithmeticException e){
                    result = "Деление на 0!";
                }

                break;
            case "*" :
                tmp = Double.parseDouble(x)*Double.parseDouble(y);
                break;
            case "+" :
                tmp = Double.parseDouble(x)+Double.parseDouble(y);
                break;
            case "-" :
                tmp = Double.parseDouble(x)-Double.parseDouble(y);
                break;
        }
        return Double.toString(tmp);
    }
}
