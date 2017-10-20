package com.example.gilgamesh.mupy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class QRActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    EditText editText;
    String TAG="sfsdf";
    String EditTextValue ;
    Thread thread ;
    public final static int QRcodeWidth = 1000 ;
    Bitmap bitmap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        imageView = (ImageView)findViewById(R.id.qr_img);
        try {
            bitmap = TextToImageEncode(new RegistrationNumber.SessionManager(this).getReg());

            imageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }


    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.black):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 1000, 0, 0, bitMatrixWidth, bitMatrixHeight);
        
       try {
           String path = Environment.getExternalStorageDirectory().toString();
           OutputStream fOut = null;
           Integer counter = 0;
           File file = new File(path, "QR" + counter + ".jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
           fOut = new FileOutputStream(file);


           bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
           fOut.flush(); // Not really required
           fOut.close(); // do not forget to close the stream

           MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
       }catch (Exception e)
       {
           e.printStackTrace();
       }


        return bitmap;
    }

}