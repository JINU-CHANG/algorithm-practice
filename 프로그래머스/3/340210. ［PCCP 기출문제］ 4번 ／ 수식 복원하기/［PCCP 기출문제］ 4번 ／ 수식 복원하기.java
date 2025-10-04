import java.util.*;

class Expression {
    String x;
    String y;
    String op;
    String result;

    public Expression(String s) {
        String[] splited = s.split(" ");
        this.x = splited[0];
        this.y = splited[2];
        this.op = splited[1];
        this.result = splited[4];
    }

    public boolean hasNoResult() {
        return result.equals("X");
    }

    public boolean canCalculate(int base) {
        try {
            convertToBase(x, base);
            convertToBase(y, base);
        } catch (NumberFormatException exception){
            return false;
        }
        return true;
    }

    public boolean hasRightResult(int base) {
        String temp = calculateResult(base);
        if (temp == null) return false;
        else if (temp.equals(result)) return true;
        else return false;
    }

    public String calculateResult(int base) {
        String temp;
        try {
            int ix = convertToBase(x, base);
            int iy = convertToBase(y, base);
            if (op.equals("+")) {
                temp = Integer.toString(ix + iy, base);
            } else {
                temp = Integer.toString(ix - iy, base);
            }
        } catch (NumberFormatException exception){
            return null;
        }

        return temp;
    }

    private int convertToBase(String s, int base) throws NumberFormatException {
        return Integer.parseInt(s, base);
    }

    @Override
    public String toString() {
        return x + " " + op + " " + y + " = " + result;
    }
}

class Solution {

    public String[] solution(String[] expressions) {
        List<Expression> answer = new ArrayList<>();
        boolean[] check = new boolean[10];

        List<Expression> expressionList = new ArrayList<>();
        for (String s : expressions) {
            Expression expression = new Expression(s);
            expressionList.add(expression);

            if (expression.hasNoResult()) answer.add(expression);
        }

        for (int i = 2; i <= 9; i++) {
            int count = 0;
            int xcount = 0;

            for (Expression expression : expressionList) {
                if (expression.canCalculate(i) && expression.hasNoResult()) {
                    xcount++;
                    continue;
                }

                if (expression.hasRightResult(i)) {
                    count++;
                }
            }

            if (count == expressions.length - xcount) {
                check[i] = true;
            }
        }

        for (int i = 2; i <= 9; i++) {
            if (check[i]) {
                for (Expression expression : answer) {
                    if (expression.result.equals("?")) continue;

                    String temp = expression.calculateResult(i);
                    if (temp == null) expression.result = "?";
                    else if (expression.result.equals("X")) expression.result = temp;
                    else if (!expression.result.equals(temp)) expression.result = "?";
                }
            }
        }

        String[] answerArr = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i).toString();
        }
        return answerArr;
    }
}