package it.polimi.se2018.client.view.gui;

import it.polimi.se2018.server.model.Cards.PatternCard;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.logging.Logger;
import static java.lang.System.out;

/**
 * Class ChoosePattern: class that handles the choice of the pattern card by the player
 * @author fadda-miceli-mundo
 */
public class ChoosePattern {

    private final Logger log = Logger.getLogger(ChoosePattern.class.getName());
    private boolean customCard = false;
    private static int indexPattern;
    private static GuiController mainController;
    private InputStream fileStream;
    private SimpleBooleanProperty patternSetted = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty customPlay = new SimpleBooleanProperty(true);
    private PatternCard selfScheme;

    /**
     * /**
     * method that allows to set the controller in that scene
     * @param mainController controller of the scene
     */
    static void setMainController(GuiController mainController){
        ChoosePattern.mainController = mainController;
    }

    /**
     * method that allows to set the index of the pattern
     * @param indexPattern index of the pattern
     */
    public static void setIndexPattern(int indexPattern) {
        ChoosePattern.indexPattern = indexPattern;
    }

    /**
     * method that allows to initialize loading all the cards in the scene
     * @throws IOException if something goes wrong
     */
    public void initialize () throws IOException {

        if (mainController.isSinglePlayer()) {
            loadFilePrivateSingle();
            loadFileToolCard();
            loadFilePublicCard();
            loadFilePatternCard();
        }
        else {
            loadFilePrivate();
            loadFileToolCard();
            loadFilePublicCard();
            loadFilePatternCard();
        }

        playGameButton.disableProperty().bind((Bindings.isNull(patternToggleGroup.selectedToggleProperty()).or(patternSetted)).and(customPlay));

        playGameButton.disableProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));

        toolCard1Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
        toolCard2Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
        toolCard3Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));

        privateCardZoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
        publicCard3Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
        publicCard2Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
        publicCard1Zoom.visibleProperty().addListener((observable, oldValue, newValue) -> out.println(newValue));
    }


    //-----------single player fxml------------------
    @FXML
    private ImageView privateCardTwo;
    @FXML
    private ImageView toolCardFour;
    @FXML
    private ImageView toolCardFive;
    @FXML
    private ImageView privateCardZoom2;
    @FXML
    private ImageView toolCard5Zoom;
    @FXML
    private ImageView toolCard4Zoom;

    /**
     * method that allows to unzoom the second private
     */
    @FXML
    void handlePrivateUnzoom2() {
        privateCardZoom2.setVisible(false);

    }
    /**
     * method that allows to zoom the second private
     */
    @FXML
    void handlePrivateZoomTwo() {
        privateCardZoom2.setVisible(true);

    }
    /**
     * method that allows to unzoom the fourth tool card
     */
    @FXML
    void handleToolUnzoom4() {
        toolCard4Zoom.setVisible(false);

    }
    /**
     * method that allows to unzoom the fifth tool card
     */
    @FXML
    void handleToolUnzoom5() {
        toolCard5Zoom.setVisible(false);
    }
    /**
     * method that allows to zoom the fourth tool card
     */
    @FXML
    void handleToolZoom4() {
        toolCard4Zoom.setVisible(true);

    }
    /**
     * method that allows to zoom the fourth tool card
     */
    @FXML
    void handleToolZoom5() {
        toolCard5Zoom.setVisible(true);

    }



    //-----------------multi player fxml
    @FXML
    private ImageView privateCard;
    @FXML
    private ImageView toolCardOne;
    @FXML
    private ImageView toolCardTwo;
    @FXML
    private ImageView toolCardThree;
    @FXML
    private ImageView publicOne;
    @FXML
    private ImageView publicTwo;
    @FXML
    private ImageView publicThree;
    @FXML
    private ImageView patternCardOne;
    @FXML
    private ImageView patternCardTwo;
    @FXML
    private ImageView patternCardThree;
    @FXML
    private ImageView patternCardFour;
    @FXML
    private ImageView toolCard1Zoom;
    @FXML
    private ImageView toolCard2Zoom;
    @FXML
    private ImageView toolCard3Zoom;
    @FXML
    private ImageView publicCard1Zoom;
    @FXML
    private ImageView publicCard2Zoom;
    @FXML
    private ImageView publicCard3Zoom;
    @FXML
    private ImageView privateCardZoom;
    @FXML
    private Button playGameButton;
    @FXML
    private Button loadButton;
    @FXML
    private RadioButton radioPatternOne;
    @FXML
    private RadioButton radioPatternTwo;
    @FXML
    private RadioButton radioPatternThree;
    @FXML
    private RadioButton radioPatternFour;
    @FXML
    private ToggleGroup patternToggleGroup;

    /**
     * method that allows to unzoom the first private card
     */
    @FXML
    void handlePrivateUnzoom (){
            privateCardZoom.setVisible(false);
        }

    /**
     * method that allows to zoom the first private card
     */
    @FXML
    void handlePrivateZoom (){
        privateCardZoom.setVisible(true);
    }

    /**
     * method that allows to unzoom the first public card
     */
    @FXML
    void handlePublicUnzoom1 (){
        publicCard1Zoom.setVisible(false);
    }

    /**
     * method that allows to unzoom the second public card
     */
    @FXML
    void handlePublicUnzoom2 (){
        publicCard2Zoom.setVisible(false);
    }

    /**
     * method that allows to unzoom the third public card
     */
    @FXML
    void handlePublicUnzoom3 (){
        publicCard3Zoom.setVisible(false);
    }

    /**
     * method that allows to zoom the first public card
     */
    @FXML
    void handlePublicZoom1 (){
        publicCard1Zoom.setVisible(true);
    }

    /**
     * method that allows to zoom the second public card
     */
    @FXML
    void handlePublicZoom2 (){
        publicCard2Zoom.setVisible(true);
    }

    /**
     * method that allows to zoom the third public card
     */
    @FXML
    void handlePublicZoom3 (){
        publicCard3Zoom.setVisible(true);
    }

    /**
     * method that allows to unzoom the first tool card
     */
    @FXML
    void handleToolUnzoom1 (){
        toolCard1Zoom.setVisible(false);
    }

    /**
     * method that allows to unzoom the second tool card
     */
    @FXML
    void handleToolUnzoom2 (){
        toolCard2Zoom.setVisible(false);
    }

    /**
     * method that allows to unzoom the third tool card
     */
    @FXML
    void handleToolUnzoom3 (){
        toolCard3Zoom.setVisible(false);
    }

    /**
     * method that allows to zoom the first tool card
     */
    @FXML
    void handleToolZoom1 (){
        toolCard1Zoom.setVisible(true);
    }

    /**
     * method that allows to zoom the second tool card
     */
    @FXML
    void handleToolZoom2 (){
        toolCard2Zoom.setVisible(true);
    }


    /**
     * method that allows to zoom the third tool card
     */
    @FXML
    void handleToolZoom3 (){
        toolCard3Zoom.setVisible(true);
    }


    /**
     * method that allows to set the pattern card after the choise of the player
     */
    @FXML
    void playButtonSelected() {

        patternSetted.setValue(true);

        AlertBox.display("Sagrada Choose", "Please, wait some seconds and the game will start");

        try {
            if (patternToggleGroup.getSelectedToggle().equals(radioPatternFour)) {
                setIndexPattern(3);
            } else if (patternToggleGroup.getSelectedToggle().equals(radioPatternThree)) {
                setIndexPattern(2);
            } else if (patternToggleGroup.getSelectedToggle().equals(radioPatternTwo)) {
                setIndexPattern(1);
            } else {
                setIndexPattern(0);
            }
            mainController.setPattern(indexPattern);
        } catch (NullPointerException e) {
            log.info("null pointer play button");
            log.warning(e.getMessage());
        }

        if (customCard) {
            mainController.setCustomPattern(selfScheme);
        }
    }


    /**
     * method that allows to load a custom pattern card
     */
    @FXML
    void loadButtonSelected()  {

        File file = null;
        String name = null;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.setInitialDirectory(new File("."));

        try {
            do {
                file = fileChooser.showOpenDialog(mainController.getStage());
                name = file.getName();
            }
            while (!(file.getName().matches(".*[a-zA-Z0-9]+.*" + ".json")));
        }
        catch (NullPointerException e) {
            log.info("closing file");
            log.warning(e.getMessage());
        }
        
        if (file != null) {
            InputStream inputStream = ChoosePattern.class.getResourceAsStream("/json/custom/" + name);
            selfScheme = new PatternCard();
            selfScheme = selfScheme.loadCard(inputStream);
            customCard = true;
            customPlay.setValue(false);
            radioPatternOne.setDisable(true);
            radioPatternTwo.setDisable(true);
            radioPatternThree.setDisable(true);
            radioPatternFour.setDisable(true);
            loadButton.setDisable(true);
        }
    }


    /**
     * method that allows to load the private card from a file
     * @throws IOException if something goes wrong
     */
    private void loadFilePrivate() throws IOException {

        String fileColor = mainController.getPrivateCard().getColour().toString();

        try {
            fileStream = ChoosePattern.class.getResourceAsStream("/images/private/" + fileColor + ".png");
            Image image = new Image(fileStream);
            privateCard.setImage(image);
            privateCardZoom.setImage(image);
        }
        finally {
            fileStream.close();
        }
    }

    /**
     * method that allows to load the two private card from a file in single player mode
     * @throws IOException if something goes wrong
     */
    private void loadFilePrivateSingle() throws IOException {

        for (int i = 0; i < mainController.getPrivateCardSingle().size(); i++) {

            String fileColor = mainController.getPrivateCardSingle().get(i).getColour().toString();

            try {
                fileStream = ChoosePattern.class.getResourceAsStream("/images/private/" + fileColor + ".png");
                Image image = new Image(fileStream);

                if (i == 0) {
                    privateCard.setImage(image);
                    privateCardZoom.setImage(image);
                }
                if (i == 1) {
                    privateCardTwo.setImage(image);
                    privateCardTwo.setVisible(true);
                    privateCardZoom2.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }
        }
    }

    /**
     * method that allows to load the tool card card from a file
     * @throws IOException if something goes wrong
     */
    private void loadFileToolCard() throws IOException  {

        for (int i = 0; i < mainController.getToolList().size(); i++) {

            String fileName = mainController.getToolList().get(i).getName();

            if (mainController.isSinglePlayer()) {
                try {
                    fileStream = ChoosePattern.class.getResourceAsStream("/images/tool/" + fileName + ".png");
                    Image image = new Image(fileStream);

                    if (i == 0) {
                        toolCardOne.setImage(image);
                        toolCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        toolCardTwo.setImage(image);
                        toolCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        toolCardThree.setImage(image);
                        toolCard3Zoom.setImage(image);
                    }
                    if (i == 3) {
                        toolCardFour.setImage(image);
                        toolCardFour.setVisible(true);
                        toolCard4Zoom.setImage(image);
                    }
                    if (i == 4) {
                        toolCardFive.setImage(image);
                        toolCardFive.setVisible(true);
                        toolCard5Zoom.setImage(image);
                    }
                }
                finally {
                    fileStream.close();
                }
            }

            else {
                try {
                    log.info("loading tool card");

                    fileStream = ChoosePattern.class.getResourceAsStream("/images/tool/" + fileName + ".png");
                    Image image = new Image(fileStream);

                    if (i == 0) {
                        toolCardOne.setImage(image);
                        toolCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        toolCardTwo.setImage(image);
                        toolCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        toolCardThree.setImage(image);
                        toolCard3Zoom.setImage(image);
                    }
                }
                finally {
                    fileStream.close();
                }
            }

        }
    }

    /**
     * method that allows to load the public card from a file
     * @throws IOException if something goes wrong
     */
    private void loadFilePublicCard() throws IOException  {

        for (int i = 0; i < mainController.getPublicCardList().size(); i++) {

            String fileName = mainController.getPublicCardList().get(i).getName();

            if (mainController.isSinglePlayer()) {
                try {

                    fileStream = ChoosePattern.class.getResourceAsStream("/images/public/" + fileName + ".png");
                    Image image = new Image(fileStream);

                    if (i == 0) {
                        publicOne.setImage(image);
                        publicCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        publicTwo.setImage(image);
                        publicCard2Zoom.setImage(image);
                    }

                }
                finally {
                    fileStream.close();
                }
            }

            else{
                try {
                    log.info("loading public card");

                    fileStream = ChoosePattern.class.getResourceAsStream("/images/public/" + fileName + ".png");
                    Image image = new Image(fileStream);

                    if (i == 0) {
                        publicOne.setImage(image);
                        publicCard1Zoom.setImage(image);
                    }
                    if (i == 1) {
                        publicTwo.setImage(image);
                        publicCard2Zoom.setImage(image);
                    }
                    if (i == 2) {
                        publicThree.setImage(image);
                        publicCard3Zoom.setImage(image);
                    }
                }
                finally {
                    fileStream.close();
                }
            }
        }
    }

    /**
     * method that allows to load the pattern cards from a file
     * @throws IOException if something goes wrong
     */
    private void loadFilePatternCard() throws IOException  {

        for (int i = 0; i < mainController.getPatternList().size(); i++) {

            String fileName = mainController.getPatternList().get(i).getName();

            try {
                log.info("loading pattern card");

                fileStream = ChoosePattern.class.getResourceAsStream("/images/pattern/" + fileName + ".png");
                Image image = new Image(fileStream);

                if (i == 0) {
                    patternCardOne.setImage(image);
                }
                if (i == 1) {
                    patternCardTwo.setImage(image);
                }
                if (i == 2) {
                    patternCardThree.setImage(image);
                }
                if (i == 3) {
                    patternCardFour.setImage(image);
                }
            }
            finally {
                fileStream.close();
            }
        }
    }

}

