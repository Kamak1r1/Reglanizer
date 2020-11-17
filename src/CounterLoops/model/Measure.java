package CounterLoops.model;

import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "measure")
@XmlType(propOrder = {"girthOfHead", "girthOfChest", "lengthOfRaglan", "productLength", "armLenght", "girtWrist", "bandsWidth", "numberLoopsOfReglan"})
public class Measure {
    //вводимые данные
    private double girthOfHead;
    private double girthOfChest;
    //    private double girtWidestPartOfChest;
    private double lengthOfRaglan;
    private double productLength;
    private double armLenght;
    private double girtWrist;
    private double bandsWidth;
    private double numberLoopsOfReglan;

    public Measure() {
    }

    public Measure(double girthOfHead, double girthOfChest, double lengthOfRaglan, double productLength, double armLenght, double girtWrist, double bandsWidth, double numberLoopsOfReglan) {
        this.girthOfHead = girthOfHead;
        this.girthOfChest = girthOfChest;
        this.lengthOfRaglan = lengthOfRaglan;
        this.productLength = productLength;
        this.armLenght = armLenght;
        this.girtWrist = girtWrist;
        this.bandsWidth = bandsWidth;
        this.numberLoopsOfReglan = numberLoopsOfReglan;
    }

    public double getGirthOfHead() {
        return girthOfHead;
    }

    public void setGirthOfHead(double girthOfHead) {
        this.girthOfHead = girthOfHead;
    }

    public double getGirthOfChest() {
        return girthOfChest;
    }

    public void setGirthOfChest(double girthOfChest) {
        this.girthOfChest = girthOfChest;
    }

    public double getLengthOfRaglan() {
        return lengthOfRaglan;
    }

    public void setLengthOfRaglan(double lengthOfRaglan) {
        this.lengthOfRaglan = lengthOfRaglan;
    }

    public double getProductLength() {
        return productLength;
    }

    public void setProductLength(double productLength) {
        this.productLength = productLength;
    }

    public double getArmLenght() {
        return armLenght;
    }

    public void setArmLenght(double armLenght) {
        this.armLenght = armLenght;
    }

    public double getGirtWrist() {
        return girtWrist;
    }

    public void setGirtWrist(double girtWrist) {
        this.girtWrist = girtWrist;
    }

    public double getBandsWidth() {
        return bandsWidth;
    }

    public void setBandsWidth(double bandsWidth) {
        this.bandsWidth = bandsWidth;
    }

    public double getNumberLoopsOfReglan() {
        return numberLoopsOfReglan;
    }

    public void setNumberLoopsOfReglan(double numberLoopsOfReglan) {
        this.numberLoopsOfReglan = numberLoopsOfReglan;
    }

}
