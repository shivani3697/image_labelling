package com.example.admin.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
    FirebaseVisionLabelDetector detector = FirebaseVision.getInstance()
            .getVisionLabelDetector();
    // Or, to set the minimum confidence required:
    FirebaseVisionLabelDetector detector = FirebaseVision.getInstance()
            .getVisionLabelDetector(options);
    Task<List<FirebaseVisionLabel>> result =
            detector.detectInImage(image)
                    .addOnSuccessListener(
                            new OnSuccessListener<List<FirebaseVisionLabel>>() {
                                @Override
                                public void onSuccess(List<FirebaseVisionLabel> labels) {
                                    // Task completed successfully
                                    // ...
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Task failed with an exception
                                    // ...
                                }
                            });
    for (FirebaseVisionLabel label: labels) {
        String text = label.getLabel();
        String entityId = label.getEntityId();
        float confidence = label.getConfidence();
    }
}

