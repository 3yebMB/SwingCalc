public class Caclculus {
    private String result = "0";
    double tmp;
    //private double x = 0;
    //private double y = 0;
    //private String oper = "";
    public String getDegree (String x, String y){
        double tmp = Double.parseDouble(x);
        int exp = Integer.parseInt(y);
        for (int i=1; i<exp; i++)
            tmp += tmp;
        return Double.toString(tmp);
    }

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
