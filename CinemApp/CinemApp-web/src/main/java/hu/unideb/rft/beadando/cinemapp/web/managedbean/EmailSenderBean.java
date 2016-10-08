package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.Serializable;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

@ManagedBean(name = "emailBean")
@ViewScoped
public class EmailSenderBean implements Serializable {

    String text;
    String address;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void sendEmail() {
        final String username = "cinemapp.fft@gmail.com";
        final String password = "ffteam1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
            qrCodeGenerator.setQrCodeText(address);
            qrCodeGenerator.createQRCode();
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
            message.setSubject("Testing Subject");
            
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<H1>Tisztelt címzett!</H1><p>Emailünkben küldjük a foglaláshoz tartozó QR kódot</p><img src=\"cid:image\">";
            messageBodyPart.setContent(htmlText,"text/html");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource fileDataSource = new FileDataSource(qrCodeGenerator.image);
            messageBodyPart.setDataHandler(new DataHandler(fileDataSource));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            
            message.setContent(multipart);

            Transport.send(message);
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
