package com.se.sample;


// Not work for this moment

//import sun.security.x509.*;
//import sun.security.x509.CertificateValidity;
//import sun.security.x509.X500Name;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.security.cert.*;
//import java.security.*;
//import java.util.Date;


public class CertificateDemo {
    // Compiler args: -XDignore.symbol.file
    public static void main(String[] args) {

    }

 //   private static void testCertificate() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, CertificateException, SignatureException, InvalidKeyException {
        // 1. Генерируем пару ключей
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        keyPairGenerator.initialize(4096);
//        KeyPair keyPair = keyPairGenerator.generateKeyPair();
//// 2. Определяем данные сертификата
//// Определяем срок действия сертификата
//        Date from = new Date();
//        Date to = new Date(from.getTime() + 365 * 1000L * 24L * 60L * 60L);
//        CertificateValidity interval = new CertificateValidity(from, to);
//// Определяем subject name, т.е. имя того, с чем ассоциирован публичный ключ
//// CN = Common Name. Через точку с запятой могут быть указаны также другие атрибуты
//// См. https://docs.oracle.com/cd/E24191_01/common/tutorials/authz_cert_attributes.html
//        X500Name owner = new X500Name("cn=Unknown");
//// Уникальный в пределах CA, т.е. Certificate Authority (тот, кто выдаёт сертификат) номер
//        BigInteger number = new BigInteger(64, new SecureRandom());
//        CertificateSerialNumber serialNumber = new CertificateSerialNumber(number);
//// Определяем алгоритм подписи сертификата
//        AlgorithmId algorithmId = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
//        CertificateAlgorithmId certificateAlgorithmId = new CertificateAlgorithmId(algorithmId);
//// 3. По подготовленной информации создаём сертификат
//        X509CertInfo info = new X509CertInfo();
//        info.set(X509CertInfo.VALIDITY, interval);
//        info.set(X509CertInfo.SERIAL_NUMBER, serialNumber);
//        info.set(X509CertInfo.SUBJECT, owner);
//        info.set(X509CertInfo.ISSUER, owner);
//        info.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
//        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
//        info.set(X509CertInfo.ALGORITHM_ID, certificateAlgorithmId);
//// 4. Подписываем сертификат
//        X509CertImpl certificate = new X509CertImpl(info);
//        certificate.sign(keyPair.getPrivate(), "SHA256withRSA");
//// 5. Проверка сертификата
//        try {
//            // В случае ошибки здесь будет брошено исключение. Например: java.security.SignatureException
//            certificate.verify(keyPair.getPublic());
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//    }
}
