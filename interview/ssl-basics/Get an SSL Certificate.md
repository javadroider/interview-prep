<!-----
NEW: Check the "Suppress top comment" option to remove this info from the output.

Conversion time: 0.375 seconds.


Using this Markdown file:

1. Paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β29
* Fri Aug 21 2020 01:03:24 GMT-0700 (PDT)
* Source doc: Untitled document
----->



# **How to Get an SSL Certificate?**

You can get an SSL certificate from any authorized Certificate Authority (CA) to secure the communication between two systems. There are two ways to get an SSL certificate:



1. Buy a certificate from CA
2. Get a free certificate from a non-profit open CA


## **Should you buy an SSL certificate?**

The decision of whether you should buy an SSL certificate depends on your need, whether you need a DV, an EV or an OV certificate. Also, do you need to secure a single domain, subdomains or multiple domains?

If you have an e-commerce web site, you gather user's information or you perform monetary transactions, then it is recommended to buy EV or OV certificates from a reputed CA. If you have a static website or you are not doing any monetary transactions, then you may use a free DV certificate. However, there is some hassle for renewing a free certificate every three months or so. So, it depends on what you can afford.


## **Buying an SSL Certificate**

You can buy an SSL certificate from CA. The prices vary depending on the CA and type of the SSL certificate.

The following are overall steps for buying SSL certificates from a CA:



1. **Choose a Certificate Authority (CA):** You can choose your CA from where you want to buy an SSL certificate. There are many CAs such as[ Comodo](https://ssl.comodo.com),[ DigiCert](https://www.digicert.com/ssl-certificate),[ RapidSSL](https://www.rapidssl.com/),[ GeoTrust](https://www.geotrust.com/),[ thawte](https://www.thawte.com/),[ Certum](https://www.certum.eu/) etc. You may choose the CA based on your budget and the features you need to manage the certificate. There are resellers who provides cheap SSL certificates from these CAs. Visit[ https://www.thesslstore.com](https://www.thesslstore.com?aid=52914109) to buy cheap certificates from reputed CAs at one place.
2. **Select the certificate you need:** Once you select a CA, you can choose the certificate you require for your website based on the validation method and the number of web sites you want to secure.
3. **Purchase the certificate:** Once you choose the certificate you require, make the payment to proceed. For some CA, this step comes after submitting a CSR.
4. **Generate and submit a CSR (Certificate Signing Request) to the CA:** You need to generate a CSR from your web server and submit it to the CA. Learn more about what a CSR is and how to generate it in the next chapter.
5. **Download the SSL certificate (after successful validation):** After submitting a CSR, the CA will take some time for validating your information. This may vary based on the validation certificate you purchase. For a DV certificate, it should be quick. But, it will take a little longer to validate for an OV and an EV certificates. Once the CA successfully validates your information, you will get an email containing the certificate or you can download it from your account on the CA's website.
6. **Install an SSL certificate on your web server:** Once you get your SSL certificate, you need to install it on the web server from where you generated your CSR. The installation process depends on the OS of your server. Learn about it[ here](https://www.tutorialsteacher.com/https/install-ssl-certificate).
