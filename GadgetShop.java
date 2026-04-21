import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import java.util.ArrayList;

public class GadgetShop extends Application {

    // MP3 fields (left side)
    private final TextField mp3ModelField = new TextField();  
    private final TextField mp3PriceField = new TextField();  
    private final TextField mp3WeightField = new TextField(); 
    private final TextField mp3SizeField = new TextField();   
    private final TextField memoryField = new TextField();      // MP3 memory
    private final TextField downloadSizeField = new TextField(); // download size


    // Mobile fields (right side)
    private final TextField mobileModelField = new TextField();  
    private final TextField mobilePriceField = new TextField();  
    private final TextField mobileWeightField = new TextField(); 
    private final TextField mobileSizeField = new TextField();   
    private final TextField creditField = new TextField();       // Mobile credit
    private final TextField addCreditField = new TextField();  // Mobile add credit
    private final TextField phoneNumberField = new TextField();  // phone number
    private final TextField durationField = new TextField();     // call duration

    // Display and log
    private final TextField displayNumberField = new TextField(); 
    private final TextArea logArea = new TextArea();
    
    // delete music field
    private final TextField deleteSizeField = new TextField(); 

    // List of gadgets
    private final ArrayList<Gadget> gadgets = new ArrayList<>();

    // sounds
    private AudioClip successSound;
    private AudioClip callSound;
    private AudioClip downloadSound;
    private AudioClip failSound;


    @Override
    public void start(Stage stage) {

        // load sounds
        successSound = new AudioClip(getClass().getResource("success.wav").toExternalForm());
        callSound = new AudioClip(getClass().getResource("call.wav").toExternalForm());
        downloadSound = new AudioClip(getClass().getResource("download.wav").toExternalForm());
        failSound = new AudioClip(getClass().getResource("fail.wav").toExternalForm());

        
        Pane root = new Pane();   
        root.setStyle("-fx-background-color:#222222;"); // background

        // TITLES
        Label mp3Title = new Label("MP3 Player"); 
        mp3Title.setLayoutX(125); 
        mp3Title.setLayoutY(10);
        mp3Title.setStyle("-fx-font-size:16px; -fx-font-weight:bold; -fx-text-fill:white;");

        Label mobileTitle = new Label("Mobile Phone"); 
        mobileTitle.setLayoutX(415); 
        mobileTitle.setLayoutY(10);
        mobileTitle.setStyle("-fx-font-size:16px; -fx-font-weight:bold; -fx-text-fill:white;");

        // ----------------- MP3 INPUTS -----------------
        Label modelLabel1 = new Label("Model:"); 
        modelLabel1.setLayoutX(12); 
        modelLabel1.setLayoutY(50); 
        
        modelLabel1.setStyle("-fx-text-fill:white;");
        mp3ModelField.setLayoutX(100); 
        mp3ModelField.setLayoutY(50);

        Label priceLabel1 = new Label("Price (\u00A3):"); 
        priceLabel1.setLayoutX(12); 
        priceLabel1.setLayoutY(80); 
       
        priceLabel1.setStyle("-fx-text-fill:white;");
        mp3PriceField.setLayoutX(100); 
        mp3PriceField.setLayoutY(80);

        Label weightLabel1 = new Label("Weight (g):"); 
        weightLabel1.setLayoutX(12); 
        weightLabel1.setLayoutY(110); 
        
        weightLabel1.setStyle("-fx-text-fill:white;");
        mp3WeightField.setLayoutX(100); 
        mp3WeightField.setLayoutY(110);

        Label sizeLabel1 = new Label("Size (10x10x10):"); 
        sizeLabel1.setLayoutX(8); 
        sizeLabel1.setLayoutY(140); 
        
        sizeLabel1.setStyle("-fx-text-fill:white;");
        mp3SizeField.setLayoutX(100); 
        mp3SizeField.setLayoutY(140);

        Label memoryLabel = new Label("Memory (MB):"); 
        memoryLabel.setLayoutX(12); 
        memoryLabel.setLayoutY(170); 
        
        memoryLabel.setStyle("-fx-text-fill:white;");
        memoryField.setLayoutX(100); 
        memoryField.setLayoutY(170);

        Label deleteSizeLabel = new Label("Delete Size (MB):");
        deleteSizeLabel.setLayoutX(8);
        deleteSizeLabel.setLayoutY(310);
        deleteSizeLabel.setStyle("-fx-text-fill:white;");

        deleteSizeField.setLayoutX(100);
        deleteSizeField.setLayoutY(310);

        Button deleteMusicButton = new Button("Delete Music");
        deleteMusicButton.setLayoutX(100);
        deleteMusicButton.setLayoutY(340);
        deleteMusicButton.setStyle("-fx-background-color:#F44336; -fx-text-fill:white; -fx-background-radius:8;");

        Button addMP3Button = new Button("Add MP3"); 
        addMP3Button.setLayoutX(100); 
        addMP3Button.setLayoutY(200);
        addMP3Button.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white; -fx-background-radius:8;");

        // ----------------- DOWNLOAD MUSIC -----------------
        
        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(100); 
        downloadMusicButton.setLayoutY(270);
        downloadMusicButton.setStyle("-fx-background-color:#9C27B0; -fx-text-fill:white; -fx-background-radius:8;");
        
        Label downloadLabel = new Label("Download (MB):");
        downloadLabel.setLayoutX(8); 
        downloadLabel.setLayoutY(240); 
        
        downloadLabel.setStyle("-fx-text-fill:white;");
        downloadSizeField.setLayoutX(100); 
        downloadSizeField.setLayoutY(240);

        // ----------------- MOBILE INPUTS -----------------
        Label modelLabel2 = new Label("Model:"); 
        modelLabel2.setLayoutX(294); 
        modelLabel2.setLayoutY(50); 
       
        modelLabel2.setStyle("-fx-text-fill:white;");
        mobileModelField.setLayoutX(380); 
        mobileModelField.setLayoutY(50);

        Label priceLabel2 = new Label("Price (\u00A3):"); 
        priceLabel2.setLayoutX(294); 
        priceLabel2.setLayoutY(80); 
        
        priceLabel2.setStyle("-fx-text-fill:white;");
        mobilePriceField.setLayoutX(380); 
        mobilePriceField.setLayoutY(80);

        Label weightLabel2 = new Label("Weight (g):"); 
        weightLabel2.setLayoutX(294); 
        weightLabel2.setLayoutY(110); 
        
        weightLabel2.setStyle("-fx-text-fill:white;");
        mobileWeightField.setLayoutX(380); 
        mobileWeightField.setLayoutY(110);

        Label sizeLabel2 = new Label("Size (10x10x10):"); 
        sizeLabel2.setLayoutX(290); 
        sizeLabel2.setLayoutY(140); 
        
        sizeLabel2.setStyle("-fx-text-fill:white;");
        mobileSizeField.setLayoutX(380); 
        mobileSizeField.setLayoutY(140);

        Label creditLabel = new Label("Credit (\u00A3):"); 
        creditLabel.setLayoutX(294); 
        creditLabel.setLayoutY(170); 
        
        creditLabel.setStyle("-fx-text-fill:white;");
        creditField.setLayoutX(380); 
        creditField.setLayoutY(170);

        Button addMobileButton = new Button("Add Mobile"); 
        addMobileButton.setLayoutX(380); 
        addMobileButton.setLayoutY(200);
        addMobileButton.setStyle("-fx-background-color:#2196F3; -fx-text-fill:white; -fx-background-radius:8;");
        
        // ----------------- ADD CREDIT -----------------
        Label addCreditLabel = new Label("Add Credit (\u00A3):");
        addCreditLabel.setLayoutX(294); 
        addCreditLabel.setLayoutY(240);
        addCreditLabel.setStyle("-fx-text-fill:white;");

        addCreditField.setLayoutX(380); 
        addCreditField.setLayoutY(240);

        Button addCreditButton = new Button("Add Credit");
        addCreditButton.setLayoutX(380); 
        addCreditButton.setLayoutY(270);
        addCreditButton.setStyle("-fx-background-color:#FF5722; -fx-text-fill:white; -fx-background-radius:8; -fx-font-weight:bold;");

        // ----------------- MAKE CALL -----------------

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setLayoutX(293); 
        phoneLabel.setLayoutY(310); 
        
        phoneLabel.setStyle("-fx-text-fill:white;");
        phoneNumberField.setLayoutX(380); 
        phoneNumberField.setLayoutY(310);
        
        Label durationLabel = new Label("Duration:");
        durationLabel.setLayoutX(293); 
        durationLabel.setLayoutY(340); 
        
        durationLabel.setStyle("-fx-text-fill:white;");
        durationField.setLayoutX(380); 
        durationField.setLayoutY(340);

        Button makeCallButton = new Button("Make Call");
        makeCallButton.setLayoutX(380); 
        makeCallButton.setLayoutY(370);
        makeCallButton.setStyle("-fx-background-color:#FF9800; -fx-text-fill:white; -fx-background-radius:8;");
        
        // ----------------- DISPLAY CONTROLS -----------------
        Label displayLabel = new Label("Display Number:"); 
        displayLabel.setLayoutX(150); 
        displayLabel.setLayoutY(411); 
        
        displayLabel.setStyle("-fx-text-fill:white;");
        displayNumberField.setLayoutX(245); 
        displayNumberField.setLayoutY(410);

        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(330); 
        displayAllButton.setLayoutY(440);
        displayAllButton.setStyle("-fx-background-color:#03A9F4; -fx-text-fill:white; -fx-background-radius:8;");

        Button displayOneButton = new Button("Display One");
        displayOneButton.setLayoutX(245); 
        displayOneButton.setLayoutY(440);
        displayOneButton.setStyle("-fx-background-color:#03A9F4; -fx-text-fill:white; -fx-background-radius:8;");

        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(530); 
        clearButton.setLayoutY(440);
        clearButton.setStyle("-fx-background-color:#757575; -fx-text-fill:white; -fx-background-radius:8;");
        
        Button deleteDevicesButton = new Button("Delete Devices");
        deleteDevicesButton.setLayoutX(20); 
        deleteDevicesButton.setLayoutY(440);
        deleteDevicesButton.setStyle("-fx-background-color:#757575; -fx-text-fill:white; -fx-background-radius:8;");

        // ----------------- LOG AREA -----------------
        logArea.setLayoutX(20); 
        logArea.setLayoutY(467);
        logArea.setPrefWidth(560); 
        logArea.setPrefHeight(150);
        logArea.setStyle("-fx-control-inner-background: #333333; -fx-text-fill:white;");
        logArea.setEditable(false); 

        // ----------------- BUTTON ACTIONS -----------------

        addMP3Button.setOnAction(e -> {
            try {
                String model = mp3ModelField.getText().trim();
                String size = mp3SizeField.getText().trim();
                if (model.isEmpty() || size.isEmpty()) {
                    showError("Input Error", "Model and Size cannot be empty.");
                    return;
                }

                double price = Double.parseDouble(mp3PriceField.getText().trim());
                int weight = Integer.parseInt(mp3WeightField.getText().trim());
                int memory = Integer.parseInt(memoryField.getText().trim());

                if (price <= 0 || weight <= 0 || memory <= 0) {
                    showError("Input Error", "Price, weight and memory must be positive.");
                    return;
                }

                MP3 c = new MP3(model,price,weight,size,memory);

                gadgets.add(c);
                logArea.appendText("MP3 added successfully\n");
                successSound.play();

            } catch (NumberFormatException ex) {
                showError("Input Error", "Check price, weight and memory.");
            }
        });
        
        addMobileButton.setOnAction(e -> {  //ADD MOBILE
            try {
                String model = mobileModelField.getText().trim();
                String size = mobileSizeField.getText().trim();

                if (model.isEmpty() || size.isEmpty()) {
                    showError("Input Error", "Model and Size cannot be empty.");
                    return;
                }

                double price = Double.parseDouble(mobilePriceField.getText().trim());
                int weight = Integer.parseInt(mobileWeightField.getText().trim());
                int credit = Integer.parseInt(creditField.getText().trim());

                if (price <= 0 || weight <= 0 || credit < 0) {
                    showError("Input Error", "Invalid numeric values.");
                    return;
                }

                Mobile m = new Mobile(model,price,weight,size,credit);

                gadgets.add(m);
                logArea.appendText("Mobile added successfully\n");
                successSound.play();

            } catch (NumberFormatException ex) {
                showError("Input Error", "Check price, weight and credit.");
            }
        });
        
        displayAllButton.setOnAction(e -> { //DISPLAY ALL
            logArea.clear();
            for (int i = 0; i < gadgets.size(); i++) {
                logArea.appendText(i + ": " + gadgets.get(i).toString() + "\n");
            }
            logArea.setScrollTop(Double.MAX_VALUE);
            successSound.play();
        });

        displayOneButton.setOnAction(e -> {     //DISPLAY ONE
            int index = getDisplayNumber();
            if (index != -1) {
                logArea.appendText(gadgets.get(index).toString() + "\n");
                logArea.setScrollTop(Double.MAX_VALUE);
                successSound.play();
            }
        });

        makeCallButton.setOnAction(e -> {   //MAKE CALL
            try {
                int index = getDisplayNumber();
                if (index == -1) return;

                String number = phoneNumberField.getText().trim();
                if (number.isEmpty()) {
                    showError("Error", "Enter a phone number.");
                    return;
                }

                int duration = Integer.parseInt(durationField.getText().trim());
                if (duration <= 0) {
                    showError("Error", "Duration must be positive.");
                    return;
                }

                Object gadget = gadgets.get(index);
                if (gadget instanceof Mobile mobile) { 
                    if (duration > mobile.getCredit()) {
                        showError("Error", "Insufficient credit. Need " + duration + ", have " + mobile.getCredit() + " minutes.");
                        return;
                    }
                    mobile.makeCall(number, duration);
                    logArea.appendText("Calling " + number + " for " + duration + " minutes\n");
                    callSound.play();
                    successSound.play();
                    logArea.setScrollTop(Double.MAX_VALUE);
                } else {
                    showError("Error", "Selected gadget is not a Mobile.");
                }
            } catch (NumberFormatException ex) {
                showError("Error", "Duration must be integer.");
            } catch (Exception ex) {
                showError("Error", "Cannot make call.");
            }
        });

        downloadMusicButton.setOnAction(e -> {  //DOWNLOAD MUSIC
            try {
                int index = getDisplayNumber();
                if (index == -1) return;

                int size = Integer.parseInt(downloadSizeField.getText().trim());
                if (size <= 0) {
                    showError("Error", "Download size must be positive.");
                    return;
                }

                Object gadget = gadgets.get(index);
                if (gadget instanceof MP3 mp3) {
                    if (size > mp3.getAvailableMemory()) {
                        showError("Error", "Not enough memory. Need " + size + "MB, have " + mp3.getAvailableMemory() + "MB.");
                        return;
                    }
                    mp3.downloadMusic(size);
                    logArea.appendText("Downloaded " + size + "MB\n");
                    downloadSound.play();
                    logArea.setScrollTop(Double.MAX_VALUE);
                } else {
                    showError("Error", "Selected gadget is not an MP3.");
                }
            } catch (NumberFormatException ex) {
                showError("Error", "Download size must be integer.");
            } catch (Exception ex) {
                showError("Error", "Cannot download music.");
            }
        });

        clearButton.setOnAction(e -> {  //CLEAR
            logArea.clear();
            logArea.appendText("Cleared all text fields and log\n");
            logArea.setScrollTop(Double.MAX_VALUE);

            mp3ModelField.clear();
            mp3PriceField.clear();
            mp3WeightField.clear();
            mp3SizeField.clear();
            memoryField.clear();
            deleteSizeField.clear();
            downloadSizeField.clear();

            mobileModelField.clear();
            mobilePriceField.clear();
            mobileWeightField.clear();
            mobileSizeField.clear();
            creditField.clear();
            addCreditField.clear();

            phoneNumberField.clear();
            durationField.clear();
            displayNumberField.clear();

            successSound.play();
        });

        deleteDevicesButton.setOnAction(e -> {  //DELETE DEVICES
            gadgets.clear();
            logArea.appendText("All devices deleted\n");
            logArea.setScrollTop(Double.MAX_VALUE);
            successSound.play();
        });

        deleteMusicButton.setOnAction(e -> {    //DELETE MUSIC
            try {
                int index = getDisplayNumber();
                if (index == -1) return;

                int amount = Integer.parseInt(deleteSizeField.getText().trim());
                if (amount <= 0) {
                    showError("Error", "Delete amount must be positive.");
                    return;
                }

                Object gadget = gadgets.get(index);
                if (gadget instanceof MP3 mp3) {
                    int usedMemory = mp3.getUsedMemory();
                    if (amount > usedMemory) {
                        showError("Error", "Cannot delete " + amount + "MB - only " + usedMemory + "MB stored.");
                        return;
                    }
                    mp3.deleteMusic(amount);
                    logArea.appendText("Deleted " + amount + "MB of music\n");
                    logArea.setScrollTop(Double.MAX_VALUE);
                    successSound.play();
                } else {
                    showError("Error", "Selected gadget is not an MP3.");
                }
            } catch (NumberFormatException ex) {
                showError("Error", "Delete size must be integer.");
            } catch (Exception ex) {
                showError("Error", "Cannot delete music!");
            }
        });

        addCreditButton.setOnAction(e -> {  //ADD CREDIT
            try {
                int index = getDisplayNumber();
                if (index == -1) return;

                if (!(gadgets.get(index) instanceof Mobile mobile)) {
                    showError("Error", "Selected device is not a Mobile.");
                    return;
                }

                int amount = Integer.parseInt(addCreditField.getText().trim());

                if (amount <= 0) {
                    showError("Error", "Credit must be positive.");
                    return;
                }

                mobile.addCredit(amount);
                logArea.appendText("Added " + amount + " credit minutes\n");
                successSound.play();
                logArea.setScrollTop(Double.MAX_VALUE);

            } catch (NumberFormatException ex) {
                showError("Error", "Amount must be integer.");
            }
        });

        root.getChildren().addAll(
            mp3Title, mobileTitle,
            modelLabel1, mp3ModelField,
            priceLabel1, mp3PriceField,
            weightLabel1, mp3WeightField,
            sizeLabel1, mp3SizeField,
            memoryLabel, memoryField,
            deleteSizeLabel, deleteSizeField, deleteMusicButton,
            addMP3Button,
            modelLabel2, mobileModelField,
            priceLabel2, mobilePriceField,
            weightLabel2, mobileWeightField,
            sizeLabel2, mobileSizeField,
            creditLabel, creditField,
            addMobileButton, addCreditLabel,
            addCreditField, addCreditButton,
            phoneLabel, phoneNumberField,
            durationLabel, durationField,
            downloadLabel, downloadSizeField,
            displayLabel, displayNumberField,
            displayAllButton, displayOneButton,
            makeCallButton, downloadMusicButton,
            clearButton, deleteDevicesButton,
            logArea
        );

        stage.setScene(new Scene(root, 600, 620));
        stage.setTitle("Gadget Shop");
        stage.show();
    }

    private int getDisplayNumber() {
        int displayNumber = -1;

        try {
            displayNumber = Integer.parseInt(displayNumberField.getText().trim());

            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                showError("Error", "Display number out of range");
                displayNumber = -1;
            }

        } catch (NumberFormatException e) {
            showError("Error", "Display number must be integer");
        }

        return displayNumber;
    }

    private void showError(String title, String message) {
        failSound.play();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}