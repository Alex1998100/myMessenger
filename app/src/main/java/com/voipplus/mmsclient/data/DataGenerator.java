package com.voipplus.mmsclient.data;

import com.voipplus.mmsclient.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static List<RandomMessageItem> generateRandomData(int itemCount) {
        List<RandomMessageItem> items = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            items.add(randomMessageItem());
        }
        return items;
    }

    private static RandomMessageItem randomMessageItem() {
        int[] icons = {
                R.drawable.baseline_airplanemode_active_24,
                R.drawable.baseline_airport_shuttle_24,
                R.drawable.baseline_check_circle_24,
                R.drawable.baseline_archive_24,
                R.drawable.baseline_audio_file_24
         };
        String[] texts = {
                "message 1", "message 2", "message 3", "message 4", "message 5",
                "message 6", "message 7", "message 8", "message 9", "message 10",
        };
        Random random = new Random();
        int iconIndex = random.nextInt(icons.length);
        int textIndex = random.nextInt(texts.length);
        return new RandomMessageItem(icons[iconIndex], texts[textIndex]);
    }
}