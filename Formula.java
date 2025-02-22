public class Formula {
    int pos;
    String formula;
    double res;

    public Formula(String form) {
        this.pos = 0;
        this.formula = form;
        this.res = 0;
    }

    public char curr() {
        if (pos < formula.length()) {
            System.out.println(formula.charAt(pos));
            System.out.println(res);
            return formula.charAt(pos);
        }
        else {
            return '$';
        }
    }

    public double prepare() {
        res = this.add();
        return res;

    }

    public double add() {
        res = this.mult();
        while (curr() == '+' || curr() == '-') {
            double tmp = mult();
            pos++;
            if (curr() == '+') {
                res = res + tmp;
            }
            else if (curr() == '-'){
                res = res - tmp;
            }
        }
        return res;
    }

    public double mult() {
        res = this.group();
        while (curr() == '*' || curr() == '/') {
            double tmp = group();
            pos++;
            if (curr() == '*') {
                res = res * tmp;
            }
            else {
                res = res / tmp;
            }
        }
        return res;
    }

    public double group() {
        res = this.num();
        return res;
    }

    public double num() {
        StringBuilder tmp = new StringBuilder();
        while (Character.isDigit(curr())) {
            tmp.append(curr());
            pos++;
        }
        if (tmp.toString().isEmpty()) {
            return 0;
        }
        return Double.parseDouble(tmp.toString());
    }


}
