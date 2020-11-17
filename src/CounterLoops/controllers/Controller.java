package CounterLoops.controllers;

import CounterLoops.Main;
import CounterLoops.model.LastDensity;
import CounterLoops.model.Measure;
import CounterLoops.model.MeasureFile;
import CounterLoops.model.OnlyNumberTextField;
import CounterLoops.parser.Parser;
import CounterLoops.parser.impl.JaxbParser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Controller extends Stage {
    private double girthOfHead;
    private double girthOfChest;
    //    double girtWidestPartOfChest;
    private double lengthOfRaglan;
    private double productLength;
    private double armLenght;
    private double girtWrist;
    private double bandsWidth;
    private double numberLoopsOfReglan;

    private double untilLoops;
    private double untilRows;
    private double afterLoops1;
    private double afterLoops2;
    private double afterRows1;
    private double afterRows2;

    private double checkDirect;

    private Stage dialogStage;

    private CalculateMeasure calculateMeasure = new CalculateMeasure();
    private Measure measure;
    private LastDensity lastDensity;
    private Parser parser = new JaxbParser();

    /*Media media = new Media(getClass().getResource("/assets/Unlock.wav").toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);*/

    @FXML
    private OnlyNumberTextField oneEnterParamField;

    @FXML
    private OnlyNumberTextField twoEnterParamField;

    /*@FXML
    OnlyNumberTextField treeEnterParamField;*/

    @FXML
    private OnlyNumberTextField fourEnterParamField;

    @FXML
    private OnlyNumberTextField fiveEnterParamField;

    @FXML
    private OnlyNumberTextField sixEnterParamField;

    @FXML
    private OnlyNumberTextField sevenEnterParamField;

    @FXML
    private OnlyNumberTextField eightEnterParamField;

    @FXML
    private OnlyNumberTextField nineEnterParamField;

    @FXML
    private OnlyNumberTextField untilLoopsEnterField1;

    @FXML
    private OnlyNumberTextField untilRowsEnterField1;

    @FXML
    private OnlyNumberTextField afterLoopsEnterField1;

    @FXML
    private OnlyNumberTextField afterRowsEnterField1;

    @FXML
    private OnlyNumberTextField afterLoopsEnterField2;

    @FXML
    private OnlyNumberTextField afterRowsEnterField2;

    @FXML
    private Button calculateButton;

    @FXML
    private RadioButton checkDirectClassic;

    @FXML
    private RadioButton checkDirectClassicPlus;

    @FXML
    private Button openFileButton;

    @FXML
    private TextField aDensityViewLoops1;

    @FXML
    private TextField aDensityViewLoops2;

    @FXML
    private TextField aDensityViewRows1;

    @FXML
    private TextField aDensityViewRows2;

    @FXML
    private TextField aNumberJunkLoops;

    @FXML
    private TextField aNumberBackNFrontLoops;

    @FXML
    private TextField aNumberSleevesLoops;

    @FXML
    private TextField aNumberReglanLinesLoops;

    @FXML
    private TextField aNumberBackNFrontLoopsMarker1;

    @FXML
    private TextField aNumberBackNFrontLoopsMarker2;

    @FXML
    private TextField aNumberBackNFrontLoopsMarker3;

    @FXML
    private TextField aNumberReglanLinesLoopsMarker1;

    @FXML
    private TextField aNumberSleevesLoopsMarker1;

    @FXML
    private TextField aNumberReglanLinesLoopsMarker2;

    @FXML
    private TextField aNumberReglanLinesLoopsMarker3;

    @FXML
    private TextField aNumberSleevesLoopsMarker2;

    @FXML
    private TextField aNumberReglanLinesLoopsMarker4;

    @FXML
    Tab tabTree;

    @FXML
    private TextField aNumberSproutRows;

    @FXML
    private TextField aNumberReglan2mRows;

    @FXML
    private TextField aNumberReglan3mRows;

    @FXML
    private TextField aNumberReglanBody2mRows;

    @FXML
    private TextField aNumberUndercuts;

    @FXML
    private TextField aNumberRows3Plus;

    @FXML
    private TextField aNumberRows4Plus;

    @FXML
    private TextField aNumberRows5Plus;

    @FXML
    private TextField aNumberRows6Plus;

    @FXML
    private TextField aNumberReglan5mRows;

    @FXML
    private TextField aNumberReglan6mRows;

    @FXML
    private TextField aNumberUndercutsToRows;

    @FXML
    private TextField aNumberElasticRows;

    @FXML
    private TextField aNumberSleeveRows;

    @FXML
    private TextField aNumberTwistRows;

    @FXML
    private TextField aNumberSleeveTwistRows;

    @FXML
    private TextField aNumberTwistBeforeElasticRows;

    @FXML
    private TextField aNumberTwistLoops;

    @FXML
    private TextField aNumberElasticSleeve;

    @FXML
    private TextField aWidthElastic;

    @FXML
    private TextField aNumberNeckRows;

    @FXML
    private TextField aTotalNumberOfEditsOfReglan;

    @FXML
    private TextField aTotalNumberOfEditsOfSleeve;

    @FXML
    private TextField aTotalNumberOfReglan;

    @FXML
    private TextField aTotalNumberOfBody;

    @FXML
    private TextField aTotalNumberOfSleeve;

    @FXML
    private Button saveFileButton;

    @FXML
    private Button restoreDensityButton;

    @FXML
    private CheckBox headCheckBox;

    //тут стараемся прикрутить список
    @FXML
    private TableView<Measure> measureTable;

    @FXML
    private TableColumn<Measure, String> nameColumn;

    private ObservableList<MeasureFile> data;


    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        checkDirectClassic.setToggleGroup(group);
        checkDirectClassicPlus.setToggleGroup(group);

        headCheckBox.setTooltip(new Tooltip("Использовать вместо обхвата головы окружность горловины."));
        restoreDensityButton.setTooltip(new Tooltip("Когда Вы производите Расчет, программа запоминает плотность, которую Вы использовали.\n Так при следующем запуске программы эта кнопка \"вспомнит\" Вашу плотность."));

        calculateButton.setOnAction(event -> {
            if (isInputValid()) {
                girthOfHead = Double.parseDouble(oneEnterParamField.getText());
                girthOfChest = Double.parseDouble(twoEnterParamField.getText());
//                girtWidestPartOfChest = Double.parseDouble(treeEnterParamField.getText());
                lengthOfRaglan = Double.parseDouble(fourEnterParamField.getText());
                productLength = Double.parseDouble(fiveEnterParamField.getText());
                armLenght = Double.parseDouble(sixEnterParamField.getText());
                girtWrist = Double.parseDouble(sevenEnterParamField.getText());
                bandsWidth = Double.parseDouble(eightEnterParamField.getText());
                numberLoopsOfReglan = Double.parseDouble(nineEnterParamField.getText());
                untilLoops = Double.parseDouble(untilLoopsEnterField1.getText());
                untilRows = Double.parseDouble(untilRowsEnterField1.getText());
                afterLoops1 = Double.parseDouble(afterLoopsEnterField1.getText());
                afterLoops2 = Double.parseDouble(afterLoopsEnterField2.getText());
                afterRows1 = Double.parseDouble(afterRowsEnterField1.getText());
                afterRows2 = Double.parseDouble(afterRowsEnterField2.getText());

                if (checkDirectClassic.isSelected()) {
                    checkDirect = 6;
                } else if (checkDirectClassicPlus.isSelected()) {
                    checkDirect = 10;
                }

                // Распределение петель
                double densityViewLoops1 = calculateMeasure.densityOfKnittingAfterWTOLoops(untilLoops, afterRows1);
                aDensityViewLoops1.setText(String.valueOf(densityViewLoops1));

                double densityViewRows1 = calculateMeasure.densityOfKnittingAfterWTORows(untilRows, afterRows2);
                aDensityViewRows1.setText(String.valueOf(densityViewRows1));

                double densityViewLoops2 = calculateMeasure.densityOfShrinkageFactorLoops(afterRows1, afterLoops1);
                aDensityViewLoops2.setText(String.valueOf(densityViewLoops2));

                double densityViewRows2 = calculateMeasure.densityOfShrinkageFactorRows(afterRows2, afterLoops2);
                aDensityViewRows2.setText(String.valueOf(densityViewRows2));

                int numberJunkL;
                if (headCheckBox.isSelected()) {
                    numberJunkL = calculateMeasure.numberJunkLoops2(girthOfHead, densityViewLoops1);
                } else {
                    numberJunkL = calculateMeasure.numberJunkLoops(girthOfHead, densityViewLoops1); // набор 1.1
                }

                aNumberJunkLoops.setText(String.valueOf(numberJunkL));

                int numberBackNFrontL = calculateMeasure.numberBackNFrontLoops(numberJunkL); // 1.2
                aNumberBackNFrontLoops.setText(String.valueOf(numberBackNFrontL));

                int numberSleevesL = calculateMeasure.distributeLoopsForSleeves(numberJunkL, numberLoopsOfReglan); // 1.3
                aNumberSleevesLoops.setText(String.valueOf(numberSleevesL));

                aNumberReglanLinesLoops.setText(String.valueOf((int) numberLoopsOfReglan));

                // Распределение маркеров
                int numberBackNFrontLoopsMarker1 = calculateMeasure.numberBackNFrontLoopsMarkers1(numberBackNFrontL);
                aNumberBackNFrontLoopsMarker1.setText(String.valueOf(numberBackNFrontLoopsMarker1));

                aNumberReglanLinesLoopsMarker1.setText(String.valueOf((int) numberLoopsOfReglan));
                aNumberSleevesLoopsMarker1.setText(String.valueOf(numberSleevesL));
                aNumberReglanLinesLoopsMarker2.setText(String.valueOf((int) numberLoopsOfReglan));
                aNumberBackNFrontLoopsMarker2.setText(String.valueOf(numberBackNFrontL));
                aNumberReglanLinesLoopsMarker3.setText(String.valueOf((int) numberLoopsOfReglan));
                aNumberSleevesLoopsMarker2.setText(String.valueOf(numberSleevesL));
                aNumberReglanLinesLoopsMarker4.setText(String.valueOf((int) numberLoopsOfReglan));

                int numberBackNFrontLoopsMarker3 = calculateMeasure.numberBackNFrontLoopsMarkers3(numberBackNFrontL, numberBackNFrontLoopsMarker1);
                aNumberBackNFrontLoopsMarker3.setText(String.valueOf(numberBackNFrontLoopsMarker3));

                // Расчет реглана
                //2.1
                int numberSprout = calculateMeasure.numberSprouts(numberBackNFrontL);
                aNumberSproutRows.setText(String.valueOf(numberSprout));

                //2.2
                int controlNumber = calculateMeasure.controlNumbers(numberSprout, numberJunkL);
                aNumberReglan2mRows.setText(String.valueOf(controlNumber));

                // 2.3 Количество рядов реглана(РРег)
                int numberRow = calculateMeasure.numberRows(lengthOfRaglan, densityViewRows1, numberSprout);

                //3.1
                int numberUndercut = calculateMeasure.numberUndercuts(girthOfChest, densityViewLoops1);
                aNumberUndercuts.setText(String.valueOf(numberUndercut));

                // 2.4(Приб)
                int numberOfIncreaceAfter = calculateMeasure.numberOfIncreaceAfter(girthOfChest, checkDirect, densityViewLoops1, numberBackNFrontL, numberSprout, numberUndercut);

                //2.5
                int numberRows3Plus = calculateMeasure.numberRows3P(numberRow, numberOfIncreaceAfter);
                aNumberRows3Plus.setText(String.valueOf(numberRows3Plus));

                int numberRows4Plus = numberRows3Plus + 1;
                aNumberRows4Plus.setText(String.valueOf(numberRows4Plus));

                //2.6
                int numberReglan3mRow = calculateMeasure.numberReglan3mRows(numberRow, numberOfIncreaceAfter, numberRows3Plus);
                aNumberReglan3mRows.setText(String.valueOf(numberReglan3mRow));

                //2.7
                int numberReglanBody2mRow = calculateMeasure.numberReglanBody2mRows(numberRow, numberReglan3mRow);
                aNumberReglanBody2mRows.setText(String.valueOf(numberReglanBody2mRow));

                //2.11
                int numberUndercutsToRow = calculateMeasure.numberUndercutsToRows(productLength, bandsWidth, densityViewRows1, numberSprout, numberRow);
                //2.8(Приб2)
                int numberOfIncreaceAfter2 = calculateMeasure.numberOfIncreaceAfter2(numberOfIncreaceAfter, numberUndercut);

                //2.9
                int numberRows5Plus = calculateMeasure.numberRows5P(numberRow, numberOfIncreaceAfter2);
                aNumberRows5Plus.setText(String.valueOf(numberRows5Plus));

                //2.10
                int numberRows6Plus = numberRows5Plus + 1;
                aNumberRows6Plus.setText(String.valueOf(numberRows6Plus));

                //2.10
                int numberReglan5mRow = calculateMeasure.numberReglan5mRows(numberRow, numberOfIncreaceAfter2, numberRows5Plus);
                aNumberReglan5mRows.setText(String.valueOf(numberReglan5mRow));

                int numberReglan6mRow = calculateMeasure.numberReglan6mRows(numberRow, numberReglan5mRow);


                // Расчеты тела и рукава
                aNumberUndercutsToRows.setText(String.valueOf(numberUndercutsToRow));
                aNumberReglan6mRows.setText(String.valueOf(numberReglan6mRow));
                int numberElasticRow = calculateMeasure.numberElasticRows(bandsWidth, densityViewRows1);
                aNumberElasticRows.setText(String.valueOf(numberElasticRow));

                // рукав
                int numberSleeveRow = calculateMeasure.numberSleeveRows(armLenght, bandsWidth, densityViewRows1); // 5.1
                aNumberSleeveRows.setText(String.valueOf(numberSleeveRow));

                //5.2
                int numberSleeveTwistRow = calculateMeasure.numberSleeveTwistRows(numberSleevesL, numberLoopsOfReglan, numberUndercut, numberSprout, numberOfIncreaceAfter2);
                aNumberSleeveTwistRows.setText(String.valueOf(numberSleeveTwistRow));

                int numberTwistRow = calculateMeasure.numberTwistRows(numberSleeveTwistRow, girtWrist, densityViewLoops1); // 5.3
                aNumberTwistRows.setText(String.valueOf(numberTwistRow));

                //не пишится потому что ошибка деления на 0 в numberTwistRow.
                int numberTwistBeforeElasticRow = calculateMeasure.numberTwistBeforeElasticRows(numberSleeveRow, numberTwistRow);
                aNumberTwistBeforeElasticRows.setText(String.valueOf(numberTwistBeforeElasticRow));

                int numberTwistLoop = calculateMeasure.numberTwistLoops(numberSleeveTwistRow, girtWrist, densityViewLoops1, numberTwistRow);
                aNumberTwistLoops.setText(String.valueOf(numberTwistLoop));

                int numberElasticSleeve = calculateMeasure.numberElasticSleeves(bandsWidth, densityViewRows1);
                aNumberElasticSleeve.setText(String.valueOf(numberElasticSleeve));

                // резинка
                int widthElastic = calculateMeasure.widthElastics(bandsWidth, densityViewRows1);
                aWidthElastic.setText(String.valueOf(widthElastic));

                int numberNeckRow = calculateMeasure.numberNeckRows(bandsWidth, densityViewRows1);
                aNumberNeckRows.setText(String.valueOf(numberNeckRow));

                //Доп справочные поля на третью вкладку
                int totalNumberReglan = calculateMeasure.totalNumberReglans(numberOfIncreaceAfter, numberSprout);
                aTotalNumberOfEditsOfReglan.setText(String.valueOf(totalNumberReglan));

                int totalNumberSleeve = calculateMeasure.totalNumberSleeves(numberOfIncreaceAfter2, numberSprout);
                aTotalNumberOfEditsOfSleeve.setText(String.valueOf(totalNumberSleeve));

                double totalNumberOfReglan = calculateMeasure.totalNumberOfReglans(lengthOfRaglan, densityViewRows2);
                aTotalNumberOfReglan.setText(String.valueOf(totalNumberOfReglan));

                double totalNumberOfBody = calculateMeasure.totalNumberOfBodys(numberBackNFrontL, numberLoopsOfReglan, totalNumberReglan, numberUndercut, densityViewLoops1, densityViewLoops2);
                aTotalNumberOfBody.setText(String.valueOf(totalNumberOfBody));

                double totalNumberOfSleeve = calculateMeasure.totalNumberOfSleeves(numberSleevesL, numberLoopsOfReglan, totalNumberSleeve, numberUndercut, densityViewLoops1, densityViewLoops2);
                aTotalNumberOfSleeve.setText(String.valueOf(totalNumberOfSleeve));


                //Сохраняем последнюю расчетную плотность
                lastDensity = new LastDensity(untilLoops, untilRows, afterLoops1, afterLoops2, afterRows1, afterRows2);

                File file = new File("LastDensity.xml");

                if (lastDensity != null) {
                    try {
                        parser.saveObject(file, lastDensity);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
//            mediaPlayer.play();
        });

        restoreDensityButton.setOnAction(event -> {
            File file = new File("LastDensity.xml");

            try {
                lastDensity = (LastDensity) parser.getObject(file, LastDensity.class);

                assert lastDensity != null;
                untilLoopsEnterField1.setText(String.valueOf(lastDensity.getUntilLoops()));
                untilRowsEnterField1.setText(String.valueOf(lastDensity.getUntilRows()));
                afterLoopsEnterField1.setText(String.valueOf(lastDensity.getAfterLoops1()));
                afterLoopsEnterField2.setText(String.valueOf(lastDensity.getAfterLoops2()));
                afterRowsEnterField1.setText(String.valueOf(lastDensity.getAfterRows1()));
                afterRowsEnterField2.setText(String.valueOf(lastDensity.getAfterRows2()));

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        saveFileButton.setOnAction(event -> {
            if (isInputMeasureValid()) {
                girthOfHead = Double.parseDouble(oneEnterParamField.getText());
                girthOfChest = Double.parseDouble(twoEnterParamField.getText());
                lengthOfRaglan = Double.parseDouble(fourEnterParamField.getText());
                productLength = Double.parseDouble(fiveEnterParamField.getText());
                armLenght = Double.parseDouble(sixEnterParamField.getText());
                girtWrist = Double.parseDouble(sevenEnterParamField.getText());
                bandsWidth = Double.parseDouble(eightEnterParamField.getText());
                numberLoopsOfReglan = Double.parseDouble(nineEnterParamField.getText());

                measure = new Measure(girthOfHead, girthOfChest, lengthOfRaglan, productLength, armLenght, girtWrist, bandsWidth, numberLoopsOfReglan);

                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
                fileChooser.getExtensionFilters().add(extFilter);

                String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
                fileChooser.setInitialDirectory(new File(currentPath));

                File file = fileChooser.showSaveDialog(Main.getPrimaryStage());

                if (file != null) {
                    if (!file.getPath().endsWith(".xml")) {
                        file = new File(file.getPath() + ".xml");
                    }
                    try {
                        parser.saveObject(file, measure);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        openFileButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
            fileChooser.getExtensionFilters().add(extFilter);

            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            fileChooser.setInitialDirectory(new File(currentPath));

            File file = fileChooser.showOpenDialog(Main.getPrimaryStage());

            if (file != null) {
                try {
                    measure = (Measure) parser.getObject(file, Measure.class);

                    assert measure != null;
                    oneEnterParamField.setText(String.valueOf(measure.getGirthOfHead()));
                    twoEnterParamField.setText(String.valueOf(measure.getGirthOfChest()));
                    fourEnterParamField.setText(String.valueOf(measure.getLengthOfRaglan()));
                    fiveEnterParamField.setText(String.valueOf(measure.getProductLength()));
                    sixEnterParamField.setText(String.valueOf(measure.getArmLenght()));
                    sevenEnterParamField.setText(String.valueOf(measure.getGirtWrist()));
                    eightEnterParamField.setText(String.valueOf(measure.getBandsWidth()));
                    nineEnterParamField.setText(String.valueOf(measure.getNumberLoopsOfReglan()));

                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private boolean isInputMeasureValid() {
        String errorMessage = "";

        if (oneEnterParamField.getText() == null || oneEnterParamField.getText().length() == 0) {
            errorMessage += "Не указан обхват головы!\n";
        }
        if (twoEnterParamField.getText() == null || twoEnterParamField.getText().length() == 0) {
            errorMessage += "Не указан обхват груди!\n";
        }
        if (fourEnterParamField.getText() == null || fourEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна реглана!\n";
        }
        if (fiveEnterParamField.getText() == null || fiveEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна изделия!\n";
        }
        if (sixEnterParamField.getText() == null || sixEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна руки!\n";
        }
        if (sevenEnterParamField.getText() == null || sevenEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана обхват кисти!\n";
        }
        if (eightEnterParamField.getText() == null || eightEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана ширина рзинки!\n";
        }
        if (nineEnterParamField.getText() == null || nineEnterParamField.getText().length() == 0) {
            errorMessage += "Не указано количество петель одной регланной линии!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Не все поля заполнены.");
            alert.setHeaderText("Пожалуйста заполните все поля.");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (oneEnterParamField.getText() == null || oneEnterParamField.getText().length() == 0) {
            errorMessage += "Не указан обхват головы!\n";
        }
        if (twoEnterParamField.getText() == null || twoEnterParamField.getText().length() == 0) {
            errorMessage += "Не указан обхват груди!\n";
        }
        /*if (treeEnterParamField.getText() == null || treeEnterParamField.getText().length() == 0) {
            errorMessage += "Не указан полуобхват груди по переду!\n";
        }*/
        if (fourEnterParamField.getText() == null || fourEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна реглана!\n";
        }
        if (fiveEnterParamField.getText() == null || fiveEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна изделия!\n";
        }
        if (sixEnterParamField.getText() == null || sixEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана длинна руки!\n";
        }
        if (sevenEnterParamField.getText() == null || sevenEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана обхват кисти!\n";
        }
        if (eightEnterParamField.getText() == null || eightEnterParamField.getText().length() == 0) {
            errorMessage += "Не указана ширина рзинки!\n";
        }
        if (nineEnterParamField.getText() == null || nineEnterParamField.getText().length() == 0) {
            errorMessage += "Не указано количество петель одной регланной линии!\n";
        }
        if (untilRowsEnterField1.getText() == null || untilRowsEnterField1.getText().length() == 0) {
            errorMessage += "Не указано количество провязанных петель!\n";
        }
        if (untilLoopsEnterField1.getText() == null || untilLoopsEnterField1.getText().length() == 0) {
            errorMessage += "Не указано количество провязанных рядов!\n";
        }
        if (afterLoopsEnterField1.getText() == null || afterLoopsEnterField1.getText().length() == 0) {
            errorMessage += "Не указаны данные до ВТО(петли)!\n";
        }
        if (afterLoopsEnterField2.getText() == null || afterLoopsEnterField2.getText().length() == 0) {
            errorMessage += "Не указаны данные до ВТО(ряды)\n";
        }
        if (afterRowsEnterField1.getText() == null || afterRowsEnterField1.getText().length() == 0) {
            errorMessage += "Не указаны данные после ВТО(петли)\n";
        }
        if (afterRowsEnterField2.getText() == null || afterRowsEnterField2.getText().length() == 0) {
            errorMessage += "Не указаны данные после ВТО(ряды)\n";
        }

        if (!checkDirectClassic.isSelected() && !checkDirectClassicPlus.isSelected()) {
            errorMessage += "Не выбран тип силуэта!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Не все поля заполнены.");
            alert.setHeaderText("Пожалуйста заполните все поля.");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }

}
