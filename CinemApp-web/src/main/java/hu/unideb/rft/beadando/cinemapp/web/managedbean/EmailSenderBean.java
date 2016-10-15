package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
            //QR kód legenerálása
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
            qrCodeGenerator.setQrCodeText(text);
            qrCodeGenerator.createQRCode();
            
            //QR kód beszúrásának a helye a html kódban
            String contentId = "qrcodecontent";
            
            //Email címzett, tárgy beállítás
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
            message.setSubject("CinemApp - Jegy foglalás");
            
            //Multipart amelybe a html Body darabkákat tesszük
            MimeMultipart fullEmailContent = new MimeMultipart();
            
            //Szöveg rész
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                    + "<head>\n"
                    + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width\" />\n"
                    + "  <title>Airmail Ping</title>\n"
                    + "  <style type=\"text/css\">\n"
                    + "  * {\n"
                    + "    margin:0;\n"
                    + "    padding:0;\n"
                    + "    font-family: Helvetica, Arial, sans-serif;\n"
                    + "  }\n"
                    + "  img {\n"
                    + "    max-width: 100%;\n"
                    + "    outline: none;\n"
                    + "    text-decoration: none;\n"
                    + "    -ms-interpolation-mode: bicubic;\n"
                    + "  }\n"
                    + "  .image-fix {\n"
                    + "    display:block;\n"
                    + "  }\n"
                    + "  .collapse {\n"
                    + "    margin:0;\n"
                    + "    padding:0;\n"
                    + "  }\n"
                    + "  body {\n"
                    + "    -webkit-font-smoothing:antialiased;\n"
                    + "    -webkit-text-size-adjust:none;\n"
                    + "    width: 100%!important;\n"
                    + "    height: 100%;\n"
                    + "    text-align: center;\n"
                    + "    color: #747474;\n"
                    + "    background-color: #ffffff;\n"
                    + "  }\n"
                    + "  h1,h2,h3,h4,h5,h6 {\n"
                    + "    font-family: Helvetica, Arial, sans-serif;\n"
                    + "    line-height: 1.1;\n"
                    + "  }\n"
                    + "  h1 small, h2 small, h3 small, h4 small, h5 small, h6 small {\n"
                    + "    font-size: 60%;\n"
                    + "    line-height: 0;\n"
                    + "    text-transform: none;\n"
                    + "  }\n"
                    + "  h1 {\n"
                    + "    font-weight:200;\n"
                    + "    font-size: 44px;\n"
                    + "  }\n"
                    + "  h2 {\n"
                    + "    font-weight:200;\n"
                    + "    font-size: 32px;\n"
                    + "    margin-bottom: 14px;\n"
                    + "  }\n"
                    + "  h3 {\n"
                    + "    font-weight:500;\n"
                    + "    font-size: 27px;\n"
                    + "  }\n"
                    + "  h4 {\n"
                    + "    font-weight:500;\n"
                    + "    font-size: 23px;\n"
                    + "  }\n"
                    + "  h5 {\n"
                    + "    font-weight:900;\n"
                    + "    font-size: 17px;\n"
                    + "  }\n"
                    + "  h6 {\n"
                    + "    font-weight:900;\n"
                    + "    font-size: 14px;\n"
                    + "    text-transform: uppercase;\n"
                    + "  }\n"
                    + "  .collapse {\n"
                    + "    margin:0!important;\n"
                    + "  }\n"
                    + "  td, div {\n"
                    + "    font-family: Helvetica, Arial, sans-serif;\n"
                    + "    text-align: center;\n"
                    + "  }\n"
                    + "  p, ul {\n"
                    + "    margin-bottom: 10px;\n"
                    + "    font-weight: normal;\n"
                    + "    font-size:14px;\n"
                    + "    line-height:1.6;\n"
                    + "  }\n"
                    + "  p.lead {\n"
                    + "    font-size:17px;\n"
                    + "  }\n"
                    + "  p.last {\n"
                    + "    margin-bottom:0px;\n"
                    + "  }\n"
                    + "  ul li {\n"
                    + "    margin-left:5px;\n"
                    + "    list-style-position: inside;\n"
                    + "  }\n"
                    + "  a {\n"
                    + "    color: #747474;\n"
                    + "    text-decoration: none;\n"
                    + "  }\n"
                    + "  a img {\n"
                    + "    border: none;\n"
                    + "  }\n"
                    + "  .head-wrap {\n"
                    + "    width: 100%;\n"
                    + "    margin: 0 auto;\n"
                    + "    background-color: #f9f8f8;\n"
                    + "    border-bottom: 1px solid #d8d8d8;\n"
                    + "  }\n"
                    + "  .head-wrap * {\n"
                    + "    margin: 0;\n"
                    + "    padding: 0;\n"
                    + "  }\n"
                    + "  .header-background {\n"
                    + "    background: repeat-x url(https://www.filepicker.io/api/file/wUGKTIOZTDqV2oJx5NCh) left bottom;\n"
                    + "  }\n"
                    + "  .header {\n"
                    + "    height: 42px;\n"
                    + "  }\n"
                    + "  .header .content {\n"
                    + "    padding: 0;\n"
                    + "  }\n"
                    + "  .header .brand {\n"
                    + "    font-size: 16px;\n"
                    + "    line-height: 42px;\n"
                    + "    font-weight: bold;\n"
                    + "  }\n"
                    + "  .header .brand a {\n"
                    + "    color: #464646;\n"
                    + "  }\n"
                    + "  .body-wrap {\n"
                    + "    width: 505px;\n"
                    + "    margin: 0 auto;\n"
                    + "    background-color: #ffffff;\n"
                    + "  }\n"
                    + "  .soapbox .soapbox-title {\n"
                    + "    font-size: 21px;\n"
                    + "    color: #464646;\n"
                    + "    padding-top: 35px;\n"
                    + "  }\n"
                    + "  .content .status-container.single .status-padding {\n"
                    + "    width: 80px;\n"
                    + "  }\n"
                    + "  .content .status {\n"
                    + "    width: 90%;\n"
                    + "  }\n"
                    + "  .content .status-container.single .status {\n"
                    + "    width: 300px;\n"
                    + "  }\n"
                    + "  .status {\n"
                    + "    border-collapse: collapse;\n"
                    + "    margin-left: 15px;\n"
                    + "    color: #656565;\n"
                    + "  }\n"
                    + "  .status .status-cell {\n"
                    + "    border: 1px solid #b3b3b3;\n"
                    + "    height: 50px;\n"
                    + "  }\n"
                    + "  .status .status-cell.success,\n"
                    + "  .status .status-cell.active {\n"
                    + "    height: 65px;\n"
                    + "  }\n"
                    + "  .status .status-cell.success {\n"
                    + "    background: #f2ffeb;\n"
                    + "    color: #51da42;\n"
                    + "  }\n"
                    + "  .status .status-cell.success .status-title {\n"
                    + "    font-size: 15px;\n"
                    + "  }\n"
                    + "  .status .status-cell.active {\n"
                    + "    background: #fffde0;\n"
                    + "    width: 135px;\n"
                    + "  }\n"
                    + "  .status .status-title {\n"
                    + "    font-size: 16px;\n"
                    + "    font-weight: bold;\n"
                    + "    line-height: 23px;\n"
                    + "  }\n"
                    + "  .status .status-image {\n"
                    + "    vertical-align: text-bottom;\n"
                    + "  }\n"
                    + "  .body .body-padded,\n"
                    + "  .body .body-padding {\n"
                    + "    padding-top: 34px;\n"
                    + "  }\n"
                    + "  .body .body-padding {\n"
                    + "    width: 41px;\n"
                    + "  }\n"
                    + "  .body-padded,\n"
                    + "  .body-title {\n"
                    + "    text-align: left;\n"
                    + "  }\n"
                    + "  .body .body-title {\n"
                    + "    font-weight: bold;\n"
                    + "    font-size: 17px;\n"
                    + "    color: #464646;\n"
                    + "  }\n"
                    + "  .body .body-text .body-text-cell {\n"
                    + "    text-align: left;\n"
                    + "    font-size: 14px;\n"
                    + "    line-height: 1.6;\n"
                    + "    padding: 9px 0 17px;\n"
                    + "  }\n"
                    + "  .body .body-text-cell a {\n"
                    + "    color: #464646;\n"
                    + "    text-decoration: underline;\n"
                    + "  }\n"
                    + "  .body .body-signature-block .body-signature-cell {\n"
                    + "    padding: 25px 0 30px;\n"
                    + "    text-align: left;\n"
                    + "  }\n"
                    + "  .body .body-signature {\n"
                    + "    font-family: \"Comic Sans MS\", Textile, cursive;\n"
                    + "    font-weight: bold;\n"
                    + "  }\n"
                    + "  .footer-wrap {\n"
                    + "    width: 100%;\n"
                    + "    margin: 0 auto;\n"
                    + "    clear: both !important;\n"
                    + "    background-color: #e5e5e5;\n"
                    + "    border-top: 1px solid #b3b3b3;\n"
                    + "    font-size: 12px;\n"
                    + "    color: #656565;\n"
                    + "    line-height: 30px;\n"
                    + "  }\n"
                    + "  .footer-wrap .container {\n"
                    + "    padding: 14px 0;\n"
                    + "  }\n"
                    + "  .footer-wrap .container .content {\n"
                    + "    padding: 0;\n"
                    + "  }\n"
                    + "  .footer-wrap .container .footer-lead {\n"
                    + "    font-size: 14px;\n"
                    + "  }\n"
                    + "  .footer-wrap .container .footer-lead a {\n"
                    + "    font-size: 14px;\n"
                    + "    font-weight: bold;\n"
                    + "    color: #535353;\n"
                    + "  }\n"
                    + "  .footer-wrap .container a {\n"
                    + "    font-size: 12px;\n"
                    + "    color: #656565;\n"
                    + "  }\n"
                    + "  .footer-wrap .container a.last {\n"
                    + "    margin-right: 0;\n"
                    + "  }\n"
                    + "  .footer-wrap .footer-group {\n"
                    + "    display: inline-block;\n"
                    + "  }\n"
                    + "  .container {\n"
                    + "    display: block !important;\n"
                    + "    max-width: 505px !important;\n"
                    + "    clear: both !important;\n"
                    + "	margin: 0 auto;\n"
                    + "  }\n"
                    + "  .content {\n"
                    + "    padding: 0;\n"
                    + "    max-width: 505px;\n"
                    + "    margin: 0 auto;\n"
                    + "    display: block;\n"
                    + "  }\n"
                    + "  .content table {\n"
                    + "    width: 100%;\n"
                    + "  }\n"
                    + "  .clear {\n"
                    + "    display: block;\n"
                    + "    clear: both;\n"
                    + "  }\n"
                    + "  table.full-width-gmail-android {\n"
                    + "    width: 100% !important;\n"
                    + "  }\n"
                    + "  </style>\n"
                    + "\n"
                    + "  <style type=\"text/css\" media=\"only screen\">\n"
                    + "\n"
                    + "  @media only screen {\n"
                    + "\n"
                    + "    table[class*=\"head-wrap\"],\n"
                    + "    table[class*=\"body-wrap\"],\n"
                    + "    table[class*=\"footer-wrap\"] {\n"
                    + "      width: 100% !important;\n"
                    + "    }\n"
                    + "\n"
                    + "    td[class*=\"container\"] {\n"
                    + "      margin: 0 auto !important;\n"
                    + "    }\n"
                    + "\n"
                    + "  }\n"
                    + "\n"
                    + "  @media only screen and (max-width: 505px) {\n"
                    + "\n"
                    + "    *[class*=\"w320\"] {\n"
                    + "      width: 320px !important;\n"
                    + "    }\n"
                    + "\n"
                    + "    table[class=\"soapbox\"] td[class*=\"soapbox-title\"],\n"
                    + "    table[class=\"body\"] td[class*=\"body-padded\"] {\n"
                    + "      padding-top: 24px;\n"
                    + "    }\n"
                    + "  }\n"
                    + "  </style>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body bgcolor=\"#ffffff\">\n"
                    + "  <div align=\"center\">\n"
                    + "    <table class=\"head-wrap w320 full-width-gmail-android\" bgcolor=\"#f9f8f8\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
                    + "      <tr class=\"header-background\">\n"
                    + "        <td class=\"header container\" align=\"center\">\n"
                    + "          <div class=\"content\">\n"
                    + "            <span class=\"brand\">\n"
                    + "              <a href=\"#\">\n"
                    + "                FourFire Team - CinemApp\n"
                    + "              </a>\n"
                    + "            </span>\n"
                    + "          </div>\n"
                    + "        </td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "\n"
                    + "    <table class=\"body-wrap w320\">\n"
                    + "      <tr>\n"
                    + "        <td></td>\n"
                    + "        <td class=\"container\">\n"
                    + "          <div class=\"content\">\n"
                    + "            <table cellspacing=\"0\">\n"
                    + "              <tr>\n"
                    + "                <td>\n"
                    + "                  <table class=\"soapbox\">\n"
                    + "                    <tr>\n"
                    + "                      <td class=\"soapbox-title\">Jegy foglalás</td>\n"
                    + "                    </tr>\n"
                    + "                  </table>\n"
                    + "                  <table class=\"body\">\n"
                    + "                    <tr>\n"
                    + "                      <td class=\"body-padding\"></td>\n"
                    + "                      <td class=\"body-padded\">\n"
                    + "                        <div class=\"body-title\">Tisztelt címzett!</div>\n"
                    + "                        <table class=\"body-text\">\n"
                    + "                          <tr>\n"
                    + "                            <td class=\"body-text-cell\">\n"
                    + "							  Kérjük a moziba érkezéskor mutassa be QR kódját a jegypénztárosnak.\n"
                    + "                            </td>\n"
                    + "                          </tr>\n"
                    + "                        </table>\n"
                    + "                        <div>\n"
                    + "			     <img src=\"cid:" + contentId + "\" /> "
                    + "						</div>\n"
                    + "                        <table class=\"body-signature-block\">\n"
                    + "                          <tr>\n"
                    + "                            <td class=\"body-signature-cell\">\n"
                    + "                              <p>Köszönjük, hogy igénybevette szolgáltatásunkat! Jó szórakozást kívánunk a filmhez!</p>\n"
                    + "                              <p class=\"body-signature\">FourFire Team</p>\n"
                    + "                            </td>\n"
                    + "                          </tr>\n"
                    + "                        </table>\n"
                    + "                      </td>\n"
                    + "                      <td class=\"body-padding\"></td>\n"
                    + "                    </tr>\n"
                    + "                  </table>\n"
                    + "                </td>\n"
                    + "              </tr>\n"
                    + "            </table>\n"
                    + "          </div>\n"
                    + "        </td>\n"
                    + "        <td></td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "\n"
                    + "    <table class=\"footer-wrap w320 full-width-gmail-android\" bgcolor=\"#e5e5e5\">\n"
                    + "      <tr>\n"
                    + "        <td></td>\n"
                    + "        <td class=\"container\">\n"
                    + "          <div class=\"content footer-lead\">\n"
                    + "            Ez egy automatikusan küldött email, kérjük ne válaszoljon.\n"
                    + "          </div>\n"
                    + "        </td>\n"
                    + "        <td></td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "    <table class=\"footer-wrap w320 full-width-gmail-android\" bgcolor=\"#e5e5e5\">\n"
                    + "      <tr>\n"
                    + "        <td></td>\n"
                    + "        <td class=\"container\">\n"
                    + "          <div class=\"content\">\n"
                    + "            <a href=\"#\">Contact Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;\n"
                    + "            <span class=\"footer-group\">\n"
                    + "              <a href=\"#\">Facebook</a>&nbsp;&nbsp;|&nbsp;&nbsp;\n"
                    + "              <a href=\"#\">Twitter</a>&nbsp;&nbsp;|&nbsp;&nbsp;\n"
                    + "              <a href=\"#\">Support</a>\n"
                    + "            </span>\n"
                    + "          </div>\n"
                    + "        </td>\n"
                    + "        <td></td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "  </div>\n"
                    + "</body>\n"
                    + "</html>", "UTF-8", "html");
            
            fullEmailContent.addBodyPart(textPart);
            
            //QR kód beszúrása a html kódba/emailbe
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.attachFile(qrCodeGenerator.image);
            imagePart.setContentID("<" + contentId + ">");
            imagePart.setDisposition(MimeBodyPart.INLINE);
            
            fullEmailContent.addBodyPart(imagePart);
            
            message.setContent(fullEmailContent);
            
            Transport.send(message);
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            Logger.getLogger(EmailSenderBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}