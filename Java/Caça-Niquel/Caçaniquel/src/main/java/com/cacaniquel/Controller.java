package com.cacaniquel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Random;

public class Controller {

    @FXML
    private Label reel1, reel2, reel3, message;

    private static final String[] SYMBOLS = {"🍒","🔔","⭐","🍋","7"};

    private final Random random = new Random();

    @FXML
    private void spin() {
        String s1 = SYMBOLS[random.nextInt(SYMBOLS.length)];
        String s2 = SYMBOLS[random.nextInt(SYMBOLS.length)];
        String s3 = SYMBOLS[random.nextInt(SYMBOLS.length)];

        reel1.setText(s1);
        reel2.setText(s2);
        reel3.setText(s3);

        if (s1.equals(s2) && s2.equals(s3)) {
            message.setText("🎉 Você ganhou! 🎉");
        } else {
            message.setText("");
        }
    }
}
