package CounterLoops.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateMeasure {

    double densityOfKnittingAfterWTOLoops(double loops, double rows) {
        BigDecimal answer = null;
        try {
//            return new BigDecimal(loops / rows).setScale(2, RoundingMode.HALF_UP).doubleValue();
            answer = new BigDecimal(loops / rows).setScale(2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        assert answer != null;
        return answer.doubleValue();
    }

    double densityOfKnittingAfterWTORows(double loops, double rows) {
        BigDecimal answer = null;
        try {
            answer = new BigDecimal(loops / rows).setScale(2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        assert answer != null;
        return answer.doubleValue();
    }

    double densityOfShrinkageFactorLoops(double rows, double loops) {
        BigDecimal answer = null;
        try {
            answer = new BigDecimal(rows / loops).setScale(2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        assert answer != null;
        return answer.doubleValue();
    }

    double densityOfShrinkageFactorRows(double rows, double loops) {
        BigDecimal answer = null;
        try {
            answer = new BigDecimal(rows / loops).setScale(2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        assert answer != null;
        return answer.doubleValue();
    }

    //сколько петель набрать на бросовую нить
    int numberJunkLoops(double head, double afterWtoLoops) {
        int temp = 0;
        double loops = 0;

        try {
            loops = (head * 0.75) * afterWtoLoops;
            temp = (int) (loops / 6);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return temp * 6;
    }

    int numberJunkLoops2(double head, double afterWtoLoops) {
        int temp = 0;
        double loops = 0;

        try {
            loops = head * afterWtoLoops;
            temp = (int) (loops / 6);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return temp * 6;
    }

    // для спины и переда
    int numberBackNFrontLoops(int numberJunk) {
        int answer = 0;
        try {
            answer = new BigDecimal(numberJunk / 3).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    //для рукавов
    int distributeLoopsForSleeves(int numberLoops, double numberLoopsReg) {
        int answer = 0;
        try {
            answer = (numberLoops / 6) - (int) numberLoopsReg * 2;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberSprouts(double rows) {
        double temp = 0;

        try {
            temp = Math.ceil(rows / 3);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        if (temp % 2 == 0) {
            return (int) temp;
        } else {
            return (int) temp + 1;
        }
    }

    int controlNumbers(int rr, int numberJunk) {
        int answer = 0;
        try {
            answer = (rr * 4) + numberJunk;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    //округлить вверх
    int numberRows(double reglanLength, double densityRows, int rr) {
        int answer = 0;
        try {
            answer = (int) (reglanLength * densityRows) - rr;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberOfIncreaceAfter(double chest, double direct, double densityLoop, int numberBnF, int numberSprout, int nUndercut) {
        int res1 = 0;
        int answer = 0;
        try {
            res1 = BigDecimal.valueOf((((chest + direct) * densityLoop) - nUndercut) / 2).setScale(0, RoundingMode.UP).intValue();
            answer = BigDecimal.valueOf((res1 - numberBnF - numberSprout) / 2).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberRows3P(int rows, int increase) {
        int answer = 0;
        try {
            answer = rows / increase;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberReglan3mRows(int rr, int increase, int rowIncrease) {
        int num1 = 0;
        int answer = 0;
        try {
            num1 = rr - (increase * rowIncrease);
            answer = rr - (num1 * (rowIncrease + 1));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberReglanBody2mRows(int rr, int numReg3m) {
        int answer = 0;
        try {
            answer = rr - numReg3m;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberOfIncreaceAfter2(int numberOfIncreaceAfter, int nUndercuts) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf((numberOfIncreaceAfter * 0.8) + (double) (nUndercuts / 4)).setScale(0, RoundingMode.DOWN).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberRows5P(int numberRow, int numberOfIncreaceAfter) {
        int answer = 0;
        try {
            answer = new BigDecimal(numberRow / numberOfIncreaceAfter).setScale(0, RoundingMode.DOWN).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberReglan5mRows(int rr, int increase, int rowIncrease) {
        int num1 = 0;
        int answer = 0;
        try {
            num1 = rr - (increase * rowIncrease);
            answer = rr - (num1 * (rowIncrease + 1));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberReglan6mRows(int rr, int numReg5m) {
        int answer = 0;
        try {
            answer = rr - numReg5m;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberUndercuts(double x, double y) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf((x * y) / 24).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberUndercutsToRows(double a, double b, double c, int d, int e) {
        double answer = 0;
        try {
            answer = Math.ceil(((a - b) * c) - d - e);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
        return (int) answer;
    }

    int numberElasticRows(double a, double b) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(a * b).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberSleeveRows(double a, double b, double c) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf((a - b) * c).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberSleeveTwistRows(double a, double b, double c, double d, double e) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(a + b + c + d + (e * 2)).intValue();
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
        return answer;
    }

    int numberTwistRows(int a, double b, double c) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(((a - (b * c)) * 0.75) / 2).setScale(0, RoundingMode.DOWN).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberTwistBeforeElasticRows(int a, double b) {
        int answer = 0;
        try {
            if (a > 0 && b > 0) {
                answer = BigDecimal.valueOf(((a / b) - 1)).setScale(0, RoundingMode.DOWN).intValue();
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberTwistLoops(int a, double b, double c, double d) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf((a - (b * c)) - d * 2).setScale(0, RoundingMode.DOWN).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        if (answer % 2 == 0) {
            return answer;
        } else {
            return answer - 1;
        }
    }

    int numberElasticSleeves(double a, double b) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(a * b).setScale(0, RoundingMode.UP).intValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int widthElastics(double a, double b) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(a * b).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberNeckRows(double a, double b) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(a * b * 2).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberBackNFrontLoopsMarkers1(int numberBackNFrontL) {
        int answer = 0;
        try {
            answer = new BigDecimal(numberBackNFrontL / 2).setScale(0, RoundingMode.UP).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int numberBackNFrontLoopsMarkers3(int numberBackNFrontL, int numberBackNFrontLoopsMarker1) {
        int answer = 0;
        try {
            answer = new BigDecimal(numberBackNFrontL - numberBackNFrontLoopsMarker1).setScale(0, RoundingMode.UP).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int totalNumberReglans(int numberOfIncreaceAfter, int numberSprout) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(numberOfIncreaceAfter + (numberSprout / 2)).setScale(0, RoundingMode.UP).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    int totalNumberSleeves(int numberOfIncreaceAfter2, int numberSprout) {
        int answer = 0;
        try {
            answer = BigDecimal.valueOf(numberOfIncreaceAfter2 + (numberSprout / 2)).setScale(0, RoundingMode.UP).intValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    double totalNumberOfReglans(double lengthOfRaglan, double densityViewRows2) {
        double answer = 0;
        try {
            answer = BigDecimal.valueOf(lengthOfRaglan / densityViewRows2).setScale(1, RoundingMode.UP).doubleValue();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public double totalNumberOfBodys(int numberBackNFrontL, double numberLoopsOfReglan, int totalNumberReglan, int numberUndercut, double densityViewLoops1, double densityViewLoops2) {
        double answer = 0;
        try {
            answer = BigDecimal.valueOf(((numberBackNFrontL + numberLoopsOfReglan + totalNumberReglan * 2 + numberUndercut) / densityViewLoops1) / densityViewLoops2).setScale(1, RoundingMode.HALF_UP).doubleValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public double totalNumberOfSleeves(int numberSleevesL, double numberLoopsOfReglan, int totalNumberSleeve, int numberUndercut, double densityViewLoops1, double densityViewLoops2) {
        double answer = 0;
        try {
            answer = BigDecimal.valueOf(((numberSleevesL + numberLoopsOfReglan + totalNumberSleeve * 2 + numberUndercut) / densityViewLoops1) / densityViewLoops2).setScale(1, RoundingMode.HALF_UP).doubleValue();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
