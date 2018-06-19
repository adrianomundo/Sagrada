package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.client.view.ViewState;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DraftPool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BoardController {



    @FXML
    private ImageView panelWindow;

    @FXML
    private ImageView patternPlayer2;

    @FXML
    private ImageView patternPlayer3;

    @FXML
    private ImageView patternPlayer4;

    @FXML
    private ImageView privateCard;

    @FXML
    private ImageView patternCard;

    @FXML
    private Text tokensNumber;

    @FXML
    private ImageView roundTracker;

    @FXML
    private ImageView toolCard1;

    @FXML
    private ImageView toolCard2;

    @FXML
    private ImageView toolCard3;

    @FXML
    private ImageView publicCard1;

    @FXML
    private ImageView publicCard2;

    @FXML
    private ImageView publicCard3;

    @FXML
    private TextField textGame;

    @FXML
    private Button next;

    @FXML
    private Button skip;

    @FXML
    private Button exit;

    @FXML
    private Button roll;

    @FXML
    private ToggleGroup patternToggleGroup;

    @FXML
    private ToggleButton cell1;

    @FXML
    private ImageView imageCell1;

    @FXML
    private ToggleButton cell2;

    @FXML
    private ImageView imageCell2;

    @FXML
    private ToggleButton cell3;

    @FXML
    private ImageView imageCell3;

    @FXML
    private ToggleButton cell4;

    @FXML
    private ImageView imageCell4;

    @FXML
    private ToggleButton cell5;

    @FXML
    private ImageView imageCell5;

    @FXML
    private ToggleButton cell6;

    @FXML
    private ImageView imageCell6;

    @FXML
    private ToggleButton cell7;

    @FXML
    private ImageView imageCell7;

    @FXML
    private ToggleButton cell8;

    @FXML
    private ImageView imageCell8;

    @FXML
    private ToggleButton cell9;

    @FXML
    private ImageView imageCell9;

    @FXML
    private ToggleButton cell10;

    @FXML
    private ImageView imageCell10;

    @FXML
    private ToggleButton cell11;

    @FXML
    private ImageView imageCell11;

    @FXML
    private ToggleButton cell12;

    @FXML
    private ImageView imageCell12;

    @FXML
    private ToggleButton cell13;

    @FXML
    private ImageView imageCell13;

    @FXML
    private ToggleButton cell14;

    @FXML
    private ImageView imageCell14;

    @FXML
    private ToggleButton cell15;

    @FXML
    private ImageView imageCell15;

    @FXML
    private ToggleButton cell16;

    @FXML
    private ImageView imageCell16;

    @FXML
    private ToggleButton cell17;

    @FXML
    private ImageView imageCell17;

    @FXML
    private ToggleButton cell18;

    @FXML
    private ImageView imageCell18;

    @FXML
    private ToggleButton cell19;

    @FXML
    private ImageView imageCell19;

    @FXML
    private ToggleButton cell20;

    @FXML
    private ImageView imageCell20;

    @FXML
    private ToggleGroup roundToggleGroup;

    @FXML
    private ToggleButton round1;

    @FXML
    private ToggleButton round2;

    @FXML
    private ToggleButton round3;

    @FXML
    private ToggleButton round4;

    @FXML
    private ToggleButton round5;

    @FXML
    private ToggleButton round6;

    @FXML
    private ToggleButton round7;

    @FXML
    private ToggleButton round8;

    @FXML
    private ToggleButton round9;

    @FXML
    private ToggleGroup poolToggleGroup;

    @FXML
    private ToggleButton dice1;

    @FXML
    private ImageView imageDice1;

    @FXML
    private ToggleButton dice2;

    @FXML
    private ImageView imageDice2;

    @FXML
    private ToggleButton dice3;

    @FXML
    private ImageView imageDice3;

    @FXML
    private ToggleButton dice4;

    @FXML
    private ImageView imageDice4;

    @FXML
    private ToggleButton dice5;

    @FXML
    private ImageView imageDice5;

    @FXML
    private ToggleButton dice6;

    @FXML
    private ImageView imageDice6;

    @FXML
    private ToggleButton dice7;

    @FXML
    private ImageView imageDice7;

    @FXML
    private ToggleButton dice8;

    @FXML
    private ImageView imageDice8;

    @FXML
    private ToggleButton dice9;

    @FXML
    private ImageView imageDice9;

    @FXML
    private ImageView privateCardZoom;

    @FXML
    private ImageView publicCardZoom1;

    @FXML
    private ImageView publicCardZoom2;

    @FXML
    private ImageView publicCardZoom3;

    @FXML
    private ImageView toolCardZoom1;

    @FXML
    private ImageView toolCardZoom2;

    @FXML
    private ImageView toolCardZoom3;

    @FXML
    private Text costTool1;

    @FXML
    private Text costTool2;

    @FXML
    private Text costTool3;


    @FXML
    void handleCellEvent(ActionEvent event) {

        if (guiState == ViewState.USEDICE) {
            next.setDisable(false);
        }

        String cellCurrent = patternToggleGroup.getSelectedToggle().getUserData().toString();

        if (cellCurrent.equalsIgnoreCase("cell1")) {
            setIndexPattern(0);
        }
        if (cellCurrent.equalsIgnoreCase("cell2")) {
            setIndexPattern(1);
        }
        if (cellCurrent.equalsIgnoreCase("cell3")) {
            setIndexPattern(2);
        }
        if (cellCurrent.equalsIgnoreCase("cell4")) {
            setIndexPattern(3);
        }
        if (cellCurrent.equalsIgnoreCase("cell5")) {
            setIndexPattern(4);
        }
        if (cellCurrent.equalsIgnoreCase("cell6")) {
            setIndexPattern(5);
        }
        if (cellCurrent.equalsIgnoreCase("cell7")) {
            setIndexPattern(6);
        }
        if (cellCurrent.equalsIgnoreCase("cell8")) {
            setIndexPattern(7);
        }
        if (cellCurrent.equalsIgnoreCase("cell9")) {
            setIndexPattern(8);
        }
        if (cellCurrent.equalsIgnoreCase("cell10")) {
            setIndexPattern(9);
        }
        if (cellCurrent.equalsIgnoreCase("cell11")) {
            setIndexPattern(10);
        }
        if (cellCurrent.equalsIgnoreCase("cell12")) {
            setIndexPattern(11);
        }
        if (cellCurrent.equalsIgnoreCase("cell13")) {
            setIndexPattern(12);
        }
        if (cellCurrent.equalsIgnoreCase("cell14")) {
            setIndexPattern(13);
        }
        if (cellCurrent.equalsIgnoreCase("cell15")) {
            setIndexPattern(14);
        }
        if (cellCurrent.equalsIgnoreCase("cell16")) {
            setIndexPattern(15);
        }
        if (cellCurrent.equalsIgnoreCase("cell17")) {
            setIndexPattern(16);
        }
        if (cellCurrent.equalsIgnoreCase("cell18")) {
            setIndexPattern(17);
        }
        if (cellCurrent.equalsIgnoreCase("cell19")) {
            setIndexPattern(18);
        }
        if (cellCurrent.equalsIgnoreCase("cell20")) {
            setIndexPattern(19);
        }



    }

    @FXML
    void handleDicePool(ActionEvent event) {

        if (guiState == ViewState.MOVE) {
            next.setDisable(false);
            setGuiState(ViewState.DICEMOVE);
        }

        String diceCurrent = poolToggleGroup.getSelectedToggle().getUserData().toString();

        System.out.println(diceCurrent);

/*        if (poolToggleGroup.getSelectedToggle().equals(dice1)){
            setIndexPool(0);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice2)){
            setIndexPool(1);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice3)){
            setIndexPool(2);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice4)){
            setIndexPool(3);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice5)){
            setIndexPool(4);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice6)){
            setIndexPool(5);
        }

        if (poolToggleGroup.getSelectedToggle().equals(dice7)){
            setIndexPool(6);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice8)){
            setIndexPool(7);
        }
        if (poolToggleGroup.getSelectedToggle().equals(dice9)){
            setIndexPool(8);
        }*/

        if (diceCurrent.equalsIgnoreCase("dice1")) {
            setIndexPool(0);
        }
        if (diceCurrent.equalsIgnoreCase("dice2")) {
            setIndexPool(1);
        }
        if (diceCurrent.equalsIgnoreCase("dice3")) {
            setIndexPool(2);
        }
        if (diceCurrent.equalsIgnoreCase("dice4")) {
            setIndexPool(3);
        }
        if (diceCurrent.equalsIgnoreCase("dice5")) {
            setIndexPool(4);
        }
        if (diceCurrent.equalsIgnoreCase("dice6")) {
            setIndexPool(5);
        }
        if (diceCurrent.equalsIgnoreCase("dice7")) {
            setIndexPool(6);
        }
        if (diceCurrent.equalsIgnoreCase("dice8")) {
            setIndexPool(7);
        }
        if (diceCurrent.equalsIgnoreCase("dice9")) {
            setIndexPool(8);
        }
        

    }

    @FXML
    void handlePrivateUnzoom(MouseEvent event) {
        privateCardZoom.setVisible(false);

    }

    @FXML
    void handlePrivateZoom(MouseEvent event) {
        privateCardZoom.setVisible(true);

    }

    @FXML
    void handleRoundButton(ActionEvent event) {

    }

    @FXML
    void handleTool1(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
            }
            if (guiState == ViewState.USETOOL) {
                next.setDisable(false);
                setIndexTool(0);
            }

        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {

            toolCardZoom1.setVisible(true);
        }

        }

    @FXML
    void handleTool2(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
            }
            if (guiState == ViewState.USETOOL) {
                next.setDisable(false);
                setIndexTool(1);
            }

        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {

            toolCardZoom2.setVisible(true);
        }


    }

    @FXML
    void handleTool3(MouseEvent event) {

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (guiState == ViewState.MOVE) {
                next.setDisable(false);
                setGuiState(ViewState.TOOLMOVE);
            }

            if (guiState == ViewState.USETOOL) {
                next.setDisable(false);
                setIndexTool(2);
            }

        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            toolCardZoom3.setVisible(true);
        }

    }

    @FXML
    void handleZoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(true);

    }

    @FXML
    void handleZoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(true);
    }

    @FXML
    void handleZoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(true);

    }

    @FXML
    void handleUnzoomPublic1(MouseEvent event) {
        publicCardZoom1.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic2(MouseEvent event) {
        publicCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomPublic3(MouseEvent event) {
        publicCardZoom3.setVisible(false);

    }

    @FXML
    void handleUnzoomTool1(MouseEvent event) {
        toolCardZoom1.setVisible(false);
    }

    @FXML
    void handleUnzoomTool2(MouseEvent event) {
        toolCardZoom2.setVisible(false);

    }

    @FXML
    void handleUnzoomTool3(MouseEvent event) {
        toolCardZoom3.setVisible(false);

    }

    @FXML
    void handleUpdatePattern2(MouseEvent event) {

    }

    @FXML
    void handleUpdatePattern3(MouseEvent event) {

    }

    @FXML
    void handleUpdatePattern4(MouseEvent event) {

    }



    @FXML
    void nextButtonSelected(ActionEvent event) {

        if (guiState == ViewState.DICEMOVE) {
            mainController.getConnection().setChooseToServer(mainController.getPlayerID(), 0);
        }

        if (guiState == ViewState.TOOLMOVE) {
            mainController.getConnection().setChooseToServer(mainController.getPlayerID(), 1);
        }

        if (guiState == ViewState.USEDICE) {
            mainController.getConnection().setMoveToServer(mainController.getPlayerID(), indexPool, indexPattern);
        }

        if (guiState == ViewState.USETOOL) {
            mainController.getConnection().useToolCardToServer(mainController.getPlayerID(),indexTool);
        }
    }

    @FXML
    void skipButtonSelected(ActionEvent event) {

        mainController.getConnection().setNextTurnToServer(mainController.getPlayerID());

    }

    @FXML
    void exitButtonSelected(ActionEvent event) {

    }

    @FXML
    void rollButtonSelected(ActionEvent event) {

        mainController.getConnection().setDraftPoolToServer(mainController.getPlayerID());

    }

    private static GuiController mainController;
    private FileInputStream fileStream;
    private static int indexPool;
    private static int indexPattern;
    private static int indexTool;
    private static ViewState guiState;


    public static void setMainController(GuiController mainController){
        BoardController.mainController = mainController;
    }

    private static void setIndexPool(int indexPool) {
        BoardController.indexPool = indexPool;
    }

    private static void setIndexTool(int indexTool) {
        BoardController.indexTool = indexTool;
    }

    private static void setIndexPattern(int indexPattern) {
        BoardController.indexPattern = indexPattern;
    }

    private static void setGuiState(ViewState state) {
        BoardController.guiState = state;
    }

    public void initialize() throws IOException {

        GuiController.setBoard(this);

        setDiceData();
        setCellData();
        setToolCost();

        loadPanel();
        loadPattern();
        loadTokensNumber();
        loadPrivate();
        loadPublicCard();
        loadToolCard();
        loadOtherPattern();


        /*poolToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (poolToggleGroup.getSelectedToggle() != null) {
                    System.out.println(poolToggleGroup.getSelectedToggle().getUserData().toString());
                }
            }
        });*/


        privateCardZoom.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        publicCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom1.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom2.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toolCardZoom3.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });
    }

    private void setDiceData() {

        dice1.setUserData("dice1");
        dice2.setUserData("dice2");
        dice3.setUserData("dice3");
        dice4.setUserData("dice4");
        dice5.setUserData("dice5");
        dice6.setUserData("dice6");
        dice7.setUserData("dice7");
        dice8.setUserData("dice8");
        dice9.setUserData("dice9");

    }

    private void setCellData() {

        cell1.setUserData("cell1");
        cell2.setUserData("cell2");
        cell3.setUserData("cell3");
        cell4.setUserData("cell4");
        cell5.setUserData("cell5");
        cell6.setUserData("cell6");
        cell7.setUserData("cell7");
        cell8.setUserData("cell8");
        cell9.setUserData("cell9");
        cell10.setUserData("cell10");
        cell11.setUserData("cell11");
        cell12.setUserData("cell12");
        cell13.setUserData("cell13");
        cell14.setUserData("cell14");
        cell15.setUserData("cell15");
        cell16.setUserData("cell16");
        cell17.setUserData("cell17");
        cell18.setUserData("cell18");
        cell19.setUserData("cell19");
        cell20.setUserData("cell20");
    }

    private void setToolCost() {

        costTool1.setText("" + mainController.getToolList().get(0).getCost());
        costTool2.setText("" + mainController.getToolList().get(1).getCost());
        costTool3.setText("" + mainController.getToolList().get(2).getCost());
    }


    private void loadPanel() throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/panel");

        try {
            System.out.println("consegna panel");
            if ((mainController.getPlayerID() == 0)) {
                fileStream = new FileInputStream(filePath + "/BluePanel" + ".png");
                Image imagePlayerOne = new Image(fileStream);
                panelWindow.setImage(imagePlayerOne);
            }
            if ((mainController.getPlayerID() == 1)) {
                fileStream = new FileInputStream(filePath + "/GreenPanel" + ".png");
                Image imagePlayerTwo = new Image(fileStream);
                panelWindow.setImage(imagePlayerTwo);
            }
            if ((mainController.getPlayerID() == 2)) {
                fileStream = new FileInputStream(filePath + "/PurplePanel" + ".png");
                Image imagePlayerThree = new Image(fileStream);
                panelWindow.setImage(imagePlayerThree);
            }

            if ((mainController.getPlayerID() == 3)) {
                fileStream = new FileInputStream(filePath + "/RedPanel" + ".png");
                Image imagePlayerFour = new Image(fileStream);
                panelWindow.setImage(imagePlayerFour);
            }
        } finally {
            fileStream.close();
        }

    }

    private void loadPrivate() throws IOException {

        File file = new File("./");
        String fileColor = mainController.getPrivateCard().getColour().toString();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/private");

        try {
            System.out.println("private board");
            fileStream = new FileInputStream(filePath + "/" + fileColor + ".png");
            Image image = new Image(fileStream);
            privateCard.setImage(image);
            privateCardZoom.setImage(image);
        }
        finally {
            fileStream.close();
        }
    }


    private void loadPattern() throws IOException {

        File file = new File("./");
        String filePattern = mainController.getPatternCurrent().getName();
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");

        try {
            System.out.println("consegna singola pattern");
            fileStream = new FileInputStream(filePath + "/" + filePattern + ".jpg");
            Image image = new Image(fileStream);
            patternCard.setImage(image);
        }
        finally {
            fileStream.close();
        }

    }


    private void loadPublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getPublicCardList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/public");

            try {
                System.out.println("consegna public board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    publicCard1.setImage(image);
                    publicCardZoom1.setImage(image);
                }
                if (i == 1) {
                    publicCard2.setImage(image);
                    publicCardZoom2.setImage(image);
                }
                if (i == 2) {
                    publicCard3.setImage(image);
                    publicCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadToolCard() throws IOException {

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            File file = new File("./");
            String fileName = mainController.getToolList().get(i).getName();
            String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/tool");

            try {
                System.out.println("consegna tool board");
                fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
                Image image = new Image(fileStream);
                if (i == 0) {
                    toolCard1.setImage(image);
                    toolCardZoom1.setImage(image);
                }
                if (i == 1) {
                    toolCard2.setImage(image);
                    toolCardZoom2.setImage(image);
                }
                if (i == 2) {
                    toolCard3.setImage(image);
                    toolCardZoom3.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }

        }
    }

    private void loadTokensNumber() {
        tokensNumber.setText("" + mainController.getPatternCurrent().getDifficulty());
    }

    private void loadOtherPattern() throws IOException {

        if (mainController.getPlayerID() == 0) {

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player2-0");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player3-0");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player4-0");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 1) {

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player2-1");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-1");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 4-1");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 2){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player 2-2");
                fileStream.close();
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-2");
                fileStream.close();
            }

            if (mainController.getPatternID3() != null) {
                String fileName = mainController.getPatternID3().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 4-2");
                fileStream.close();
            }

        }

        if (mainController.getPlayerID() == 3){

            if (mainController.getPatternID0() != null) {
                String fileName = mainController.getPatternID0().getName();
                Image image = loadImage(fileName);
                patternPlayer2.setImage(image);
                System.out.println("setted player 2-3");
                fileStream.close();
            }

            if (mainController.getPatternID1() != null) {
                String fileName = mainController.getPatternID1().getName();
                Image image = loadImage(fileName);
                patternPlayer3.setImage(image);
                System.out.println("setted player 3-3");
                fileStream.close();
            }

            if (mainController.getPatternID2() != null) {
                String fileName = mainController.getPatternID2().getName();
                Image image = loadImage(fileName);
                patternPlayer4.setImage(image);
                System.out.println("setted player 3-3 ");
                fileStream.close();
            }

        }

    }

    private Image loadImage(String fileName) throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/pattern");
        fileStream = new FileInputStream(filePath + "/" + fileName + ".jpg");
        return new Image(fileStream);
    }

    private void loadDiceOnPattern(int indexPattern, String fileName) throws IOException {

        File file = new File("./");
        String filePath = file.getAbsolutePath().replace(".", "src/main/resources/images/dice");

        try {
            System.out.println("updating  pattern");
            fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
            Image image = new Image(fileStream);

            if (indexPattern == 0) {
                imageCell1.setImage(image);
                cell1.setOpacity(1);
            }
            if (indexPattern == 1) {
                imageCell2.setImage(image);
                cell2.setOpacity(1);
            }
            if (indexPattern == 2) {
                imageCell3.setImage(image);
                cell3.setOpacity(1);
            }
            if (indexPattern == 3) {
                imageCell4.setImage(image);
                cell4.setOpacity(1);
            }
            if (indexPattern == 4) {
                imageCell5.setImage(image);
                cell5.setOpacity(1);
            }
            if (indexPattern == 5) {
                imageCell6.setImage(image);
                cell6.setOpacity(1);
            }
            if (indexPattern == 6) {
                imageCell7.setImage(image);
                cell7.setOpacity(1);
            }
            if (indexPattern == 7) {
                imageCell8.setImage(image);
                cell8.setOpacity(1);
            }
            if (indexPattern == 8) {
                imageCell9.setImage(image);
                cell9.setOpacity(1);
            }
            if (indexPattern == 9) {
                imageCell10.setImage(image);
                cell10.setOpacity(1);
            }
            if (indexPattern == 10) {
                imageCell11.setImage(image);
                cell11.setOpacity(1);
            }
            if (indexPattern == 11) {
                imageCell12.setImage(image);
                cell12.setOpacity(1);
            }
            if (indexPattern == 12) {
                imageCell13.setImage(image);
                cell13.setOpacity(1);
            }
            if (indexPattern == 13) {
                imageCell14.setImage(image);
                cell14.setOpacity(1);
            }
            if (indexPattern == 14) {
                imageCell15.setImage(image);
                cell15.setOpacity(1);
            }
            if (indexPattern == 15) {
                imageCell16.setImage(image);
                cell16.setOpacity(1);
            }
            if (indexPattern == 16) {
                imageCell17.setImage(image);
                cell17.setOpacity(1);
            }
            if (indexPattern == 17) {
                imageCell18.setImage(image);
                cell18.setOpacity(1);
            }
            if (indexPattern == 18) {
                imageCell19.setImage(image);
                cell19.setOpacity(1);
            }
            if (indexPattern == 19) {
                imageCell20.setImage(image);
                cell20.setOpacity(1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            fileStream.close();
        }

    }

    public void updateRound(int round) {
        textGame.setText("Round " + round + "is started");
        next.setDisable(true);
        skip.setDisable(true);
        roll.setDisable(true);
    }

    public void updateTurn() {
        textGame.setText("It's your turn");
        next.setDisable(false);
        skip.setDisable(false);
        roll.setDisable(true);
    }

    public void updateOtherTurn(String name) {
        textGame.setText("It's " + name + " turn");
        next.setDisable(true);
        skip.setDisable(true);
        roll.setDisable(true);
    }

    public void textRollMsg() {
        textGame.setText("Click the roll button to roll the draft pool");
        roll.setDisable(false);
    }

    public void updateDraftPool(DraftPool draftPool) throws IOException {

       for (int i = 0; i < draftPool.getDraftPool().size(); i++) {

           File file = new File("./");
           String fileName = draftPool.getDraftPool().get(i).toStringGui();
           String filePath = file.getAbsolutePath().replace(".", "src/main/resources/Images/dice");

           try {
               fileStream = new FileInputStream(filePath + "/" + fileName + ".png");
               Image image = new Image(fileStream);
               if (i == 0) {
                   imageDice1.setImage(image);
                   dice1.setVisible(true);
               }
               if (i == 1) {
                   imageDice2.setImage(image);
                   dice2.setVisible(true);
               }
               if (i == 2) {
                   imageDice3.setImage(image);
                   dice3.setVisible(true);
               }
               if (i == 3) {
                   imageDice4.setImage(image);
                   dice4.setVisible(true);
               }
               if (i == 4) {
                   imageDice5.setImage(image);
                   dice5.setVisible(true);
               }
               if (i == 5) {
                   imageDice6.setImage(image);
                   dice6.setVisible(true);
               }
               if (i == 6) {
                   imageDice7.setImage(image);
                   dice7.setVisible(true);
               }
               if (i == 7) {
                   imageDice8.setImage(image);
                   dice8.setVisible(true);
               }
               if (i == 8) {
                   imageDice9.setImage(image);
                   dice9.setVisible(true);
               }
           }
           catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           finally {
               fileStream.close();
           }
       }
    }

    public void updateToken(int tokenNumber) {
        tokensNumber.setText("" + tokenNumber);
    }

    public void updatePattern(PatternCard patternCard) {

        for (int index = 0; index < patternCard.getPattern().size(); index++) {

            if (!patternCard.getPattern().get(index).isBoxEmpty()) {

                String filename = patternCard.getDice(index).toStringGui();

                try {
                    loadDiceOnPattern(index, filename);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void textChooseMsg() {
        roll.setDisable(true);
        next.setDisable(true);
        setGuiState(ViewState.MOVE);
        textGame.setText("Click a dice or a Tool to perform a move, then NEXT - Last click we'll be considered valid");
    }

    public void textMoveMsg() {
        next.setDisable(true);
        setGuiState(ViewState.USEDICE);
        textGame.setText("Click the dice you want to move & the cell of the window, then NEXT or SKIP");
    }

    public void toolMoveMsg() {
        next.setDisable(true);
        setGuiState(ViewState.USETOOL);
        textGame.setText("Click on the tool card (if) you want to use it, then NEXT or SKIP");
    }


}
