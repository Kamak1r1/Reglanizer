package CounterLoops.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "lastDensity")
@XmlType(propOrder = {"untilLoops", "untilRows", "afterLoops1", "afterLoops2", "afterRows1", "afterRows2"})
public class LastDensity {
    private double untilLoops;
    private double untilRows;
    private double afterLoops1;
    private double afterLoops2;
    private double afterRows1;
    private double afterRows2;

    public LastDensity() {

    }

    public LastDensity(double untilLoops, double untilRows, double afterLoops1, double afterLoops2, double afterRows1, double afterRows2) {
        this.untilLoops = untilLoops;
        this.untilRows = untilRows;
        this.afterLoops1 = afterLoops1;
        this.afterLoops2 = afterLoops2;
        this.afterRows1 = afterRows1;
        this.afterRows2 = afterRows2;
    }

    public double getUntilLoops() {
        return untilLoops;
    }

    public void setUntilLoops(double untilLoops) {
        this.untilLoops = untilLoops;
    }

    public double getUntilRows() {
        return untilRows;
    }

    public void setUntilRows(double untilRows) {
        this.untilRows = untilRows;
    }

    public double getAfterLoops1() {
        return afterLoops1;
    }

    public void setAfterLoops1(double afterLoops1) {
        this.afterLoops1 = afterLoops1;
    }

    public double getAfterLoops2() {
        return afterLoops2;
    }

    public void setAfterLoops2(double afterLoops2) {
        this.afterLoops2 = afterLoops2;
    }

    public double getAfterRows1() {
        return afterRows1;
    }

    public void setAfterRows1(double afterRows1) {
        this.afterRows1 = afterRows1;
    }

    public double getAfterRows2() {
        return afterRows2;
    }

    public void setAfterRows2(double afterRows2) {
        this.afterRows2 = afterRows2;
    }
}
