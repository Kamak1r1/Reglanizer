package CounterLoops.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class MeasureFile {
    private SimpleStringProperty fileName;
    private SimpleObjectProperty<Measure> measureData;

    public MeasureFile() {

    }

    public MeasureFile(String s1, Object measure) {
        fileName = new SimpleStringProperty(s1);
        measureData = new SimpleObjectProperty<Measure>((Measure) measure);
    }

    public String getFileName() {
        return fileName.get();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public Measure getMeasureData() {
        return measureData.get();
    }

    public SimpleObjectProperty<Measure> measureDataProperty() {
        return measureData;
    }

    public void setMeasureData(Measure measureData) {
        this.measureData.set(measureData);
    }

    @Override
    public String toString() {
        return (fileName.get());
    }
}
