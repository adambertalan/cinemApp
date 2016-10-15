package hu.unideb.rft.beadando.cinemapp.web.managedbean;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.Serializable;

public class QRCodeGenerator implements Serializable{
    public String qrCodeText;
    private String filePath = "qrcode.png";
    private String charset = "UTF-8";
    private int height = 200;
    private int width = 200;
    Map hintMap = new HashMap();
    public File image = new File(filePath);
    
    public String getQrCodeText() {
        return qrCodeText;
    }

    public void setQrCodeText(String qrCodeText) {
        this.qrCodeText = qrCodeText;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Map getHintMap() {
        return hintMap;
    }

    public void setHintMap(Map hintMap) {
        this.hintMap = hintMap;
    }
    
    public void createQRCode(){
        try {
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeText.getBytes(charset),charset),BarcodeFormat.QR_CODE,width,height,hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), image);
        } catch (WriterException | IOException ex) {
            System.out.println("QR Code hiba.");
        }
    }
}
